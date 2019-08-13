import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.lang.String.*;
public class AdminClick extends JFrame
{
	JFrame frame;
	JLabel l3,l2,l1,label1;
	JTextField f1;
	JPasswordField f2;
	JButton b1,b2;
	public AdminClick()
	{
		frame= new JFrame("AdminLogin");
		frame.setSize(1360,760);
		frame.setLayout(null);
	       frame.setContentPane(new JLabel(new ImageIcon("E://javapro//4659.jpg")));
			frame.setLayout(new FlowLayout());
	       label1=new JLabel();
	       frame.add(label1);
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
		 JLabel l3=new JLabel("ADMIN LOGIN");
			l3.setBounds(480,80,420,50);
			l3.setForeground(Color.black);
			l3.setFont(new Font("Monotype Corsiva",Font.BOLD,44));
		 JLabel l1=new JLabel("User Name:");
		l1.setBounds(470,270,120,20);
		l1.setForeground(Color.black);
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		JLabel l2=new JLabel("Password:");
		l2.setBounds(470,320,120,20);
		l2.setForeground(Color.black);
		l2.setFont(new Font("Tahoma",Font.BOLD,20));
		JTextField f1=new JTextField();
		f1.setBounds(630,270,170,20);
		JPasswordField f2=new JPasswordField();
		f2.setBounds(630,320,170,20);
		f2.setToolTipText("Enter Password");
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
		String str=f1.getText();
		String str2=String.valueOf(f2.getPassword());
		if(str.equalsIgnoreCase("h") && str2.equals("h"))
		{ 
		new AdminSuccess();  
		frame.dispose();
	    }
		else {
				JOptionPane.showMessageDialog(null,"User Name and Password is incorrect", "Alert", JOptionPane.WARNING_MESSAGE);
				f1.setText("");
				f2.setText("");
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
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
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
	}
	public static void main(String args[])
	{
		AdminClick obj=new AdminClick(); 
		
	}
	
}
