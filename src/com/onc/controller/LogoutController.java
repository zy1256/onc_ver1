package com.onc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		String forwardPath="redirect:login.jsp";
		return forwardPath;
	}

}
