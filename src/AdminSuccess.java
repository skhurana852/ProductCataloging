import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminSuccess implements ActionListener{
	JFrame frame;
	JLabel l3,l2,l1,label1;
	JTextField f1;
	JPasswordField f2;
	JButton b1,b2,b3,b4,b5,b6;
	JMenuItem i1,i2,i4;
	javax.swing.JScrollPane jScrollPane1;
	javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable jTable1;
	public AdminSuccess()
	{
		frame= new JFrame("WelcomAdmin!");
		frame.setSize(1360,760);
		frame.setLayout(null);
	       frame.setContentPane(new JLabel(new ImageIcon("E://javapro//4659.jpg")));
			frame.setLayout(new FlowLayout());
			//menu section
	        JMenuBar mb=new JMenuBar();
	        JMenu menu=new JMenu("Toogle");
	        JMenu menu1=new JMenu("Help");
	        JMenuItem i1=new JMenuItem("Login page");
	        JMenuItem i2=new JMenuItem("Home");
	        JMenuItem i4=new JMenuItem("Visit http://www.aeskay.com");
	        mb.add(menu);
	        mb.add(menu1);
	        i1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent ae)
	        	{
	        		SelectProfile obj=new SelectProfile();
	        		obj.show();
	        		frame.dispose();
	        	}
	});
	        i2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent ae)
	        	{
	        		SelectProfile obj=new SelectProfile();
	        		obj.show();
	        		frame.dispose();
	        	}
	});

	        menu.add(i1);
	        menu.add(i2);
	        menu1.add(i4);
	        frame.setJMenuBar(mb);
	        //menuend
	       label1=new JLabel();
	       frame.add(label1);
	       l1=new JLabel("WELCOME   ADMIN");
	       l1.setBounds(390,110,530,50);
		   l1.setForeground(Color.black);
		   l1.setFont(new Font("Monotype Corsiva",Font.BOLD,54));
		   b1=new JButton("Add User");
		   b1.setBounds(400,270,150,60);
		   b2=new JButton("Delete User");
		   b2.setBounds(720,270,150,60);
		   frame.add(b1);
		   b3=new JButton("Add Product");
		   b3.setBounds(400,370,150,60);
		   b4=new JButton("Delete Product");
		   b4.setBounds(720,370,150,60);
		   b5=new JButton("View Products");
		   b5.setBounds(400,470,150,60);
		   frame.add(b5);
		   b6=new JButton("Update Products");
		   b6.setBounds(720,470,150,60);
		   frame.add(b6);
		   frame.add(b4);
		   frame.add(b3);
		   frame.add(b1);
		   frame.add(b2);
		   frame.add(l1);
		   b1.addActionListener(this);
		   b3.addActionListener(this);
		   b4.addActionListener(this);
		   b2.addActionListener(this);
		   b5.addActionListener(this);
		   b6.addActionListener(this);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setLayout(null);
		   frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new AddUser();
			frame.dispose();
		}
		
		else if(e.getSource()==b3)
		{
			new AddProduct();
			frame.dispose();
		}
		else if(e.getSource()==b4)
		{
			new DeleteProduct();
			frame.dispose();
		}
		else if(e.getSource()==b2)
		{
			new DeleteUser();
			frame.dispose();
		}
		else if(e.getSource()==b5)
		{
			 new ViewProduct();
			 frame.dispose();
		}
		else if(e.getSource()==b6)
		{
			new UpdateProduct();
			frame.dispose();
		}
	}
	public static void main(String args[])
	{
		new AdminSuccess();
	}
}
