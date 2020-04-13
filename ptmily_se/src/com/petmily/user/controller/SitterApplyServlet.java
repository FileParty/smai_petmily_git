package com.petmily.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petmily.user.model.service.UserService;
import com.petmily.user.model.vo.PetSitter2;

/**
 * Servlet implementation class SitterApplyServlet
 */
@WebServlet("/apply/form")
public class SitterApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SitterApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�տ��� ���� �����͸� ������ �ҷ��ͼ� ������
		HttpSession session=request.getSession();
		PetSitter2 pss=(PetSitter2)session.getAttribute("petsitter");
		
		System.out.println(pss);
		
		//����� ���� ������ ���� �����ʹ� �Ʒ��� ���� 8��
		
		//����� ������ �ۼ� �̸�
//		String sitterName=request.getParameter("name");
		//����� ������ �ۼ� �̸���
//		String sitterEmail=request.getParameter("email");
		//����� ������ �ۼ� �ּ�
//		String sitterAddress=request.getParameter("address");
		
		//����� ������ �ۼ� ������ ����
		String[] residenceValue=request.getParameterValues("houseType");
		//����� ������ �ۼ� ����
		String[] petSitterJob=request.getParameterValues("jobCheck");
		//����� ������ ���� ������ 
		String petSitterFamily=request.getParameter("familyNoChck");
		//����� ������ �ݷ����� �ݷ� ���� ����
		String petSitterKeeppets=request.getParameter("careCheck");
		//����� ������ ����� ���Ȱ�� ����
		String petSitterActivity=request.getParameter("career");
		
		//�ҷ��� �����͸� vo�� �����
//		pss.setSitterName(sitterName);
//		pss.setSitterEmail(sitterEmail);
//		pss.setSitterAddress(sitterAddress);
		pss.setResidenceValue(String.join(",", residenceValue));
		pss.setPetSitterJob(String.join(",",petSitterJob));
		pss.setPetSitterFamily(petSitterFamily);
		pss.setPetSitterKeeppets(petSitterKeeppets); 
		pss.setPetSitterActivity(petSitterActivity);
		
		System.out.println(pss);
		
		//db����
		int result=new UserService().insertSitter(pss);
		
		//�����Ϸ� �������� �Ѿ
		RequestDispatcher rd=request.getRequestDispatcher("/views/sitter/applyEnd.jsp");
		rd.forward(request, response);
		
		//���� �����ֱ�
		session.removeAttribute("petsitter");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
