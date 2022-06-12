package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;

public class AWTBorderLayoutDemo extends Frame {
	private Button btnNorth, btnSouth, btnCenter, btnEast,btnWest;
	
	public AWTBorderLayoutDemo() {
		setLayout(new BorderLayout(3,3));
		
		btnNorth = new Button("North");
		add(btnNorth, BorderLayout.NORTH);
		btnSouth = new Button("South");
		add(btnSouth, BorderLayout.SOUTH);
		btnCenter = new Button("Center");
		add(btnCenter, BorderLayout.CENTER);
		btnEast = new Button("East");
		add(btnEast, BorderLayout.EAST);
		btnWest = new Button("West");
		add(btnWest, BorderLayout.WEST);
		
		setTitle("BorderLayout Demo");
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
				System.exit(1);
				
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
	
	public static void main (String[] args) {
		new AWTBorderLayoutDemo();
	}
}
