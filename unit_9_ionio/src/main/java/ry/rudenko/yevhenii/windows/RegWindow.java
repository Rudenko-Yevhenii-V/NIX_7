package ry.rudenko.yevhenii.windows;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    JPanel mainPanel = new JPanel(new GridLayout(0,1));
    JPanel mainPanel1 = new JPanel();
    JPanel mainPanel2 = new JPanel();
    JPanel mainPanel3 = new JPanel();
    JPanel mainPanel4 = new JPanel();
    JPanel mainPanel5 = new JPanel();
    JPanel mainPanel6 = new JPanel();
    mainPanel.setSize(1000, 500);
    JLabel jLabelname = new JLabel("name for registration");
    JTextField name = new JTextField(15);
    JLabel jLabelPass = new JLabel("password registration");
    JPasswordField jPasswordField = new JPasswordField(15);
    JButton jButton = new JButton("ENTER");
    mainPanel1.add(jLabelname);
    mainPanel1.add(name);
    mainPanel1.add(jLabelPass);
    mainPanel1.add(jPasswordField);
    mainPanel1.add(jButton);
    mainPanel.add(mainPanel2);
    mainPanel.add(mainPanel3);
    mainPanel.add(mainPanel1);
    mainPanel.add(mainPanel4);
    mainPanel.add(mainPanel5);
    mainPanel.add(mainPanel6);
    add(mainPanel, BorderLayout.SOUTH);
    pack();
    jButton.addActionListener(actionEvent -> {
      if (!(name.getText().equals(""))) {
        if (!(jPasswordField.getText().equals(""))) {
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
