package ry.rudenko.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ry.rudenko.taskLevel2.task1.StringValidatorForTheTask1Lvl2;

public class ValidateStringWindow extends  JFrame {
  public ValidateStringWindow() {
    super("ValidateStringWindow");
    setBounds(100, 100, 800, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    JPanel buttonsPanel = new JPanel(new BorderLayout());
    JPanel buttonsPanel1 = new JPanel(new BorderLayout());
    JPanel buttonsPanel2 = new JPanel(new BorderLayout());

    JLabel labelTask1 = new JLabel(" enter text to validate");
    JTextField jTextField= new JTextField(10);
    JButton button = new JButton("VALIDATE");
    JButton jButtonGoToMain = new JButton("Go To Main");

    buttonsPanel1.add(labelTask1, BorderLayout.WEST);
    buttonsPanel1.add(jTextField, BorderLayout.CENTER);
    buttonsPanel1.add(button, BorderLayout.EAST);

    buttonsPanel2.add(jButtonGoToMain);
    buttonsPanel.add(buttonsPanel1,BorderLayout.NORTH);
    buttonsPanel.add(buttonsPanel2,BorderLayout.SOUTH);

    button.addActionListener(e -> {
      if(new StringValidatorForTheTask1Lvl2(jTextField.getText()).isValid()){
        labelTask1.setText(jTextField.getText() + " = true");
        labelTask1.setForeground(Color.GREEN);
      }else {
        labelTask1.setText(jTextField.getText() + " = false");
        labelTask1.setForeground(Color.RED);
      }
        }
    );
    jButtonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );

    add(buttonsPanel, BorderLayout.SOUTH);
    pack();
  }
}