package ry.rudenko.yevhenii.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ry.rudenko.yevhenii.controller.UserController;

public class HelloWindow extends JFrame {

  public HelloWindow() {
    super("HEllo take a choice");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    JLabel jLabelname = new JLabel("CRUD APP");
    JButton jButton = new JButton("ENTER");
    JLabel jLabelPass = new JLabel("TEST PARSER JSON");
    JButton jButtonRegistration = new JButton("ENTER");

    mainPanel.add(jLabelname);
    mainPanel.add(jButton);
    mainPanel.add(jLabelPass);
    mainPanel.add(jButtonRegistration);
    add(mainPanel, BorderLayout.SOUTH);
    pack();
    jButton.addActionListener(actionEvent -> {
      this.setVisible(false);
      this.removeAll();
      new ShowModule().setVisible(true);
    });
    jButtonRegistration.addActionListener(actionEvent -> {
      this.setVisible(false);
      this.removeAll();
      new ParserWindow().setVisible(true);
    });
  }
}
