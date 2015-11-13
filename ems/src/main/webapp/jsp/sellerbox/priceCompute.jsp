<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>客服辅助工具-价格计算</title>
<script src="/statics/assets/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/statics/assets/css/chosen.css" />
<link rel="stylesheet" href="/statics/assets/css/ace.min.css" />
<style type="text/css">
.dd2-handle {
	cursor: move;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		var optionStr = '<option value=""></option>';
		var typeChosen = $(".type_select");
		var productChosen = $(".product_select");
		var setChosen = $(".set_select");
		var image = $(".product_image");
		//添加产品类别
		init(typeChosen, productChosen, setChosen, image);
		typeChosen.chosen({
			disable_search_threshold : 100
		}).trigger("chosen:updated").change(function() {//选择了类型
			var currentTypeChosen = $(this);
			//如果存在第一个空白选项，则去除掉它
			currentTypeChosen.children("[value='0']").remove();

			var currentProductChosen = $("#" + currentTypeChosen.data("cascadeProductId"));
			currentProductChosen.children().css("display", "none");
			currentProductChosen.children().each(function() {
				if ($(this).data("fortype") == currentTypeChosen.val()) {
					$(this).css("display", "");
				}
			});
			//如果下一级没有空白选项则添加一个
			$(optionStr).prependTo(currentProductChosen).attr("selected", true).val(0).text("请选择产品");

			currentProductChosen.trigger("chosen:updated");
			currentTypeChosen.trigger("chosen:updated");
			currentProductChosen.trigger("change", false);
		});

		productChosen.chosen({
			disable_search_threshold : 100
		}).trigger("chosen:updated").change(function(e, removeBlankOption) { //选择了产品
			var currentProductChosen = $(this);
			//如果存在第一个空白选项，则去除掉它
			if (removeBlankOption)
				currentProductChosen.children("[value='0']").remove();

			//显示产品图片
			var currentImg = $("#" + currentProductChosen.data("cascadeImgId"));
			var imgPath = currentProductChosen.children().filter("option:selected").data("img");
			currentImg.attr("src", imgPath==undefined ? "/statics/upload/images/pricecompute/nopic.jpg" : imgPath);
			//显示产品组合
			var currentSetChosen = $("#" + currentProductChosen.data("cascadeSetId"));
			currentSetChosen.children().css("display", "none");
			currentSetChosen.children().each(function() {
				if ($(this).data("forproduct") == currentProductChosen.val()) {
					$(this).css("display", "");
				}
			});
			//如果下一级没有空白选项则添加一个
			$(optionStr).prependTo(currentSetChosen).attr("selected", true).val(0).text("请选择组合");
			currentSetChosen.trigger("chosen:updated");
			currentProductChosen.trigger("chosen:updated");
			currentSetChosen.trigger("change", false);

		});
		setChosen.chosen({
			disable_search_threshold : 100
		}).change(function(e, removeBlankOption) {
			var currentSetChosen = $(this);
			//如果存在第一个空白选项，则去除掉它
			if (removeBlankOption)
				currentSetChosen.children("[value='0']").remove();
			currentSetChosen.trigger("chosen:updated");
		});
		$(".coumn-rest-btn").click(function() {
			var currentTypeChosen = $("#" + $(this).data("cascadeProductTypeId"));
			var currentProductChosen = $("#" + $(this).data("cascadeProductId"));
			var currentSetChosen = $("#" + $(this).data("cascadeSetId"));
			var currentImg = $("#" + $(this).data("cascadeImg"));

			init(currentTypeChosen, currentProductChosen, currentSetChosen, currentImg);
			currentTypeChosen.chosen({
				disable_search_threshold : 100
			}).trigger("chosen:updated");
			currentProductChosen.chosen({
				disable_search_threshold : 100
			}).trigger("chosen:updated");
			currentSetChosen.chosen({
				disable_search_threshold : 100
			}).trigger("chosen:updated");
		});
		$("#to_detail_btn").click(toDetail);

		$("#re_compute_btn").click(function() {
			//配送费
			var peisongfei = $("#peisongfei").val();
			//物流成本
			var deliveryCost = $("#delivery_cost").val();
			//订单总金额
			var priceAamount = $("#price_amount").val();
			//包装体积
			var allVolumn = $("#all_product_volumn").val();
			//产品成本
			var productCost = $("#all_product_cost").val();
			// 			alert(peisongfei+","+deliveryCost +","+priceAamount +","+allVolumn+","+productCost);

			if (peisongfei == 0) {
				alert("配送费没有填写！")
				return;
			} else if (deliveryCost == 0) {
				alert("物流费用没有填写！")
				return;
			} else if (priceAamount == 0) {
				alert("总售价没有填写！")
				return;
			} else if (allVolumn == 0) {
				alert("总体积没有填写！")
				return;
			} else if (productCost == 0) {
				alert("产品总成本(出厂价)没有填写！")
				return;
			}
			var profit = priceAamount * 0.945 - peisongfei - (allVolumn * deliveryCost) - productCost;
			$("#final_profit").text(Math.round(profit));
			$("#profit_rate").text(getPercent(profit, priceAamount));

		});
	});

	function getPercent(num, total) {
		num = parseFloat(num);
		total = parseFloat(total);
		if (isNaN(num) || isNaN(total)) {
			return "-";
		}
		return total <= 0 ? "0%" : (Math.round(num / total * 10000) / 100.00 + "%");
	}

	function init(typeChosen, productChosen, setChosen, image) {
		var productType = $("#type_compute_mian").data("opts").data;
		var optionStr = '<option value=""></option>';
		//清空数据
		image.attr("src", "/statics/upload/images/pricecompute/nopic.jpg"); //图片
		typeChosen.html("");
		productChosen.html("");
		setChosen.html("");
		//添加1个空白类型
		$(optionStr).appendTo(typeChosen).val(0).text("请选择产品类型");
		$(optionStr).appendTo(productChosen).val(0).text("请选择产品");
		$(optionStr).appendTo(setChosen).val(0).text("请选择组合");

		for (var i = 0; i < productType.length; i++) {
			pt = productType[i];
			$(optionStr).appendTo(typeChosen).val(pt.name).data("products", pt.products).text(pt.name);
			var ps = pt.products;
			for (var j = 0; j < ps.length; j++) { //初始化产品数据
				var p = ps[j];
				var productOption = $(optionStr).appendTo(productChosen).data("fortype", pt.name).val(p.name).text(p.name).data("img", p.imageName).css("display", "none");
				var sets = p.sets;
				for (var k = 0; k < sets.length; k++) { //初始化组合数据
					var set = sets[k];
					var setOption = $(optionStr).appendTo(setChosen).data("forproduct", p.name).val(set.name).text(set.name);
					setOption.css("display", "none");
					//立方数
					setOption.data("volume", set.volume);
					//日常价
					setOption.data("dailyPrice", set.dailyPrice);
					//活动价
					setOption.data("activityPrice", set.activityPrice);
					//成本
					setOption.data("cost", set.cost);

				}
			}
		}

	}

	function validateToDetailOrNot(productTypeChosen, productChosen, setChosen) {
		var a = productTypeChosen.val() != 0;
		var b = productChosen.val() != 0;
		var c = setChosen.val() != 0;
		if ((a || b || c) && !(a && b && c)) {
			return 1; //部分选中
		} else if (a && b && c) {
			return 2; //全部选中
		} else {
			return 0; //全部没选中
		}

	}

	var allCost = 0; //总成本
	var allVolumn = 0; //总方数

	function toDetail() {
		initDetalTable();
		var i = 1;

		var dailyPriceAmount = 0;
		var activityPriceAmount = 0;

		var shouldAlert = false; //是否要提示有部分区域没全部选中
		var allTypeSelection = $(".type_select");
		var validSelectionCount = 0;
		allTypeSelection.each(function() {
			var me = $(this);
			var setChosen = $("#" + me.data("cascadeSetId"));
			var productChosen = $("#" + me.data("cascadeProductId"));
			var validateResult = validateToDetailOrNot(me, productChosen, setChosen);

			if (validateResult == 1)
				shouldAlert = true;
			if (validateResult != 2)
				return true;
			validSelectionCount ++;
			//产品类别
			var productType = me.val();
			//产品名称型号
			var product = productChosen.val();
			//产品组合
			var set = setChosen.val();
			var setOption = setChosen.children(":selected");
			//立方数
			var volumn = setOption.data("volume");
			//日常价
			var dailyPrice = setOption.data("dailyPrice");
			dailyPriceAmount += dailyPrice;
			//活动价
			var activityPrice = setOption.data("activityPrice");
			activityPriceAmount += activityPrice;
			//成本
			var cost = setOption.data("cost");
			//填充价格汇总表行
			fillPriceDetailTable(productType, product, set, dailyPrice, activityPrice);
			allVolumn += volumn;
			allCost += cost;

		});
		if(validSelectionCount == 0){
			alert("没有选择任何产品");
			return;
		}
		//填充小结
		$("#daily_price_amount").html(dailyPriceAmount);
		$("#activity_price_amount").html(activityPriceAmount);
		$("#reduce_amount").html(dailyPriceAmount - activityPriceAmount);
		if (shouldAlert) {
			alert("部分产品区域没有选择完毕，将忽略");
		}

		//计算利润区域

		$("#price_amount").val(activityPriceAmount);
		$("#all_product_volumn").val(allVolumn);
		$("#all_product_cost").val(allCost);
		
		$("#detail_head").removeClass("hidden");
		$("#profit_detail").removeClass("hidden");
		$("#price_detail").removeClass("hidden");
		window.location.href="#pcpt";
	}

	function fillPriceDetailTable(productType, product, set, dailyPrice, activityPrice) {
		var tr = $("<tr class='detail_table_line'></tr>").prependTo($("#price_detail tbody"));
		var str = "<td></td>";
		var str2 = "<td align='right'><span class='label label-sm label-warning'>" + activityPrice + "</span></td>";
		var str3 = "<td align='right'><span class='label label-sm label-success'>" + dailyPrice + "</span></td>";
		//计算已优惠
		var reduce = dailyPrice - activityPrice;
		$(str).prependTo(tr).html(reduce).css("text-align", "right");
		$(str2).prependTo(tr);
		$(str3).prependTo(tr);
		$(str).prependTo(tr).html(set);
		$(str).prependTo(tr).html(product);
		$(str).prependTo(tr).html(productType);
	}

	function initDetalTable() {
		$(".data_fill_aware").html("");//清空小计
		//清除生成的行
		$(".detail_table_line").remove();

		allCost = 0;
		allVolumn = 0;
	}
