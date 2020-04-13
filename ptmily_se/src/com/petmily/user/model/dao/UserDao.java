package com.petmily.user.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.petmily.user.model.vo.PetSitter2;
import static com.petmily.common.JDBCTemplate.close;

public class UserDao {
	
	private Properties props=new Properties();
	
	//기본 생성자
	public UserDao(){
		try {
			String path=UserDao.class.getResource("/sql/user/user-query.properties").getPath();
			props.load(new FileReader(path));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	//펫시터 회원가입 
		public int insertUserTable(Connection conn, PetSitter2 pss) {
			PreparedStatement pstmt=null;
			int result = 0 ;
			
			String sql=props.getProperty("insertUserTable");
			
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, pss.getPetsitterId()); //회원가입 아이디
				pstmt.setString(2, pss.getPassword()); //회원가입 비밀번호
				pstmt.setString(3, pss.getSitterName()); //회원가입 이름
				pstmt.setString(4, pss.getSitterBday().replaceAll("-", "/"));//회원가입 휴대폰
				pstmt.setString(5, pss.getSitterPhone());
				pstmt.setString(6, pss.getPostCode());//회원가입 주소 우편번호
				pstmt.setString(7, pss.getSitterAddress()); //회원가입 주소
				pstmt.setString(8, pss.getAddressDetail()); //회원가입 상세주소
				pstmt.setString(9, pss.getSitterEmail()); //회원가입 이메일
				pstmt.setString(10, pss.getSitterGender()); //회원가입 성별
				pstmt.setString(11, pss.getType()); //회원가입 시터 타입
				result=pstmt.executeUpdate();	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		
		//펫 시터 회원가입 중 USER_PET_SITTER에 대한 메소드
		public int insertUserPetSitter(Connection conn, PetSitter2 pss) {
			PreparedStatement pstmt=null;
			int result = 0 ;
			String sql=props.getProperty("insertPetSitter");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, pss.getPetsitterId()); //펫시터 아이디
				pstmt.setString(2, pss.getCertificateYN()); //펫시터 자격증 보유 여부
				pstmt.setString(3, pss.getPetSitterJob()); //펫시터 직업
				pstmt.setString(4, pss.getPetSitterFamily()); //펫시터 가족 구성원
				pstmt.setString(5, pss.getPetSitterKeeppets()); //펫시터 반려동물 반려 경험 여부
				pstmt.setString(6, pss.getPetSitterActivity()); //펫시터 활동 경력
				pstmt.setString(7, pss.getAccountOwner()); //펫시터 정산계좌 계좌주
				pstmt.setString(8, pss.getBankName()); //펫시터 정산계좌 은행명
				pstmt.setString(9, pss.getAccountNo()); //펫시터 정산계좌 계좌번호
			//	pstmt.setString(10, ps.getType()); //펫시터 사용자 타입(펫시터)
				pstmt.setString(10, pss.getSitterImg()); //펫시터 프로필 이미지
				result=pstmt.executeUpdate();	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
				return result;
		}
			
		//펫 시터 회원가입 중 PET_SITTER_CERTIFICATE 메소드
		public int insertPetSitterCertificate(Connection conn, PetSitter2 pss) {
			PreparedStatement pstmt=null;
			int result = 0;
			
			String sql="";
			sql=props.getProperty("insertPetSitterCertificate");
					try {
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, pss.getPetsitterId()); //펫시터 아이디	
						pstmt.setString(2, pss.getCertificateName()); //펫시터 자격증 이름
						pstmt.setString(3, pss.getIssuingOrg()); //펫시터 자격증 발급기관
						pstmt.setString(4, pss.getCertiGetDate()); //펫시터 자격증 발급일
						pstmt.setString(5, pss.getCertiEndDate()); //펫시터 자격증 만료일
						pstmt.setString(6, pss.getCertiImg()); //펫시터 자격증 이미지
						result=pstmt.executeUpdate();	
					}catch(SQLException e) {
						e.printStackTrace();
					}finally {
						close(pstmt);
					}
				return result;
				
		}//insertPetSitterCertificate
		
		
		
		//펫시터 회원가입 중 RESIDENCE_TYPE 테이블에 대한 것
		public int insertResidenceType(Connection conn, String id, String res) {
			PreparedStatement pstmt=null;
			int result = 0 ;
			String sql=props.getProperty("insertResidenceType");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id); //펫시터 아이디
				pstmt.setString(2, res); //거주지 유형
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

}
