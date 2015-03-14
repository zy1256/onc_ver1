package com.onc.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ��� ��Ʈ�ѷ����� �����ؾ��ϴ� Ŭ����
 */
public interface Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
		
		
		
	
}
