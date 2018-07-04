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

import code.java.servlet.ContextListener;
 
public class LogonAction extends Action{
 
	//Get a logger
	private static final Logger logger = Logger.getLogger(LogonAction.class);
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
        throws Exception {
 
		//logs debug
		logger.info("Info action in login");
		LinkedHashMap map = (LinkedHashMap)request.getServletContext().getAttribute("productList");
		if(map !=null)
		{
			List l = new ArrayList();
			 Set set = map.entrySet();
		      
		      // Get an iterator
		      Iterator i = set.iterator();
		      while(i.hasNext()) {
		          Map.Entry me = (Map.Entry)i.next();
		          System.out.print(me.getKey() + ": ");
		          System.out.println(me.getValue());
		          l.add((JSONObject)me.getValue());
		          
		       }
		      request.setAttribute("productList", l);
		}
		
		ContextListener config = ContextListener.getInstance(request.getServletContext());
		String key = config.getProperty(request.getParameter("userId"));
		if(key != null)
 		{
	    return mapping.findForward("success");
		}
		 return mapping.findForward("failure");
	    
	}
 
}