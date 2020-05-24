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

   // db���� ������
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

   // db���� ������
   public void dbClose() {
      if (rs != null) try {rs.close();} catch (Exception e1) {}
      if (ps != null) try {ps.close();} catch (Exception e2) {}
      if (conn != null) try {conn.close();} catch (Exception e3) {}
      
   }

   //  ���̺� ����� ���� ���� �˻�
   public DefaultTableModel tableGetSelect(DefaultTableModel model) {
      String sql = "select employee_number \"�����ȣ\", employee_name \"����\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"�������\", phone \"����ó\", job_name \"��å\" from employees"
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
   
   // ���̺� ���� �޼ҵ�
   public DefaultTableModel newTableGetSelect() {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"�����ȣ\", employee_name \"����\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"�������\", phone \"����ó\", job_name \"��å\" from employees"
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
   
   // ��ü ��ȸ
   public DefaultTableModel allGetSelect(String all) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"�����ȣ\", employee_name \"����\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"�������\", phone \"����ó\", job_name \"��å\" from employees"
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

   // �����ȣ ��ȸ
   public DefaultTableModel eNumGetSelect(String eNum) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"�����ȣ\", employee_name \"����\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"�������\", phone \"����ó\", job_name \"��å\" from employees"
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
   
   // ���� ��ȸ
   public DefaultTableModel eNameGetSelect(String eName) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"�����ȣ\", employee_name \"����\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"�������\", phone \"����ó\", job_name \"��å\" from employees"
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
   
   // ��å ��ȸ
   public DefaultTableModel jNameGetSelect(String jName) {
      DefaultTableModel model = new DefaultTableModel();
      String sql = "select employee_number \"�����ȣ\", employee_name \"����\", TO_CHAR(birth_date, 'YYYY-MM-DD') \"�������\", phone \"����ó\", job_name \"��å\" from employees"
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
   
   // ȭ�鿡�� row�� ���ý� �����ȣ�� �Է¹޾� ��ȸ�ϴ� ������
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

   // ������ ����ϴ� �޼ҵ�
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
   
   // ���� ������ �����ϴ� �޼ҵ�
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
   
   // ���� ������ �����ϴ� �޼ҵ�
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
   
   // ������Ͻ� �����ȣ �ߺ��� üũ�ϴ� �޼ҵ�
   public boolean eNumCheck(int eNum) { // ���������� true, ������ false
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
   
   //���� ���̺� ���� �ִ� �����ȣ���� ��ȸ�Ͽ� list�� ����
}