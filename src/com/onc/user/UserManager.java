package com.onc.user;

public class UserManager {
	
	private static UserManager _instance;
	private UserManager(){
		System.out.println("UserManager : " + this);
	}
	
	public static UserManager getInstance(){
		if(_instance==null){
			_instance = new UserManager();
		}
		return _instance;
	}
	
	public User login(String user_id,String user_pw) throws UserNotFoundException, Exception{
		User user = this.findUser(user_id);
		if(!user.isMatchPassword(user_pw)){
			throw new PasswordMismatchException("密码错误");
		}
		return user;
	}
	
	public User findUser(String user_id) throws Exception,UserNotFoundException{
		User user = getUserDao().findUser(user_id);
		if(user==null){
			throw new UserNotFoundException(user_id + "不存在");
		}
		return user;
	}
	
	private UserDao getUserDao(){
		return UserDao.getUserDao();
	}

}
