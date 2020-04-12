<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.petmily.user.model.vo.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type = "text/css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>
<% 
	User loginUser = (User)session.getAttribute("loginUser");
%>
</head>
<body>
 <header>
    <div id="headerMenuBar">
        <a href="<%=request.getContextPath()%>"><img src="<%=request.getContextPath()%>/img/common/logo.png" alt="로고이미지" width="35" height="53"/></a>
	        <ul id="headerDefault">
	            <li><a href="#">펫 시터 찾기</a></li>
	            <li><a href="#">펫 시터 지원</a></li>
	        </ul>
	        <% if(loginUser==null){ %>
	        <ul id="headerUnlogin">
	        	<li><a href="<%=request.getContextPath()%>/log-in">로그인</a></li>
	            <li><a href="<%=request.getContextPath()%>/join">회원가입</a></li>
	        </ul>
	        <% } else { %>
	        <ul id="headerlogin">
	        	<li><a href="#"><img alt="유저" src="<%=request.getContextPath()%>/img/common/Profile.png"
	        						width="30px" height="30px"></a></li>
	            <li><p><%=loginUser.getUserName()%>님</p></li>
	            <li><a href="<%=request.getContextPath()%>/log-out">로그아웃</a></li>
	            <li><a href="#"><img alt="종소리" src="<%=request.getContextPath()%>/img/common/Bell.png"
	            					width="30px" height="30px"></a></li>
	        </ul>
	        <% } %>
    </div>
    <div id="headerMargin"></div>
</header>

