package com.lazyshan.oa.mms.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class MyInterceptor implements Interceptor {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		String originalSql = boundSql.getSql().trim();
		Pager pager = toPage(parameter);
		if (pager != null) {

			int total = getCount(mappedStatement, boundSql);
			pager.setTotal(total);
			// 对原始Sql追加limit

			int offset = ((pager.getPage() - 1) * pager.getRows());

			StringBuffer sb = new StringBuffer();
			 sb.append(originalSql).append(" limit ").append(offset).append(",").append(pager.getRows());
			BoundSql newBoundSql = newBoundSql(mappedStatement, boundSql, sb.toString());
			MappedStatement newMs = newMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
			invocation.getArgs()[0] = newMs;
			pager.setResult((List)invocation.proceed());
		}
		return invocation.proceed();
	}

	private int getCount(MappedStatement mappedStatement, BoundSql boundSql) throws Throwable {
		Connection connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
		String countSql = new StringBuffer().append("SELECT COUNT(*) FROM (").append(boundSql.getSql().trim()).append(")  _aliesForPage").toString();
		BoundSql boundSql2 = newBoundSql(mappedStatement, boundSql, countSql);
		PreparedStatement countStmt = connection.prepareStatement(boundSql2.getSql());
		DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), boundSql2);
		parameterHandler.setParameters(countStmt);
		ResultSet rs = countStmt.executeQuery();
		int totpage = 0;
		if (rs.next()) {
			totpage = rs.getInt(1);
		}
		rs.close();
		countStmt.close();
		connection.close();
		return totpage;
	}

	/**
	 * 传入的参数带有{@link Pager}就认为是要分页
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	private Pager toPage(Object parameter) {
		if (parameter != null) {
			if (parameter.getClass().isArray()) {
				for (Object o : (Object[]) parameter) {
					if (o instanceof Pager)
						return (Pager) o;
				}
			} else if (parameter instanceof Pager) {
				return (Pager) parameter;
			}
		}
		return null;
	}

	private BoundSql newBoundSql(MappedStatement mappedStatement, BoundSql originalBoundSql, String sql) {
		return new BoundSql(mappedStatement.getConfiguration(), sql, originalBoundSql.getParameterMappings(), originalBoundSql.getParameterObject());
	}

	private MappedStatement newMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
		Builder builder = new Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		builder.keyProperty(ms.getKeyProperties() != null && ms.getKeyProperties().length > 0 ? ms.getKeyProperties()[0] : null);
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());

		return builder.build();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

	public class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}
}
