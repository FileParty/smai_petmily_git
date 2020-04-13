package com.petmily.user.model.service;

import java.sql.Connection;

import com.petmily.user.model.dao.UserDao;
import com.petmily.user.model.vo.PetSitter2;
import static com.petmily.common.JDBCTemplate.close;
import static com.petmily.common.JDBCTemplate.getConnection;
import static com.petmily.common.JDBCTemplate.rollback;
import static com.petmily.common.JDBCTemplate.commit;

public class UserService {
	
	UserDao dao = new UserDao();
	
	//시터 회원가입 
		public int insertSitter(PetSitter2 pss) {
			Connection conn=getConnection();
			int result=dao.insertUserTable(conn,pss);
		    if(result>0) {
		    	result=dao.insertUserPetSitter(conn, pss);
		    	if(result>0) {
		    		if(pss.getCertificateYN().equals("Y")){
		    			result=dao.insertPetSitterCertificate(conn, pss);
		    		}
		    		if(result>0) {
		    			for(String res : pss.getResidenceValue().split(",")) {
		    				result=dao.insertResidenceType(conn, pss.getPetsitterId(),res);
		    			}
		    			if(result>0) {
		    				commit (conn);
		    			}else {
			    			rollback(conn);
			    		}
		    		}else {
		    			rollback(conn);
		    		}
		    	}else{
		    		rollback(conn);
		    	}
		    	}else{
		    		rollback(conn);
		    	}
				return result;
		    }

}
