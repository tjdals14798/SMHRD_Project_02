package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class cameraDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	cameraVO vo = null;
	int cnt = 0;
	
	public void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         String url="jdbc:mysql://project-db-stu.ddns.net:3307/pole_db";
	         String dbid="pole_db";
	         String dbpw="1004hw";

			System.out.println("���Ἲ��");
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			System.out.println("�������");
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	} 
	
	public ArrayList<cameraVO> cameravalue() {
		
		cameraVO cvo = new cameraVO();
		ArrayList<cameraVO> al = new ArrayList<cameraVO>();
		
		try {
			
		connection();

		String sql = "Select mac_code,date_add(camera_date, interval 9 hour)as camera_date from pole_camera_info order by camera_date desc limit 30";
		
		psmt = conn.prepareStatement(sql);
		


		rs = psmt.executeQuery();
		
		while(rs.next()){
			
			String getMac_code = rs.getString("mac_code");
			String getCamera_date = rs.getString("camera_date");
			
			cvo = new cameraVO(getMac_code, getCamera_date);
			
			al.add(cvo);
			
			
			}
		
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
			} finally {
				close();
		}
		return al;
	}
}
