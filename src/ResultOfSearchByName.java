import java.awt.Color;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
public class ResultOfSearchByName implements ActionListener {
	JScrollPane jScrollPane1,jScrollPane2;
	JFrame frame;
	JButton bt,bt1;
	JMenuItem i1,i2,i4;
	public ResultOfSearchByName(String s)
{
		frame=new JFrame();
		JMenuBar mb=new JMenuBar();
        JMenu menu=new JMenu("Toogle");
        JMenu menu1=new JMenu("Help");
        frame.getContentPane().setBackground(Color.WHITE);
         i1=new JMenuItem("Login page");
         i2=new JMenuItem("Home");
         i4=new JMenuItem("Visit http://www.aeskay.com");
        mb.add(menu);
        mb.add(menu1);
        menu.add(i1);
        menu.add(i2);
        menu1.add(i4);
        frame.setJMenuBar(mb);
        i1.addActionListener(this);
        i2.addActionListener(this);
		bt=new JButton("Done");
		bt.setBounds(390,470,100,40);
		frame.add(bt);
		bt1=new JButton("Cancel");
		bt1.setBounds(790,470,100,40);
		bt.addActionListener(this);
		bt1.addActionListener(this);
		frame.add(bt1);
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
      jScrollPane1.setBounds(220, 116, 850, 300);
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
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bt)
		{
			new UserSucess();
			frame.dispose();
		}
		else if(e.getSource()==bt1)
		{
			new SearchByName();
			frame.dispose();
		}
		else if(e.getSource()==i1 || e.getSource()==i2)
		{
			SelectProfile obj=new SelectProfile();
			obj.show();
			frame.dispose();
		}
	}
public static void main(String args[])
{
	new ResultOfSearchByName("Kurkure");
}
}
