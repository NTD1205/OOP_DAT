package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;
public class AWTGridLayoutDemo extends Frame {
	private Button btn1, btn2, btn3, btn4, btn5, btn6;
	
	public AWTGridLayoutDemo() {
		setLayout(new GridLayout(3,2,3,3));
		
		btn1 = new Button("Button 1");
		add(btn1);
		btn2 = new Button("This is Butotn 2");
		add(btn2);
		btn3 = new Button("3");
		add(btn3);
		btn4 = new Button("Another Button 4");
		add(btn4);
		btn5 = new Button("Button 5");
		add(btn5);
		btn6 = new Button("One More Button 6");
		add(btn6);
		
		setTitle("GridLayout Demo");
		setSize(280,150);
		setVisible(true);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	public static void main(String[] args) {
		new AWTGridLayoutDemo();
	}
}
