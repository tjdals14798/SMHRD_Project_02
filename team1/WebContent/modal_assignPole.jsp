<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>

</style>
<body>
	<!----------------------------------------------- ���� ��� ��� ���� -------------------------------------------->
		<div id="modal2">
			<form action="assignpole" method="post" class="pole_form">
				<table class="pole_tb_body" cellpadding="2"
					style="border-collapse: collapse;">
					<tr height="100px">

						<td colspan="3" align="center" style="font-size: 30px;">
							<div id="empas">
								<img src="./images/pole.png" width="50px" height="50px">
								<p>���� ���</p>
							</div>
						</td>
					</tr>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>

					<tr height="25">
						<td class="wid3"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid4">���ֹ�ȣ</td>
						<td><input type="text" name="pole_code"
							style="margin-left: -5%; height:30px;"></td>
					</tr>

					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>

					<tr height="25">
						<td class="wid3"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid4">���� ����</td>
						<td><input type="text" name="pole_height"
							style="margin-left: -5%; height:30px;" /></td>
					</tr>

					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>

					<tr height="25">
						<td class="wid3"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid4">���� �ּ�</td>
						<td><input type="text" name="pole_addr"
							style="margin-left: -5%; height:30px;" /></td>
					</tr>

					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>


					<tr height="25">
						<td class="wid3"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid4">��� �����</td>
						<td><select name = "pole_office" style="margin: 0 0 0 -6%; width:150px; height:30px">
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


					<tr height="25">
						<td class="wid3"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid4">����� �����ȣ</td>
						<td><input type="text" name="emp_id"
							style="margin-left: -5%; height:30px;" /></td>
					</tr>

					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>


					<tr height="25">
						<td class="wid3"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td class="wid4">��ġ ����</td>
						<td><input type="text" name="pole_date"
							style="margin-left: -5%; height:30px;" /></td>
					</tr>
					<tr height="7">
						<td colspan="3">
							<hr />
							
						</td>
					</tr>

					<tr height="25">
						<td class="wid3"><img src="./images/check2.png" width="25px"
							; height="25px";></td>
						<td colspan="2" style="text-align: center;"><input
							type="checkbox" class="input_focus" name="transformer_yn"
							value="Y" style="margin-left: 4%; width: 20px;">���б� <input
							type="hidden" name="transformer_yn" value='N'> <input
							type="checkbox" class="input_focus" name="pole_com" value="Y"
							style="margin-left: 4%; width: 20px;">��ż� <input
							type="hidden" name="pole_com" value='N'> <input
							type="checkbox" class="input_focus" name="pole_high" value="Y"
							style="margin-left: 4%; width: 20px;">��м� <input
							type="hidden" name="pole_high" value='N'> <input
							type="checkbox" class="input_focus" name="pole_down" value="Y"
							style="margin-left: 4%; width: 20px;">���м� <input
							type="hidden" name="pole_down" value='N'></td>
					<tr height="7">
						<td colspan="3">
							<hr />
						</td>
					</tr>

					<tr height="70">
						<td colspan="3"><input type="button" name="rol" value="����ϱ�"
							id="uncheck2" class="rol">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" value="����ϱ�" class="suc" id="check">
						</td>
					</tr>
				</table>

			</form>

			<div class="modal_layer"></div>
		</div>
	<!-- --------------------------------------------- ���� ��� ��� ���� ------------------------------------------ -->
</body>
</html>