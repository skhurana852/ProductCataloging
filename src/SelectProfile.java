import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SelectProfile extends JFrame implements ActionListener
{
	public JLabel jlabel,jlabel1;
	 JButton bt1,bt2;
	 JFrame jframe;
	 JMenuItem i1,i2,i4;
	public void show()
    {
		  
        jframe=new JFrame("Welcome");
     JLabel jlabel=new JLabel("Please Select Your Profile");
        jlabel.setBounds(490,250,430,30);
        jlabel.setFont(new Font("Palatino Linotype",Font.BOLD,33));
        //menu section
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
        jframe.setJMenuBar(mb);
        //menuend
        //image section
     jframe.setLayout(null);
       jframe.setContentPane(new JLabel(new ImageIcon("E://javapro//4659.jpg")));
		jframe.setLayout(new FlowLayout());
       jlabel1=new JLabel();
       jframe.add(jlabel1);
       //image section end
        //jframe.setContentPane(new JLabel(new ImageIcon("bg.jpg")));
       // jframe.setSize(1350,750);
        bt1=new JButton("ADMIN");
        bt2=new JButton("USER");
        bt1.setBounds(620,320,120,50);
        bt2.setBounds(620,420,120,50);
        jframe.setSize(1360,760);
        jframe.add(bt1);
        jframe.add(bt2);
        jframe.add(jlabel);
        jlabel.setForeground(Color.black);
        i1.addActionListener(this);
        i2.addActionListener(this);
        //  jframe.add(label1);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bt1)
		{
		new AdminClick();
		jframe.dispose();
		}
		else if(e.getSource()==bt2)
		{
			new UserClick();
			jframe.dispose();
		}
		else if(e.getSource()==i1 || e.getSource()==i2)
		{
			SelectProfile obj=new SelectProfile();
			obj.show();
			jframe.dispose();
		}
	}
    public static void main(String args[])
    {
        
        SelectProfile ob=new SelectProfile();
        ob.show();  
    
    }
}