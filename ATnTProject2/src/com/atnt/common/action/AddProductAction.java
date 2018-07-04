package com.atnt.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import code.java.servlet.ContextListener;

public class AddProductAction {
	
private static final Logger logger = Logger.getLogger(AddProductAction.class);
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {
 
		//logs debug
		logger.info("Info action in login");
		
		ContextListener config = ContextListener.getInstance(request.getServletContext());
		String key = config.getProperty(request.getParameter("userId"));
		if(key != null)
 		{
	    return mapping.findForward("success");
		}
		 return mapping.findForward("failure");
	    
	}

}
