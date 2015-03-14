package com.onc.controller;


import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/*
 * �������Ϸκ��� Controller��ü�� ���ϰ�
 * DispatcherServlet�� ��û�� ���� Controller��ü��ȯ
 */
public class HandlerMapping {
	
	HashMap<String, Controller> mapping;
	
	public HandlerMapping(String configFilePath){
		mapping = new HashMap<String, Controller>();
		
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(configFilePath);
			Properties prop = new Properties();
			prop.load(fis);
			
			Set keySet = prop.keySet();
			Iterator<String> keyIter = keySet.iterator();
			System.out.println("----------------properties----------------");
			while (keyIter.hasNext()) {
				String urlKey = (String) keyIter.next();
				String controllerClassStr = prop.getProperty(urlKey);
				System.out.println(urlKey+"="+controllerClassStr);
				//class �ε�				
				Class cclazz= Class.forName(controllerClassStr);
				//default ���� ��
				Controller controller = (Controller)cclazz.newInstance();
				mapping.put(urlKey, controller);
			}
				
			System.out.println("-------------------------------------------");
		}catch(Exception e){
			
		}
	}

	public Controller getController(String command) {
		return mapping.get(command);
		
	}
}
