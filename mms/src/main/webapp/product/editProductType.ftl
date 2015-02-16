<div style="padding: 20px; margin: auto;  padding: 10px;20px">
	<form id="pt_edit_form" action="">
		<input id="productType" name="productType" class="easyui-textbox"
			data-options="prompt:'请输入一个产品类别名称'
		,required:true,
		validType:'maxLength[20]'"		
		style="width: 300px">
	</form>
</div>
<script type="text/javascript">

	// 显示进度条
$('#pt_edit_form').form({
	url : "/pt/savept",
	onSubmit: function(){
		$.messager.progress({title:"正在提交，请稍候..."});
		var isValid = $(this).form('validate');
		if (!isValid){
			$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
		}
		return isValid;	// 返回false终止表单提交
	},
	success: function(data){
		$.messager.progress('close');	// 如果提交成功则隐藏进度条
	},
	onLoadError :function(data){
		alert(data);
	}
});
</script>
