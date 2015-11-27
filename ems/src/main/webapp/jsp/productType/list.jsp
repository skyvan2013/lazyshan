<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>

<title>首页</title>
<link rel="stylesheet" href="/statics/assets/css/jquery.gritter.css" />
<link rel="stylesheet" href="/statics/assets/css/ace.min.css" />
<link rel="stylesheet" href="/statics/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="/statics/assets/css/ace-skins.min.css" />
<script src="/statics/assets/js/jquery.nestable.min.js"></script>
<script src="/statics/assets/js/jquery.gritter.min.js"></script>
<script src="/statics/assets/js/bootbox.min.js"></script>
<script src="/statics/app/js/json2.js"></script>
<script src="/statics/app/js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var moveLi;
		var moveLiParent;
		//添加document监听事件,记录移动的行，这是hack的做法，不推荐。。需要在初始化nestable前添加
		$(document).on("mouseup", function(e) {
			var placeholder = $(".dd-placeholder");
			moveLi = placeholder.next();
			moveLiParent = placeholder.parent();
		});

		initNestable();
		//决定是否添加“添加子分类”按钮
		$(document).on("mouseup", function() {
			var li;
			if (moveLi.length == 0) {
				li = moveLiParent.children(":last");
			} else if (moveLi.length > 0) {
				li = moveLi.prev();
			} else {
				return true;
			}
			level = li.parentsUntil(".dd", "ol").length;
			if (level == 1) { //ol
				var btn = $("[data-rel=level1_blank_line]  [data-rel2='add_type_btn']");
				if (li.find("[data-rel2='add_type_btn']").length == 0) {
					li.find(".oper_btn_div:first").append(btn.clone());
					li.toggleClass("level-1").toggleClass("level-2");
				}
			} else if (level == 2) {
				var btn = li.find("[data-rel2='add_type_btn']");
				if (btn.length > 0) {
					btn.remove();
					li.toggleClass("level-1").toggleClass("level-2");
				}
			}
			moveLi = undefined;
			moveLiParent = undefined;
		});
		//"继续添加"按钮
		$(".product_type_main_content").on(ace.click_event, '[data-rel2="add_type_btn"]', function() {
			if (this.dataset.addLevel == "1") {
				var blankLine = $("[data-rel='level1_blank_line']");
				newBlankLine = blankLine.clone().removeAttr("data-rel");
				newBlankLine.removeClass("hidden");
				newBlankLine.insertBefore(blankLine);
				newBlankLine.find('[data-rel="tooltip"]').tooltip();
			} else if (this.dataset.addLevel = "2") {
				var levelOneLi = $(this).parents("li:first");
				if (levelOneLi.find("ol").length == 0) {
					ol = $("#blank_line").clone();
					ol.removeAttr("id");
					ol.removeClass("hidden");
					levelOneLi.append(ol);
					levelOneLi.find('[data-rel="tooltip"]').tooltip();
				} else {
					var li = $("#blank_line").children("li").clone()
					levelOneLi.find("ol").append(li);
					li.find('[data-rel="tooltip"]').tooltip();
				}
				dd.nestable("expandItem", levelOneLi);
				if (levelOneLi.children("[data-action='expand']").length == 0)
					dd.nestable("setParent", levelOneLi);
			}

		});

		//所有输入框change函数
		$(".dd").on("change", '[data-rel="type_name_text"]', function() {
			var currentLine = $(this).parents(".dd-item").get(0);
			currentLine.dataset.typeName = this.value;
		});

		//保存按钮
		$("#btn_save").click(function() {
			//准备数据
			var allTypesData = $('.dd').nestable('serialise');
			//过滤数据
			for (var i = 0; i < allTypesData.length; i++) {
				if (allTypesData[i].typeName == undefined) {
					allTypesData.splice(i, 1);
					i--;
					continue;
				}
				if (allTypesData[i].children) {
					for (var j = 0; j < allTypesData[i].children.length; j++) {
						if (allTypesData[i].children[j].typeName == undefined) {
							allTypesData[i].children.splice(j, 1);
							j--;
						}
					}
				}
			}
			$.ajax({
				type : "post",
				url : "/pt/update",
				dataType : "json",
				data : JSON.stringify(allTypesData),
				contentType : "application/json",
				success : function(obj) {
					if (obj.result == "success") {
						bootbox.alert("保存成功，即将重新加载页面...", function() {
							window.location.href = window.location.href;
						});
					}
				},
				error : function() {
					alert("错误");
				}
			});

		});
		$(".dd").on(ace.click_event, "[data-oper='delete']", function() {
			var li = $(this).parents("li:first");
			bootbox.confirm("确定要删除吗?", function(result) {

				if (result) {
					var typeName = li.get(0).dataset.typeName;
					alert(typeName)
					//
				}
			});
		});
	});

	//初始化可拖拽列表
	function initNestable() {
		window.dd = $('.dd').nestable({
			maxDepth : 2
		}).eq(0);
		dd.nestable("collapseAll");
		$('.dd-handle a').on('mousedown', function(e) {
			e.stopPropagation();
		});
		$('[data-rel="tooltip"]').tooltip();
	}
</script>
<style type="text/css">
.dd {
	max-width: 5000px;
}

.dd2-handle {
	cursor: move;
}

.dd2-content {
	margin: 0px 0px;
	font-family: "Open Sans", "宋体";
	font-weight: normal;
	padding: 2px 0px;
	margin-right: 12px;
}

.dd2-content   .create-time-content {
	line-height: 31px;
	height: 31px;
}

.oper-btn {
	margin: 5px 2px 0px 2px;
	width: 25px;
	padding: 3px;
}

.dd-item {
	margin: 1px 0px;
}

.level-1 .dd2-content {
	padding-left: 25px;
}

