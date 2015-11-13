package com.lazyshan.oa.sms.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazyshan.oa.sms.common.GsonUtils;
import com.lazyshan.oa.sms.temp.ProductType;
import com.lazyshan.oa.sms.temp.ProductType.Product;
import com.lazyshan.oa.sms.temp.ProductType.Product.ProductSet;

@Controller
@RequestMapping("/sellerbox")
public class SellerBox extends BaseController {
	public List<ProductType> pts;
	
		
	
	
	
	@RequestMapping("/pc")
	public String priceCompute(Model model){
		Map map = new HashMap();
		map.put("data", pts);
		model.addAttribute("options",GsonUtils.toJson(map));
		return "sellerbox/priceCompute";
	}
	
	
	
	@PostConstruct
	public void initData(){
		pts = new ArrayList<ProductType>();
		ProductType pt;
		List<ProductType.Product> ps;
		ProductType.Product p;
		List<ProductType.Product.ProductSet> psets;
		ProductType.Product.ProductSet pset;
//===========================沙发================================= begin		
		pt = new ProductType();
		pt.setName("沙发");//类别名称
		ps = new ArrayList<Product>();
		pt.setProducts(ps);
//===========================W320================================= begin
		p = new ProductType.Product();
		p.setName("W320");//具体产品
		p.setImageName("W320.jpg");//图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合1【双+贵】");//组合名称
		pset.setVolume(1.8F);//包装体积
		pset.setDailyPrice(7839);//日常价
		pset.setActivityPrice(6848);//双11活动价
		pset.setCost(4100);//成本
		psets.add(pset);
		
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合2【单+双+贵】");//组合名称
		pset.setVolume(2F);//包装体积
		pset.setDailyPrice(8972);//日常价
		pset.setActivityPrice(7842);//双11活动价
		pset.setCost(4655);//成本
		psets.add(pset);
		
		
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合3【单人位+双人位+三人位】");//组合名称
		pset.setVolume(2.8F);//包装体积
		pset.setDailyPrice(12878);//日常价
		pset.setActivityPrice(10965);//双11活动价
		pset.setCost(6450);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合4【双人位+三人位】");//组合名称
		pset.setVolume(2.5F);//包装体积
		pset.setDailyPrice(9689);//日常价
		pset.setActivityPrice(8245);//双11活动价
		pset.setCost(4850);//成本
		psets.add(pset);	
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合5【双人位+双人位+三人位】");//组合名称
		pset.setVolume(3F);//包装体积
		pset.setDailyPrice(13892);//日常价
		pset.setActivityPrice(11900);//双11活动价
		pset.setCost(7000);//成本
		psets.add(pset);
		
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("单人位");//组合名称
		pset.setVolume(0.5F);//包装体积
		pset.setDailyPrice(3406);//日常价
		pset.setActivityPrice(3050);//双11活动价
		pset.setCost(1600);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("双人位");//组合名称
		pset.setVolume(0.5F);//包装体积
		pset.setDailyPrice(4574);//日常价
		pset.setActivityPrice(3935);//双11活动价
		pset.setCost(2150);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("三人位");//组合名称
		pset.setVolume(1F);//包装体积
		pset.setDailyPrice(5742);//日常价
		pset.setActivityPrice(4941);//双11活动价
		pset.setCost(2700);//成本
		psets.add(pset);
		
		
		
		ps.add(p);
//===========================W320================================= end
//===========================W326================================= begin
		p = new ProductType.Product();
		p.setName("W326");//具体产品
		p.setImageName("W326.jpg");//图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合A【三+贵】");//组合名称
		pset.setVolume(1.8F);//包装体积
		pset.setDailyPrice(6357);//日常价
		pset.setActivityPrice(5467);//双11活动价
		pset.setCost(3350);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合B【双+贵】");//组合名称
		pset.setVolume(2F);//包装体积
		pset.setDailyPrice(5450);//日常价
		pset.setActivityPrice(4687);//双11活动价
		pset.setCost(2800);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合C【四+贵】");//组合名称
		pset.setVolume(2.5F);//包装体积
		pset.setDailyPrice(7401);//日常价
		pset.setActivityPrice(6365);//双11活动价
		pset.setCost(3900);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合D【三+贵+扶手柜】");//组合名称
		pset.setVolume(2.5F);//包装体积
		pset.setDailyPrice(7235);//日常价
		pset.setActivityPrice(6222);//双11活动价
		pset.setCost(3700);//成本
		psets.add(pset);	
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合E【双+贵+扶手柜】");//组合名称
		pset.setVolume(2.2F);//包装体积
		pset.setDailyPrice(6300);//日常价
		pset.setActivityPrice(5418);//双11活动价
		pset.setCost(3150);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合F【单人位+双人位+三人位】");//组合名称
		pset.setVolume(2.8F);//包装体积
		pset.setDailyPrice(8955);//日常价
		pset.setActivityPrice(7701);//双11活动价
		pset.setCost(4300);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("组合G【双人位+三人位】");//组合名称
		pset.setVolume(2.3F);//包装体积
		pset.setDailyPrice(6856);//日常价
		pset.setActivityPrice(5896);//双11活动价
		pset.setCost(3300);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("双扶手单人位");//组合名称
		pset.setVolume(0.5F);//包装体积
		pset.setDailyPrice(2203);//日常价
		pset.setActivityPrice(1895);//双11活动价
		pset.setCost(1000);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("双扶手双人位");//组合名称
		pset.setVolume(0.9F);//包装体积
		pset.setDailyPrice(3194);//日常价
		pset.setActivityPrice(2747);//双11活动价
		pset.setCost(1450);//成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("双扶手三人位");//组合名称
		pset.setVolume(1.1F);//包装体积
		pset.setDailyPrice(4075);//日常价
		pset.setActivityPrice(3505);//双11活动价
		pset.setCost(1850);//成本
		psets.add(pset);
		
		ps.add(p);
//===========================W326================================= end 
		pts.add(pt);
//===========================沙发================================= end		

// ===========================茶几================================= begin
		pt = new ProductType();
		pt.setName("茶几");// 类别名称
		ps = new ArrayList<Product>();
		pt.setProducts(ps);
// ===========================CJ320A================================= begin
		p = new ProductType.Product();
		p.setName("CJ320A");// 具体产品
		p.setImageName("CJ320A.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		pset = new ProductType.Product.ProductSet();
		pset.setName("无组合");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(1710);// 日常价
		pset.setActivityPrice(1535);// 双11活动价
		pset.setCost(900);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================CJ320A================================= end
// ===========================CJ326A================================= begin
		p = new ProductType.Product();
		p.setName("CJ326A");// 具体产品
		p.setImageName("CJ326A.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		pset = new ProductType.Product.ProductSet();
		pset.setName("无组合");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(1599);// 日常价
		pset.setActivityPrice(1424);// 双11活动价
		pset.setCost(800);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================CJ326A================================= end
		
		
		pts.add(pt);
// ===========================茶几================================= end
		
// ===========================方几================================= begin
		pt = new ProductType();
		pt.setName("方几");// 类别名称
		ps = new ArrayList<Product>();
		pt.setProducts(ps);
// ===========================CJ326B================================= begin
		p = new ProductType.Product();
		p.setName("CJ326B");// 具体产品
		p.setImageName("CJ326B.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("无组合");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(950);// 日常价
		pset.setActivityPrice(800);// 双11活动价
		pset.setCost(550);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================CJ326B================================= end
		
		
		
		pts.add(pt);
// ===========================方几================================= end

		
// ===========================电视柜================================= begin
		pt = new ProductType();
		pt.setName("电视柜");// 类别名称
		ps = new ArrayList<Product>();
		pt.setProducts(ps);
// ===========================TV320================================= begin
		p = new ProductType.Product();
		p.setName("TV320");// 具体产品
		p.setImageName("TV320.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("无组合");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(3168);// 日常价
		pset.setActivityPrice(2839);// 双11活动价
		pset.setCost(1500);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================TV320================================= end

		
// ===========================TV326================================= begin
		p = new ProductType.Product();
		p.setName("TV326");// 具体产品
		p.setImageName("TV326.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("无组合");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(2050);// 日常价
		pset.setActivityPrice(1820);// 双11活动价
		pset.setCost(1050);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================TV326================================= end
		
		
		pts.add(pt);
// ===========================电视柜================================= end


// ===========================斗柜================================= begin
		pt = new ProductType();
		pt.setName("斗柜");// 类别名称
		ps = new ArrayList<Product>();
		pt.setProducts(ps);
// ===========================DG326================================= begin
		p = new ProductType.Product();
		p.setName("DG326");// 具体产品
		p.setImageName("DG326.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("三层四斗柜");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(1320);// 日常价
		pset.setActivityPrice(1140);// 双11活动价
		pset.setCost(660);// 成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("四层五斗柜");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(1660);// 日常价
		pset.setActivityPrice(1440);// 双11活动价
		pset.setCost(830);// 成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("五层六斗柜");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(1960);// 日常价
		pset.setActivityPrice(1690);// 双11活动价
		pset.setCost(930);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================DG326================================= end
		
		
		pts.add(pt);
// ===========================斗柜================================= end
// ===========================餐桌椅================================= begin
		pt = new ProductType();
		pt.setName("餐桌椅");// 类别名称
		ps = new ArrayList<Product>();
		pt.setProducts(ps);		
// ===========================CT212================================= begin
		p = new ProductType.Product();
		p.setName("CT212");// 具体产品
		p.setImageName("CT212.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("餐桌1.56米");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(2304);// 日常价
		pset.setActivityPrice(2063);// 双11活动价
		pset.setCost(1280);// 成本
		psets.add(pset);

		pset = new ProductType.Product.ProductSet();
		pset.setName("餐桌1.56米+6椅");// 组合名称
		pset.setVolume(0.7F);// 包装体积
		pset.setDailyPrice(5328);// 日常价
		pset.setActivityPrice(4775);// 双11活动价
		pset.setCost(2960);// 成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("餐桌1.56米+4椅");// 组合名称
		pset.setVolume(0.9F);// 包装体积
		pset.setDailyPrice(2304);// 日常价
		pset.setActivityPrice(2063);// 双11活动价
		pset.setCost(2400);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================CT212================================= end

		
// ===========================CT212================================= begin
		p = new ProductType.Product();
		p.setName("CT205");// 具体产品
		p.setImageName("CT205.jpg");// 图片名称
		psets = new ArrayList<ProductSet>();
		p.setSets(psets);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("单餐桌");// 组合名称
		pset.setVolume(0.5F);// 包装体积
		pset.setDailyPrice(2320);// 日常价
		pset.setActivityPrice(2068);// 双11活动价
		pset.setCost(1160);// 成本
		psets.add(pset);

		pset = new ProductType.Product.ProductSet();
		pset.setName("一桌四椅");// 组合名称
		pset.setVolume(0.7F);// 包装体积
		pset.setDailyPrice(4560);// 日常价
		pset.setActivityPrice(3984);// 双11活动价
		pset.setCost(2280);// 成本
		psets.add(pset);
		
		pset = new ProductType.Product.ProductSet();
		pset.setName("一桌六椅");// 组合名称
		pset.setVolume(0.9F);// 包装体积
		pset.setDailyPrice(5680);// 日常价
		pset.setActivityPrice(5092);// 双11活动价
		pset.setCost(2840);// 成本
		psets.add(pset);

		ps.add(p);
// ===========================CT212================================= end
		
		
		
		pts.add(pt);
// ===========================餐桌椅================================= end
	}
	
}


