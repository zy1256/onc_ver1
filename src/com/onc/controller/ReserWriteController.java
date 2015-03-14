package com.onc.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onc.reservation.Reser;
import com.onc.reservation.ReserManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ReserWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("user_write.jsp");
			forwardPath="redirect:reserWrite.jsp";
			return forwardPath;
		}
		String p_name="";
		String p_count="";
		String p_price="";
		String p_pic="";
		String p_costmer="";
		String p_state="";
		String user_no = "";
		String p_outprice="";
			try{
			String savePath = request.getRealPath("/upload");
			int sizeLimit = 5*1024*1024;
			MultipartRequest mr = new MultipartRequest(request,savePath,sizeLimit,"UTF-8",new
					DefaultFileRenamePolicy());
			File file = mr.getFile("p_pic");
			if(!(file==null)){
				p_pic = file.getName();
			}
			System.out.println(file);
			if(p_pic == null || p_pic.equals("")){
				System.out.println("파일 업로드 실패");
				p_pic="noimg";
			}else{
				System.out.println(savePath);
				System.out.println("파일명 : " + p_pic);
			}
			p_name = mr.getParameter("p_name");
			p_count = mr.getParameter("p_count");
			p_price = mr.getParameter("p_price");
			p_costmer = mr.getParameter("p_costmer");
			p_state = mr.getParameter("p_state");
			user_no = mr.getParameter("user_no");
			p_outprice = mr.getParameter("p_outprice");
			if(p_count==null || p_count==""){
				p_count="1";
			}
			if(p_price==null || p_price==""){
				p_price="0";
			}
			if(p_costmer==null || p_costmer==""){
				p_costmer="";
			}
			Reser reser = new Reser(p_name, 
														Integer.parseInt(p_count), 
														Integer.parseInt(p_price), 
														p_pic, 
														p_costmer, 
														Integer.parseInt(p_state),
														Integer.parseInt(user_no),
														Integer.parseInt(p_outprice));
				int row = ReserManager.getInstance().create(reser);
				forwardPath="redirect:listReservation.do?state="+p_state;
				return forwardPath;
			}catch(Exception e){
				e.printStackTrace();
				forwardPath="error.html";
			}
		
		return forwardPath;
	}

}
