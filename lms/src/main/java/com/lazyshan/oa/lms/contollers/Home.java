package com.lazyshan.oa.lms.contollers;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home extends ControllerBasic {
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/ajax/data")
	public void  simulateData(PrintWriter out) {
		String s = "{\"total\":58,\"rows\":[{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50," + "\"attr1\":\"Large\",\"itemid\":\"EST-1\"},	{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\"," + "\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},	{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\"," + "\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},	{\"productid\":\"RP-SN-01\",\"productname\":"
				+ "\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},	{\"productid\":\"RP-LI-02\",\"" + "productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},	{\"productid\":\"" + "FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},	{\"productid\""
				+ ":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},	{\"productid\"" + ":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":23.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},	{\"productid\"" + ":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"},	{\"productid\":"
				+ "\"AV-CB-01\",\"productname\":\"Amazon Parrot\",\"unitcost\":92.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"}]}";
	}

}
