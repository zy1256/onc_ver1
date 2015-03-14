package com.onc.reservation;

public class ReserMain {

	public static void main(String[] args) throws Exception {
		int rows = ReserDao.getReserDao().count(1, 1, 21);
		System.out.println(rows);
 
	}

}
