package com.petmily.reservation.model.dao;

import static com.petmily.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.petmily.board.model.dao.BoardDao;
import com.petmily.reservation.model.vo.PetReservation;
public class ReservationDao {
	
	private Properties prop = new Properties();

	public ReservationDao() {
		
		try {
			String path = BoardDao.class.getResource("/sql/rev/rev-query.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<PetReservation> requestRev(Connection conn,String id) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		PetReservation pr = null;
		List<PetReservation> list = new ArrayList();
		String sql = prop.getProperty("requestRev");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				pr = new PetReservation();
				pr.setReservationCode(rs.getInt("RESERVATION_CODE"));
				pr.setPetSitterId(rs.getString("PET_SETTER_ID"));
				pr.setUserId(rs.getString("USER_ID"));
				pr.setBoardNo(rs.getInt("BOARD_CODE"));
				pr.setCheckIn(rs.getString("CHECKIN_DATE"));
				pr.setCheckOut(rs.getString("CHECKOUT_DATE"));
				pr.setCareType(rs.getString("CARE_TYPE"));
				pr.setPetType(rs.getString("PET_TYPE"));
				pr.setPetBath(rs.getInt("PET_BATH"));
				pr.setPetMedication(rs.getString("PET_MEDICATION"));
				pr.setPetPickup(rs.getString("PET_PICK_UP"));
				pr.setPlusQuestion(rs.getString("PLUS_QUESTIONS"));
				pr.setPriceEndDate(rs.getString("PRICE_END_DATE"));
				pr.setPrice(rs.getInt("PRICE"));
				pr.setResType(rs.getString("RES_TYPE"));
				list.add(pr);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	

}
