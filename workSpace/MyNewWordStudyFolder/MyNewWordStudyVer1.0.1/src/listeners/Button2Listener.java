package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

import process.CharacterDeletion;
import process.ReadDictionary;
import process.WriteNewWordToStudy;
import process.ShowWordToStudy;

public class Button2Listener implements ActionListener  {
	
	private JTextArea jTextArea1;

	public Button2Listener(JTextArea jTextArea1) {
		this.jTextArea1 = jTextArea1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s, s1;
		s = jTextArea1.getText();
		String[] textArray = s.split(" ");
		ShowWordToStudy sts = new ShowWordToStudy(textArray);
		
				try {
					sts.check();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		jTextArea1.setText(sts.getSetWord());
		
		
		
		
		
	}

}
