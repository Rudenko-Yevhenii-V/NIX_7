package ry.rudenko.windows;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ry.rudenko.taskLevel1.task1.UniqueCharactersFromArray;
import ry.rudenko.windows.triangle.TriangleTest;

public class LevelTwo extends JFrame {

  public LevelTwo() {
    super("MODULE1 for NIX 7!!!");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon iconTitle = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "titl2.jpg"));
    iconTitle.getImage().flush();
    JLabel titleLabel = new JLabel();
    titleLabel.setIcon(iconTitle);

    ImageIcon icon2 = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "task1lvl2.jpg"));
    icon2.getImage().flush();
    JLabel task2Label = new JLabel();
    task2Label.setIcon(icon2);
    ImageIcon icon3 = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "task2lvl2.jpg"));
    icon3.getImage().flush();
    JLabel task3Label = new JLabel();
    task3Label.setIcon(icon3);
    JPanel jPanel1 = new JPanel(new FlowLayout());
    JTextField jTextFieldTask1 = new JTextField();
    jTextFieldTask1.setToolTipText("Enter numbers");
    JPanel jPanel2 = new JPanel(new BorderLayout());
    JButton jButtonValidate = new JButton("press on to Validate String with (){}[]");
    JPanel jPanel3 = new JPanel(new BorderLayout());
    JButton jButtonMaxDeep = new JButton("press on to show MAX deep");
    JPanel jPanel4 = new JPanel(new FlowLayout());
    JButton jButtonGoToMain = new JButton("Go To Main");
    jPanel1.add(titleLabel);
    jPanel2.add(task2Label, BorderLayout.NORTH);
    jPanel2.add(jButtonValidate, BorderLayout.CENTER);
    jPanel3.add(task3Label, BorderLayout.NORTH);
    jPanel3.add(jButtonMaxDeep, BorderLayout.CENTER);
    jPanel4.add(jButtonGoToMain);
    JPanel buttonsPanel = new JPanel(new BorderLayout());
    JPanel buttonsPanel2 = new JPanel(new BorderLayout());
    buttonsPanel.add(jPanel1, BorderLayout.NORTH);
    buttonsPanel.add(buttonsPanel2, BorderLayout.SOUTH);
    buttonsPanel2.add(jPanel2, BorderLayout.NORTH);
    buttonsPanel2.add(jPanel3, BorderLayout.CENTER);
    buttonsPanel2.add(jPanel4, BorderLayout.SOUTH);

    add(buttonsPanel, BorderLayout.SOUTH);
    pack();

    jButtonValidate.addActionListener(e -> {
          setVisible(false);
          new ValidateStringWindow().setVisible(true);
        }
    );
    jButtonMaxDeep.addActionListener(e -> {
          setVisible(false);
          new MaxDeepTree().setVisible(true);
        }
    );
    jButtonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );
  }
}