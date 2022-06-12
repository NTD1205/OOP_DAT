package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;
public class MouseMotionDemo extends Frame implements MouseListener, MouseMotionListener {
	private TextField tfMouseClickX;
	private TextField tfMouseClickY;
	
	private TextField tfMousePositionX;
	private TextField tfMousePositionY;
	
	public MouseMotionDemo() {
		setLayout(new FlowLayout());
		
		add(new Label("X-Click "));
		tfMouseClickX = new TextField(10);
		tfMouseClickX.setEditable(false);
		add(tfMouseClickX);
		add(new Label("Y-Click:"));
		tfMouseClickY = new TextField(10);
		tfMouseClickY.setEditable(false);
		add(tfMouseClickY);
		
		add(new Label("X-Position: "));
		tfMousePositionX = new TextField(10);
		tfMousePositionX.setEditable(false);
		add(tfMousePositionX);
		tfMousePositionY = new TextField(10);
		tfMousePositionY.setEditable(false);
		add(tfMousePositionY);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setTitle("MouseMotion Demo");
		setSize(400, 120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseMotionDemo();
	}
	
	@Override
	public void mouseMoved(MouseEvent evt) {
		tfMousePositionX.setText(evt.getX() +"");
		tfMousePositionY.setText(evt.getY() +"");
	}
	@Override public void mouseDragged(MouseEvent evt) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
