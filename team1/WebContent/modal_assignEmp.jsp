<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
		<div id="modal">
			<form action="assignEmp" method="post" class="emp_form">
				<table class="tb_body" cellpadding="2"
					style="border-collapse: collapse;">
					<tr height="50">

						<td colspan="3" align="center" style="font-size: 25px;">
							<div id="empas">
							<img src="./images/img4.png" width="50px" height="50px">
								<p>����� ���</p>
							</div>
						</td>
					</tr>

					<tr height="7">
						<td colspan="3">
							<hr>
						</td>
					</tr>

					<tr height="30">
						<td class="wid1"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td style="width:20%;">�����ȣ �ο�</td>
						<td><input type="text" name="emp_id"
							style="margin-left: 13%; height:30px;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="LoginCheckService" style="text-decoration: none;">�ߺ� �˻�</a></td>
					</tr>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>
					<tr height="30">
						<td class="wid1"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid2">��й�ȣ</td>
						<td><input type="password" name="emp_pw" id="pw"
							style="margin-left: -20%; height:30px;" /></td>
					</tr>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>
					<tr height="30">
						<td class="wid1"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid2">��й�ȣ Ȯ��</td>
						<td><input type="password" name="wUserPWConfirm" id="pwCheck"
							style="margin-left: -20%; height:30px;" /></td>
					</tr>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>
					<tr height="30">
						<td class="wid1"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid2">��� �̸�</td>
						<td><input type="text" name="emp_name"
							style="margin-left: -20%; height:30px;" /></td>
					</tr>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>
					<tr height="30">
						<td class="wid1"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid2">��� ����ó</td>
						<td><input type="tel" name="emp_phone"
							style="margin-left: -20%; height:30px;" /></td>

					</tr>		
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>
					<tr height="30">
						<td class="wid1"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid2">����� ��</td>
						<td><select name = "emp_office" style="margin: 0 0 0 -21%; width:150px; height:30px">
						<option >�����ϼ���</option>
						<option value="�ϱ�">�ϱ�</option>
						<option value="����">����</option>
						<option value="����">����</option>
						<option value="����">����</option>
						<option value="���걸" >���걸</option>
						</select></td>
					</tr>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>
					<tr height="30">
						<td class="wid1"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid2">������ ����</td>
						<td><input type="radio" name="admin_yesno" value="Y"
							class="input_focus" style="margin-left: -20%; width: 20px;">������
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="admin_yesno"
							class="input_focus" value="N" style="width: 20px;">�����</td>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>

					<tr height="80">
						<td colspan="3"><input type="button" name="" value="����ϱ�"
							id="uncheck" class="rol">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="submit" value="����ϱ�" class="suc" id="check"></td>
					</tr>
				</table>

			</form>

			<div class="modal_layer"></div>
		</div>
	<!----------------------------------------------- ����� ��� ��� ���� -------------------------------------------->
</body>
</html>