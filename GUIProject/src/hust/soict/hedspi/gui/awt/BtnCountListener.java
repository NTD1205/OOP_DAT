package hust.soict.hedspi.gui.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.gui.awt.AWTCounter;
public class BtnCountListener implements ActionListener {
	
	AWTCounter frame;
	public BtnCountListener(AWTCounter frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		frame.count++;
		frame.tfCount.setText(frame.count +"");
	}
}

