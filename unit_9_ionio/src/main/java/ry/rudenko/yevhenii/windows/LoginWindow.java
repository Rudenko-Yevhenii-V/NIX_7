package ry.rudenko.yevhenii.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ua.com.alevel.controller.UserController;

public class LoginWindow extends JFrame {

  public LoginWindow() {
    super("LoginWindow");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    JLabel jLabelname = new JLabel("enter your name");
    JTextField name = new JTextField(15);
    JLabel jLabelPass = new JLabel("enter your password");
    JPasswordField jPasswordField = new JPasswordField(15);
    JButton jButton = new JButton("ENTER");
    JButton jButtonRegistration = new JButton("registration");

    mainPanel.add(jLabelname);
    mainPanel.add(name);
    mainPanel.add(jLabelPass);
    mainPanel.add(jPasswordField);
    mainPanel.add(jButton);
    mainPanel.add(jButtonRegistration);
    add(mainPanel, BorderLayout.SOUTH);
    pack();
    jButton.addActionListener(actionEvent -> {
      if (!(name.getText().equals(""))) {
        if (!(jPasswordField.getText().equals(""))) {
          UserController userController = new UserController();
          String tokken = userController.loginForCRUD(name.getText(), jPasswordField.getText());
          if (tokken.equals("NullPointerException")) {
            name.setBackground(Color.RED);
            jPasswordField.setBackground(Color.RED);
            return;
          }

          if (!tokken.isEmpty()) {
          } else {
            name.setBackground(Color.RED);
            jPasswordField.setBackground(Color.RED);
            return;
          }
          this.setVisible(false);
          this.removeAll();
          new ShowModule().setVisible(true);
        }
      }
    });
    jButtonRegistration.addActionListener(actionEvent -> {
      this.setVisible(false);
      this.removeAll();
      new RegWindow().setVisible(true);
    });
  }
}
