package ru.rudenko.nix.Windows;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ua.com.alevel.controller.UserController;

public class RegWindow extends JFrame {

  public RegWindow() {
    super("Registration Window");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    JLabel jLabelname = new JLabel("name for registration");
    JTextField name = new JTextField(15);
    JLabel jLabelPass = new JLabel("password registration");
    JPasswordField jPasswordField = new JPasswordField(15);
    JButton jButton = new JButton("ENTER");
    mainPanel.add(jLabelname);
    mainPanel.add(name);
    mainPanel.add(jLabelPass);
    mainPanel.add(jPasswordField);
    mainPanel.add(jButton);
    add(mainPanel, BorderLayout.SOUTH);
    pack();
    jButton.addActionListener(actionEvent -> {
      if (!(name.getText().equals(""))) {
        if (!(jPasswordField.getText().equals(""))) {
          System.out.println(name.getText() + " +++ " + jPasswordField.getText());
          UserController userController = new UserController();
          userController.createForCRUD(name.getText(), jPasswordField.getText());
          this.setVisible(false);
          this.removeAll();
          new LoginWindow().setVisible(true);
        }
      }
    });
  }
}
