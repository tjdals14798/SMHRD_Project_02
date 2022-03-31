package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class tiltDAO {
   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet rs = null;
   tiltVO vo = null;
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
   
   public int insert_tilt(String mac_code) {
      try {
         
         connection();
         
         String sql = "insert into pole_tilt_info(mac_code,tilt_value) value (?,90)";
         
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
   
public ArrayList<tiltVO> tiltvalue() {
      
      tiltVO tvo = new tiltVO();
      ArrayList<tiltVO> al = new ArrayList<tiltVO>();
      
      try {
         
      connection();

      String sql = "Select mac_code,date_add(tilt_date, interval 9 hour)as tilt_date, tilt_value from pole_tilt_info order by tilt_date desc limit 30";
      
      psmt = conn.prepareStatement(sql);

      rs = psmt.executeQuery();
      
      while(rs.next()){
         
         String getMac_code = rs.getString("mac_code");
         String getTilt_date = rs.getString("tilt_date");
         int getTilt_value = rs.getInt("tilt_value");
         
         tvo = new tiltVO(getMac_code,getTilt_date,getTilt_value);
         
         al.add(tvo);
         }
      
      } catch (Exception e) {
         System.out.println();
         e.printStackTrace();
         } finally {
            close();
      }
      return al;
   }
   //�׷���
   public ArrayList<tiltVO> tilt_info(String mac_code) {
      tiltVO vo = null;
      ArrayList<tiltVO> tal = new ArrayList<tiltVO>();
      try {
         connection();
         String sql = "select mac_code,tilt_value,date_add(tilt_date, interval 9 hour)as tilt_date from pole_tilt_info where mac_code = ? order by tilt_date desc limit 10";
         
         psmt = conn.prepareStatement(sql);
         
         psmt.setString(1, mac_code);

         rs = psmt.executeQuery();

         while (rs.next()) {
            
            int tilt_value=rs.getInt("tilt_value");
            String tilt_date=rs.getString("tilt_date");

            vo= new tiltVO(tilt_value,tilt_date);
            
            tal.add(vo);
         }

      } catch (Exception e) {
         System.out.println("��ȸ����");
         e.printStackTrace();

      } finally {
         close();
      }
      
      return tal;
   }
   
   public ArrayList<tiltVO> tilt_info_and(String mac_code) {
      tiltVO vo = null;
      ArrayList<tiltVO> tal = new ArrayList<tiltVO>();
      try {
         connection();
         String sql = "select mac_code,tilt_value,date_add(tilt_date, interval 9 hour)as tilt_date from pole_tilt_info where mac_code = ? order by tilt_date desc limit 10";
         //select p.*,t.* from pole_info p,pole_tilt_info t where p.mac_code = t.mac_code && t.mac_code = 'testcode1';
         psmt = conn.prepareStatement(sql);
         
         psmt.setString(1, mac_code);

         rs = psmt.executeQuery();

         while (rs.next()) {
            
            int tilt_value=rs.getInt("tilt_value");
            String tilt_date=rs.getString("tilt_date");

            vo= new tiltVO(tilt_value,tilt_date);
            
            tal.add(vo);
         }

      } catch (Exception e) {
         System.out.println("��ȸ����");
         e.printStackTrace();

      } finally {
         close();
      }
      
      return tal;
   }

   public ArrayList<tiltVO> al_all_info() {
      tiltVO vo = null;
      ArrayList<tiltVO> tal = new ArrayList<tiltVO>();
      try {
         connection();
      
         String sql = "select distinct m.mac_code,t.tilt_date,t.tilt_value,c.camera_date,i.impact_date "
               + "from machine_info m left join pole_tilt_info t on m.mac_code = t.mac_code "
               + "left join pole_camera_info c on m.mac_code = c.mac_code "
               + "left join pole_impact_info i on m.mac_code = i.mac_code "
               + "order by tilt_date desc limit 30";
         psmt = conn.prepareStatement(sql);

         rs = psmt.executeQuery();

         while (rs.next()) {
            
            String mac_code = rs.getString("mac_code");
            int tilt_value=rs.getInt("tilt_value");
            String tilt_date=rs.getString("tilt_date");
            String camera_date=rs.getString("camera_date");
            String impact_date=rs.getString("impact_date");
   

            vo= new tiltVO(mac_code,tilt_date,tilt_value,camera_date,impact_date);
            
            tal.add(vo);
         }

      } catch (Exception e) {
         System.out.println("��ȸ����");
         e.printStackTrace();

      } finally {
         close();
      }
      
      return tal;
   }
}
