package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import process.CharacterDeletion;

public class Button1Listener implements ActionListener {//���� ���������� ������ Transformation

	private JTextArea jTextArea1;
			
	public Button1Listener(JTextArea jTextArea1) { //����������� ������� �������� ����
		this.jTextArea1 = jTextArea1;
				
	}

	@Override
	public void actionPerformed(ActionEvent e) { //��� ���� ������������ �� ���� ���������� �� ������ 
		String s, s1;
		s = (jTextArea1.getText());	//��������� ����� � ���������� ����	
		CharacterDeletion chD = new CharacterDeletion(s);	//��������� � ����������� ����� CharacterDeletion	
		s1 = chD.getSt();	//��������� � ����� CharacterDeletion �������������� �����	
		jTextArea1.setText(s1.toLowerCase());//������������ � �������� ���� �������������� �����
		
		
		
		
	}
	

}
