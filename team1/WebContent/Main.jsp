<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="Model.poleDAO"%>
<%@page import="Model.tiltDAO"%>
<%@page import="Model.cameraDAO"%>
<%@page import="Model.impactDAO"%>
<%@page import="Model.poleVO"%>
<%@page import="Model.tiltVO"%>
<%@page import="Model.impactVO"%>
<%@page import="Model.cameraVO"%>
<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
<head>
<link rel="shorcut icon" type="image/x-icon"
	href="./images/upoplogo.PNG" type="text/css">
<title>POLE OF PISA 전주관리 시스템</title>
<link rel="stylesheet" href="css/Maincss.css">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<style>
@font-face {
	font-family: 'neon';
	src: url('./fonts/AppleSDGothicNeoL.ttf') format('truetype');
}

* {
	font-family: neon;
}

#btnimpt, #btnmtn, #btntt {
	border-radius: 10px;
	width: 31.5%;
	height: 16%;
	border: #ccc solid 1px;
	padding: 10px;
	font-size: 15px;
	color: wheat;
	background: #000000bd;
	-webkit-transition: all 0.1s ease;
}

#btnimpt:hover, #btnmtn:hover, #btntt:hover {
	background: #000000d6;
	color: white;
}

#select_line {
	margin-left: 5%;
	margin-bottom: 2.5%;
}
#select_line2{

margin-top: 5%;

}

#alarm::-webkit-scrollbar {
    width: 10px;
  }
#alarm::-webkit-scrollbar-thumb {
    background-color: #000000bd;
  }
#alarm::-webkit-scrollbar-track {
    background-color: #ffffff;
  }
 
.search_container::-webkit-scrollbar {
    width: 0px;
  }
.search_container::-webkit-scrollbar-thumb {
    background-color: #000000bd;
  }
.search_container::-webkit-scrollbar-track {
    background-color: #ffffff;
  }
  #nav > ul, ul>li{
  list-style : none;
  margin:0;
  padding:0;
  float: left;
  }
