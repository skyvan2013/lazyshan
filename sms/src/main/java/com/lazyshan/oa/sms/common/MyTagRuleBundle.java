package com.lazyshan.oa.sms.common;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

public class MyTagRuleBundle implements TagRuleBundle {
	@Override
	public void install(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		//content head title
		defaultState.addRule("cht", new ExportTagToContentRule(siteMeshContext,contentProperty.getChild("cht"), false));
		defaultState.addRule("breadcrumb", new ExportTagToContentRule(siteMeshContext,contentProperty.getChild("breadcrumb"), false));
	}
	@Override
	public void cleanUp(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		
	}
}