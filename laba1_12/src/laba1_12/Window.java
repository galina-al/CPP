package laba1_12;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Window extends JFrame{
	double beg, end;
	JLabel l, l1, l2, l3, l33;
	JTextField t1, t2;
	JButton b1;
	Listener list  = new Listener();
	
	public Window(){
		super("laba1");
		setLayout(new FlowLayout());
		l = new JLabel("sin(x)dx");
		l1 = new JLabel("Начало интервала ");
		l2 = new JLabel("Конец интервала ");
		l3 = new JLabel("Интеграл ");
		l33 = new JLabel("");
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		b1 = new JButton("Интегрировать");
		

		
		Box box1 = Box.createHorizontalBox();
		box1.add(l);
		box1.add(Box.createHorizontalStrut(330));
		
		Box box2 = Box.createHorizontalBox();
		box2.add(l1);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(t1);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(l2);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(t2);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(l3);
		box4.add(Box.createHorizontalStrut(30));
		//l3.setAlignmentX(RIGHT_ALIGNMENT);
		box4.add(l33);
		box4.add(Box.createHorizontalStrut(150));
		box4.add(b1);
		//b1.setAlignmentX(LEFT_ALIGNMENT);
		b1.addActionListener(list);
		
		Box mainbox = Box.createVerticalBox();
		mainbox.add(box1);
		mainbox.add(box2);
		mainbox.add(box3);
		mainbox.add(box4);
		
		setContentPane(mainbox);
	}
	
	public class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1){
				beg = Double.parseDouble(t1.getText()); 
				end = Double.parseDouble(t2.getText());
				Main.Integrate();
			}
		}

	}
	

}
