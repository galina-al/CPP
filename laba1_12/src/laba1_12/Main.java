package laba1_12;

import java.math.BigDecimal;

import javax.swing.JFrame;


public class Main {
	static Window win = new Window();
	
	public static void main(String[] args) {
		
			win.setVisible(true);
			win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			win.setSize(400, 120);
			win.setResizable(false);
			win.setLocationRelativeTo(null);
	}
	public static void Integrate(){
		double point1, point2, n = 10, h, sin, integral = 0.0;
		point1 = win.beg;
		point2 = win.end;
		h = (point2 - point1)/n;
		sin = (Math.sin(point1) + Math.sin(point2)) / 2;
		for(double i = (point1 + h), k=1; k < 10; i += h, k++){
			sin += Math.sin(i); }
		integral = h * sin;
		BigDecimal d = new BigDecimal(integral).setScale(2, BigDecimal.ROUND_HALF_UP);
		win.l33.setText(String.valueOf(d));
	}
}
