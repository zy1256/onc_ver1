package com.onc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onc.reservation.Reser;
import com.onc.reservation.ReserManager;
import com.onc.user.User;

public class ReservationController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		String forwardPath="";
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("login_user");
		try{
			String state = request.getParameter("state");
			List<Reser> reserList = null;
			if (state==null || state.equals("") || state.equals("1")){
				reserList = ReserManager.getInstance().findListByUser(user.getUser_no());
			}else if (state.equals("3")){
				reserList = ReserManager.getInstance().findListBought(user.getUser_no());
			}else if (state.equals("4")){
				reserList = ReserManager.getInstance().findListOut(user.getUser_no());
			}else if (state.equals("2")){
				reserList = ReserManager.getInstance().findListReser(user.getUser_no());
			}else if (state.equals("5")){
				reserList = ReserManager.getInstance().findReserList();
			}else{
				reserList = ReserManager.getInstance().findListByUser(user.getUser_no());
			}
			if(reserList.size()==0){
				request.setAttribute("MSG", "暂无订单");
			}
			int countAll = ReserManager.getInstance().reserCount(1, 3, user.getUser_no());
			int count1 = ReserManager.getInstance().reserCount(1, 1, user.getUser_no());
			int count2 = ReserManager.getInstance().reserCount(2, 2, user.getUser_no());
			int count3 = ReserManager.getInstance().reserCount(3, 3, user.getUser_no());
			System.out.println(countAll + "," + count1  + "," + count2  + "," + count3);
			request.setAttribute("reserList", reserList);
			request.setAttribute("countAll", countAll);
			request.setAttribute("count1", count1);
			request.setAttribute("count2", count2);
			request.setAttribute("count3", count3);
			forwardPath="listReservation.jsp";
		}catch(Exception e){
			forwardPath="redirect:error.html";
			e.printStackTrace();
		}
		
		return forwardPath;
	}

}
