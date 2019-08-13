import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddUser extends JFrame implements ActionListener{
	 JButton jButton1;
     JButton jButton2;
     JLabel jLabel1;
     JLabel jLabel2;
     JLabel jLabel3;
     JLabel jLabel4;
     JLabel jLabel6;
     JLabel jLabel7;
     JPasswordField jPasswordField1;
     JTextField jTextField1;
     JTextField jTextField2;
     JTextField jTextField3;
     JTextField jTextField4;
     JFrame frame;
     JLabel label1;
     JMenuItem i1,i2,i4;
     Connection con;
     Statement stmt;
    public AddUser()
	{
    	frame=new JFrame("Add User!");
    	  frame.setSize(1366,760);
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
	jLabel1 = new JLabel();
    jLabel2 = new JLabel();
    jTextField1 = new JTextField();
    jLabel3 = new JLabel();
    jPasswordField1 = new JPasswordField();
    jLabel4 = new JLabel();
    jTextField2 = new JTextField();
    jLabel6 = new javax.swing.JLabel();
    jTextField3 = new JTextField();
    jLabel7 = new javax.swing.JLabel();
    jTextField4 = new JTextField();
    jButton1 = new JButton();
    jButton2 = new JButton();
    frame.setLayout(null);
    frame.setContentPane(new JLabel(new ImageIcon("E://javapro//4659.jpg")));
		frame.setLayout(new FlowLayout());
    label1=new JLabel();
    frame.add(label1);
    frame.setSize(1366,760);

    jLabel1.setFont(new Font("Tahoma", Font.BOLD, 35)); // NOI18N
    jLabel1.setText("Add  New User");
    frame.add(jLabel1);
    jLabel1.setBounds(500, 110, 290, 61);

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("Password:");
    frame.add(jLabel2);
    jLabel2.setBounds(504, 265, 106, 23);

    jTextField1.addActionListener(this);
    frame.add(jTextField1);
    jTextField1.setBounds(614, 216, 134, 20);

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel3.setText("User Name:");
    frame.add(jLabel3);
    jLabel3.setBounds(504, 216, 106, 23);

    jPasswordField1.setText("jPasswordField1");
    frame.add(jPasswordField1);
    jPasswordField1.setBounds(614, 268, 130, 23);

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel4.setText("E-mail:");
    frame.add(jLabel4);
    jLabel4.setBounds(504, 316, 106, 22);

    jTextField2.addActionListener(this);
    frame.add(jTextField2);
    jTextField2.setBounds(614, 363, 134, 20);

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel6.setText("O-Id:");
    frame.add(jLabel6);
    jLabel6.setBounds(504, 411, 106, 22);

    jTextField3.addActionListener(this);
    frame.add(jTextField3);
    jTextField3.setBounds(614, 316, 134, 20);

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel7.setText("Phone No. :");
    frame.add(jLabel7);
    jLabel7.setBounds(504, 363, 106, 22);

    jTextField4.addActionListener(this);
    frame.add(jTextField4);
    jTextField4.setBounds(614, 411, 134, 20);

    jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jButton1.setText("Submit");
    jButton1.addActionListener(this);
    frame.add(jButton1);
    jButton1.setBounds(480, 530, 127, 53);
    //menu section
    mb.add(menu);
    mb.add(menu1);
    menu.add(i1);
    
    menu.add(i2);
    menu1.add(i4);
    frame.setJMenuBar(mb);
    i1.addActionListener(this);
    i2.addActionListener(this);
    jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jButton2.setText("Cancel");
    frame.add(jButton2);
    jButton2.setBounds(720, 530, 122, 53);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jButton2.addActionListener(this);
    jButton1.addActionListener(this);
    
}// </editor-fold>                        

    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==jButton2)
    	{
    		new AdminSuccess();
    		frame.dispose();
    	}
    	else if(e.getSource()==i1 || e.getSource()==i2)
		{
			SelectProfile obj=new SelectProfile();
			obj.show();
			frame.dispose();
		}
    	else if(e.getSource()==jButton1)
    	{
    		try {
    		Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
			stmt = con.createStatement();
			String str= jTextField1.getText().toString();
			String str1=jPasswordField1.getPassword().toString();
			String str2=jTextField3.getText().toString();
			String phone= jTextField2.getText().toString();
			String str4=jTextField4.getText().toString();
			try {
				JOptionPane.showMessageDialog(null, "Please Wait..", "Loading..", JOptionPane.INFORMATION_MESSAGE);
				Thread.sleep(1000);
			}
			catch(Exception w)
				{
					System.out.println(w);
				}
			stmt.executeUpdate("insert into user121(name,password,email,phone,oid)values('"+str+"','"+str1+"','"+str2+"','"+phone+"','"+str4+"')");
			JOptionPane.showMessageDialog(null, "User Successfully Added", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
    		catch(Exception ew)
    		{
    			System.out.println(ew);
    		}
    	}
    }
    public static void main(String args[])
	{
	new AddUser();
	}
}