.level-1 .create-time-content {
	margin-left: 56px;
}

.level-2 {
	margin-left: 6px;
}

.level-2 .create-time-content {
	margin-left: 29px;
}
</style>
</head>
<body>
	<div class="row product_type_main_content">
		<ol class="hidden dd-list" id="blank_line">
			<li class="dd-item dd2-item level-2">
				<div class="dd-handle dd2-handle">
					<i class="normal-icon icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i>
				</div>
				<div class="row" style="margin-left:36px;">
					<div class="dd2-content">
						<div class="col-xs-3" style="text-align:right">
							<input type="text" value="" placeholder="输入类别名称" data-rel="type_name_text" />
						</div>
						<div class="col-xs-3 create-time-content">今天</div>
						<div style="float:right" class="oper_btn_div">
							<a data-oper='delete' data-rel="tooltip" data-placement="top" title="删除" href="javascript:;"
								class="oper-btn badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="bigger-125 icon-trash"></i>
							</a>
						</div>
					</div>
				</div>
			</li>
		</ol>
		<div class="col-xs-3">
			<button class="btn  btn-primary btn-xs btn-purple" id="btn_save">
				<i class="icon-save bigger-120"></i>保 存
			</button>
			<button class="btn btn-xs" data-rel2="add_type_btn" data-add-level="1">添加主分类</button>
			<!-- 			<button class="btn  btn-primary btn-xs btn-purple"> -->
			<!-- 				<i class="icon-pencil bigger-120"></i> 添 加 -->
			<!-- 			</button> -->
		</div>
		<div class="col-xs-12 space-1"></div>
		<div class="col-xs-12" style="padding:0px 12px;">
			<div class="table-header " style="padding:0px;">
				<div class="row" style="margin-left:36px;">
					<div class="col-xs-3" style="text-align: right">商品类别名称</div>
					<div class="col-xs-8" style="padding-left:50px;">创建时间</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="dd dd-draghandle">
				<ol class="dd-list">
					<c:forEach items="${list}" var="item1">
						<li class="dd-item dd2-item level-1" data-id="${item1.id}" data-order-value='${item1.orderValue}' data-type-name='${item1.typeName}'>
							<div class="dd-handle dd2-handle">
								<i class="normal-icon icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i>
							</div>
							<div class="row" style="margin-left:36px;">
								<div class="dd2-content">
									<div class="col-xs-3" style="text-align:right">
										<input type="text" value="${item1.typeName}" placeholder="输入类别名称" data-rel="type_name_text" />
									</div>
									<div class="col-xs-3 create-time-content">
										<f:formatDate value="${item1.createTime}" pattern="yyyy年MM月dd日 HH:mm" />
									</div>
									<div style="float:right" class="oper_btn_div">
										<a data-rel="tooltip" data-placement="top" title="删除" data-oper="delete" href="javascript:;"
											class="oper-btn badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="bigger-125 icon-trash"></i>
										</a><a data-rel="tooltip" data-placement="top" title="添加子分类" data-rel2="add_type_btn" data-add-level="2" href="javascript:;"
											class="oper-btn badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="bigger-125 icon-plus"></i>
										</a>
									</div>
								</div>
							</div> <c:if test="${item1.subTypes.size()>0}">
								<ol class="dd-list">
									<c:forEach items="${item1.subTypes}" var="item2">
										<li class="dd-item dd2-item level-2" data-id="${item2.id}" data-order-value='${item2.orderValue}' data-type-name='${item2.typeName}'>
											<div class="dd-handle dd2-handle">
												<i class="normal-icon icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i>
											</div>
											<div class="row" style="margin-left:36px;">
												<div class="dd2-content">
													<div class="col-xs-3" style="text-align:right">
														<input type="text" value="${item2.typeName}" placeholder="输入类别名称" data-rel="type_name_text" />
													</div>
													<div class="col-xs-2 create-time-content">${item2.createTime}</div>
													<div style="float:right" class="oper_btn_div">
														<a data-rel="tooltip" data-placement="top" title="删除" href="javascript:;" data-oper='delete'
															class="oper-btn badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="bigger-125 icon-trash"></i>
														</a>
													</div>
												</div>
											</div>
										</li>
									</c:forEach>
								</ol>
							</c:if>
						</li>
					</c:forEach>
					<li class="dd-item dd2-item level-1 hidden" data-rel="level1_blank_line">
						<div class="dd-handle dd2-handle">
							<i class="normal-icon icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i>
						</div>
						<div class="row" style="margin-left:36px;">
							<div class="dd2-content">
								<div class="col-xs-3" style="text-align:right">
									<input type="text" value="" placeholder="输入类别名称" data-rel="type_name_text" />
								</div>
								<div class="col-xs-3 create-time-content">今天</div>
								<div style="float:right" class="oper_btn_div">
									<a data-rel="tooltip" data-placement="top" title="删除" data-oper="delete" href="javascript:;"
										class="oper-btn badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="bigger-125 icon-trash"></i>
									</a><a data-rel="tooltip" data-placement="top" title="添加子分类" data-rel2="add_type_btn" data-add-level="2" href="javascript:;"
										class="oper-btn badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="bigger-125 icon-plus"></i>
									</a>
								</div>
							</div>
						</div>
					</li>
				</ol>
			</div>
		</div>
	</div>

	<!-- sitemesh 提取区块 -->
	<breadcrumb>
	<li><i class="icon-home home-icon"></i> <a href="/">首页</a></li>
	<li class="active">产品类别</li>
	</breadcrumb>
	<cht> 首页 <small> <i class="icon-double-angle-right"></i> 产品类别管理
	</small> </cht>
	<menuid>menu_pt_manage</menuid>
	<!-- ./sitemesh 替换区块 -->
</body>
</html>

