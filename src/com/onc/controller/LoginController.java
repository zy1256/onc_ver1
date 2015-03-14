package com.onc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onc.user.PasswordMismatchException;
import com.onc.user.User;
import com.onc.user.UserManager;
import com.onc.user.UserNotFoundException;



public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		String forwardPath="";
		if(request.getMethod().equals("GET")){
			forwardPath="redirect:login.jsp";
			return forwardPath;
		}
		String user_id_java = request.getParameter("user_id");
		String user_pw_java = request.getParameter("user_pw");
		try{
			User user = UserManager.getInstance().login(user_id_java, user_pw_java);
			HttpSession session = request.getSession();
			session.setAttribute("login_user_id", user_id_java);
			session.setAttribute("login_user", user);
			if(user.getUser_adm()==1){
				forwardPath="redirect:listReservation.do?state=1";
			}else if(user.getUser_adm()==2){
				forwardPath="redirect:userReser.do?state=1";
			}
			System.out.println("login susses-" + user.getUser_name());
			request.setAttribute("MSG", "成功");
			return forwardPath;
		}catch(UserNotFoundException e){
			System.out.println(e.getMessage());
			request.setAttribute("MSG", e.getMessage());
			forwardPath="login.jsp";
			return forwardPath;
		}catch(PasswordMismatchException e){
			System.out.println(e.getMessage());
			request.setAttribute("MSG", e.getMessage());
			forwardPath="login.jsp";
			return forwardPath;
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="redirect:error.html";
		}
		
		return forwardPath;
	}

}
