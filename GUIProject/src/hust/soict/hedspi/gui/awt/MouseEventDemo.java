package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener,WindowListener{
	private TextField tfMouseX;
	private TextField tfMouseY;
	
	public MouseEventDemo() {
		setLayout(new FlowLayout());
		
		add(new Label("X-Click: "));
		
		tfMouseX = new TextField(10);
		tfMouseX.setEditable(false);
		add(tfMouseX);
		
		add(new Label("Y-Click: "));
		
		tfMouseY = new TextField(10);
		tfMouseY.setEditable(false);
		add(tfMouseY);
		
		addMouseListener(this);
		addWindowListener(this);
		
		setTitle("MouseEvent Demo");
		setSize(350,100);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new MouseEventDemo();
	}
	
	@Override
	public void mouseClicked(MouseEvent evt) {
		tfMouseX.setText(evt.getX() + "");
		tfMouseY.setText(evt.getY() + "");
	}
	
	@Override public void mousePressed(MouseEvent evt) {}
	@Override public void mouseReleased(MouseEvent evt) {}
	@Override public void mouseEntered(MouseEvent evt) {}
	@Override public void mouseExited(MouseEvent evt) {}

	@Override
	public void windowOpened(WindowEvent e) {
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
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
