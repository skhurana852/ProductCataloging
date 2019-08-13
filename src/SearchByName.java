import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
public class SearchByName implements ActionListener {

	JFrame frame;
	JTextField t1;
	JLabel lb;
	JButton bt1,bt;
	javax.swing.JTable jTable1;
    JScrollBar jScrollBar1;
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane2;
    JMenuItem i1,i2,i4;
	public SearchByName()
	{
		frame=new JFrame("SEARCH!");
		frame.setLayout(null);
	       frame.setContentPane(new JLabel(new ImageIcon("E://javapro//background.jpg")));
			frame.setLayout(new FlowLayout());
		t1=new JTextField();
		t1.setBounds(650,260,190,20);
		lb=new JLabel("Enter Name:");
		lb.setBounds(480,260,390,20);
		lb.setForeground(Color.BLACK);
		lb.setFont(new Font("Tahoma",Font.BOLD,22));
		bt1=new JButton("Search");
		bt1.setBounds(490,370,100,40);
		bt1.addActionListener(this);
		frame.add(bt1);
		frame.add(lb);
		frame.add(t1);
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
	        bt=new JButton("Cancel");
			bt.setBounds(730,370,100,40);
			bt.addActionListener(this);
			frame.add(bt);
	        i1.addActionListener(this);
	        i2.addActionListener(this);
	        frame.setJMenuBar(mb);
		frame.setSize(1360,760);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1)
		{
				String str=t1.getText();
				new ResultOfSearchByName(str);
				frame.dispose();
		}
		else if(e.getSource()==i1 || e.getSource()==i2)
		{
			SelectProfile obj=new SelectProfile();
			obj.show();
			frame.dispose();
		}
		else if(e.getSource()==i1 || e.getSource()==i2)
		{
			SelectProfile obj=new SelectProfile();
			obj.show();
			frame.dispose();
		}
		else if(e.getSource()==bt)
		{
			new UserSucess();
			frame.dispose();
		}
	}
	
	public static void main(String args[])
	{
		new SearchByName();
	}
}
