package com.onc.reservation;

import java.util.Date;

public class Reser {
//	order_no number(10) not null constraint order_no primary key,
//    o_date date,
//    p_name varchar2(100),
//    p_count number(10),
//    p_price number(15),
//    p_pic varchar2(200),
//    p_costmer varchar2(20),
//    p_state number(2)
	private int order_no;
	private Date o_date;
	private String p_name;
	private int p_count;
	private int p_price;
	private String p_pic;
	private String p_costmer;
	private int p_state;
	private int user_no;
	private int p_outprice;
	
	public Reser() {
		// TODO Auto-generated constructor stub
	}

	public Reser(int order_no, Date o_date, String p_name, int p_count,
			int p_price, String p_pic, String p_costmer, int p_state,int user_no,int p_outprice) {
		super();
		this.order_no = order_no;
		this.o_date = o_date;
		this.p_name = p_name;
		this.p_count = p_count;
		this.p_price = p_price;
		this.p_pic = p_pic;
		this.p_costmer = p_costmer;
		this.p_state = p_state;
		this.user_no = user_no;
		this.p_outprice = p_outprice;
	}
	public Reser(String p_name, int p_count,
			int p_price, String p_pic, String p_costmer, int p_state , int user_no, int p_outprice) {
		super();
		this.p_name = p_name;
		this.p_count = p_count;
		this.p_price = p_price;
		this.p_pic = p_pic;
		this.p_costmer = p_costmer;
		this.p_state = p_state;
		this.user_no = user_no;
		this.p_outprice = p_outprice;
	}

	public int getP_outprice() {
		return p_outprice;
	}

	public void setP_outprice(int p_outprice) {
		this.p_outprice = p_outprice;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_count() {
		return p_count;
	}

	public void setP_count(int p_count) {
		this.p_count = p_count;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_pic() {
		return p_pic;
	}

	public void setP_pic(String p_pic) {
		this.p_pic = p_pic;
	}

	public String getP_costmer() {
		return p_costmer;
	}

	public void setP_costmer(String p_costmer) {
		this.p_costmer = p_costmer;
	}

	public int getP_state() {
		return p_state;
	}

	public void setP_state(int p_state) {
		this.p_state = p_state;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	
	
}
