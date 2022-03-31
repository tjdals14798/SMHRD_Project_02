package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class impactDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	impactVO vo = null;
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
public ArrayList<impactVO> impactvalue() {
		
		impactVO ivo = new impactVO();
		ArrayList<impactVO> al = new ArrayList<impactVO>();
		
		try {
			
		connection();
		//Select mac_code,date_add(impact_date, interval 9 hour)as impact_date from pole_impact_info order by impact_date desc limit 30
		String sql = "Select mac_code,date_add(impact_date, interval 9 hour)as impact_date from pole_impact_info order by impact_date desc limit 30";
		
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		
		while(rs.next()){
			
			String getMac_code = rs.getString("mac_code");
			String getImpact_date = rs.getString("impact_date");
			
			ivo = new impactVO(getMac_code, getImpact_date);
			
			al.add(ivo);
			
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
