<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型列表</title>
<script type="text/javascript" src="/js/app/js/dgrid.js"></script>
<script type="text/javascript">
	function delClicked(list) {
		$.messager.confirm("提示", "分类下如果有商品数据的话将不能删除,确定要删除所选的分类吗?", function(c) {
			if (c == true) {
				var rows = list.datagrid("getSelections");
				if (rows.length == 0)
					return false;
				var queryData = "";
				var ignoreLines = [];
				for (var i = 0; i < rows.length; i++) {
					if(rows[i].productCount > 0){
						var il = {};
						il.pt=rows[i].productType;
						il.ptn=rows[i].productTypeDesc;
						ignoreLines.push(il);
						continue;
					}
					queryData += "&pts=" + rows[i].productType
				}
				
				var progress = function(){
					$.messager.progress({
						title : "正在删除,请稍候"
					});
					$.ajax({
						url : "/pt/delpts",
						type : "get",
						data : queryData,
						dataType : "json",
						success : function(data) {
							if (data.success == true) {
								$.messager.alert("提示", "删除成功");
								location.reload(true);
							} else {
								$.messager.alert("提示", "删除失败");
							}
						},
						complete : function() {
							$.messager.progress("close");
						},
						error : function() {
							$.messager.alert("提示", "删除失败");
						}

					});
				}
				if(ignoreLines.length > 0){
					var str = "以下分类下已经包含了产品([产品类型ID|产品类型名称]),将不会删除:<br/>";
					for(var i = 0; i<ignoreLines.length; i++){
						str += "["+ignoreLines[i].pt+"|"+ignoreLines[i].ptn+"]";
						if((i+1) < ignoreLines.length)
							str +=",";
					}
					$.messager.confirm("提示",str+"<br/>确定继续吗?",function(){ progress();});
				}else{
					progress();
				}
				
			}
		});
	}
	function editClicked(list) {
		var row = list.datagrid("getSelected");
		var a = $("#editWindow").dialog({
			title : "编辑产品类型",
			href : "/pt/editpt",
			queryParams : {
				productType : row.productType
			},
			height : 120
		});
	}
	function addClicked(list) {
		var a = $("#addWindow").dialog({
			title : "添加产品类型",
			href : "/pt/editpt",
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
	<div id="editWindow"></div>
	<div id="addWindow"></div>
</body>
</html>