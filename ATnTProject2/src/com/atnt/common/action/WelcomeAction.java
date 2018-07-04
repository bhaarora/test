package com.atnt.common.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.wink.json4j.JSONObject;
 
public class WelcomeAction extends Action{
 
	//Get a logger
	private static final Logger logger = Logger.getLogger(WelcomeAction.class);
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {
		
		//logs debug
		if(logger.isDebugEnabled()){
			logger.debug("WelcomeAction.execute()");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
				
	    return mapping.findForward("success");
	    
	}
 
}