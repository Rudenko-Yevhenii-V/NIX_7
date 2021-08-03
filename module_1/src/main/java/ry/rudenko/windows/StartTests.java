package ry.rudenko.windows;

import javax.swing.*;
import java.awt.*;

public class StartTests extends JFrame {

  public StartTests(){
    super("JUnit TESTS");
    setBounds(5, 5, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel buttonsPanel = new JPanel(new FlowLayout());
    JTextArea jTextArea = new JTextArea(40, 40);
    JScrollPane sp = new JScrollPane(jTextArea);
    JButton jButton1 = new JButton("start JUnit tests");
    JButton jButton2 = new JButton("go to main menu");
    buttonsPanel.add(sp);
    buttonsPanel.add(jButton1);
    buttonsPanel.add(jButton2);
    add(buttonsPanel, BorderLayout.SOUTH);
    pack();
    jButton1.addActionListener(e -> new BatStarter().start("mvn test", jTextArea));
    jButton2.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );

  }
}