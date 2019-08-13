import java.awt.Font;
import java.awt.*;
import javax.swing.*;
public class Welcome extends JFrame {
JFrame frame;
JLabel lb;
JProgressBar jb;    
int i=0,num=0;     
public Welcome()
{
	frame=new JFrame("Welcome!");
	frame.setContentPane(new JLabel(new ImageIcon("E://javapro//wbg.jpg")));
	frame.setSize(1366,768);
	lb=new JLabel("Loading");
	lb.setBounds(450,450,200,30);
	lb.setFont(new Font("Tahoma",Font.BOLD,16));
	frame.add(lb);
	
	 jb=new JProgressBar(0,2000);    
	    jb.setBounds(550,450,200,30);         
	    jb.setValue(0); 
	    jb.setStringPainted(true);    
	    frame.add(jb);    
	frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void iterate()
{    
    while(i<=2000)
    {    
      jb.setValue(i);    
      i=i+20;    
      try{Thread.sleep(150);}catch(Exception e){}    
    }
}
public void start()
{
	try
	{
	Thread.sleep(1000);
	JOptionPane.showMessageDialog(null, "Welcome!","Welcome", JOptionPane.INFORMATION_MESSAGE);
	}
	catch(Exception e)
	{}
	SelectProfile obj=new SelectProfile();
	obj.show();
	frame.dispose();
}
public static void main(String args[])
{
	Welcome m=new Welcome();
	m.iterate();
	m.start();
}
}
