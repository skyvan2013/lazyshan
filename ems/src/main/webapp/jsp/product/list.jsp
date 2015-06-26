<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>

<script src="/statics/assets/js/jquery.nestable.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {

		$('.dd').nestable();
		$('.dd').on('change', function() {
			alert($(".dd-item.dd2-item").data("id"))
		});

		$('.dd-handle a').on('mousedown', function(e) {
			e.stopPropagation();
		});

		$('[data-rel="tooltip"]').tooltip();

	});
</script>
<style type="text/css">
.dd2-handle {
	cursor: move;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-sm-6">
			<div class="dd dd-draghandle">
				<c:if test="${pts.size() > 0}">
					<ol class="dd-list">
						<c:forEach items="${pts}" var="pt">
							<li class="dd-item dd2-item" data-id="${pt.typeId}">
								<div class="dd-handle dd2-handle">
									<i class="icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i>
								</div>
								<div class="dd2-content">
									<a data-rel="tooltip" data-placement="left" title="删除" href="#" class="badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="normal-icon bigger-130 icon-trash"> </i>
									</a>
								</div>
								<!-- 简单处理，顶多两级分类 -->
								<c:if test="${pt.productTypes.size() > 0 }">
									<ol class="dd-list">
									<c:forEach items="${pt.productTypes}" var="pt2">
										<li class="dd-item dd2-item" data-id="${pt2.typeId }">
											<div class="dd-handle dd2-handle">
												<i class="icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i>
											</div>
											<div class="dd2-content">
												<a data-rel="tooltip" data-placement="left" title="删除" href="#" class="badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="normal-icon bigger-130 icon-trash"> </i>
												</a>
											</div>
										</li>
									</c:forEach>
									</ol>
								</c:if>
							</li>
						</c:forEach>
					</ol>
				</c:if>
					<!-- 					<li class="dd-item dd2-item" data-id="14"> -->
					<!-- 						<div class="dd-handle dd2-handle"> -->
					<!-- 							<i class="normal-icon icon-time pink bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i> -->
					<!-- 						</div> -->
					<!-- 						<div class="dd2-content">Recent Posts</div> -->
					<!-- 					</li> -->

					<!-- 					<li class="dd-item dd2-item" data-id="15"> -->
					<!-- 						<div class="dd-handle dd2-handle"> -->
					<!-- 							<i class="normal-icon icon-signal orange bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i> -->
					<!-- 						</div> -->
					<!-- 						<div class="dd2-content">Statistics</div> -->

					<!-- 						<ol class="dd-list"> -->
					<!-- 							<li class="dd-item dd2-item" data-id="16"> -->
					<!-- 								<div class="dd-handle dd2-handle"> -->
					<!-- 									<i class="normal-icon icon-user red bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i> -->
					<!-- 								</div> -->
					<!-- 								<div class="dd2-content">Active Users</div> -->
					<!-- 							</li> -->

					<!-- 							<li class="dd-item dd2-item dd-colored" data-id="17"> -->
					<!-- 								<div class="dd-handle dd2-handle btn-info"> -->
					<!-- 									<i class="normal-icon icon-edit bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i> -->
					<!-- 								</div> -->
					<!-- 								<div class="dd2-content btn-info no-hover">Published Articles</div> -->
					<!-- 							</li> -->

					<!-- 							<li class="dd-item dd2-item" data-id="18"> -->
					<!-- 								<div class="dd-handle dd2-handle"> -->
					<!-- 									<i class="normal-icon icon-eye-open green bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i> -->
					<!-- 								</div> -->
					<!-- 								<div class="dd2-content">Visitors</div> -->
					<!-- 							</li> -->
					<!-- 						</ol> -->
					<!-- 					</li> -->

					<!-- 					<li class="dd-item dd2-item" data-id="19"> -->
					<!-- 						<div class="dd-handle dd2-handle"> -->
					<!-- 							<i class="normal-icon icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i> -->
					<!-- 						</div> -->
					<!-- 						<div class="dd2-content">Menu</div> -->
					<!-- 					</li> -->
				
			</div>
		</div>
		<div class="vspace-sm-16"></div>

	</div>

					<ol  class="dd-list hide" data-template="true">
							<li class="dd-item dd2-item" data-id="">
								<div class="dd-handle dd2-handle">
									<i class="icon-reorder blue bigger-130"></i> <i class="drag-icon icon-move bigger-125"></i>
								</div>
								<div class="dd2-content">
									<a data-rel="tooltip" data-placement="left" title="删除" href="#" class="badge badge-primary radius-5 tooltip-info pull-right white no-hover-underline"> <i class="normal-icon bigger-130 icon-trash"> </i>
									</a>
								</div>
							</li>
					</ol>






	<!-- sitemesh 提取区块 -->
	<breadcrumb>
	<li><i class="icon-home home-icon"></i> <a href="/">首页</a></li>
	<li class="active">产品类别</li>
	</breadcrumb>
	<cht> 首页 <small> <i class="icon-double-angle-right"></i> 产品类别管理
	</small> </cht>
	<!-- ./sitemesh 替换区块 -->
</body>
</html>

