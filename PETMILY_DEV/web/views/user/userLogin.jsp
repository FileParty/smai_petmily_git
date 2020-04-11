<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%@ page import="com.petmily.user.model.vo.User"%>
    

<%@ include file="/views/common/header.jsp" %>

	<!-- ���� ������ CSS : �α��� -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/loginForm.css">
	<!-- ���� ������ Jquery ���� -->
	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script> 

<section>

	<!-- �α��� Ÿ��Ʋ -->
     <p id="loginTitle">�α���</p>

     <!-- ù��° article : �α��� �� -->
     <article>
         <form id="loginForm" action="<%=request.getContextPath()%>/log-in.do" method="post" > 
             <table id="loginTB" >

                 <tr id="firstTr">
                     <td class="idForm" id="idTitle"> <p id="idTitle">���̵�</p> </td>
                     <td class="idForm"> 
                     	<input type="text" autofocus name="userId" id="userId" required placeholder="���̵� �Է�"  >
                     	<!-- value="loginUser.getUser_id()" -->
                   	 </td>
                     <td rowspan="2" id="login-td" class="idForm">
                         <button type="submit" name="login-btn" id="login-btn" onclick="log_in(); msg_div();">login</button>
                     </td>
                 </tr>

                 <tr>
                     <td class="pwForm" id="pwTitle"> ��й�ȣ </td>
                     <td class="pwForm"> 
                     	<input type="password" name="userPw" id="userPw" required placeholder="��й�ȣ �Է�" >
                     </td>
                 </tr>

             </table>

			
			<!-- ����� ��¿ �� ���� �κ� -->
			<%-- <% if((boolean)request.getAttribute("flag")==false) { %>
	             <!-- �޼����� : ���̵� Ȥ�� ��й�ȣ�� �߸� �Ǿ����ϴ�. -->
	           	 <p id="idpwMistake" style="display:block;">���̵� Ȥ�� ��й�ȣ�� �߸� �Ǿ����ϴ�.</p>
           	 <% } %> --%> 
           	 
           	 
             <br>
             
             <!-- idã��, pwã��, ȸ������ �±� -->
             <a id="first_find_enroll" class="find_enroll" href="javascript:void(0);" onclick="findId();">���̵�</a>
             <a class="find_enroll" href="javascript:void(0);" onclick="findPw();">��й�ȣ ã��</a>
             <a class="find_enroll" href="javascript:void(0);" onclick="location.replace('<%=request.getContextPath()%>/join')">ȸ������</a>
             
         </form>
         
     </article>

     <!-- �α��� ���� sns�α��� ���� ���� ���� -->
     <div id="blank"></div>

     <!-- �ι�° article : sns �α���(API �ʿ�) -->
     <!-- ���� API�� ��� �ؾ� ���� ���� form �±� ���, div�θ� �����ص���! -->
     <article id="second-article">
         <div id="facebook" class="SNS_BG" onclick="location.replace('....')">���̽������� �α��� </div>
         <div id="naver" class="SNS_BG" onclick="location.replace('....')">���̹��� �α���(������)</div>
         <div id="google" class="SNS_BG" onclick="location.replace('....')">���۷� �α���(API ������ȯ���� ���� �����)</div>
         <!-- DB�� insert ���� �ʿ�. -->
     </article>

</section>


<script>
	// ���̵� �Է��ϼ���. ��й�ȣ�� �Է��ϼ���. ��Ʈ
	function log_in() { 
		var userId = $("#userId").val();
		var userPw = $("#userPw").val();
		
		// ���̵��� ������ �����ϰ�, ���̵��� ���̰� 0�� ���� ��
		if(userId!=null && userId.trim().length==0) {
			alert('���̵� �Է��ϼ���.');
			$("#userId").focus();
			return false;
			
		}
		// ��й�ȣ�� ������ �����ϰ�, ��й�ȣ���� ���̰� 0�� ���� ��
		if(userPw.trim().length==0) {
			alert('��й�ȣ�� �Է��ϼ���.');
			$("#userPw").focus();
			return false;
		}
		return true;
		
	}
	
	//-----------------------------------------------------------------------
	
	// ���⿡ �� �Ϸ��� �ߴ���...
	
	//-----------------------------------------------------------------------
	

	
	// ���̵�ã��, ��й�ȣã�� ����(�˾�â)
	function findId() { // ���̵� ã��
		// �� â�� ����� userId�� ���� ���ϴ� �Լ�!
		var url = "<%=request.getContextPath()%>/idFind";
		var status = "height=420px, width=600px, top=200px, left=500px";
		window.open(url, "_blank", status);
	};
	
	function findPw() { // ��й�ȣ ã��
		var url = "<%=request.getContextPath()%>/pwFind";
		var status = "height=420px, width=600px, top=200px, left=500px";
		window.open(url, "_blank", status);
	}
</script>









<%@ include file="/views/common/footer.jsp" %>