</script>
</head>
<body>
	<div id="type_compute_mian" class="row" data-opts='${options}'>
		<c:forEach begin="1" end="6" varStatus="status">
			<div class="col-xs-2">
				<div class="width-85" style="text-align:center">
					<img class="product_image" id="img${status.index}" src="" width="134" height="134" />
				</div>
				<div style="height:20px;"></div>
				<select class="width-85 chosen-select type_select" data-cascade-set-id="set_select${status.index}" data-cascade-product-id="product_select${status.index}" id="type_select${status.index}">

				</select>
				<div style="height:20px;"></div>
				<select class="width-85 chosen-select product_select" id="product_select${status.index}" data-cascade-img-id="img${status.index}" data-cascade-set-id="set_select${status.index}">

				</select>
				<div style="height:20px;"></div>
				<select class="width-85 chosen-select set_select" id="set_select${status.index}">

				</select>
				<div style="height:20px;"></div>
				<button class="btn coumn-rest-btn" style="padding:3px 6px;" data-cascade-img="img${status.index}" data-cascade-product-id="product_select${status.index}" data-cascade-set-id="set_select${status.index}" data-cascade-product-type-id="type_select${status.index}">
					<i class="icon-undo"></i> 重置
				</button>
			</div>
		</c:forEach>
		<div class="hr hr24 col-xs-12"></div>
		<button class="btn btn-app btn-light btn-xs" id="to_detail_btn"> <i class="icon-print bigger-160"></i> 生成明细
		</button>
		<div id="detail_head" class="hidden">
			<div class="hr hr24 col-xs-12"></div>
			<div class="col-xs-5">
				<h4>价格汇总</h4>
			</div>
			<div class="col-xs-7">
				<h4 style="display:inline-block">利润计算</h4>
				<button class="btn coumn-rest-btn" style="padding:3px 6px;" id="re_compute_btn">
					<i class="icon-undo"></i> 计算
				</button>
			</div>
		</div>
		<div class="col-xs-5 hidden" style="height:300px;margin-top:20px;" id="price_detail">
			<table id="sample-table-2" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>产品类型</th>
						<th>产品</th>
						<th>组合</th>
						<th>日常价（元）</th>
						<th>双11价格（元）</th>
						<th>已优惠（元）</th>
					</tr>
				</thead>
				<tbody>
					<!-- 					<tr class="detail_table_line"> -->
					<!-- 						<td></td> -->
					<!-- 						<td></td> -->
					<!-- 						<td></td> -->
					<!-- 						<td></td> -->
					<!-- 						<td><span class="label label-sm label-success">12312元</span></td> -->
					<!-- 						<td><span class="label label-sm label-warning">1254元</span></td> -->
					<!-- 					</tr> -->
					<tr>
						<td colspan="3" style="text-align:right;">小计：</td>
						<td class="data_fill_aware" id="daily_price_amount" style="text-align:right;"></td>
						<td class="data_fill_aware" id="activity_price_amount" style="text-align:right;"></td>
						<td class="data_fill_aware" id="reduce_amount" style="text-align:right;"></td>
					</tr>
				</tbody>
			</table>

		</div>
		<div class="col-xs-7 hidden" style="height:300px;margin-top:20px;" id="profit_detail">
			<div class="row profit_area">
				<div class="col-xs-1" style="text-align:right;padding:5px;"></div>
				<div class="col-xs-2" style="padding:5px;">总售价x94.5%：</div>
				<div class="col-xs-9" style="padding:5px;">
					<input type="text" type="text" id="price_amount" /> × 94.5%
				</div>
				<div class="hr col-xs-12"></div>
				<div class="col-xs-1" style="text-align:right;padding:5px;">—</div>
				<div class="col-xs-2" style="padding:5px;">运费x体积：</div>
				<div class="col-xs-9" style="padding:5px;">
					<input type="text" id="delivery_cost" />元/m³ × <input type="text" id="all_product_volumn" />m³
				</div>
				<div class="hr col-xs-12"></div>
				<div class="col-xs-1" style="text-align:right;padding:5px;">—</div>
				<div class="col-xs-2" style="padding:5px;">产品成本：</div>
				<div class="col-xs-9" style="padding:5px;">
					<input type="text" id="all_product_cost" />元
				</div>
				<div class="hr col-xs-12"></div>
				<div class="col-xs-1" style="text-align:right;padding:5px;">—</div>
				<div class="col-xs-2" style="padding:5px;">配送安装费：</div>
				<div class="col-xs-9" style="padding:5px;">
					<input type="text" id="peisongfei" />元
				</div>
				<div class="hr col-xs-12"></div>
				<div class="col-xs-1" style="text-align:right;padding:5px;">=</div>
				<div class="col-xs-2" style="padding:5px;">利润：</div>
				<div class="col-xs-9" style="padding:5px;">
					<span id="final_profit">0</span>元，利润比例&nbsp;<span id="profit_rate" style="min-width:20px;border-bottom:1px solid blue;">0%</span>
				</div>
			</div>
		</div>
	</div>
	<a id="pcpt"></a>



	<!-- sitemesh 提取区块 -->
	<breadcrumb>
	<li><i class="icon-home home-icon"></i> <a href="/">首页</a></li>
	<li class="active">价格计算</li>
	</breadcrumb>
	<cht> 首页 <small> <i class="icon-double-angle-right"></i> 价格计算
	</small> </cht>
	<menuid>menu_price_compute</menuid>
	<!-- ./sitemesh 替换区块 -->
</body>
</html>