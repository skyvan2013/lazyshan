/**
 * 为了方便创建列表页面写的插件
 */
(function($) {
	$.fn.dgrid = function(options) {
		list = $("<table id='datagrid_table'></table>").prependTo(this);
		var defaults = {
			showEditButton : true, // 显示编辑按钮
			showDeleteButton : true, // 显示删除按钮
			showAddButton : true, // 是否显示添加按钮
			showToolbar : true, // 是否显示工具栏,如果工具栏没有显示,那么所有在工具栏上门的控件都不能显示
			delClicked : undefined,
			editClicked : undefined,
		};
		options = $.extend(defaults, options);
		var onEditButtonClick = function() {
			selections = list.datagrid("getSelections").length;
			if (selections < 1) {
				$.messager.alert('提示', '请选中要编辑或查看的行');
				return true;
			} else if (selections > 1) {
				$.messager.alert('提示', '一次只能编辑或查看一行的详情');
				return true;
			} else {

				if (options.editClicked != undefined) {
					return eval(options.editClicked + "(list)");
				}
			}
		}
		var onDeleteButtonClick = function() {
			if (list.datagrid("getSelections").length < 1) {
				$.messager.alert('提示', '请选中要删除的行');
				return true;
			} else if (options.delClicked != undefined) {
				return eval(options.delClicked + "(list)");
			}
		}
		var onAddButtonClick = function() {
			if (options.addClicked != undefined)
				return eval(options.addClicked + "(list)");
		}
		if (options.showToolbar == true) {
			// 创建toolbar
			toolbar = $("<div id='grid_toolbar'></div>");
			toolbar.css('padding', '2px 5px');
			toolbar.hide();
			// toolbar加入文档中
			list.append(toolbar);
			if (options.showDeleteButton == true) { // 添加删除按钮
				$(
						"<a id='del_btn' href='javascript:;' >"
								+ (options.delBtnName != undefined ? options.delBtnName
										: "删除") + "</a>").appendTo(toolbar);
			}
			if (options.showEditButton == true) { // 添加编辑按钮
				$(
						"<a id='edit_btn' href='javascript:;'>"
								+ (options.editBtnName != undefined ? options.editBtnName
										: "编辑") + "</a>").appendTo(toolbar);
				$("<span>&nbsp;</span>").insertBefore("#edit_btn");
				disorenable = function() {
					edit_btn = $("#del_edit");
					if ($(this).datagrid("getChecked").length > 1) {
						edit_btn.linkbutton("disable");
					} else {
						edit_btn.linkbutton("enable");
					}
				}
			}
			if (options.showAddButton == true) { // 添加新增按钮
				$(
						"<a id='add_btn' href='javascript:;' >"
								+ (options.addBtnName != undefined ? options.addBtnName
										: "新增") + "</a>").appendTo(toolbar);
				$("<span>&nbsp;</span>").insertBefore("#add_btn");
			}
			$("#add_btn").linkbutton({
				iconCls : 'icon-add',
				onClick : onAddButtonClick
			});
			$("#edit_btn").linkbutton({
				iconCls : 'icon-edit',
				onClick : onEditButtonClick
			});
			$("#del_btn").linkbutton({
				iconCls : 'icon-remove',
				onClick : onDeleteButtonClick
			});
		}

		var otherDefaultOptions = {
			onCheck : options.showToolbar && options.showEditButton
					&& disorenable,
			onUncheck : options.showToolbar && options.showEditButton
					&& disorenable,
			onCheckAll : options.showToolbar && options.showEditButton
					&& disorenable,
			onUncheckAll : options.showToolbar && options.showEditButton
					&& disorenable,
			toolbar : options.showToolbar && toolbar,
			rownumbers : true,
			pagination : true,
			ctrlSelect : true,
			striped : true,
			singleSelect : false,
			collapsible : true,
			fitColumns : true,
			pageSize : 15,
			pageList : [15,30,45,60,75]
		}
		options = $.extend(options, otherDefaultOptions);
		// 打开渲染列表
		list.datagrid(options);
		return list;
	};
})(jQuery);

/**
 * 自动调整datagrid的宽度
 */
$(window).resize(function() {
	list.datagrid('resize', {
		width : $(window).width() - 162
	})
});

/**
 * 工程中默认的编辑框dialog参数
 */
(function($) {
	$.fn.extend($.fn.dialog.defaults, {
		width : 600,
		height : 400,
		modal : true,
		buttons: [{ text:'保存',
			iconCls:'icon-ok',
			handler:function(){
						var current_window = $(this).parents(".dialog-button").siblings(".window-body");
						current_window.find("form").form("submit");
					}
		  },{text:'取消',
			handler:function(){
						var current_window = $(this).parents(".dialog-button").siblings(".window-body");
						current_window.dialog("close");
					}
		}]
	})
})(jQuery);

$.extend($.fn.validatebox.defaults.rules, {
	maxLength : {
		validator : function(value, param) {
			return value.length <= param[0];
		},
		message : '最多可输入 {0}个字！'
	},
	minLength : {
		validator : function(value, param) {
			return value.length >= param[0];
		},
		message : '最少需要输入{0}个字！.'
	}
});
