<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shorcut icon" type="image/x-icon" href="./images/upoplogo.PNG" type="text/css">
<title>���ְ��� �ý��� �α���</title>
<link rel="stylesheet" href="css/logincss.css">
</head>
<style>
body{
    background-size: cover;
    background-image: url("./images/ppt3.png");
 	background-repeat: no-repeat;
 	}

</style>
<body>
    <section class="form">
        <table class="tb"> 
            <tr>
                <td class="img">
                    <img src="./images/upoplogo.PNG" width="150px" height="150px">
                    
                </td>
                <td>
                    <h1><strong>���� ���� �ý���</strong></h1>
                    <p>POLE MANAGEMENT SYSTEM</p>
                    <form action="LoginService" method="post" class="loginbox">
                        <input placeholder="���̵� �Է����ּ���" type="text" name="emp_id" id="user_id"></input>
                        <input placeholder="��й�ȣ�� �Է����ּ���" type="password" name="emp_pw" id="user_pw"></input>
                        <input type="checkbox" id="checkid" value="saveID" onclick="confirmSave(this)">���̵� ����
                        <br>                     
                        <input type="submit" id="submit" value="�α���">
                        <div id="findinfo">
                        <a href="" id = "findid">���̵� ã��</a>&nbsp;&nbsp;&nbsp;
                        <a href="" id = "findpw">��й�ȣ ã��</a>  
                        </div>
                    </form>
                </td>
            </tr>
        </table>
    </section>

    <footer>
        <div id="copyright">
            <h4 style="color: #ffffff;">�����ڸ� ���� �ý������μ� �ΰ��� �и� ��� �� �� �ֽ��ϴ�.</h3>
            <br>
            <p style="color: #ffffff; margin-top:-1%;">Copyright 2021, Pole Of Pisa, LTD. All right Reserved.</p>
        </div>
    </footer>

   
</body>
</html>