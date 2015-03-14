package com.onc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onc.reservation.Reser;
import com.onc.reservation.ReserManager;

public class ReserModifyFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		String forwardPath="";
		String order_no = request.getParameter("order_no");
		try{
			Reser reser = ReserManager.getInstance().findReser(Integer.parseInt(order_no));
			request.setAttribute("reser", reser);
			forwardPath="reserModifyForm.jsp";
		}catch(Exception e){
			forwardPath="redirect:error.html";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
