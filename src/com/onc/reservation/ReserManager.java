package com.onc.reservation;

import java.util.ArrayList;
import java.util.List;

public class ReserManager {
	
	private static ReserManager _instance;
	private ReserManager(){
		System.out.println("RserManager : " + this);
	}
	public static ReserManager getInstance(){
		if(_instance==null){
			_instance = new ReserManager();
		}
		return _instance;
	}
	//添加订单
	public int create(Reser reser) throws Exception{
		int row = this.getReserDao().create(reser);
		return row;
	}
	//订单查找
	public Reser findReser(int order_no) throws Exception{
		Reser reser = this.getReserDao().findReser(order_no);
		return reser;
	}
	//订单状态更改
	public int updateState(int order_no, int p_state) throws Exception{
		Reser reser = findReser(order_no);
		reser.setP_state(p_state);
		int row = this.getReserDao().update(reser);
		return row;
	}
	//订单修改
	public int updateReser(int order_no,Reser reser) throws Exception{
		Reser reserP = findReser(order_no);
		reserP.setP_name(reser.getP_name()); 
		reserP.setP_count(reser.getP_count());
		reserP.setP_price(reser.getP_price());
		reserP.setP_pic(reser.getP_pic());
		reserP.setP_costmer(reser.getP_costmer());
		reserP.setP_state(reser.getP_state());
		reserP.setUser_no(reser.getUser_no());
		reserP.setP_outprice(reser.getP_outprice());
		int row = this.getReserDao().update(reserP);
		return row;
	}
	//个人订单列表
	public List<Reser> findListByUser (int user_no) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListByInt(user_no,1,3);
		return reserList1;
	}
	//个人订单列表（预约）
	public List<Reser> findListReser (int user_no) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListByInt(user_no,1,1);
		return reserList1;
	}
	//个人订单列表（购入）
	public List<Reser> findListBought (int user_no) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListByInt(user_no,2,2);
		return reserList1;
	}
	//个人订单列表（断货）
	public List<Reser> findListOut (int user_no) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListByInt(user_no,3,3);
		return reserList1;
	}
	//搜索个人订单列表
	public List<Reser> SearchListByUser (int user_no,String keyword) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListBySearch(user_no, 1, 3, keyword);
		return reserList1;
	}
	//搜索个人订单列表（预约）
	public List<Reser> SearchListByReser (int user_no,String keyword) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListBySearch(user_no, 1, 1, keyword);
		return reserList1;
	}
	//搜索个人订单列表（购入）
	public List<Reser> SearchListByBought (int user_no,String keyword) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListBySearch(user_no, 2, 2, keyword);
		return reserList1;
	}
	//搜索个人订单列表（断货）
	public List<Reser> SearchListByOut (int user_no,String keyword) throws Exception{
		List<Reser> reserList1 = this.getReserDao().findListBySearch(user_no, 3, 3, keyword);
		return reserList1;
	}
	//订单数量
	public int reserCount(int p_state1, int p_state2, int user_no) throws Exception{
		int rows;
		rows = ReserDao.getReserDao().count(p_state1, p_state2, user_no);
		return rows;
	}
	//客户订单列表
	public List<Reser> findByCostmer (String costmer) throws Exception{
		List<Reser> reserList = this.getReserDao().findUserReser(1, 1, 2, costmer);
		return reserList;
	}

	//客户订单数量
	public int userReserCount(int p_state1, int p_state2, String user_name) throws Exception{
		int rows;
		rows = ReserDao.getReserDao().userCount(p_state1, p_state2, user_name);
		return rows;
	}
	//订单列表（所有）
	public List<Reser> findReserList() throws Exception{
		return getReserDao().findAll();
	}
	
	private ReserDao getReserDao(){
		return ReserDao.getReserDao();
	}

}
