package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import process.SetWordToField;
import process.ShowWordToStudy;
import process.StrDontKnow;

public class Button4Listener implements ActionListener  {
	
	private JTextField jTextField1;
	static String s = "";

	public Button4Listener(JTextField jTextField1) {
		this.jTextField1 = jTextField1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		StrDontKnow sdk = new StrDontKnow();
		SetWordToField swtf = new SetWordToField();
		//s = s + " " + jTextField1.getText();
		if(!(jTextField1.getText().equals("Empty"))){
//			System.out.println("BOOLE++++++" + (jTextField1.getText().equals("Empty")));
//			s = s + " " + jTextField1.getText();
			sdk.setS(jTextField1.getText());
		}
		
				//System.out.println(" Stroka c NO button" + s);
				try {
					jTextField1.setText(swtf.getS());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println("koza" + swtf.getS());
		
		
		
		
	}

}
