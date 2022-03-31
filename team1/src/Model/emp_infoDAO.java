package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
 

public class emp_infoDAO {
   
   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet rs = null;
   emp_infoVO vo = null;
   ArrayList<emp_infoVO> al =null;
   boolean check= false;
   int cnt = 0;

   //��������
   public void connection() {
   
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url="jdbc:mysql://project-db-stu.ddns.net:3307/pole_db";
         String dbid="pole_db";
         String dbpw="1004hw";

         System.out.println("�������Ἲ��");
         conn = DriverManager.getConnection(url,dbid,dbpw);
         
      	} catch (Exception e) {

    	 System.out.println("�����������");
         e.printStackTrace();

      }

   }

   

//   ���Ӳ���

   public void close() {
      try {
         if(rs!=null) {
            rs.close();
      }
         if(psmt!=null) {
            psmt.close();
         }
         if(conn!=null) {
            conn.close();
         }

         
      } catch (Exception e2) {
         e2.printStackTrace();

      }

   }

   

   // ������ �߰�

   public int addemp(String emp_id,String emp_pw,String emp_name, String emp_phone,String emp_office, String admin_yesno) {
   
      try {
         connection();         

         String sql = "insert into emp_info values (?,?,?,?,?,?)";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1,emp_id);
         psmt.setString(2,emp_pw);
         psmt.setString(3,emp_name);
         psmt.setString(4,emp_phone);
         psmt.setString(5,emp_office);
         psmt.setString(6,admin_yesno);

         cnt = psmt.executeUpdate();

      } catch (Exception e) {
         System.out.println("������ �߰� ����");
         e.printStackTrace();
  
      }finally {
         close();

      }
      return cnt;

   }
 

   // �α���

   public emp_infoVO login(String emp_id, String emp_pw) {


      try {
         connection();

         String sql = "select * from emp_info where emp_id=? and emp_pw =?";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1,emp_id);
         psmt.setString(2,emp_pw);       
         
         rs = psmt.executeQuery();
       

         if(rs.next()){
            System.out.println("�α��μ���!");

            String getemp_id = rs.getString("emp_id");
            String getemp_pw = rs.getString("emp_pw");
            String getemp_name = rs.getString("emp_name");
            String getemp_Office = rs.getString("emp_office");
            String getemp_phone = rs.getString("emp_phone");
            String getadmin_yesno = rs.getString("admin_yesno");

            vo = new emp_infoVO(getemp_id, getemp_pw, getemp_name, getemp_Office, getemp_phone, getadmin_yesno);
           

         }else {
            System.out.println("�α��ν���!");
         }   

      } catch (Exception e) {
         System.out.println("���ܻ�Ȳ���� ���� �α��ν���");
         e.printStackTrace();
         

      }finally {
         close();
      }
      return vo;
   }

   

   // ������ ���� ����

   public int update(String emp_id, String emp_pw,String emp_name, String emp_office, String emp_phone, String admin_yesno) {

      try {
        connection();

        String sql = "UPDATE emp_info SET emp_pw = ?, emp_name =?, emp_office = ?, emp_phone = ?, admin_yesno = ? WHERE emp_id = ?";

         psmt = conn.prepareStatement(sql);      
         psmt.setString(1,emp_pw);
         psmt.setString(2,emp_name);
         psmt.setString(3,emp_office);
         psmt.setString(4,emp_phone);
         psmt.setString(5,admin_yesno);
         psmt.setString(6,emp_id);

         cnt = psmt.executeUpdate();

      	} catch (Exception e) {

         System.out.println("������ ���� ��������");

         e.printStackTrace();

      }finally {
        close();
     }

      return cnt;

   }

   

//  ȸ������ ����

   public ArrayList<emp_infoVO> selectAll() {

      try {
        al = new ArrayList<emp_infoVO>();
         connection();

         String sql = "select * from emp_info";
         psmt = conn.prepareStatement(sql);
         rs = psmt.executeQuery();

         while(rs.next()){

            String getemp_id = rs.getString("emp_id");
            String getemp_name = rs.getString("emp_name");
            String getemp_office = rs.getString("emp_office");
            String getemp_phone = rs.getString("emp_phone");
            String getadmin_yesno = rs.getString("emp_yesni");

            vo = new emp_infoVO(getemp_id,getemp_name,getemp_office,getemp_phone,getadmin_yesno);   
            
            al.add(vo);
         }

      } catch (Exception e) {
         System.out.println("������ ���� �ҷ����� ����");
         e.printStackTrace();

      }finally {
         close();
      }
      return al;

   }

   
//   ������ ����

   public int delete(String emp_id) {
      try {

         connection();

            String sql = "DELETE from admin where emp_id=?";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, emp_id);
            cnt = psmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      }finally {
        close();   
      }
      return cnt;
   }

 

}