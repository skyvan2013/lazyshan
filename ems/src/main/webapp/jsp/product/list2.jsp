<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别管理</title>
<script type="text/javascript" src="/statics/js/easyui/plugins/treegrid-dnd.js"></script>
</head>
<body>
	<table id="tg" style="height: 500px;">
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
	<div id="save" style="display: none;"></div>
	<script type="text/javascript">
		var pageConfig = {
			//工具条设置
			toolbar : [ {
				text : '添加一级分类',
				iconCls : 'icon-add',
				handler : appendTop
			}, '-', {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					alert('save')
				}
			} ],
			//表格列设置
			columns : [ [ {
				title : '分类名称',
				field : 'name',
				width : "20%"
			}, {
				field : 'persons',
				title : '分类级别',
				align : 'center',
				width: "10%"
			}, {
				field : 'begin',
				title : '分类备注',
				halign : 'center',
				width: "70%",
				styler : function() {
					return "padding-left:10px;"
				}
			} ] ]

		};
		var idIndex = 1;
		function appendTop() {
			idIndex++;
			var d1 = new Date();
			var d2 = new Date();
			d2.setMonth(d2.getMonth() + 1);
			$('#tg').treegrid('append', {
				data : [ {
					id : "new" + idIndex,
					name : '',
					persons : '',
					begin : '',
					end : '',
					progress : ''
				} ]
			})
		}

		function onContextMenu(e, row) {
			e.preventDefault();
			$(this).treegrid('select', row.id);
			$('#mm').menu('show', {
				left : e.pageX,
				top : e.pageY
			});
		}

		$(document).ready(function() {
			$('#tg').treegrid({
				treeField : 'name',
				iconCls : 'icon-ok',
				animate : true,
				collapsible : false,
				fitColumns : false,
				url : 'sd/treegrid',
				method : 'get',
				idField : 'id',
				pagination : false,
				lines : true,
				onContextMenu : onContextMenu,
				toolbar : pageConfig.toolbar,
				pageList : [ 1, 30, 45, 100 ],
				pageSize : 1,
				columns : pageConfig.columns,
				onLoadSuccess : function() {
					$(this).treegrid('enableDnd');
				}
			}).datagrid("getPager").pagination({
				buttons : [ {
					text : "编辑",
					iconCls : 'icon-save',
					handler : function() {
						alert('edit')
					}
				}, '-', {
					text : "保存",
					iconCls : 'icon-save',
					handler : function() {
						alert('save')
					}
				} ]
			});
		});
	</script>
</body>
</html>