package company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ProductDao {
   Connection conn;
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
   PreparedStatement ps;
   
   public ProductDao() {
      conn = DBConn.getConn();
   }
   
   public int insert(ProductVo vo) {
      int r = 0;
      
      try {//비품관리
         String sql = "insert into Product values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
         ps = conn.prepareStatement(sql);
         ps.setString(1, vo.getImPath());
         ps.setString(2, vo.getImName());
         ps.setString(3, vo.getpId());
         ps.setString(4, vo.getpName());
         ps.setInt(5, vo.getEa());
         ps.setString(6, sdf.format(vo.getiDate()));
         ps.setInt(7, vo.getPrice());
         ps.setString(8, vo.getNote());
         ps.setInt(9, vo.getTotPrice());
         r = ps.executeUpdate();
         
         //재무관리
         String pId = vo.getpId();
         sql = "insert into finance (expend, iDate) select totprice, iDate from product where pId=?"; 
         ps = conn.prepareStatement(sql);
         ps.setString(1, pId);
         r = ps.executeUpdate();
         
         if(r>0) {
            conn.commit();
         } else {
            conn.rollback();
         }
      }catch(Exception ex) {
         ex.printStackTrace();
      }finally {
         try {
            ps.close();
            conn.close();
            
         } catch (SQLException e) {
            e.printStackTrace();
         }
         return r;         
      }
      
   }
   
   public ProductVo im(String pId) {
      ProductVo vo = new ProductVo();
      String sql = "select imName, imPath from product where pId=?";
          try {
             ps = conn.prepareStatement(sql);
             ps.setString(1, pId);
             ResultSet rs = ps.executeQuery();
             while(rs.next()) {
                vo.setImName(rs.getString(1));
                vo.setImPath(rs.getString(2));
             }
             rs.close();
             ps.close();
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
      }
         return vo;
   }
   
   
   public DefaultTableModel list(){
       String sql = "select pId 비품코드, pName 비품명, ea 수량, Ltrim(to_char(price, 'L99,999,999')) 단가, Ltrim(to_char(totPrice, 'L99,999,999')) 총금액, to_char(iDate, 'rrrr.MM.dd') 구매날짜, note 특이사항 from product";
       DefaultTableModel model = new DefaultTableModel();
       try {
          ps = conn.prepareStatement(sql);
          ResultSetMetaData meta = ps.getMetaData();
          int cnt = meta.getColumnCount();
             for(int i=1; i<=cnt; i++) {
                model.addColumn(meta.getColumnName(i));             
             }
          
          ResultSet rs = ps.executeQuery();
          while(rs.next()) {
             Vector list = new Vector();
             for(int i=1; i<=cnt; i++) {
                list.add(rs.getString(i));                  
             }
             model.addRow(list);
          }
          rs.close();
          ps.close();
          conn.close();
       } catch (SQLException e) {
          e.printStackTrace();
       }finally {
          return model;            
       }
 }
   
   public DefaultTableModel select(int index, String find){
      DefaultTableModel model = new DefaultTableModel();
      String sql = null;
       try {
          switch(index) {
          case 0 :
             sql = "select pId 비품코드, pName 비품명, ea 수량, Ltrim(to_char(price, 'L99,999,999')) 단가, Ltrim(to_char(totPrice, 'L99,999,999')) 총금액, to_char(iDate, 'rrrr.MM.dd') 구매날짜, note 특이사항 from product"
                   + " where pId like ? or  pName like ? or iDate like ?";
             ps = conn.prepareStatement(sql);
             ps.setString(1, "%" + find + "%");
             ps.setString(2, "%" + find + "%");
             ps.setString(3, "%" + find + "%");
             break;
          case 1 : 
             sql = "select pId 비품코드, pName 비품명, ea 수량, Ltrim(to_char(price, 'L99,999,999')) 단가, Ltrim(to_char(totPrice, 'L99,999,999')) 총금액, to_char(iDate, 'rrrr.MM.dd') 구매날짜, note 특이사항 from product where pId like ?";
             ps = conn.prepareStatement(sql);
             ps.setString(1, "%" + find + "%");
             break;
          case 2 : 
             sql = "select pId 비품코드, pName 비품명, ea 수량, Ltrim(to_char(price, 'L99,999,999')) 단가, Ltrim(to_char(totPrice, 'L99,999,999')) 총금액, to_char(iDate, 'rrrr.MM.dd') 구매날짜, note 특이사항 from product where pName like ?";
             ps = conn.prepareStatement(sql);
             ps.setString(1, "%" + find + "%");
             break; 
          case 3 :
             sql = "select pId 비품코드, pName 비품명, ea 수량, Ltrim(to_char(price, 'L99,999,999')) 단가, Ltrim(to_char(totPrice, 'L99,999,999')) 총금액, to_char(iDate, 'rrrr.MM.dd') 구매날짜, note 특이사항 from product where iDate like ?";
             ps = conn.prepareStatement(sql); 
             ps.setString(1, "%" + find + "%");
             break;
          }
          
          ResultSetMetaData meta = ps.getMetaData();
          int cnt = meta.getColumnCount();
             for(int i=1; i<=cnt; i++) {
                model.addColumn(meta.getColumnName(i));                  
             }
          
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()) {
             Vector list = new Vector();
             
             for(int i=1; i<=cnt; i++) {
                list.add(rs.getString(i));                  
             }
             model.addRow(list);
          }
          rs.close();
          ps.close();
          conn.close();
       } catch (SQLException e) {
          e.printStackTrace();
       }finally {
          return model;            
       }
 }
   
   public int update(ProductVo vo) {
      int r = 0;
      try {
    		  String sql = "update product set imName=?, imPath=?, pName=?, ea=?, iDate=?, price=?, note=?, totPrice=? where pId=?";
    		  ps = conn.prepareStatement(sql);
    		  ps.setString(1, vo.getImName());  		   
    		  ps.setString(2, vo.getImPath());
    		  ps.setString(3, vo.getpName());
    		  ps.setInt(4, vo.getEa());
    		  ps.setString(5, sdf.format(vo.getiDate()));
    		  ps.setInt(6, vo.getPrice());
    		  ps.setString(7, vo.getNote());
    		  ps.setInt(8, vo.totPrice);
    		  ps.setString(9, vo.getpId()); 
    	  
         conn.setAutoCommit(false); 
         r = ps.executeUpdate();
         
         if(r>0){
            conn.commit();
         }else {
            conn.rollback();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            ps.close();
            conn.close();
         }catch(Exception ex){
            ex.printStackTrace();
         }
         return r;
      }
   }
   
   public int delete(String pId) {
      int r = 0;
      
      String sql = "delete from product where pId=?";
      try{
         ps = conn.prepareStatement(sql);
         ps.setString(1, pId);
         
         conn.setAutoCommit(false);
         
         r = ps.executeUpdate();
         if(r>0) {
            conn.commit();
         } else {
            conn.rollback();
         }
         ps.close();
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         return r;      
      } 
   }
}