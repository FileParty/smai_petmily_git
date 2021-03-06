<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.petmily.admin.model.vo.AdminPetsitter" %>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/adminSideBar.css" type = "text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/adminPetsitter.css" type = "text/css">
<% 
	ArrayList<AdminPetsitter> list = new ArrayList();
	if(request.getAttribute("userList")!=null){
		list = (ArrayList<AdminPetsitter>)request.getAttribute("userList");
	}
	int AuCount = 1;
	String type = "USER_NAME";
	if(request.getAttribute("type")!=null){
		type = (String)request.getAttribute("type");
	}
%>
<section id="adminMainMenu">
<%@ include file="/views/admin/adminSideBar.jsp" %>
	<section id="adminUserList">
		<h4>펫 시터 지원 목록</h4>
		<hr/>
		<div id="adminUserListSearchType">
			<p id="type-date">일자 순
				<img alt="2" 
					<% if(type.equals("ENROLL_DATE")){ %>
						src="<%=request.getContextPath()%>/img/common/arrowDown.png" 
					<% } else { %>
						src="<%=request.getContextPath()%>/img/common/arrowUp.png" 
					<% } %>
					width="20px" height="20px"></p>
			<p id="type-star">평점 순
				<img alt="1" 
					<% if(type.equals("STAR")){ %>
						src="<%=request.getContextPath()%>/img/common/arrowDown.png" 
					<% } else { %>
						src="<%=request.getContextPath()%>/img/common/arrowUp.png" 
					<% } %>
					width="20px" height="20px"></p>
			<p id="type-name">이름 순
				<img alt="1" 
					<% if(type.equals("USER_NAME")){ %>
						src="<%=request.getContextPath()%>/img/common/arrowDown.png" 
					<% } else { %>
						src="<%=request.getContextPath()%>/img/common/arrowUp.png" 
					<% } %>
					width="20px" height="20px"></p>
		</div>
		<div class="adminUserInfo">
			<table>
				<thead>
					<tr>
						<th>No</th>
						<th>아이디</th>
						<th>이름</th>
						<th>가입 일자</th>
						<th>후기 평점</th>
						<th>자격증</th>
						<th>펫 시터 등급</th>
					</tr>
				</thead>
				<tbody>
					<%for(AdminPetsitter aps : list){ %>
						<tr>
							<td><%=AuCount++%></td>
							<td><%=aps.getUserId()%></td>
							<td><%=aps.getUserName()%></td>
							<td><%=aps.getEnrollDate().substring(0,11)%></td>
							<td><%=aps.getStar()%></td>
							<td>
							<% if(aps.getCerCount()>0){%>
								<button class="Abtns" onclick="CerShow();">상세 보기</button>
							<% } else { %>
								<p> N </p>
							<% } %>
							</td>
							<td><%=aps.getUserType().substring(0,3)%></td>
						</tr>
					<% } %>
				</tbody>
			</table>
			<div id="pageBar">
				<%= request.getAttribute("pageBar") %>
			</div>
		</div>
	</section>
</section>
<script>
	$(function(){
		// 일자순 이벤트
		$("#type-date").click(function(){
				location.replace('<%=request.getContextPath()%>/admin/petsitterList?type=ENROLL_DATE');
		})
		// 평점순 이벤트
		$("#type-star").click(function(){
				location.replace('<%=request.getContextPath()%>/admin/petsitterList?type=STAR');
		})
		// 이름순 이벤트
		$("#type-name").click(function(){
			location.replace('<%=request.getContextPath()%>/admin/petsitterList?type=USER_NAME');
		})
		
	})
	
	function CerShow(){
		let id = $($(event.target).parent().parent()).find("td:nth-of-type(2)").html();
		window.open("<%=request.getContextPath()%>/admin/petsitterCer?userId="+id,"_blank","width=725px; height=500px");
	}
</script>
<%@ include file="/views/common/footer.jsp" %>