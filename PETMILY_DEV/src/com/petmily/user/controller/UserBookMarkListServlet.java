package com.petmily.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petmily.user.model.service.UserService;
import com.petmily.user.model.vo.User;
import com.petmily.user.model.vo.UserBookMark;
import com.petmily.user.model.vo.UserBookMarkBoard;


@WebServlet("/userBookMarkList")
public class UserBookMarkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserBookMarkListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		회원정보 - 북마크 화면으로 전환하는 기능
//		로그인 된 상태로 진행되어야 한다.
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null) {
//			잘못된 접근 처리
			request.setAttribute("msg","잘못된 접근입니다.");
			request.setAttribute("loc", ""); // 메인으로 이동
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		else {
//			<북마크 리스트 페이징처리>
//			1. 현재페이지
			int cPage;
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			}
			catch(NumberFormatException e) {
				e.printStackTrace();
				System.out.println("페이징처리 에러!");
				cPage=1;
			}
			
//			2. 페이지당 데이터 수
			int numPerPage=5;
			
//			-------
			String id = request.getParameter("userId");
			System.out.println("북마크로직 이동하기 위해 확인하는 id 값 : "+id);
			
//			DB에서 id와 동일한 정보를 가져온다(페이징 처리하는 변수도 같이 보내기)
			List<UserBookMarkBoard> list = new UserService().userBookMarkList(id, cPage, numPerPage);
			System.out.println("서블릿 list: "+list);
//			------
			
//			3. page bar 만들기
			int totalData = new UserService().selectBoardCount();
			int totalPage = (int)Math.ceil((double)totalData/numPerPage);
			
//			가져온 내용을 저장하고 아이디값과 함께 매핑값을 보낸다.
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/user/userBookMarkList.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
