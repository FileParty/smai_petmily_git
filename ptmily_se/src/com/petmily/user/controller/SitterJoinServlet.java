package com.petmily.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


import com.petmily.user.model.vo.PetSitter2;


/**
 * Servlet implementation class SitterJoinServlet
 */
@WebServlet("/apply/join")
public class SitterJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SitterJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "���ۼ� ����! [form:encType]");
			request.setAttribute("loc", "/apply");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		String path = getServletContext().getRealPath("/upload/sitter/");
		int maxSize=1024*1024*10;
		
		//db�� ������ ���� �޾ƿ���.(cos.jar ���� Ȯ��)
		MultipartRequest mr = new MultipartRequest(request,path,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		String id = mr.getParameter("user_id"); //����� ���̵�
		String password = mr.getParameter("password"); //����� ���
		String file = mr.getFilesystemName("upload"); //����� ������ �̹���
		String name = mr.getParameter("user_name"); //����� �̸�
		String gender = mr.getParameter("gender");//����
		String bday = mr.getParameter("user_birth_day"); //����� ����
		String email = mr.getParameter("email");//����� �̸���
		String phone = mr.getParameter("phone");//����� �ڵ��� ��ȣ
		String post = mr.getParameter("postNum");// ����� ���� ��ȣ
		String address = mr.getParameter("address");//����� �ּ�
		String detail = mr.getParameter("detail");// ����� �� �ּ�
		String bank = mr.getParameter("bank");// ����� ���� �����
		String account = mr.getParameter("account"); //����� ���¹�ȣ
		String accountName = mr.getParameter("accountName");//����� ������
		String certificate = mr.getParameter("certificate");//�ڰ��� ����
		String certiName = mr.getParameter("certiName");//����� �ڰ��� ��
		String certiAgency = mr.getParameter("certiAgency"); //����� �ڰ��� �������
		String certiday = mr.getParameter("certiday");//����� �ڰ��� �������.
		String expireday = mr.getParameter("expireday"); //����� �ڰ��� ��������.
		String limg = mr.getFilesystemName("liupload"); //����� �ڰ��� �̹���
		String type = mr.getParameter("type");//����� Ÿ�� : �̽��������
		
		
		//vo�� �ҷ��� ������ �����
		//null�� ���� ���������� �޾ƿ� ����
		PetSitter2 pss=
				new PetSitter2(id, password, file, name, email, bday, gender, phone, post, address, detail, 
						bank, account, accountName, certificate, certiName, certiAgency, 
						certiday, expireday, limg, type, null, null, null, null, null);
		
//		pss.setPetsitterId(id);
//		pss.setPassword(password);
//		pss.setSitterImg(file);
//		pss.setSitterName(name);
//		pss.setSitterGender(gender);
//		pss.setSitterBday(bday);
//		pss.setSitterEmail(email);
//		pss.setSitterPhone(phone);
//		pss.setPostCode(post);
//		pss.setSitterAddress(address);
//		pss.setAddressDetail(detail);
//		pss.setBankName(bank);
//		pss.setAccountNo(account);
//		pss.setAccountOwner(accountName);
//		pss.setCertificateYN(certificate);
//		pss.setCertificateName(certiName);
//		pss.setIssuingOrg(certiAgency);
//		pss.setCertiGetDate(certiday);
//		pss.setCertiEndDate(expireday);
//		pss.setCertiImg(limg);
//		pss.setType(type);
		
		System.out.println(pss);
		
		HttpSession session=request.getSession(); //���ǻ���
		session.setAttribute("petsitter", pss); //������ ���ǰ� ���� 
		RequestDispatcher rd=request.getRequestDispatcher("/views/sitter/sitterApplyForm.jsp");
		//���ǿ� ��Ƽ� ���� �������� �޾ƿ� ������ �ѱ�
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
