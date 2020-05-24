package semishit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class EmployeesDao {
   Connection conn = null;
   PreparedStatement ps = null;
   ResultSet rs = null;

   // db연결 생성자
   public EmployeesDao() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@192.168.0.22:1521:xe";
      String dbUser = "chta";
      String dbPwd = "chta";

      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, dbUser, dbPwd);
      } catch (ClassNotFoundException e) {
         
      } catch (SQLException e) {
      
      }
   }

   // db종료 생성자
   public void dbClose() {
      if (rs != null) try {rs.close();} catch (Exception e1) {}
      if (ps != null) try {ps.close();} catch (Exception e2) {}
      if (conn != null) try {conn.close();} catch (Exception e3) {}
      
   }

   //  테이블에 목록을 띄우기 위한 검색
   public DefaultTableModel tableGetSelect(DefaultTableModel model) {
      String sql = "select employee_number \"사원번호\", employee_name \"성명\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"생년월일\", phone \"연락처\", job_name \"직책\" from employees"
            + " order by employee_number";
      try {
         ps = conn.prepareStatement(sql);
         ResultSetMetaData meta = ps.getMetaData();

         int cnt = meta.getColumnCount();
         for (int i = 1; i <= cnt; i++) {
            model.addColumn(meta.getColumnName(i));
         }

         rs = ps.executeQuery();
         while (rs.next()) {
            Vector row = new Vector();
            for (int i = 1; i <= cnt; i++) {
               row.add(rs.getString(i));
            }
            model.addRow(row);
         }

      } catch (SQLException e) {

      } finally {
         dbClose();
      }
      return model;
   }
   
   // 테이블 갱신 메소드
   public DefaultTableModel newTableGetSelect() {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"사원번호\", employee_name \"성명\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"생년월일\", phone \"연락처\", job_name \"직책\" from employees"
            + " order by employee_number";
      try {
         ps = conn.prepareStatement(sql);
         ResultSetMetaData meta = ps.getMetaData();

         int cnt = meta.getColumnCount();
         for (int i = 1; i <= cnt; i++) {
            model.addColumn(meta.getColumnName(i));
         }

         rs = ps.executeQuery();
         while (rs.next()) {
            Vector row = new Vector();
            for (int i = 1; i <= cnt; i++) {
               row.add(rs.getString(i));
            }
            model.addRow(row);
         }

      } catch (SQLException e) {

      } finally {
         dbClose();
      }
      return model;
   }
   
   // 전체 조회
   public DefaultTableModel allGetSelect(String all) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"사원번호\", employee_name \"성명\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"생년월일\", phone \"연락처\", job_name \"직책\" from employees"
            + " where employee_number like ? or employee_name like ? or job_name like ?"
            + " order by employee_number";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, "%" + all + "%");
         ps.setString(2, "%" + all + "%");
         ps.setString(3, "%" + all + "%");
         ResultSetMetaData meta = ps.getMetaData();

         int cnt = meta.getColumnCount();
         for (int i = 1; i <= cnt; i++) {
            model.addColumn(meta.getColumnName(i));
         }

         rs = ps.executeQuery();
         while (rs.next()) {
            Vector row = new Vector();
            for (int i = 1; i <= cnt; i++) {
               row.add(rs.getString(i));
            }
            model.addRow(row);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return model;
   }

   // 사원번호 조회
   public DefaultTableModel eNumGetSelect(String eNum) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"사원번호\", employee_name \"성명\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"생년월일\", phone \"연락처\", job_name \"직책\" from employees"
            + " where employee_number = ?"
            + " order by employee_number";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, eNum);
         ResultSetMetaData meta = ps.getMetaData();

         int cnt = meta.getColumnCount();
         for (int i = 1; i <= cnt; i++) {
            model.addColumn(meta.getColumnName(i));
         }

         rs = ps.executeQuery();
         while (rs.next()) {
            Vector row = new Vector();
            for (int i = 1; i <= cnt; i++) {
               row.add(rs.getString(i));
            }
            model.addRow(row);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return model;
   }
   
   // 성명 조회
   public DefaultTableModel eNameGetSelect(String eName) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"사원번호\", employee_name \"성명\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"생년월일\", phone \"연락처\", job_name \"직책\" from employees"
            + " where employee_name = ?"
            + " order by employee_number";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, eName);
         ResultSetMetaData meta = ps.getMetaData();

         int cnt = meta.getColumnCount();
         for (int i = 1; i <= cnt; i++) {
            model.addColumn(meta.getColumnName(i));
         }

         rs = ps.executeQuery();
         while (rs.next()) {
            Vector row = new Vector();
            for (int i = 1; i <= cnt; i++) {
               row.add(rs.getString(i));
            }
            model.addRow(row);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return model;
   }
   
   // 직책 조회
   public DefaultTableModel jNameGetSelect(String jName) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"사원번호\", employee_name \"성명\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"생년월일\", phone \"연락처\", job_name \"직책\" from employees"
            + " where job_name = ?"
            + " order by employee_number";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, jName);
         ResultSetMetaData meta = ps.getMetaData();

         int cnt = meta.getColumnCount();
         for (int i = 1; i <= cnt; i++) {
            model.addColumn(meta.getColumnName(i));
         }

         rs = ps.executeQuery();
         while (rs.next()) {
            Vector row = new Vector();
            for (int i = 1; i <= cnt; i++) {
               row.add(rs.getString(i));
            }
            model.addRow(row);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return model;
   }
   
   // 화면에서 row를 선택시 사원번호를 입력받아 조회하는 생성자
   public EmployeesVo panelGetSelect(int eNum) {
      EmployeesVo vo = null;
      String sql = "select * from employees where employee_number = ?"
            + " order by employee_number";

      try {
         ps = conn.prepareStatement(sql);
         ps.setInt(1, eNum);

         rs = ps.executeQuery();
         if (rs.next()) {
            vo = new EmployeesVo();
            vo.seteNum(rs.getInt("employee_number"));
            vo.seteName(rs.getString("employee_name"));
            vo.setbDate(rs.getDate("birth_date"));
            vo.setPhone(rs.getString("phone"));
            vo.setEmail(rs.getString("email"));
            vo.setAddress(rs.getString("address"));
            vo.setjName(rs.getNString("job_name"));
            vo.sethDate(rs.getDate("hire_date"));
            vo.setRemark(rs.getString("remark"));
            vo.setePhoto(rs.getString("emp_photo"));
            vo.setSalary(rs.getInt("salary"));
            vo.setePName(rs.getString("emp_photo_name"));
         }

      } catch (SQLException e) {

      } finally {
         dbClose();
      }

      return vo;
   }

   // 직원을 등록하는 메소드
   public int empInsert(EmployeesVo vo) {
      int cnt = 0;
      String sql = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      String sql2 = "insert into finance(expend, idate) select salary, hire_date from employees";
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      try {
         ps = conn.prepareStatement(sql);
         ps.setInt(1, vo.geteNum());
         ps.setString(2, vo.geteName());
         ps.setString(3, sdf.format(vo.getbDate()));
         ps.setString(4, vo.getPhone());
         ps.setString(5, vo.getEmail());
         ps.setString(6, vo.getAddress());
         ps.setString(7, vo.getjName());
         ps.setString(8, sdf.format(vo.gethDate()));
         ps.setString(9, vo.getRemark());
         ps.setString(10, vo.getePhoto());
         ps.setInt(11, vo.getSalary());
         ps.setString(12, vo.getePName());
         conn.setAutoCommit(false);
         cnt = ps.executeUpdate();
         
         ps = conn.prepareStatement(sql2);
         ps.setInt(1, vo.geteNum());
         ps.executeUpdate();
         
         if (cnt > 0) {
            conn.commit();
         } else {
            conn.rollback();
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return cnt;
   }
   
   // 직원 정보를 수정하는 메소드
   public int empUpdate(EmployeesVo vo) {
      int cnt = 0;
      String sql = "update employees set employee_name = ?, birth_date = ?, phone = ?, email = ?, address = ?, job_name = ?, hire_date = ?, remark = ?, emp_photo = ?, salary = ?, emp_photo_name = ?"
               + " where employee_number = ?";
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, vo.geteName());
         ps.setString(2, sdf.format(vo.getbDate()));
         ps.setString(3, vo.getPhone());
         ps.setString(4, vo.getEmail());
         ps.setString(5, vo.getAddress());
         ps.setString(6, vo.getjName());
         ps.setString(7, sdf.format(vo.gethDate()));
         ps.setString(8, vo.getRemark());
         ps.setString(9, vo.getePhoto());
         ps.setInt(10, vo.getSalary());
         ps.setString(11, vo.getePName());
         ps.setInt(12, vo.geteNum());
         
         conn.setAutoCommit(false);
         cnt = ps.executeUpdate();
         if (cnt > 0) {
            conn.commit();
         } else {
            conn.rollback();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return cnt;
   }
   
   // 직원 정보를 삭제하는 메소드
   public int empDelete(int serial) {
      int cnt = 0;
      String sql = "delete from employees"
               + " where employee_number = ?";
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      
      try {
         ps = conn.prepareStatement(sql);
         ps.setInt(1, serial);
         
         conn.setAutoCommit(false);
         cnt = ps.executeUpdate();
         if (cnt > 0) {
            conn.commit();
         } else {
            conn.rollback();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return cnt;
   }
   
   // 직원등록시 사원번호 중복을 체크하는 메소드
   public boolean eNumCheck(int eNum) { // 값이있으면 true, 없으면 false
      boolean result = false;
      String sql = "select employee_number from employees where employee_number = ?";
      
      try {
         
         ps = conn.prepareStatement(sql);
         ps.setInt(1, eNum);
         
         
         rs = ps.executeQuery();
         result = rs.next();
         
      } catch (SQLException e) {
         
         e.printStackTrace();
      } finally {
         dbClose();
      }
      return result;
   }
   
   //현재 테이블에 나와 있는 사원번호들을 조회하여 list에 저장
}