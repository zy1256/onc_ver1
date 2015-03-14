package com.onc.reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onc.db.RdbmsDao;

public class ReserDao extends RdbmsDao {
	
	private static ReserDao _reserDao;
	
	private ReserDao(){
		System.out.println("RserDao : " + this);
	}
	
	public static ReserDao getReserDao(){
		if(_reserDao == null){
			_reserDao = new ReserDao();
		}
		return _reserDao;
	}
	
	public synchronized int create (Reser reser) throws Exception{
		int rows;
		Connection con =null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserCreateSQL);
			pstmt.setString(1, reser.getP_name());
			pstmt.setInt(2, reser.getP_count());
			pstmt.setInt(3, reser.getP_price());
			pstmt.setString(4, reser.getP_pic());
			pstmt.setString(5, reser.getP_costmer());
			pstmt.setInt(6, reser.getP_state());
			pstmt.setInt(7, reser.getUser_no());
			pstmt.setInt(8, reser.getP_outprice());
			rows = pstmt.executeUpdate();
			return rows;
		}finally{
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
	}
	public int update(Reser reser) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserUpdate);
			pstmt.setString(1, reser.getP_name());
			pstmt.setInt(2, reser.getP_count());
			pstmt.setInt(3, reser.getP_price());
			pstmt.setString(4, reser.getP_pic());
			pstmt.setString(5, reser.getP_costmer());
			pstmt.setInt(6, reser.getP_state());
			pstmt.setInt(7, reser.getUser_no());
			pstmt.setInt(8, reser.getP_outprice());
			pstmt.setInt(9, reser.getOrder_no());
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
	}
	public Reser findReser(int order_no) throws Exception{
		Reser reser = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserFindByOrderNo);
			pstmt.setInt(1, order_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				reser = new Reser(rs.getInt("order_no"),
												rs.getDate("o_date"),
												rs.getString("p_name"),
												rs.getInt("p_count"),
												rs.getInt("p_price"),
												rs.getString("p_pic"),
												rs.getString("p_costmer"),
												rs.getInt("p_state"),
												rs.getInt("user_no"),
												rs.getInt("p_outprice"));
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		return reser;
	}
	public int removeReser(int order_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserRemove);
			pstmt.setInt(1, order_no);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
	}
	public List<Reser> findListByInt(int byInt,int value1,int value2) throws Exception{
		ArrayList<Reser> reserList = new ArrayList<Reser>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserFindBy);
			pstmt.setInt(1, byInt);
			pstmt.setInt(2, value1);
			pstmt.setInt(3, value2);
			rs = pstmt.executeQuery();
			while(rs.next()){
				reserList.add(new Reser(
						rs.getInt("order_no"),
						rs.getDate("o_date"),
						rs.getString("p_name"),
						rs.getInt("p_count"),
						rs.getInt("p_price"),
						rs.getString("p_pic"),
						rs.getString("p_costmer"),
						rs.getInt("p_state"),
						rs.getInt("user_no"),
						rs.getInt("p_outprice")
						));
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		
		return reserList;
	}
	

	public List<Reser> findListBySearch(int byInt,int value1,int value2,String keyword) throws Exception{
		ArrayList<Reser> reserList = new ArrayList<Reser>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserSearch);
			pstmt.setInt(1, byInt);
			pstmt.setInt(2, value1);
			pstmt.setInt(3, value2);
			pstmt.setString(4, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				reserList.add(new Reser(
						rs.getInt("order_no"),
						rs.getDate("o_date"),
						rs.getString("p_name"),
						rs.getInt("p_count"),
						rs.getInt("p_price"),
						rs.getString("p_pic"),
						rs.getString("p_costmer"),
						rs.getInt("p_state"),
						rs.getInt("user_no"),
						rs.getInt("p_outprice")
						));
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		
		return reserList;
	}
	
	public List<Reser> findUserReser(int byInt,int value1,int value2,String costmer) throws Exception{
		ArrayList<Reser> reserList = new ArrayList<Reser>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.userReser);
			pstmt.setInt(1, byInt);
			pstmt.setInt(2, value1);
			pstmt.setInt(3, value2);
			pstmt.setString(4, costmer);
			rs = pstmt.executeQuery();
			while(rs.next()){
				reserList.add(new Reser(
						rs.getInt("order_no"),
						rs.getDate("o_date"),
						rs.getString("p_name"),
						rs.getInt("p_count"),
						rs.getInt("p_price"),
						rs.getString("p_pic"),
						rs.getString("p_costmer"),
						rs.getInt("p_state"),
						rs.getInt("user_no"),
						rs.getInt("p_outprice")
						));
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		
		return reserList;
	}
	
	public List<Reser> findAll() throws Exception{
		ArrayList<Reser> reserList = new ArrayList<Reser>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserFindAllSQL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				reserList.add(new Reser(
										rs.getInt("order_no"),
										rs.getDate("o_date"),
										rs.getString("p_name"),
										rs.getInt("p_count"),
										rs.getInt("p_price"),
										rs.getString("p_pic"),
										rs.getString("p_costmer"),
										rs.getInt("p_state"),
										rs.getInt("user_no"),
										rs.getInt("p_ourprice")));
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		
		return reserList;
	}
	
	
	public int count(int p_state1, int p_state2, int user_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rows=0;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.reserCount);
			pstmt.setInt(1, p_state1);
			pstmt.setInt(2, p_state2);
			pstmt.setInt(3, user_no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rows=rs.getInt("count");
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		
		return rows;
	}

	public int userCount(int p_state1, int p_state2, String user_name) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rows=0;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(ReserSQL.userReserCount);
			pstmt.setInt(1, p_state1);
			pstmt.setInt(2, p_state2);
			pstmt.setString(3, user_name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rows=rs.getInt("count");
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		
		return rows;
	}

}
