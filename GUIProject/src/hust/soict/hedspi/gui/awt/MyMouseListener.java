package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;
public class MyMouseListener extends Frame implements MouseListener,WindowListener {
	private TextField tfOutput;
	
	@Override
	public void mousePressed(MouseEvent e) {
		tfOutput.setText("Mouse button is pressed");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		tfOutput.setText("Mouse-button released");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		tfOutput.setText("Mouse=button clicked (pressed and released)!");
	}
	
	@Override 
	public void mouseEntered(MouseEvent e) {
		tfOutput.setText("Mouse-pointer entered the source component!");
	}
	
	public void mouseExited(MouseEvent e) {
		tfOutput.setText("Mosue exited-pointer the source component!");
	}
	
	public MyMouseListener(){
		setLayout(new FlowLayout());
		
		add(new Label("Mouse Testing"));
		tfOutput = new TextField(40);
		tfOutput.setEditable(false);
		add(tfOutput);
		
		addMouseListener(this);
		addWindowListener(this);
		
		setTitle("MouseListenerTesting");
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyMouseListener();
	}

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
