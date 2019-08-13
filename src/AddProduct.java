import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class AddProduct extends JFrame implements ActionListener{
	 JButton jButton1;
     JButton jButton2;
     JLabel jLabel1;
     JLabel jLabel2;
     JLabel jLabel3;
     JLabel jLabel4;
     JLabel jLabel6;
     JLabel jLabel7;
     JLabel jLabel8;
     JLabel jLabel9;
     JTextField jTextField5;
     JTextField jTextField1;
     JTextField jTextField2;
     JTextField jTextField3;
     JTextField jTextField4;
     JTextField jTextField8;
     JFrame frame;
     JLabel label1;
     JButton BrButton;
     JLabel lbimg;
     JSpinner jSpinner1;
     JMenuItem i1,i2,i4;
    public AddProduct()
	{
    	frame=new JFrame("Add User!");
    	  frame.setSize(1366,760);
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
	jLabel1 = new JLabel();
    jLabel2 = new JLabel();
    jTextField1 = new JTextField();
    jLabel3 = new JLabel();
    jTextField5 = new JTextField();
    jLabel4 = new JLabel();
    jTextField2 = new JTextField();
    jLabel6 = new javax.swing.JLabel();
    jTextField3 = new JTextField();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jTextField4 = new JTextField();
    jTextField8 = new JTextField();
    jButton1 = new JButton();
    jButton2 = new JButton();
    frame.setLayout(null);
    frame.setContentPane(new JLabel(new ImageIcon("E://javapro//4659.jpg")));
		frame.setLayout(new FlowLayout());
    label1=new JLabel();
    frame.add(label1);
    frame.setSize(1366,760);

    jLabel1.setFont(new Font("Tahoma", Font.BOLD, 35)); // NOI18N
    jLabel1.setText("Add  New Product");
    frame.add(jLabel1);
    jLabel1.setBounds(505, 130, 320, 61);

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel2.setText("Catalog ID:");
    frame.add(jLabel2);
    jLabel2.setBounds(504, 265, 106, 23);

    jTextField1.addActionListener(this);
    frame.add(jTextField1);
    jTextField1.setBounds(614, 216, 134, 20);

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel3.setText("Product Name:");
    frame.add(jLabel3);
    jLabel3.setBounds(480, 216, 146, 23);

    frame.add(jTextField5);
    jTextField5.setBounds(614, 268, 130, 23);

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel4.setText("Brand:");
    frame.add(jLabel4);
    jLabel4.setBounds(504, 316, 106, 22);

    jTextField2.addActionListener(this);
    frame.add(jTextField2);
    jTextField2.setBounds(614, 363, 134, 20);

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel6.setText("Image:");
    frame.add(jLabel6);
    jLabel6.setBounds(504, 411, 106, 22);

    jTextField3.addActionListener(this);
    frame.add(jTextField3);
    jTextField3.setBounds(614, 316, 134, 20);
    frame.add(jTextField8);
    jTextField8.setBounds(614, 520, 134, 20);

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel7.setText("Counter No.:");
    frame.add(jLabel7);
    jLabel7.setBounds(504, 363, 136, 22);
    jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel8.setText("Qty:");
    frame.add(jLabel8);
    jLabel8.setBounds(504, 459, 136, 22);
    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel9.setText("Price:");
    frame.add(jLabel9);
    jLabel9.setBounds(504, 520, 136, 22);
    jSpinner1=new JSpinner();
    frame.add(jSpinner1);
    jSpinner1.setBounds(614, 459, 50, 40);
    jTextField4.addActionListener(this);
    frame.add(jTextField4);
    jTextField4.setBounds(614, 411, 134, 20);

    jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jButton1.setText("Submit");
    jButton1.addActionListener(this);
    frame.add(jButton1);
    jButton1.setBounds(480, 590, 127, 53);  
   //	lbimg=new JLabel(new ImageIcon(getClass().getResource(path)));
       //lbimg.setBounds(100,80, 400,400);
       //frame.add(lbimg);
    jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jButton2.setText("Cancel");
    frame.add(jButton2);
    jButton2.setBounds(720, 590, 122, 53);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jButton2.addActionListener(this);
    BrButton =new JButton("Browse");
    BrButton.setBounds(780,411,100,20);
    frame.add(BrButton);
    BrButton.addActionListener(this); 
    i1.addActionListener(this);
    i2.addActionListener(this);
    
}//</editor-fold>                        

    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==jButton2)
    	{
    		new AdminSuccess();
    		frame.dispose();
    	}
    	else if(e.getSource()==BrButton)
    	{
    		JFileChooser chooser=new JFileChooser();
    		chooser.showOpenDialog(null);
    		File f =chooser.getSelectedFile();
    		String filename=f.getName();
    		jTextField4.setText(filename);
    		//final String path= f.getName(); 
    	}
    	else if(e.getSource()==i1 || e.getSource()==i2)
		{
			SelectProfile obj=new SelectProfile();
			obj.show();
			frame.dispose();
		}
    	else if(e.getSource()==jButton1)
    	{
    		String str1=jTextField1.getText().toString();
    		String str3=jTextField2.getText().toString();
    		String str4=jTextField3.getText().toString();
    		String str5=jTextField4.getText().toString();
    		String str6=jSpinner1.getValue().toString();
    		String str2=jTextField5.getText().toString();
    		String str7=jTextField8.getText().toString();
    		 try
    		  {
    		  Class.forName("oracle.jdbc.OracleDriver");
    		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system123");
    	      Statement stmt=con.createStatement();
    	      
    	      System.out.println(str1+str2+str3+str4+str5+str6+str7);
    	      
    	     // stmt.executeUpdate("CREATE_TABLE_IF_NOT_EXIST(name varchar(50),catalogid varchar(50),brand varchar(50),counter varchar(50),imagepath varchar(50),qty varchar(50),column_price varchar(50)");
    	  
    	  stmt.executeUpdate("insert into product(name,catalogid,brand,counter,imagepath,qty,column_price)values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"')");
    	  JOptionPane.showMessageDialog(null, "Product Successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);
    	  }
    		  catch(Exception w)
    		  {
    			  System.out.println(w);
    			  JOptionPane.showMessageDialog(null,"Error in Data","Error", JOptionPane.WARNING_MESSAGE);
    		  }
    	}
    }
    public static void main(String args[])
	{
	new AddProduct();
	}
}

