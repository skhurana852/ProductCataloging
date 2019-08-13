import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class form implements ActionListener{
	JLabel l1,l2,l3,l4,lb;
	JTextField tf1,tf3,tf4;
	JPasswordField tf2;
	JButton b1,b2,b3,b4;
public	form ()
	{
		JFrame frame=new JFrame();
		frame.setSize(300,500);
		lb=new JLabel("Java Form");
		lb.setBounds(80,30,150,30);
		lb.setFont(new Font("Tahoma",Font.BOLD,24));
		frame.add(lb);
		l1=new JLabel("Name");
		l1.setBounds(20,100,100,25);
		l1.setForeground(Color.black);
		l1.setFont(new Font("Tahoma",Font.BOLD,13));
		frame.add(l1);
		l2=new JLabel("Password");
		l2.setBounds(20,140,100,25);
		l2.setForeground(Color.black);
		l2.setFont(new Font("Tahoma",Font.BOLD,13));
		frame.add(l2);
		l3=new JLabel("E-mail");
		l3.setBounds(20,180,100,25);
		l3.setForeground(Color.black);
		l3.setFont(new Font("Tahoma",Font.BOLD,13));
		frame.add(l3);
		l4=new JLabel("ID");
		l4.setBounds(20,220,120,20);
		l4.setForeground(Color.black);
		l4.setFont(new Font("Tahoma",Font.BOLD,13));
		frame.add(l4);
		tf1=new JTextField();
		tf1.setBounds(90,100,120,20);
		frame.add(tf1);
		tf2=new JPasswordField();
		tf2.setBounds(90,140,120,20);
		frame.add(tf2);
		tf3=new JTextField();
		tf3.setBounds(90,180,120,20);
		frame.add(tf3);
		tf4=new JTextField();
		tf4.setBounds(90,220,120,20);
		frame.add(tf4);
		b1=new JButton("Insert");
		b1.setBounds(20,300,100,40);
		frame.add(b1);
		b2=new JButton("Delete");
		b2.setBounds(150,300,100,40);
		frame.add(b2);
		b3=new JButton("Update");
		b3.setBounds(20,350,100,40);
		frame.add(b3);
		b4=new JButton("View");
		b4.setBounds(150,350,100,40);
		frame.add(b4);
		frame.setLayout(null);
		frame.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	String str=tf1.getText();
	String str1=tf2.getPassword().toString();
	String str2=tf3.getText().toString();
	String str3=tf4.getText().toString();
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
	Statement stmt=con.createStatement();
	//stmt.executeUpdate("insert into UserDetails VALUES(saransh,1213,str2,str3)");
	stmt.executeUpdate("insert into testform VALUES(str,String.valueOf(str1),String.valueOf(str2),String.valueOf(str3))");  
	System.out.println("Data inserted");
	}
	catch(Exception w)
	{
		System.out.println(w);
	}
	}
	if(e.getSource()==b2)
	{
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
	Statement stmt=con.createStatement();
	stmt.executeUpdate("Delete from UserDetails where name='saransh'");  
	System.out.println("Data inserted");
	}
	catch(Exception w)
	{
		System.out.println(w);
	}
	}
}
public static void main(String args[])
	{
		form ob=new form();
	}
	
}
