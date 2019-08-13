import java.awt.Color;
import java.sql.*;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class testsql {
	JScrollPane jScrollPane1,jScrollPane2;
	JFrame frame;
	public testsql(String s)
{
		frame=new JFrame();
	try
	{
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
	Statement stmt=con.createStatement();
	String str="select*from product where name='"+s+"'";
	ResultSet rs=stmt.executeQuery(str);
	   String[] ColumnNames={"NAME","CATALOG_ID","BRAND","COUNTER_NO","QUANTITY","PRICE","IMAGE"};
		  DefaultTableModel model=new DefaultTableModel(ColumnNames,0);
		  JTable table=new JTable(model);
		  jScrollPane1 = new javax.swing.JScrollPane(table);
	while(rs.next())
	{
		Vector row=new Vector();
		String a=rs.getString("name");
		String b=rs.getString("catalogid");
		String c=rs.getString("brand");
		String d=rs.getString("counter");
		String e=rs.getString("qty");
		String f=rs.getString("column_price");
		row.add(a);
		row.add(b);
		row.add(c);
		row.add(d);
		//row.add(img);
		row.add(e);
		row.add(f);
		model.addRow(row);
	System.out.println(a+b+c+d+e+f);
	}
	
	  Border border = BorderFactory.createLineBorder(Color.blue);
	table.getTableHeader().setBackground(Color.blue);
	  table.getTableHeader().setForeground(Color.white);
	  table.setBorder(border);
	table.setRowHeight(60); 
	 table.setBounds(200,100,900,960);
	 jScrollPane2=new JScrollPane();
	 jScrollPane2.setViewportView(jScrollPane1);
	 //jScrollBar1.setBounds(985, 27, 17, 281);
	 jScrollPane1.setAutoscrolls(true);
   	      frame.add(jScrollPane1);
      jScrollPane1.setBounds(220, 96, 850, 600);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	frame.setSize(1366,760);
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
	new testsql("Kurkure");
}
}
