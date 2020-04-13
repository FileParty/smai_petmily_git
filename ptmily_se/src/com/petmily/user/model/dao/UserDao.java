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
	
	//�⺻ ������
	public UserDao(){
		try {
			String path=UserDao.class.getResource("/sql/user/user-query.properties").getPath();
			props.load(new FileReader(path));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	//����� ȸ������ 
		public int insertUserTable(Connection conn, PetSitter2 pss) {
			PreparedStatement pstmt=null;
			int result = 0 ;
			
			String sql=props.getProperty("insertUserTable");
			
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, pss.getPetsitterId()); //ȸ������ ���̵�
				pstmt.setString(2, pss.getPassword()); //ȸ������ ��й�ȣ
				pstmt.setString(3, pss.getSitterName()); //ȸ������ �̸�
				pstmt.setString(4, pss.getSitterBday().replaceAll("-", "/"));//ȸ������ �޴���
				pstmt.setString(5, pss.getSitterPhone());
				pstmt.setString(6, pss.getPostCode());//ȸ������ �ּ� �����ȣ
				pstmt.setString(7, pss.getSitterAddress()); //ȸ������ �ּ�
				pstmt.setString(8, pss.getAddressDetail()); //ȸ������ ���ּ�
				pstmt.setString(9, pss.getSitterEmail()); //ȸ������ �̸���
				pstmt.setString(10, pss.getSitterGender()); //ȸ������ ����
				pstmt.setString(11, pss.getType()); //ȸ������ ���� Ÿ��
				result=pstmt.executeUpdate();	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		
		//�� ���� ȸ������ �� USER_PET_SITTER�� ���� �޼ҵ�
		public int insertUserPetSitter(Connection conn, PetSitter2 pss) {
			PreparedStatement pstmt=null;
			int result = 0 ;
			String sql=props.getProperty("insertPetSitter");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, pss.getPetsitterId()); //����� ���̵�
				pstmt.setString(2, pss.getCertificateYN()); //����� �ڰ��� ���� ����
				pstmt.setString(3, pss.getPetSitterJob()); //����� ����
				pstmt.setString(4, pss.getPetSitterFamily()); //����� ���� ������
				pstmt.setString(5, pss.getPetSitterKeeppets()); //����� �ݷ����� �ݷ� ���� ����
				pstmt.setString(6, pss.getPetSitterActivity()); //����� Ȱ�� ���
				pstmt.setString(7, pss.getAccountOwner()); //����� ������� ������
				pstmt.setString(8, pss.getBankName()); //����� ������� �����
				pstmt.setString(9, pss.getAccountNo()); //����� ������� ���¹�ȣ
			//	pstmt.setString(10, ps.getType()); //����� ����� Ÿ��(�����)
				pstmt.setString(10, pss.getSitterImg()); //����� ������ �̹���
				result=pstmt.executeUpdate();	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
				return result;
		}
			
		//�� ���� ȸ������ �� PET_SITTER_CERTIFICATE �޼ҵ�
		public int insertPetSitterCertificate(Connection conn, PetSitter2 pss) {
			PreparedStatement pstmt=null;
			int result = 0;
			
			String sql="";
			sql=props.getProperty("insertPetSitterCertificate");
					try {
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, pss.getPetsitterId()); //����� ���̵�	
						pstmt.setString(2, pss.getCertificateName()); //����� �ڰ��� �̸�
						pstmt.setString(3, pss.getIssuingOrg()); //����� �ڰ��� �߱ޱ��
						pstmt.setString(4, pss.getCertiGetDate()); //����� �ڰ��� �߱���
						pstmt.setString(5, pss.getCertiEndDate()); //����� �ڰ��� ������
						pstmt.setString(6, pss.getCertiImg()); //����� �ڰ��� �̹���
						result=pstmt.executeUpdate();	
					}catch(SQLException e) {
						e.printStackTrace();
					}finally {
						close(pstmt);
					}
				return result;
				
		}//insertPetSitterCertificate
		
		
		
		//����� ȸ������ �� RESIDENCE_TYPE ���̺� ���� ��
		public int insertResidenceType(Connection conn, String id, String res) {
			PreparedStatement pstmt=null;
			int result = 0 ;
			String sql=props.getProperty("insertResidenceType");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id); //����� ���̵�
				pstmt.setString(2, res); //������ ����
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

}
