package com.onc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onc.reservation.ReserManager;

public class UpdateStateController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		String forwardPath="";
		String order_no = request.getParameter("order_no");
		String p_state = request.getParameter("p_state");
		String state = request.getParameter("state");
		try{
			ReserManager.getInstance().updateState(Integer.parseInt(order_no), Integer.parseInt(p_state));
			forwardPath="zz.jsp";
			
			request.setAttribute("p_state",p_state) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return forwardPath;
	}

}
