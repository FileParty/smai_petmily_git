<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   *{   
       
        box-sizing: border-box;
        font-family: 'Noto Sans KR', sans-serif;
    }
    html, body,section {
          height: 100%;
      }
    .col-9{
        height: 100%;
        /* overflow: hidden; */
    }
 
    .container{
        height: 100%;
        padding: 0;
        width: 1366px;
        margin-left: auto;
        margin-right: auto;
        /* border: 1px solid red; */
 
    }
    .top-div{
    	overflow: hidden;
    }
    .row{
        padding: 0;
        margin: 0;
    }
    .menu{
            width: 230px;
            /* border: 1px solid yellow; */
            margin-top: 150px;

        }
    #menu{
        width: 230px;
        position : fixed;
    }
    ul{
        padding-inline-start:0;
    }
    .title{
        font-size: 14px;
    }
    .content{
        font-size: 12px;
        margin-bottom: 5px;
    }
        a:link { color: black; text-decoration: none;}
        a:visited { color: gray; text-decoration: none;}
        a:hover { color: black; text-decoration: underline;}
    .vl {   width: 1px;
            margin-top: 0px;
            border-left: 1px solid lightgrey;
            /* height: 100%; */
        }
    .breadcrumb .active {
        color: white;
    }
    .breadcrumb{

        background-color: #ffcc33;
        /* z-index: 500px !important; */
        /* position: fixed; */
        height: 40px;
        width: 100%;
        border-radius: 0%;
    }
    .breadcrumb-item{
        line-height: 16px;
        font-size: 12px;
    }
    hr{
            margin-left: 0;
            width: 10%;
        }
    table{
        border-radius: 5px;
        margin-left: 50px;
        margin-top: 60px;
    }
    td{
        /* width: 100px; */
        font-size: 12px;
        padding: 5px;
    }
    .second-td{
        text-align: left;
        color: gray;
        line-height: 40px
    }
    .third-td{
        text-align: right;
    }

    table{
        border-collapse: collapse;
        
    }

    td{
    
        border-top: 1px solid gray;
        border-bottom: 1px solid gray;
        
    }

    input{
        border-radius: 5px;
        border: 1px solid rgb(179, 179, 179);
        background-color: rgb(228, 228, 228);
        height: 30px;
        padding: 10px;
    }
    #intro{
        height: 200px;
    }
    #inner{
        margin-top: 10px;
        border-collapse: collapse;
        border-color: white;
        padding: 100px;
        background-color: lightgray;
        
    }
    #inner td{
        padding: 10px 10px;
        text-align: center;
        border: 1px solid white;
    }
    #inner tr{
        border: 1px solid white;
    }
    #line{
        width: 770px;
    }
    .sub-title{
        font-size: 13px;
        font-weight: 500;
    }

.btn2{
    margin-left: 3px;
    font-size: 12px;
    padding: 0;
    width: 20px;
    height: 20px;

}
.btn1{
/* border: 3px solid #ffcc3383;
background-color: #ffcc33; */
    font-size: 12px;
  width: 110px;
  height: 35px;
  border-radius: 20.5px;
 
}
.btn1:hover{
    color: white;
    background-color: #ffcc33;
}
button{
    font-size: 12px;
color: #ffcc33;
  width: 100px;
  height: 30px;
  border-radius: 20.5px;
  border: solid 1px #ffcc33;
  background-color: white;
}

button:hover{
    color: white;
    background-color: #ffcc33;
}
label.custom-file-label::after{
    height: 28px;
}

.hr-line {
    height: 2px;
    color: #ffcc33;
    background-color: #ffcc33;
    border: none;
}

.duplicate{
        font-size: 12px;
        color: white;
        width: 80px;
        height: 30px;
        border-radius: 20.5px;
        border: solid 1px grey;
        background-color: grey;
    }

    .duplicate:hover{
    color: white;
    background-color: #ffcc33;
    border: solid 1px #ffcc33;
    }

    .subrow{

        border-bottom: 1px solid white;
    }
    .subrow2{
        
        border-top: 1px solid white;
        border-bottom: 1px solid white;
    }
    .subrow3{
        
        border-top: 1px solid white;
    }


