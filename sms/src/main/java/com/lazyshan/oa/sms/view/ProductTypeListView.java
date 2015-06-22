package com.lazyshan.oa.sms.view;

import java.io.Serializable;
import java.util.Date;

public class ProductTypeListView implements Serializable {
	private static final long serialVersionUID = 3080200525754003489L;
	private Integer typeId;
	private String typeName;
	private Integer parentTypeId;
	private int typeLevel;
	private Integer position;
	private String desc;
}
