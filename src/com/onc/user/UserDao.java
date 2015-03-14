package com.onc.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onc.db.RdbmsDao;

public class UserDao extends RdbmsDao{
	
	private static UserDao _userDao;
	
	private UserDao(){
		System.out.println("UserDao : " + this);
	}
	public static UserDao getUserDao(){
		if(_userDao == null){
			_userDao = new UserDao();
		}
		return _userDao;
	}
	
	public User findUser(String user_id) throws Exception{
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			pstmt = con.prepareStatement(UserSQL.FIND_USER_SQL);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt("user_no"),
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getInt("user_adm")
						);
			}
		}finally{
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				releaseConnection(con);
		}
		return user;
	}

}
