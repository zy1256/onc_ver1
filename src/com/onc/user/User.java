package com.onc.user;

public class User {
	
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private int user_adm;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int user_no, String user_id, String user_pw, String user_name,
			int user_adm) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_adm = user_adm;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_adm() {
		return user_adm;
	}

	public void setUser_adm(int user_adm) {
		this.user_adm = user_adm;
	}
	
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.user_pw.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}
	

}
