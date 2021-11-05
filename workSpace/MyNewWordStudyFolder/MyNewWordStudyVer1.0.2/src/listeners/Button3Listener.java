package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import process.SetWordToField;
import process.ShowWordToStudy;
import process.StrKnow;

public class Button3Listener implements ActionListener  {
	
	private JTextField jTextField1;
	static String s = "";

	public Button3Listener(JTextField jTextField1) {
		this.jTextField1 = jTextField1;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		StrKnow sk = new StrKnow();
		SetWordToField swtf = new SetWordToField();
		if(!(jTextField1.getText().equals("Empty"))){
			sk.setS(jTextField1.getText());
		}
				
				try {
					jTextField1.setText(swtf.getS());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	}
}