</style>
</head>
<body>
<body>
    <section>
        <div class="container">
            <form action="<%=request.getContextPath()%>/sitter/write" method="post" onsubmit="return test();">
            
            <!-- form을 넘기기 위해 hidden 처리한 input을 만듦. -->
            <input type="hidden" id="userId" name="userId" value="" >
            
            <div class="row">
                <!-- 메뉴 영역 -->
            <div class="col-2 menu">
                    <div id="menu">
                        <ul type="none">
                            <li class="title"><a href="<%=request.getContextPath()%>/userInfo">회원정보</a></li>
                            <hr class="hr-line"/>
                            <li class="content"><a href="<%=request.getContextPath()%>/userUpdate?userId="> - 회원정보 수정</a></li>
                            <li class="content"><a href="<%=request.getContextPath()%>/userDelete?userId="> - 회원 탈퇴</a></li>
                            <li class="content"><a href=""> - 북마크</a></li>
                            <li class="content"><a href=""> - 작성 후기</a></li>
                            <br/>
        
                            <li class="title">펫 프로필</li>
                            <hr class="hr-line"/>
                            <li class="content"><a href=""> - 펫 프로필</a></li>
                            <br/>
                            
                            <li class="title">예약</li>
                            <hr class="hr-line"/>
                            <li class="content"><a href=""> - 요청한 예약</a></li>
                            <li class="content"><a href=""> - 진행중인 예약</a></li>
                            <li class="content"><a href=""> - 종료된 예약</a></li>
                            <li class="content"><a href=""> - 채팅</a></li>
                            <br/>
                            
                            <li class="title">결제</li>
                            <hr class="hr-line"/>
                            <li class="content"><a href=""> - 결제 내역</a></li>
                            <li class="content"><a href=""> - 추가 요금 내역</a></li>
                            <br/>
                            
                        </ul>
                    </div>
                </div>
            <div class="vl"></div>
            <div class="col-9" style="padding:0;">
                <div class="row top-div" style="height: 200px;overflow: hidden;">
                    <img class="top-img" style="width: 100%; margin-top: -230px;" src="https://images.unsplash.com/flagged/photo-1548245643-7b805f2f93d5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80">
                </div>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item">회원 정보</li>
                    <li class="breadcrumb-item active">회원 정보 수정</li>
                </ul>
                   <!-- 콘텐츠 영역 -->
                    <table style="margin-left: auto; margin-right:auto">
                    	<tr>  
                            <td class="sub-title">프로필 이미지</td> 
                            <td class="second-td">1123.jpg</td>
                            <td class="third-td"><button type="button" onclick="toggle1();">수정하기</button></td>
                        </tr>
                        <div>
                        <tr class="row1" style="display: none;">
                            <td></td>
                            <td style="line-height:40px; padding-left:50px;"><input type="profileImg" id="profileImg" name="profileImg" style="height:25px; width: 230px;"/> </td> 
                            <td><button class="duplicate" type="button" style="height:25px;">중복확인</button></td>
                            <p></p>
                        </tr>
                        </div>
                        <tr>
                            <td class="sub-title" style="width: 150px;">이름</td> 
                            <td colspan="2" class="second-td" style="width: 400px;">고세빈</td>
                        </tr>
                        <tr>  
                            <td class="sub-title">이메일</td> 
                            <td class="second-td"></td>
                            <td class="third-td"><button type="button" onclick="toggle1();">수정하기</button></td>
                        </tr>
                        <div>
                        <tr class="row1" style="display: none;">
                            <td></td>
                            <td style="line-height:40px; padding-left:50px;"><input type="email" id="email" name="email" style="height:25px; width: 230px;"/> </td> 
                            <td><button class="duplicate" type="button" style="height:25px;">중복확인</button></td>
                            <p></p>
                        </tr>
                        </div>

                        <tr>
                            <td class="sub-title">생년월일</td> 
                            <td colspan="2" class="second-td">고세빈</td>
                        </tr>
                        <tr>
                            <td class="sub-title">성별</td> 
                            <td colspan="2" class="second-td">고세빈</td>
                        </tr>
                        <tr>
                            <td class="sub-title">휴대폰 번호</td> 
                            <td class="second-td"></td>
                            <td class="third-td"><button type="button" onclick="toggle2();">수정하기</button></td>
                        </tr>
                        <tr class="row2" style="display: none;">
                            <td></td>
                            <td style="line-height:40px; padding-left:50px;"><input type="text" id="phone" name="phone" style="height:25px; width: 230px;"/> </td> 
                            <td><button class="duplicate" type="button" style="height:25px;">중복확인</button></td>
                            <p></p>
                        </tr>
                        <tr>
                            <td class="sub-title">주소</td> 
                            <td class="second-td"> / / </td>
                            <td class="third-td"><button type="button" onclick="toggle3();">수정하기</button></td>
                        </tr>
                        <tr class="row3" style="display: none; border:1px solid white">
                            <td class="subrow"></td>
                            <td colspan = "2" class="subrow"style= "padding-left:50px;" >
                                <input style="line-height: 40px;" type="text" id="postNum" name="postNum"  placeholder="우편번호">&nbsp;&nbsp;&nbsp;<button class="duplicate" type="button" style="height:25px; width: 100px; " onclick="zip_code();" >우편번호 찾기</button></td> 
                            <!-- <td class="subrow" ></td> -->
                        </tr>
                        <tr class="row3" style="display: none;">
                            <td class="subrow2"></td>
                            <td class="subrow2" style= "padding-left:50px;">
                                <input style="line-height: 40px; width: 250px;" id="streetAddress" name="address" type="text" placeholder="도로명주소"/>
                            </td>
                            <td class="subrow2"></td>
                        </tr>
                        <tr class="row3" style="display: none;">
                            <td class="subrow3"></td>
                            <td class="subrow3" style = "padding-left:50px; padding-bottom: 10px;">
                                <input style="line-height: 40px; width: 250px;" id="addressInput" name="detail" type="text" placeholder="상세주소 입력"/>
                            </td>
                            <td class="subrow3"></td>
                        </tr>
                        <tr>
                            <td class="sub-title">비밀번호</td> 
                            <td class="second-td">비공개</td>
                            <td class="third-td"><button type="button" onclick="toggle4();">수정하기</button></td>    
                        </tr>
                        <tr class="row4" style="display: none;">
                            <td class="subrow2"></td>
                            <td class="subrow2" style= "padding-left:50px;">
                                <input style="line-height: 40px; width: 250px;" id="nowpw" name="nowpw" type="password" placeholder="현재 비밀번호"/>
                            </td>
                            <td class="subrow2"></td>
                        </tr>
                        <tr class="row4" style="display: none;">
                            <td class="subrow2"></td>
                            <td class="subrow2" style = "padding-left:50px;">
                                <input style="line-height: 40px; width: 250px;" id="newpw" name="newpw" type="password" placeholder="새 비밀번호"/>
                            </td>
                            <td class="subrow2"></td>
                        </tr>
                        <tr class="row4" style="display: none;">
                            <td class="subrow3"></td>
                            <td class="subrow3" style = "padding-left:50px; padding-bottom: 10px;">
                                <input style="line-height: 40px; width: 250px;" id="pwck" name="pwck" type="password" placeholder="새 비밀번호 확인"/>
                            </td>
                            <td class="subrow3"></td>
                        </tr>
                                         
                      
                        </table>
                        <br/>
                        <br/>
                        <div>
                        <button style="display:flex; margin-right: auto; margin-left: auto; color:white; border: solid 1px black; background-color :black; text-align: center;" type="submit">수정</button>
                        </div>
                        <br/>
                        <br/>

                    </div>
                </div>
            </div>
        </form>
        </div>
    </section>
</body>
</html>