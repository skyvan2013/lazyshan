<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别管理</title>
</head>
<body>
	<table id="tg" title="操作说明：右键可展开菜单操作" style="width: 100%; height: 450px"
		data-options="
				iconCls: 'icon-ok',
				rownumbers: true,
				animate: true,
				collapsible: false,
				fitColumns: true,
				url: 'sd/treegrid',
				method: 'get',
				idField: 'id',
				treeField: 'name',
				onContextMenu: onContextMenu,
				toolbar:toolbar,
				pagination:true,
				pageList:[1,30,45,100],
				pageSize:1
			">
		<thead>
			<tr>
				<th data-options="field:'name'">分类名称</th>
				<th data-options="field:'persons',align:'center',width:150,fixed:true">分类级别</th>
				<th data-options="field:'begin',width:500,align:'center'">分类描述</th>
			</tr>
		</thead>
	</table>
	<div id="mm" class="easyui-menu" style="width: 120px;">
		<div onclick="append()" data-options="iconCls:'icon-add'">添加子分类</div>
		<div class="menu-sep"></div>
		<div onclick="removeIt()" data-options="iconCls:'icon-remove'">刪除分类</div>
		<div onclick="removeIt()" data-options="iconCls:'icon-edit'">编辑分类</div>
		<div class="menu-sep"></div>
		<div onclick="collapse()">收 起</div>
		<div onclick="expand()">展 开</div>
	</div>



	<script type="text/javascript">
		(function($) {
			function pagerFilter(data) {
				if ($.isArray(data)) { // is array  
					data = {
						total : data.length,
						rows : data
					}
				}
				var dg = $(this);
				var state = dg.data('treegrid');
				var opts = dg.treegrid('options');
				var pager = dg.treegrid('getPager');
				pager.pagination({
					onSelectPage : function(pageNum, pageSize) {
						opts.pageNumber = pageNum;
						opts.pageSize = pageSize;
						pager.pagination('refresh', {
							pageNumber : pageNum,
							pageSize : pageSize
						});
						dg.treegrid('loadData', state.originalRows);
					}
				});
				if (!state.originalRows) {
					state.originalRows = data.rows;
				}
				var topRows = [];
				var childRows = [];
				$.map(state.originalRows, function(row) {
					row._parentId ? childRows.push(row) : topRows.push(row);
				});
				data.total = topRows.length;
				var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
				var end = start + parseInt(opts.pageSize);
				data.rows = $.extend(true, [], topRows.slice(start, end).concat(childRows));
				return data;
			}

			var appendMethod = $.fn.treegrid.methods.append;
			var loadDataMethod = $.fn.treegrid.methods.loadData;
			$.extend($.fn.treegrid.methods, {
				clientPaging : function(jq) {
					return jq.each(function() {
						var state = $(this).data('treegrid');
						var opts = state.options;
						opts.loadFilter = pagerFilter;
						var onBeforeLoad = opts.onBeforeLoad;
						opts.onBeforeLoad = function(row, param) {
							state.originalRows = null;
							onBeforeLoad.call(this, row, param);
						}
						$(this).treegrid('loadData', state.data);
						$(this).treegrid('reload');
					});
				},
				loadData : function(jq, data) {
					jq.each(function() {
						$(this).data('treegrid').originalRows = null;
					});
					return loadDataMethod.call($.fn.treegrid.methods, jq, data);
				},
				append : function(jq, param) {
					return jq.each(function() {
						var state = $(this).data('treegrid');
						if (state.options.loadFilter == pagerFilter) {
							$.map(param.data, function(row) {
								row._parentId = row._parentId || param.parent;
								state.originalRows.push(row);
							});
							$(this).treegrid('loadData', state.originalRows);
						} else {
							appendMethod.call($.fn.treegrid.methods, jq, param);
						}
					})
				}
			});

		})(jQuery);

		function formatProgress(value) {
			if (value) {
				var s = '<div style="width:100%;border:1px solid #ccc">' + '<div style="width:' + value + '%;background:#cc0000;color:#fff">' + value + '%' + '</div>'
				'</div>';
				return s;
			} else {
				return '';
			}
		}

		$(function() {
			$('#tg').treegrid();
		})

		function onContextMenu(e, row) {
			e.preventDefault();
			$(this).treegrid('select', row.id);
			$('#mm').menu('show', {
				left : e.pageX,
				top : e.pageY
			});
		}
		function removeIt() {
			var node = $('#tg').treegrid('getSelected');
			if (node) {
				$('#tg').treegrid('remove', node.id);
			}
		}
		function collapse() {
			var node = $('#tg').treegrid('getSelected');
			if (node) {
				$('#tg').treegrid('collapse', node.id);
			}
		}
		function expand() {
			var node = $('#tg').treegrid('getSelected');
			if (node) {
				$('#tg').treegrid('expand', node.id);
			}
		}
		function append() {
			var node = $('#tg').treegrid('getSelected');
			$('#tg').treegrid('append', {
				parent : node.id,
				data : [ {
					id : "",
					name : "",
					persons : "",
					begin : "",
					end : "",
					progress : ""
				} ]
			})
		}
		var idIndex = 100;
		function appendTop() {
			idIndex++;
			var d1 = new Date();
			var d2 = new Date();
			d2.setMonth(d2.getMonth() + 1);
			$('#tg').treegrid('append', {
				data : [ {
					id : idIndex,
					name : 'New Task' + idIndex,
					persons : parseInt(Math.random() * 10),
					begin : $.fn.datebox.defaults.formatter(d1),
					end : $.fn.datebox.defaults.formatter(d2),
					progress : parseInt(Math.random() * 100)
				} ]
			})
		}

		var toolbar = [ {
			text : '添加一级分类',
			iconCls : 'icon-add',
			handler : appendTop
		}, '-', {
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				alert('save')
			}
		} ];
	</script>

</body>
</html>