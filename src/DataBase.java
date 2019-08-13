import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
public class DataBase {
 
  public void delete(String x, String y)
  {
	  
	  try
	  {
		  Class.forName("oracle.jdbc.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
	      Statement stmt=con.createStatement();
	  
	  String strquery="delete from user121 where name='"+x+"' and oid='"+y+"'";
	  ResultSet rs= stmt.executeQuery(strquery);
	  if(rs.next())
	  {
		  JOptionPane.showMessageDialog(null, "User Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
	       
	   }
	  }
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "User Not Found", "Error", JOptionPane.WARNING_MESSAGE);
			}
  }
  public void addProd(String str1, String str2,String str3,String str4,String str5,String str6,String str7)
  {
	 
}
  public void deleteprod(String x, String y)
  {
	  
	  try
	  {
		  Class.forName("oracle.jdbc.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
	      Statement stmt=con.createStatement();
	  
	  String strquery="delete from product where name='"+x+"' and catalogid='"+y+"'";
	  ResultSet rs= stmt.executeQuery(strquery);
	  if(rs.next())
	  {
		  JOptionPane.showMessageDialog(null, "Product Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
	       
	   }
	  }
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Product Not Found", "Error", JOptionPane.WARNING_MESSAGE);
			}
  }
  public void show()
  {
	 
  }
}