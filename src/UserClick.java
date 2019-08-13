import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class UserClick
{
	JFrame frame;
	JLabel l3,l2,l1,label1;
	JTextField f1;
	JTextField f2;
	JButton b1,b2;
	JMenuItem i1,i2,i4;
	public UserClick()
	{
		frame= new JFrame("UserLogin");
		frame.setSize(1360,760);
		frame.setLayout(null);
		//menu section
        JMenuBar mb=new JMenuBar();
        JMenu menu=new JMenu("Toogle");
        JMenu menu1=new JMenu("Help");
        JMenuItem i1=new JMenuItem("Login page");
        JMenuItem i2=new JMenuItem("Home");
        JMenuItem i4=new JMenuItem("Visit http://www.aeskay.com");
        mb.add(menu);
        mb.add(menu1);
        menu.add(i1);
        menu.add(i2);
        menu1.add(i4);
        frame.setJMenuBar(mb);
        //menuend
	       frame.setContentPane(new JLabel(new ImageIcon("E://javapro//background.jpg")));
			frame.setLayout(new FlowLayout());
	       label1=new JLabel();
	       frame.add(label1);
	
		 JLabel l3=new JLabel("USER LOGIN");
			l3.setBounds(480,80,420,50);
			l3.setForeground(Color.black);
			l3.setFont(new Font("Monotype Corsiva",Font.BOLD,44));
		 JLabel l1=new JLabel("User Name:");
		l1.setBounds(470,270,120,20);
		l1.setForeground(Color.black);
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		JLabel l2=new JLabel("OID:");
		l2.setBounds(470,320,120,20);
		l2.setForeground(Color.black);
		l2.setFont(new Font("Tahoma",Font.BOLD,20));
		JTextField f1=new JTextField();
		f1.setBounds(630,270,170,20);
		JTextField f2=new JTextField();
		f2.setBounds(630,320,170,20);
		JButton b1=new JButton("Login");
		b1.setBounds(480,470,100,40);
		JButton b2=new JButton("Cancel");
		b2.setBounds(690,470,100,40);
	// adding all the components
		frame.add(b1);
		frame.add(b2);
		frame.add(f1);
		frame.add(f2);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		b1.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent ae)
		{
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
		Statement stmt=con.createStatement();
		String sqlstr= "select * from user121 where name='"+f1.getText()+"' and oid ='"+f2.getText().toString()+"'";
		ResultSet rs= stmt.executeQuery(sqlstr);
		
			if(rs.next())
			{
				
			new UserSucess();
			frame.dispose();
			}
		else
		{
			JOptionPane.showMessageDialog(null, "DID NOT MATCH", "Error", JOptionPane.WARNING_MESSAGE);
		}
			}
		catch(Exception e)
		{
			System.out.println(ae);
		}
		
	
		}
	});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SelectProfile ob=new SelectProfile();
				ob.show();
				frame.dispose();
			}
		});
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SelectProfile obj=new SelectProfile();
				obj.show();
				frame.dispose();
			}
		});
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SelectProfile obj=new SelectProfile();
				obj.show();
				frame.dispose();
			}
		});
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		UserClick obj=new UserClick(); 
		
	}
	
}
