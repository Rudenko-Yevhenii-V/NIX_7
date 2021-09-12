package ry.rudenko.yevhenii.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IstrWindow extends JFrame {

  public IstrWindow() {
    super("Hello");
    setBounds(110, 110, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel(new GridLayout(0,1));
    JLabel jLabelname = new JLabel("App don't have any dependency like Jackson, gson");
    JLabel jLabelname2 = new JLabel("Main class left in library unit_9_NIXson_lib to check homework");
    JLabel jLabelname3 = new JLabel("TEST PARSER JSON window only for demonstration!");
    JLabel jLabelname4 = new JLabel("Exemple json = {\"id\":\"1\",\"name\":\"J. K. Rowling\"}");
    JLabel jLabelname5 = new JLabel("Convert to : Book.id = 1, Book.name = \"J. K. Rowling\"");
    JLabel jLabelname6 = new JLabel("for other students(If you have a questions ask me telegram)");
    JButton jButton = new JButton("NEXT");
    mainPanel.add(jLabelname);
    mainPanel.add(jLabelname2);
    mainPanel.add(jLabelname3);
    mainPanel.add(jLabelname4);
    mainPanel.add(jLabelname5);
    mainPanel.add(jLabelname6);
    mainPanel.add(jButton);
    add(mainPanel, BorderLayout.SOUTH);
    pack();
    jButton.addActionListener(actionEvent -> {
      this.setVisible(false);
      this.removeAll();
      new HelloWindow().setVisible(true);
    });
  }
}
