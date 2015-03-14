package com.onc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onc.reservation.Reser;
import com.onc.reservation.ReserManager;
import com.onc.user.User;

public class SearchReserController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		String forwardPath="";
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("login_user");
		try{
			String state = request.getParameter("stateP");
			String query = request.getParameter("query");
			System.out.println(state);
			System.out.println(query);
			List<Reser> reserList = null;
			if (state==null || state.equals("") || state.equals("1")){
				reserList = ReserManager.getInstance().SearchListByUser(user.getUser_no(), query);
			}else if (state.equals("3")){
				reserList = ReserManager.getInstance().SearchListByBought(user.getUser_no(), query);
			}else if (state.equals("4")){
				reserList = ReserManager.getInstance().SearchListByOut(user.getUser_no(), query);
			}else if (state.equals("2")){
				reserList = ReserManager.getInstance().SearchListByReser(user.getUser_no(), query);
			}else if (state.equals("5")){
				reserList = ReserManager.getInstance().findReserList();
			}else{
				reserList = ReserManager.getInstance().SearchListByUser(user.getUser_no(), query);
			}
			if(reserList.size()==0){
				request.setAttribute("MSG", "暂无订单");
			}
			request.setAttribute("reserList", reserList);
			forwardPath="searchResult.jsp";
		}catch(Exception e){
			forwardPath="redirect:error.html";
			e.printStackTrace();
		}
		
		return forwardPath;
	}

}
