<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型列表</title>
<script type="text/javascript" src="/js/app/js/dgrid.js"></script>
<script type="text/javascript">
	function delClicked(list) {
		$.messager.confirm("提示","分类下如果有商品数据的话将不能删除,确定要删除所选的分类吗?",function(c){
			if(c==true){
				var rows = list.datagrid("getSelections");
				if(rows.length ==0)
					return false;
				var queryData="";
				for(var i=0; i<rows.length; i++){
					queryData +="&pts="+rows[i].productType					
				}
				$.messager.progress({title:"正在删除,请稍候"});
				$.ajax({
					url : "/pt/delpts",
					type : "get",
					data : queryData,
					dataType:"json",
					success : function(data){
						if(data.success ==true){
							$.messager.alert("提示","删除成功");
							location.reload(true);
						}else{
							$.messager.alert("提示","删除失败");
						}
					},
					complete: function(){
						$.messager.progress("close");
					},
					error : function(){
						$.messager.alert("提示","删除失败");
					}
					
				});
			}
		});
	}
	function editClicked(list) {
		var row = list.datagrid("getSelected");
		var a = $("#editWindow").dialog({
			title :"编辑产品类型",
			href :"/pt/editpt",
			queryParams:{ productType:row.productType},
			height : 120			
		});
	}
	function addClicked(list) {
		var a = $("#editWindow").dialog({
			title :"添加产品类型",
			href :"/pt/editpt",
			height : 120			
		});
		
	}
	$(document).ready(function() {
		var list = $("#mainDiv").dgrid({
			url : 'ajax/listAllProductType',
			editClicked : "editClicked",
			delClicked : "delClicked",
			addClicked : "addClicked",
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				title : '产品类型ID',
				field : 'productType',
				align : 'center',
				width : 80,
				fixed : true

			}, {
				title : '产品类型名称',
				field : 'productTypeDesc',
				width : 100,
				align : 'center',
				fixed : true

			}, {
				title : '分类下产品数量',
				field : 'productCount',
				align : 'center',
				width : 3000
			} ] ],
			delBtnName : "删除分类",
			editBtnName : "编辑分类",
			addBtnName : "添加分类"
		});

	});
</script>
</head>
<body>
	<div id="mainDiv"></div>
	<div id="editWindow" >
	</div>
</body>
</html>