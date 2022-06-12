package hust.soict.hedspi.gui.awt;

import java.awt.*;
import java.awt.event.*;
public class WindowEventDemoAdapter extends Frame{
	private TextField tfCount;
	private Button btnCount;
	private int count = 0;
	
	public WindowEventDemoAdapter() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
		tfCount = new TextField("0",10);
		tfCount.setEditable(false);
		add(tfCount);
		
		btnCount = new Button("Count");
		add(btnCount);
		btnCount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				++count;
				tfCount.setText(count +"");
			}
		});
		
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
		
		setTitle("WindowEvent Demo");
		setSize(250,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowEventDemoAdapter();
	}
	
}
