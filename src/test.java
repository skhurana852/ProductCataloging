import javax.swing.*;
public class test {

	JButton b1;
	test()
	{
		JFrame setf=new JFrame("test");
		b1=new JButton("welcome");
		setf.add(b1);
		setf.setSize(100,100);
		setf.setLayout(null);
		setf.setVisible(true);
	}
	public static void main(String args[])
	{
		test ob=new test();
	}
}
