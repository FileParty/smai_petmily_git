package com.petmily.userReview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petmily.user.model.service.UserService;
import com.petmily.userReview.model.vo.UserReview;
import com.petmily.userReview.service.UserReviewService;


@WebServlet("/userReview")
public class UserReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		회원정보 - 작성 후기 서블릿
//		이용자가 작성한 후기 리스트를 불러와서 화면에 뿌린다.
//		페이징 처리 필요!
		
//		로그인 된 상태로 진행되어야 한다.
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null) {
//			잘못된 접근 처리
			request.setAttribute("msg","잘못된 접근입니다.");
			request.setAttribute("loc", ""); // 메인으로 이동
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		else {
			String userId=request.getParameter("userId"); // 사용자 아이디 가져오기			
			List<UserReview> list=new UserReviewService().selectUserReviewList(userId); 
			System.out.println("작성후기 list 가져오나 보자(서블릿) : "+list);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/userMypage/userReview.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
