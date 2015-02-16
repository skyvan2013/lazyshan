<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型列表</title>
<script type="text/javascript" src="/js/app/js/dgrid.js"></script>
<script type="text/javascript">
	function delClicked(list) {
	}
	function editClicked(list) {
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