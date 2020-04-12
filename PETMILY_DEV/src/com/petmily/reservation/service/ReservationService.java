package com.petmily.reservation.service;

import static com.petmily.common.JDBCTemplate.close;
import static com.petmily.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.petmily.reservation.model.dao.ReservationDao;
import com.petmily.reservation.model.vo.PetReservation;

public class ReservationService {
	
	  private ReservationDao dao = new ReservationDao();
	  
	  public List<PetReservation> requestRev(String id) {
		  Connection conn = getConnection();
		  List<PetReservation> list = dao.requestRev(conn,id);
		  close(conn);
		  return list;

	  }
}
