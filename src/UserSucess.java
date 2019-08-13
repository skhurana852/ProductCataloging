import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class UserSucess implements ActionListener{
JFrame frame;
	JButton bt1,bt2,bt3,bt4;
	String str1;
	 JMenuItem i1,i2,i4;
     javax.swing.JTable jTable1;
     JScrollBar jScrollBar1;
     JScrollPane jScrollPane1;
     JScrollPane jScrollPane2;
     JLabel lb,jlabel1,lb2,lb3;
	JScrollPane jScrollPane3;
	
	public UserSucess()
	{
	//	Container c= getContentPane();
		frame=new JFrame();
			frame.setLayout(null);
	       frame.getContentPane().setBackground(Color.WHITE);
			frame.setLayout(new FlowLayout());
	       jlabel1=new JLabel();
	       frame.add(jlabel1);
	       JMenuBar mb=new JMenuBar();
	        JMenu menu=new JMenu("Toogle");
	        JMenu menu1=new JMenu("Help");
	         i1=new JMenuItem("Login page");
	         i2=new JMenuItem("Home");
	         i4=new JMenuItem("Visit http://www.aeskay.com");
	        mb.add(menu);
	        mb.add(menu1);
	        menu.add(i1);
	        menu.add(i2);
	        menu1.add(i4);
	        frame.setJMenuBar(mb);
		lb=new JLabel("WELCOME USER");
		lb.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		lb.setBounds(500,20,300,40);
		lb2=new JLabel("Search BY:");
		lb2.setFont(new Font("Tahoma",Font.BOLD,20));
		lb2.setBounds(130,120,300,40);
		bt1=new JButton("Name");
		bt1.setBounds(330,120,100,40);
		bt2=new JButton("Catalog Id");
		bt2.setBounds(590,120,100,40);
		bt3=new JButton("Brand");
		bt3.setBounds(850,120,100,40);
		bt4=new JButton("Cancel");
		bt4.setBounds(1100,120,100,40);
		lb3=new JLabel("Products Timeline");
		lb3.setFont(new Font("Tahoma",Font.BOLD,20));
		lb3.setBounds(500,200,300,40);
		frame.setSize(1360,730);
		frame.add(lb2);
		frame.add(bt1);
		frame.add(bt2);
		frame.add(bt3);
		frame.add(lb3);
		frame.add(bt4);
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       bt3.addActionListener(this);
       bt4.addActionListener(this);
        frame.add(lb);
        
        

        try {
			  Class.forName("oracle.jdbc.OracleDriver");
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
		      Statement stmt=con.createStatement();
		     String str="select * from product";
		      ResultSet rs=stmt.executeQuery(str);
		      String[] ColumnNames={"NAME","CATALOG_ID","BRAND","COUNTER_NO","QUANTITY","PRICE","IMAGE"};
		  DefaultTableModel model=new DefaultTableModel(ColumnNames,0);
		  JTable table=new JTable(model);
		  jScrollPane1 = new javax.swing.JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 
			
		  
		  while(rs.next())
		  {

				Vector row=new Vector();
				String name=rs.getString("name");
				String catid=rs.getString("catalogid");
				String brand=rs.getString("brand");
				//String img=rs.getString("imagepath");
				String counter=rs.getString("counter");
				String qty=rs.getString("qty");
				String price=rs.getString("column_price");
				String Image=rs.getString("imagepath");
				row.add(name);
				row.add(catid);
				row.add(brand);
				row.add(counter);
				
				//row.add(img);
				row.add(qty);
				row.add(price);
				row.add(lb);
				model.addRow(row);
		  }
		  Border border = BorderFactory.createLineBorder(Color.blue);
		  table.getTableHeader().setBackground(Color.blue);
		  table.getTableHeader().setForeground(Color.white);
		  table.setBorder(border);
		table.setRowHeight(60); 
		 //table.setBounds(200,100,900,960);
		 jScrollPane2=new JScrollPane();
		 jScrollPane2.setViewportView(jScrollPane1);
		 jScrollPane1.setAutoscrolls(true);
	     	      frame.add(jScrollPane1);
	        jScrollPane1.setBounds(50, 260, 1250, 400);
	       ImageIcon ic=new ImageIcon("Desert.jpg");
	       JLabel lb= new JLabel(ic);
	       //lb.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	       lb.setBounds(1100, 120, 400, 400);
	        frame.add(lb);
		 stmt.close();
		  rs.close();
		  
        }
        catch(Exception we)
		  {
			  System.out.println(we);
		  }
        i1.addActionListener(this);
        i2.addActionListener(this);
		frame.setLayout(null);
		frame.setVisible(true);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt4)
		{
			SelectProfile ob=new SelectProfile();
			ob.show();
			frame.dispose();
		}
		else if(ae.getSource()==bt1)
		{
			new SearchByName();
			frame.dispose();
		}
		else if(ae.getSource()==bt2)
		{
			new SearchByCatalog();
			frame.dispose();
		}
		else if(ae.getSource()==bt3)
		{
			new SearchByBrand();
			frame.dispose();
		}
		else if(ae.getSource()==i1 || ae.getSource()==i2)
			{
				SelectProfile obj=new SelectProfile();
				obj.show();
				frame.dispose();
			}
	}
public static void main(String args[])
{
	new UserSucess();
}
}
