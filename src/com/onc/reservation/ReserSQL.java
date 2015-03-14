package com.onc.reservation;

public class ReserSQL {
	public final static String reserFindAllSQL = "select * from LIST_RESER order by o_date desc";
	public final static String reserCreateSQL="insert into list_reser(ORDER_NO,o_date,p_name,p_count,p_price,p_pic,p_costmer,p_state,user_no,p_outprice) "
																	+ "values (order_no_seq.nextval,sysdate,?,?,?,?,?,?,?,?)";
	public final static String reserRemove = "delete from list_reser where order_no=?";	
	public final static String reserUpdate = "update list_reser set p_name=?,p_count=?,p_price=?,p_pic=?,p_costmer=?,p_state=?,user_no=?,p_outprice=? where order_no=?";
	public final static String reserFindByOrderNo = "select * from LIST_RESER where order_no=?";
	public final static String reserFindBy = "select * from LIST_RESER "
															+ "where user_no=? and p_state between ? and ? order by o_date desc";
	public final static String reserSearch = "select * from list_reser where user_no=? and (p_state between ? and ?) and p_costmer like ? order by o_date desc";
	public final static String reserCount = "select count(*) as count from LIST_RESER where (P_STATE BETWEEN ? and ?) and user_no=?";
	public final static String userReser = "select * from list_reser where user_no=? and (p_state between ? and ?) and P_COSTMER=? order by o_date DESC";
	public final static String userReserCount = "select count(*) as count from LIST_RESER where (P_STATE BETWEEN ? and ?) and P_COSTMER=?";
	
}
