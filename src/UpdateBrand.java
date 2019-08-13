
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class UpdateBrand implements ActionListener{
	JFrame frame;
	JTextField tf,tf1;
	JLabel lb,lb1;
	JButton bt,bt1;
	public UpdateBrand()
	{
		frame=new JFrame("Update!");
		frame.getContentPane().setBackground(Color.white);
		lb=new JLabel("Previous Brand:");
		lb.setBounds(200,150,200,20);
		lb.setFont(new Font("Tahoma",Font.BOLD,18));
		tf=new JTextField();
		tf.setBounds(400,150,130,20);
		frame.add(lb);
		frame.add(tf);
		lb1=new JLabel("New Brand:");
		lb1.setBounds(200,300,200,20);
		lb1.setFont(new Font("Tahoma",Font.BOLD,18));
		tf1=new JTextField();
		tf1.setBounds(400,300,130,20);
		bt=new JButton("Update");
		bt.setBounds(300,400,100,40);
		bt.addActionListener(this);
		frame.add(bt);
		frame.add(lb1);
		frame.add(tf1);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(700, 678);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bt)
		{
			try
			{
				Class.forName("oracle.jdbc.OracleDriver");
				  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
			      Statement stmt=con.createStatement();
			      String j=tf1.getText();
			      String k=tf.getText();
			      String str="select*from product where brand='"+k+"'";
			      ResultSet rs=stmt.executeQuery(str);
			      if(rs.next())
			      {
			      stmt.executeUpdate("update product set brand='"+j+"' where brand='"+k+"'");
			    	  JOptionPane.showMessageDialog(null, "Product Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null, "Product Not Found", "Error", JOptionPane.WARNING_MESSAGE); 
			      }
			      }
			catch(Exception ae)
			{
				
			}
		}
	}
	
	public static void main(String args[])
	{
		new UpdateBrand();
	}
}
