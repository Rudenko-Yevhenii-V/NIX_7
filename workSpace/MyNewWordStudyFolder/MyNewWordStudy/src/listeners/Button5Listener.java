package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

import process.ShowWordToStudy;
import process.StrDontKnow;
import process.StrKnow;
import process.WriteNewWordToDictionary;
import process.WriteNewWordToStudy;

public class Button5Listener implements ActionListener  {
	
	private JTextArea jTextArea1;

	public Button5Listener(JTextArea jTextArea1) {
		this.jTextArea1 = jTextArea1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s;
		StrKnow artK = new StrKnow();
		s = StrKnow.s;
		StrDontKnow dk = new StrDontKnow();
		WriteNewWordToStudy wrs = new WriteNewWordToStudy(dk.getS());
		StrKnow sk = new StrKnow();
		WriteNewWordToDictionary wtd = new WriteNewWordToDictionary(sk.getS());
		
				
		//jTextArea1.setText(s);
		jTextArea1.setText(wrs.getS());
		
		
		
		
	}

}
