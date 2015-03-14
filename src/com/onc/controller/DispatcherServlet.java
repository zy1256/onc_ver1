package com.onc.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	HandlerMapping handlermapping;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String configFile = config.getInitParameter("configFile");
		System.out.println("configFile:"+configFile);
		String configFilePath = getServletContext().getRealPath(configFile);
		System.out.println("configFilePath:"+configFilePath);
		handlermapping = new HandlerMapping(configFilePath);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requsetURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requsetURI.substring(contextPath.length());

		String forwardPath="";
		Controller controller=handlermapping.getController(command);
		if(controller==null){
			controller=handlermapping.getController("/bad.do");
		}
	
		forwardPath = controller.handleRequest(request,response);
		
		if(forwardPath.startsWith("redirect:")){
			//redirect
			int colonIndex=forwardPath.indexOf(":");
			forwardPath = forwardPath.substring(colonIndex+1);
			
			response.sendRedirect(forwardPath);
		}else{
			//forward
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
	}

	

}
