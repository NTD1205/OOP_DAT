package hust.soict.hedspi.gui.awt;
import java.awt.*;
import java.awt.event.*;
public class AWTCounter3ButtonsGetSource extends Frame {
	private TextField tfCount;
	private Button btnCountUp, btnCountDown, btnReset;
	private int count = 0;
	
	public AWTCounter3ButtonsGetSource() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
		tfCount = new TextField("0", 10);
		tfCount.setEditable(false);
		add(tfCount);
		
		btnCountUp = new Button("Count Up");
		add(btnCountUp);
		btnCountDown = new Button("Count Down");
		add(btnCountDown);
		btnReset = new Button("Reset");
		add(btnReset);
		
		BtnListener listener = new BtnListener();
		btnCountUp.addActionListener(listener);
		btnCountDown.addActionListener(listener);
		btnReset.addActionListener(listener);
		
		setTitle("AWT Counter");
		setSize(400,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTCounter3ButtonsGetSource();
	}
	
	private class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			Button source = (Button)evt.getSource();	
			if (source == btnCountUp) {
				++count;
			} else if (source == btnCountDown) {
				--count;
			} else {
				count = 0;
			}
			tfCount.setText(count + "");
		}
	}
}