</style>
<body>

	<%
   request.setCharacterEncoding("utf-8");
   poleVO pvo = (poleVO) session.getAttribute("pole");

   poleDAO pdao = new poleDAO();
   ArrayList<poleVO> arrpVO = pdao.pole_selectAll();

   tiltDAO tdao = new tiltDAO();
   impactDAO idao = new impactDAO();
   cameraDAO cdao = new cameraDAO();

   String pole_code = request.getParameter("pole_code");
   String pole_height = request.getParameter("pole_height");
   String pole_date = request.getParameter("pole_date");
   String emp_id = request.getParameter("emp_id");
   String transformer_yn = request.getParameter("transformer_yn");
   String pole_office = request.getParameter("pole_office");
   String pole_high = request.getParameter("pole_high");
   String pole_down = request.getParameter("pole_down");
   String pole_com = request.getParameter("pole_com");
   String camera_date = request.getParameter("camera_date");
   String impact_date = request.getParameter("impact_date");
   String tilt_date = request.getParameter("tilt_date");
   String mac_code = request.getParameter("mac_code");
   String pole_level = request.getParameter("pole_level");
   
   ArrayList<poleVO> filter = pdao.filter(pole_height, pole_date, emp_id, transformer_yn, pole_office, pole_high, pole_down, pole_com, pole_code);
   ArrayList<tiltVO> t_alarm = tdao.tiltvalue();
   ArrayList<cameraVO> c_alarm = cdao.cameravalue();
   ArrayList<impactVO> i_alarm = idao.impactvalue();
   %>

	<!-- 네비게이션  -->
	<div id="nav" style="height: 60px;">
		<nav>
				<p
				style="float: left; color: wheat; font-size: 20px; margin: 0.8% 0% 0% 4%;">
				UTILITY POLE OF PISA
				</p>
			<button type="button" onclick="location.href='Main.jsp'">
			HOME
			</button>
			<button id="modal_pole">전주 등록</button>
			<button id="modal_emp">사용자 등록</button>
			<button type="button" onclick="location.href='LogoutService'">
			로그아웃
			</button>
		</nav>
		<div class="nav_img">
			<img src="./images/bar.png" width="100%" height="60px">
		</div>
	</div>

	<!-- 헤더 -->
	<div id="header">
		<div class="header_img">
			<img src="./images/upoplogo.PNG" width="100px" height="100px"
				id="logo">
		</div>
		<div class="header_h1">
			<b style="font-size: 40px; margin-left: -60%;">전주 통합 관리 시스템</b> <br>
			<b style="font-size: 30px; margin-left: -60%;">POLE MANAGEMENT SYSTEM</b>
		</div>
	</div>

	<!-- 사용자등록, 전주등록 modal include -->
	<%@ include file="/modal_assignEmp.jsp"%>
	<%@ include file="/modal_assignPole.jsp"%>

	<!-- 검색창 필터링  -->
	  <div id="searchBar">
      <div id="field_area">
         <form action="Main.jsp" method="get">
            <fieldset>
            <div class="fieldset_head">
               <b><p style="text-align: center; line-height : 1.75; font-size : 25px; color:#555555;">광주광역시<select name="pole_office" style="border:none; background:none;">
                  <option value="">사업소 선택</option>
                  <option value="동구">동구</option>
                  <option value="서구">서구</option>
                  <option value="남구">남구</option>
                  <option value="북구">북구</option>
                  <option value="광산구">광산구</option>
               </select></p> 
               </b>
              
               </div>

 
              	<div id="select_box" style="margin-top:3%">
             	<label>전주번호</label>
               <input type="text" name="pole_code" class="filter" style="width: 120px; height: 40px; margin-right: 4%;"> 
               
               <label>관리자</label>
               <input type="text" name="emp_id" style="width: 120px; height: 40px; margin-right: 4%; font-size: 15px;">
               
               <label>설치일자</label> 
               <input type="text" name="pole_date" id="searchtext">

               <label>높이</label> <input type="text" name="pole_height" id="searchtext"> <br> 
               </div>
               
               <div id="select_box2">
               <label>　변압기</label>
               <select name="transformer_yn" id="searchtext">
                  <option value="">선택</option>
                  <option value="Y">Y</option>
                  <option value="N">N</option>
               </select>
               <label> 고압선 </label>
               <select name="pole_high">
                  <option value="">선택</option>
                  <option value="Y">Y</option>
                  <option value="N">N</option>
               </select>
               
               <label>　저압선</label>
               <select name="pole_down" style="margin-right:2%;">
                  <option value="">선택</option>
                  <option value="Y">Y</option>
                  <option value="N">N</option>
               </select>
               
               <label>　통신선</label>
               <select name="pole_com" >
                  <option value="">선택</option>
                  <option value="Y">Y</option>
                  <option value="N">N</option>
               </select>
              </div>
               <input type="submit" name="pole_code" value="검색" class="filter_search" style="float: right; background-color : #FFFFFF; border: 1px solid #ccc; border-radius : 10px; width: 100px; margin-right:45%; margin-top:2%; ">
            </fieldset>
         </form>
      </div>

		<!-- 알림메세지  -->
		<div id="alarm">
			<button id="btntt">
			기울기감지
			</button>
			<button id="btnimpt">
				충격감지
			</button>
			<button id="btnmtn">
				모션감지
			</button>


			
			<div id="tiltdiv">
				<%
               for (int i = 0; i < t_alarm.size(); i++) {
            %>
				<div id="alarmback">
					<img src="./images/bell.png" width="30px" height="30px"
						style="float: left; margin-top: -1%">
						
					<div id="alarm_msg">			
					<%if(t_alarm.get(i).getTilt_value() < 79){ %>		
						<%=t_alarm.get(i).getTilt_date()%>에 <b><a href="managePole.jsp?pole_code=<%=t_alarm.get(i).getMac_code()%>"><%=t_alarm.get(i).getMac_code()%></a></b>에서
						<br>
						<b style="color:red;">기준치를 벗어난</b> 기울기 변화가 감지 됨 <br> 
						<b >(현재 기울기 : <b style="color:red;"><%=t_alarm.get(i).getTilt_value()%></b>)</b>
						<%}else{ %>
						<%=t_alarm.get(i).getTilt_date()%>에 <b><a href="managePole.jsp?pole_code=<%=t_alarm.get(i).getMac_code()%>"><%=t_alarm.get(i).getMac_code()%></a></b>에서
						기울기 변화가 감지 됨 <br> <b>(현재 기울기 : <%=t_alarm.get(i).getTilt_value()%>)
						<%} %>
						</b>
					
					</div>
				</div>
				<%
               }
            %>
			</div>
			<div id="impactdiv">
			
				<%
               for (int i = 0; i < i_alarm.size(); i++) {
            %>
				<div id="alarmback">
					<img src="./images/thunder.png" width="30px" height="30px"
						style="float: left; margin-top: -1%">
					<div id="alarm_msg">
						<%=i_alarm.get(i).getImpact_date()%>에 <b><a
							href="managePole.jsp?pole_code=<%=i_alarm.get(i).getMac_code()%>"><%=i_alarm.get(i).getMac_code()%></a></b>에서
						충격이 감지 됨 <br>
					</div>
				</div>
				<%
               }
            %>
			</div>


			<div id="motiondiv">
				<%
               for (int i = 0; i < c_alarm.size(); i++) {
            %>
				<div id="alarmback">
					<img src="./images/photo.png" width="30px" height="30px"
						style="float: left; margin-top: -1%">
					<div id="alarm_msg">
						<%=c_alarm.get(i).getCamera_date()%>에 <b><a
							href="managePole.jsp?pole_code=<%=c_alarm.get(i).getMac_code()%>"><%=c_alarm.get(i).getMac_code()%></a></b>에서
						모션이 감지 됨 <br>
					</div>
				</div>
				<%
               }
            %>
			</div>

			
		</div>

	</div>
	<!-- 알림메세지 끝 -->


 <!-- 검색 전 pole_info 전체결과 -->
   <%
      if (pole_height == null) {
   %>
   <div id="wrapper">
      <div class="search_container" style="text-align: center;">
         <table id="poletable" style="text-align: center; margin: auto;">
            <tr>
               <th>위험도</th>
               <th>전주번호</th>
               <th>관리자</th>
               <th>담당 사업소</th>
               <th>설치일자</th>
               <th>높이</th>
               <th>변압기</th>
               <th>고압선</th>
               <th>저압선</th>
               <th>통신선</th>
               <th>현재 기울기</th>

            </tr>
            <%
               for (int i = 0; i < arrpVO.size(); i++) {
            %>
            <tr>
               <%
                  if (arrpVO.get(i).getNow_tilt()>=80 && arrpVO.get(i).getNow_tilt()<85 ) {
               %>
               <td><img src="./images/middlesign.png" width="35px"  height="35px"></td>

               <%
                  } else if (arrpVO.get(i).getNow_tilt()<79 ) {
               %>
               <td><img src="./images/high.png" width="40px" height="40px"></td>
               <%
                  } else if (arrpVO.get(i).getNow_tilt()>=86 || arrpVO.get(i).getNow_tilt()<=90) {
               %>
               <td><img src="./images/checked.png" width="30px" height="30px"></td>
               <%
                  }
               %>
               <td><a href="managePole.jsp?pole_code=<%=arrpVO.get(i).getPole_code()%>"><%=arrpVO.get(i).getPole_code()%></a></td>
               <td><%=arrpVO.get(i).getEmp_id()%></td>
               <td><%=arrpVO.get(i).getPole_office()%></td>
               <td><%=arrpVO.get(i).getPole_date()%></td>
               <td><%=arrpVO.get(i).getPole_height()%></td>
               <td><%=arrpVO.get(i).getTransformer_yn()%></td>
               <td><%=arrpVO.get(i).getPole_high()%></td>
               <td><%=arrpVO.get(i).getPole_down()%></td>
               <td><%=arrpVO.get(i).getPole_com()%></td>
               <td><%=arrpVO.get(i).getNow_tilt()%></td>
            </tr>
            <%
               }
            %>
         </table>
      </div>
   </div>

   <%
      } else {
   %>
   <!-- 검색 후 전주정보 -->

   <div id="min_wrapper">

      <div class="search_container" style="text-align: center;">
         <table id="poletable"
            style="text-align: center; margin: auto; margin-top: 4%;">
            <tr>
               <th>위험도</th>
               <th>전주번호</th>
               <th>관리자</th>
               <th>담당 사업소</th>
               <th>설치일자</th>
               <th>높이</th>
               <th>변압기</th>
               <th>고압선</th>
               <th>저압선</th>
               <th>통신선</th>
               <th>현재 기울기</th>
            </tr>
            <%
               for (int i = 0; i < filter.size(); i++) {
            %>
            <tr>
               <%
                  if (filter.get(i).getNow_tilt()>=80 && filter.get(i).getNow_tilt()<85 ) {
               %>
               <td><img src="./images/middlesign.png" width="35px"
                  height="35px"></td>

               <%
                  } else if (filter.get(i).getNow_tilt()<79 ) {
               %>
               <td><img src="./images/high.png" width="40px" height="40px"></td>
               <%
                  } else if (filter.get(i).getNow_tilt()>=85 || arrpVO.get(i).getNow_tilt()<=90) {
               %>
               <td><img src="./images/checked.png" width="30px" height="30px"></td>
               <%
                  }
               %>
               <td><a
                  href="managePole.jsp?pole_code=<%=filter.get(i).getPole_code()%>"><%=filter.get(i).getPole_code()%></a></td>
               <td><%=filter.get(i).getEmp_id()%></td>
               <td><%=filter.get(i).getPole_office()%></td>
               <td><%=filter.get(i).getPole_date()%></td>
               <td><%=filter.get(i).getPole_height()%></td>
               <td><%=filter.get(i).getTransformer_yn()%></td>
               <td><%=filter.get(i).getPole_high()%></td>
               <td><%=filter.get(i).getPole_down()%></td>
               <td><%=filter.get(i).getPole_com()%></td>
               <td><%=filter.get(i).getNow_tilt()%></td>
            </tr>
            <%
               }
            %>
         </table>
      </div>
   </div>

   <%
      }
   %>

	<!-- footer -->
	<div id="footer">
		<div class="copyright" style="text-align: center;">
			<h3 style="color: rgba(202, 202, 202, 0.733)">관리자를 위한 시스템으로서 인가된
				분만 사용 할 수 있습니다.</h3>
			<p style="color: rgba(202, 202, 202, 0.733)">Copyright 2021, Pole
				Of Pisa, LTD. All right Reserved.</p>
		</div>
	</div>


	<!-- 사용자 등록 모달 -->

	<script>
      $("#modal_emp").click(function() {
         $("#modal").fadeIn();
      });
      $("#uncheck").click(function() {
         $("#modal").fadeOut();
      });
   </script>
   
	<script>
      // 전주 등록 모달
      $("#modal_pole").click(function() {
         $("#modal2").fadeIn();
      });
      $("#uncheck").click(function() {
         $("#modal2").fadeOut();
      });
      
   </script>
   
   
	<!-- Scripts -->
	
	<!-- modal.js -->
	<script src="js/modal.js"></script>

	<!-- alarm.js -->
	<script>
      $(document).ready(function() {
         $('#tiltdiv').show();
         $('#motiondiv').hide();
         $('#impactdiv').hide();

         $('#btnimpt').click(function() {
            $('#motiondiv').hide();
            $('#tiltdiv').hide();
            $('#impactdiv').show();
            return false;
         });

         $('#btnmtn').click(function() {
            $('#impactdiv').hide();
            $('#tiltdiv').hide();
            $('#motiondiv').show();
            return false;
         });

         $('#btntt').click(function() {
            $('#motiondiv').hide();
            $('#impactdiv').hide();
            $('#tiltdiv').show();
            return false;
         });
      });
   </script>
</body>
</html>