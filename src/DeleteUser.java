import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class DeleteUser extends JFrame implements ActionListener {
	JButton jButton1;
	    JButton jButton2;
	    JLabel jLabel1;
	    JLabel jLabel2;
	    JTextField jTextField1;
	    JTextField jTextField2;
	    JLabel jlabel1;
	    JFrame frame;
	    JMenuItem i1,i2,i4;
	public DeleteUser()
{
		

		frame=new JFrame("Delete Product");
		frame.setSize(1360, 760);
		//imagesection
		 frame.setLayout(null);
	       frame.setContentPane(new JLabel(new ImageIcon("E://javapro//4659.jpg")));
			frame.setLayout(new FlowLayout());
	       jlabel1=new JLabel();
	       frame.add(jlabel1);
	       //imageend
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        jTextField1.setBounds(670, 234, 245, 28);
        jTextField2.setBounds(670, 282, 245, 28);
        jLabel1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("User Name:");
        jLabel1.setBounds(503, 232, 170, 28);
        jLabel2.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("OID:");
        jLabel2.setBounds(503, 280, 170, 28);
        jTextField2.addActionListener(this);

        jButton1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(this);
        jButton1.setBounds(513, 410, 100, 48);
        jButton2.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setBounds(711, 410, 100, 48);
        jButton2.setText("Cancel");
        frame.add(jButton1);
        frame.add(jButton2);
        frame.add(jLabel1);
        frame.add(jLabel2);
        frame.add(jTextField1);
        frame.add(jTextField2);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        i1.addActionListener(this);
        i2.addActionListener(this);
        frame.setLayout(null);
       frame.setVisible(true);
      
}
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
			String str1=jTextField1.getText();
			String str2=jTextField2.getText();
			DataBase ob=new DataBase();
			ob.delete(str1, str2);
		jTextField1.setText("");
		jTextField2.setText("");
			
		}
	}
	public static void main(String args[])
	{
		new DeleteUser();
	}
}

