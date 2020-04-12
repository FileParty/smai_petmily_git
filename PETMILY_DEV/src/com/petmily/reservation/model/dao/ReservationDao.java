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
				pr.setSitterName("PPAP");
				pr.setReservationCode(rs.getInt("RCODE"));
				pr.setCheckIn(rs.getString("CIN"));
				pr.setCheckOut(rs.getString("COUT"));
				pr.setResType(rs.getString("RES"));
				pr.setPrice(rs.getInt("PRICE"));
				pr.setPetSitterId(rs.getString("PID"));
				pr.setBoardTitle(rs.getString("TITLE"));
				
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
