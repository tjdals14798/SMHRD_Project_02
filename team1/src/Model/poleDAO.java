package Model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class poleDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	poleVO vo = null;
	int cnt = 0;
	ArrayList<poleVO> al = null;
	ArrayList<poleVO> lal = null;
	boolean check = false;

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
	
	//����
	@SuppressWarnings("null")
	public ArrayList<poleVO> filter(String pole_height, String pole_date, String emp_id, String transformer_yn, String pole_office, String pole_high, String pole_down, String pole_com, String pole_code) {
		
		ArrayList<poleVO> al = new ArrayList<poleVO>();
		
		try {		
			vo = new poleVO();
			
			connection();
			String sql = "select *,(select tilt_value from pole_tilt_info where pole_tilt_info.mac_code=pole_info.mac_code order by tilt_date desc limit 1) as now_tilt from pole_info where 1=1";
			
			// ������ �߰� �� ������ ������ �߰�
			String addQuery = "";
			
			if (pole_height != null || !pole_height.equals("")) {
				addQuery += " AND pole_height like '%" + pole_height + "%'";
			}
			if (pole_date != null || !pole_date.equals("")) {
				addQuery += " AND pole_date like '%" + pole_date + "%'";
			}
			if (emp_id != null || !emp_id.equals("")) {
				addQuery += " AND emp_id like '%" + emp_id + "%'";
			}	
			if (transformer_yn != null || !transformer_yn.equals("")) {
				addQuery += " AND transformer_yn like '%" + transformer_yn + "%'";
			}
			if (pole_office != null || !pole_office.equals("")) {
				addQuery += " AND pole_office like'%" + pole_office + "%'";
			}					
			if (pole_high != null || !pole_high.equals("")) {
				addQuery += " AND pole_high like '%" + pole_high + "%'";
			}
			if (pole_down != null || !pole_down.equals("")) {
				addQuery += " AND pole_down like '%" + pole_down + "%'";
			}
			if (pole_com != null || !pole_com.equals("")) {
				addQuery += " AND pole_com like '%" + pole_com + "%'";
			}
			if (pole_code != null || !pole_code.equals("")) {
				addQuery += " AND pole_code like '%" + pole_code + "%'";
			}
			
			sql += addQuery+"order by pole_date desc";
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			// �÷��� ���� null���� check, !null�̶�� addQuery�ؼ� �˻� �� ���͸�
			

			while(rs.next()) {
				
				//�ؿ�
				
				String getpole_office = rs.getString("pole_office");
				String getemp_id = rs.getString("emp_id");		
				String getpole_date = rs.getString("pole_date");
				String getpole_height = rs.getString("pole_height");
				String gettransformer_yn = rs.getString("transformer_yn");	
				String getpole_high = rs.getString("pole_high");
				String getpole_down = rs.getString("pole_down");
				String getpole_com = rs.getString("pole_com");
				String getpole_code = rs.getString("pole_code");
				int now_tilt = rs.getInt("now_tilt");
				
				vo = new poleVO(getpole_code, getpole_height, getpole_date, getemp_id, gettransformer_yn, getpole_com, getpole_high, getpole_down, getpole_office,now_tilt);
				
				al.add(vo);
			}
			

			
		} catch (Exception e) {
			System.out.println("������ ���� ���͸� ����");
			e.printStackTrace();

		} finally {
			close();
		}
		return al;
	}
	
	//��� �߰�
	public int addmachine(String mac_code) {
		
		try {
			
			connection();
			
			String sql = "insert into machine_info value (?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mac_code);
			
			cnt = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("��Ͻ���");
		}finally {
			close();
		}
		
		return cnt;
	}
	
	
	
	// ���� �߰�
	public int addpole(String pole_code,String mac_code, String pole_height, String pole_addr, String pole_high, String pole_down, String pole_com, String transformer_yn, String pole_level, String emp_id, String pole_office, String pole_date) {
		try {

			connection();

//	   	         3. ������ sql�� ���� (�����Ҷ����� ���� �޶����� �κ��� ? �ۼ�)

			String sql = "insert into pole_info (pole_code,mac_code,pole_height,"
					+ "pole_addr, pole_high, pole_down,"
					+ "pole_com,transformer_yn,emp_id, pole_office, pole_date) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";

//	   	         4. sql�� ���ఴü (PreparedStatment)����

			psmt = conn.prepareStatement(sql);

//	   	         5. ���ε� ����(?) ä���

			psmt.setString(1, pole_code);
			psmt.setString(2, mac_code);
			psmt.setString(3, pole_height);
			psmt.setString(4, pole_addr);
			psmt.setString(5, pole_high);
			psmt.setString(6, pole_down);
			psmt.setString(7, pole_com);
			psmt.setString(8, transformer_yn);
			psmt.setString(9, emp_id);
			psmt.setString(10, pole_office);
			psmt.setString(11, pole_date);
			

//	   	         6. sql�� ���� �� ���ó��

			cnt = psmt.executeUpdate();

		} catch (Exception e) {

			System.out.println("��Ͻ���");
			e.printStackTrace();

		} finally {
			close();
		}
		return cnt;
	}
	
	// ���� ���� ����
	public int pole_update(String pole_code,String pole_office, String pole_high, String pole_down,
			String pole_com, String transformer_yn, String emp_id) {

		try {

			connection();

			String sql = "UPDATE pole_info SET pole_office = ?, pole_high = ?, pole_down = ?, pole_com = ?, transformer_yn = ?, emp_id = ? WHERE pole_code = ?";

			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pole_office);
			psmt.setString(2, pole_high);
			psmt.setString(3, pole_down);
			psmt.setString(4, pole_com);
			psmt.setString(5, transformer_yn);
			psmt.setString(6, emp_id);
			psmt.setString(7, pole_code);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("��������");
			e.printStackTrace();

		} finally {
			close();
		}
		return cnt;

	}

	// ���� ���� ����Ʈ

	public ArrayList<poleVO> pole_selectAll() {

		try {

			al = new ArrayList<poleVO>();

			connection();

			String sql = "select *,(select tilt_value from pole_tilt_info where pole_tilt_info.mac_code=pole_info.mac_code order by tilt_date desc limit 1) as now_tilt from pole_info;";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String getPole_code = rs.getString("pole_code");
				String getMac_code = rs.getString("mac_code");
				String getPole_height = rs.getString("pole_height"); 
				String getPole_addr = rs.getString("pole_addr");
				String getPole_date = rs.getString("pole_date");
				String getEmp_id = rs.getString("emp_id");
				String getTransformer_yn = rs.getString("transformer_yn");
				String getPole_com = rs.getString("pole_com");
				String getpole_high = rs.getString("pole_high");
				String getpole_down = rs.getString("pole_down");
				String getPole_comment = rs.getString("pole_comment");
				String getPole_eday = rs.getString("pole_eday");
				String getPole_office= rs.getString("pole_office");
				String getPole_level = rs.getString("pole_level");
				int now_tilt = rs.getInt("now_tilt");

				vo = new poleVO(getPole_code, getMac_code, getPole_height, getPole_addr, getPole_date, getEmp_id, getTransformer_yn, getPole_com, getpole_high, getpole_down, getPole_comment, getPole_eday, getPole_level, getPole_office,now_tilt);


//	   	            vo���� al�� add

				al.add(vo);

			}

		} catch (Exception e) {
			System.out.println("��ȸ����");
			e.printStackTrace();

		} finally {
			close();
		}
		return al;
	}
	
	// ���� ������ ������

		public poleVO pole_selectONE(String pole_code) {

			try {
				connection();

				String sql = "select *,(select tilt_value from pole_tilt_info where pole_tilt_info.mac_code=pole_info.mac_code and mac_code = ? order by tilt_date desc limit 1) as now_tilt from pole_info where pole_code = ?";
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, pole_code);
				psmt.setString(2, pole_code);

				rs = psmt.executeQuery();

				while (rs.next()) {

					String getPole_code = rs.getString("pole_code");
					String getMac_code = rs.getString("mac_code");
					String getPole_height = rs.getString("pole_height"); 
					String getPole_addr = rs.getString("pole_addr");
					String getPole_date = rs.getString("pole_date");
					String getEmp_id = rs.getString("emp_id");
					String getTransformer_yn = rs.getString("transformer_yn");
					String getPole_com = rs.getString("pole_com");
					String getpole_high = rs.getString("pole_high");
					String getpole_down = rs.getString("pole_down");
					String getPole_comment = rs.getString("pole_comment");
					String getPole_eday = rs.getString("pole_eday");
					String getPole_office= rs.getString("pole_office");
					String getPole_level = rs.getString("pole_level");
					int now_tilt = rs.getInt("now_tilt");

					vo = new poleVO(getPole_code, getMac_code, getPole_height, getPole_addr, getPole_date, getEmp_id, getTransformer_yn, getPole_com, getpole_high, getpole_down, getPole_comment, getPole_eday,getPole_level, getPole_office,now_tilt);

				}

			} catch (Exception e) {
				System.out.println("��ȸ����");
				e.printStackTrace();

			} finally {
				close();
			}
			return vo;
		}
		
		
	

	// ���� ����

	public int pole_delete(String pole_code) {
		try {
			connection();

			String sql = "DELETE from pole_info where pole_code = ? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pole_code);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			close();
		}

		return cnt;
	}
	
	// ���� �� ������ �޸� ���
	public int webmemo(String pole_memo,String pole_comment, String pole_code) {
		try{
			connection();

		String sql = "UPDATE pole_info SET pole_comment = ? ? WHERE pole_code = ?";
		System.out.println(sql);

		psmt = conn.prepareStatement(sql);

		psmt.setString(2, pole_comment);
		psmt.setString(1, pole_memo);
		psmt.setString(3, pole_code);

		cnt = psmt.executeUpdate();
	} catch (Exception e) {
		System.out.println("���Խ���");
		e.printStackTrace();
	} finally {
		close();
	}
	return cnt;
	}

	public ArrayList<tiltVO> tilt_info(String pole_code) {
		ArrayList<tiltVO> tal = new ArrayList<tiltVO>();
		try {
			connection();

			String sql = "select * from pole_tilt_info where mac_code = ?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pole_code);

			rs = psmt.executeQuery();

			while (rs.next()) {
				
				String mac_code=rs.getString("mac_code");
				int tilt_value=rs.getInt("tilt_value");
				String mac_date=rs.getString("mac_date");

			tiltVO vo= new tiltVO(mac_code,tilt_value,mac_date);
				
			}

		} catch (Exception e) {
			System.out.println("��ȸ����");
			e.printStackTrace();

		} finally {
			close();
		}
		
		return tal;
	}
	
	
	
	// ���� ���� ���� and
		public int pole_update_and(String pole_code,String pole_office, String pole_high, String pole_down,
				String pole_com, String transformer_yn, String emp_id, String pole_comment) {

			try {

				connection();

				String sql = "UPDATE pole_info SET pole_office = ?, pole_high = ?, pole_down = ?, pole_com = ?, transformer_yn = ?, emp_id = ?, pole_comment = ? WHERE pole_code = ?";

				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, pole_office);
				psmt.setString(2, pole_high);
				psmt.setString(3, pole_down);
				psmt.setString(4, pole_com);
				psmt.setString(5, transformer_yn);
				psmt.setString(6, emp_id);
				psmt.setString(7, pole_comment);
				psmt.setString(8, pole_code);

				cnt = psmt.executeUpdate();

			} catch (Exception e) {
				System.out.println("��������");
				e.printStackTrace();

			} finally {
				close();
			}
			return cnt;

		}


}
