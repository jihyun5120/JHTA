package semishit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinanDao {
   Connection conn;
   PreparedStatement pstmt;
   
   public FinanDao() {
      conn=DBConn.getConn();
   }
   
/*   public List<Integer> select(){
      List<Integer> list = new ArrayList<Integer>();
      int s = 0;
      String query = "select sum(expend), to_char(idate, 'MM') from finance group by idate";
      try {
         pstmt=conn.prepareStatement(query);
         ResultSet set = pstmt.executeQuery();
         while(set.next()) {
            s = set.getInt("sum(expend)");
            list.add(s);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return list;
   }*/
   
   public List<FinanVo> selectP(){
      List<FinanVo> list = new ArrayList<FinanVo>();
      FinanVo vo = null;
      String query = "select sum(profit), to_char(idate, 'yyyy-MM') mon from finance group by to_char(idate, 'yyyy-MM') order by to_char(idate, 'yyyy-MM') ASC";
      try {
         pstmt=conn.prepareStatement(query);
         ResultSet set = pstmt.executeQuery();
         
         while(set.next()) {
            vo = new FinanVo();
            vo.setProfit(set.getInt("sum(profit)"));
            vo.setDat(set.getString("mon"));
            list.add(vo);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return list;
   }
   
   public List<FinanVo> selectE(){
	      List<FinanVo> list = new ArrayList<FinanVo>();
	      FinanVo vo = null;
	      String query = "select sum(expend), to_char(idate, 'yyyy-MM') mon from finance group by to_char(idate, 'yyyy-MM') order by to_char(idate, 'yyyy-MM') ASC";
	      try {
	         pstmt=conn.prepareStatement(query);
	         ResultSet set = pstmt.executeQuery();
	         
	         while(set.next()) {
	            vo = new FinanVo();
	            vo.setExpend(set.getInt("sum(expend)"));
	            vo.setDat(set.getString("mon"));
	            list.add(vo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return list;
	   }
   
   public List<FinanVo> selectPE(){
	      List<FinanVo> list = new ArrayList<FinanVo>();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	      Date date = null;
	      FinanVo vo = null;
	      String query = "select sum(expend), sum(profit), to_char(idate, 'yyyy-MM') mon from finance group by to_char(idate, 'yyyy-MM') order by to_char(idate, 'yyyy-MM') ASC";
	      try {
	         pstmt=conn.prepareStatement(query);
	         ResultSet set = pstmt.executeQuery();
	         
	         while(set.next()) {
	            vo = new FinanVo();
	            date = sdf.parse(set.getString("mon"));
	            vo.setExpend(set.getInt("sum(expend)"));
	            vo.setProfit(set.getInt("sum(profit)"));  
	            vo.setIdate(date);
	            vo.setDat(set.getString("mon"));
	            
	            list.add(vo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return list;
	   }
}