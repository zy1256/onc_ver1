package com.onc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onc.reservation.Reser;
import com.onc.reservation.ReserManager;
import com.onc.user.User;

public class UserController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String forwardPath="";
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("login_user");
		try{
			List<Reser> reserList = null;
			reserList = ReserManager.getInstance().findByCostmer(user.getUser_name());
			if(reserList.size()==0){
				request.setAttribute("MSG", "暂无订单");
			}
			int countAll = ReserManager.getInstance().userReserCount(1, 2, user.getUser_name());
			int count1 = ReserManager.getInstance().userReserCount(1, 1, user.getUser_name());
			int count2 = ReserManager.getInstance().userReserCount(2, 2, user.getUser_name());
			request.setAttribute("reserList", reserList);
			request.setAttribute("countAll", countAll);
			request.setAttribute("count1", count1);
			request.setAttribute("count2", count2);
			forwardPath="userReserList.jsp";
		}catch(Exception e){
			forwardPath="redirect:error.html";
			e.printStackTrace();
		}
		return forwardPath;
	}

}
