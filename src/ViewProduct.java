import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class ViewProduct implements ActionListener {
	JFrame frame;
	
	String str1;
	 JMenuItem i1,i2,i4;
     javax.swing.JTable jTable1;
     JScrollBar jScrollBar1;
     JScrollPane jScrollPane1;
     JScrollPane jScrollPane2;
     JLabel lb,jlabel1;
     JButton btb;
     JCheckBox cb;
	public 	ViewProduct()
	{
		frame=new JFrame();
		lb=new JLabel("Products Available");
		lb.setFont(new Font("Tahoma",Font.BOLD,20));
		lb.setBounds(500,20,300,40);
		btb=new JButton("Back");
		btb.setBounds(50,100,100,40);
		frame.setLayout(null);
	       frame.setContentPane(new JLabel(new ImageIcon("E://javapro//backg.JPEG")));
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
	        frame.add(btb);
		frame.setSize(1360,760);
        jScrollBar1 = new javax.swing.JScrollBar();
        frame.add(lb);
        

        try {
			  Class.forName("oracle.jdbc.OracleDriver");
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
		      Statement stmt=con.createStatement();
		     String str="select * from product";
		      ResultSet rs=stmt.executeQuery(str);
		      String[] ColumnNames={"NAME","CATALOG_ID","BRAND","COUNTER_NO","QUANTITY","PRICE","SELECT"};
		  DefaultTableModel model=new DefaultTableModel(ColumnNames,0);
		  JTable table=new JTable(model);
		  jScrollPane1 = new javax.swing.JScrollPane(table);
		 
			
		  
		  while(rs.next())
		  {

				Vector row=new Vector();
				String name=rs.getString("name");
				String catid=rs.getString("catalogid");
				String brand=rs.getString("brand");
				String counter=rs.getString("counter");
				String qty=rs.getString("qty");
				String price=rs.getString("column_price");
				row.add(name);
				row.add(catid);
				row.add(brand);
				row.add(counter);
				row.add(qty);
				row.add(price);
				cb=new JCheckBox(name,false);
				row.add(cb);
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
		 jScrollBar1.setBounds(985, 27, 17, 281);
		 jScrollPane1.setAutoscrolls(true);
	     	      frame.add(jScrollPane1);
	        jScrollPane1.setBounds(220, 76, 850, 600);
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
        btb.addActionListener(this);
		frame.setLayout(null);
		frame.setVisible(true);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		 if(e.getSource()==i1 || e.getSource()==i2)
		{
			SelectProfile obj=new SelectProfile();
			obj.show();
			frame.dispose();
		}
		 else if(e.getSource()==btb)
		 {
			 new AdminSuccess();
			 frame.dispose();
		 }
	}
	public static void main(String args[])
	{
		new ViewProduct();
	}
}
