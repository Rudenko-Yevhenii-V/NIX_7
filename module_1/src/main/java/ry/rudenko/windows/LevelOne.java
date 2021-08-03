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
import javax.swing.SwingConstants;
import ry.rudenko.taskLevel1.task1.UniqueCharactersFromArray;

public class LevelOne extends JFrame {
  public LevelOne() {
    super("MODULE1 for NIX 7!!!");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon iconTitle = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "lvl1title.jpg"));
    iconTitle.getImage().flush();
    JLabel titleLabel = new JLabel();
    titleLabel.setIcon(iconTitle);
    ImageIcon icon1 = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "lvl1t1.jpg"));
    icon1.getImage().flush();
    JLabel task1Label = new JLabel();
    task1Label.setIcon(icon1);
    ImageIcon icon2 = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "lvl1t2.jpg"));
    icon2.getImage().flush();
    JLabel task2Label = new JLabel();
    task2Label.setIcon(icon2);
    ImageIcon icon3 = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "lvl1t3.jpg"));
    icon3.getImage().flush();
    JLabel task3Label = new JLabel();
    task3Label.setIcon(icon3);

    JButton jButtonTask1 = new JButton("enter");
    JButton jButtonTask2 = new JButton("enter");
    JButton jButtonTask3 = new JButton("enter");
    JButton jButtonGoToMain = new JButton("Go To Main");

    JPanel buttonsPanel = new JPanel(new GridLayout(5, 1));
    JPanel jPanel1 = new JPanel(new FlowLayout());
    jPanel1.add(titleLabel);

    JPanel jPanel2 = new JPanel(new GridLayout(2, 1));
    jPanel2.add(task1Label);
    JTextField jTextFieldTask1 = new JTextField();
    JLabel jLabelEnterNumbers = new JLabel("Enter numbers");
    jTextFieldTask1.setToolTipText("Enter numbers");
    JPanel jPanetask1 = new JPanel(new BorderLayout());
    jPanel2.add(jPanetask1);
    jPanetask1.add(jLabelEnterNumbers, BorderLayout.NORTH);
    JPanel bufer1 = new JPanel(new GridLayout(1, 2));
    jPanetask1.add(bufer1);
    bufer1.add(jTextFieldTask1);
    bufer1.add(jButtonTask1);

    JPanel jPanel3 = new JPanel(new BorderLayout());
    jPanel3.add(task2Label, BorderLayout.NORTH);
    JButton jButtonHorseMove = new JButton("press on to show horse moves");
    jPanel3.add(jButtonHorseMove, BorderLayout.SOUTH);

    JPanel jPanel4 = new JPanel(new BorderLayout());
    jPanel4.add(task3Label, BorderLayout.NORTH);
    JButton jButtonTrianhle = new JButton("press on to show area of a triangle");
    jPanel4.add(jButtonTrianhle, BorderLayout.CENTER);

    JPanel jPanel5 = new JPanel(new FlowLayout());
    jPanel5.add(jButtonGoToMain);

    buttonsPanel.add(jPanel1);
    buttonsPanel.add(jPanel2);
    buttonsPanel.add(jPanel3);
    buttonsPanel.add(jPanel4);
    buttonsPanel.add(jPanel5);
    jPanel1.add(titleLabel);
    add(buttonsPanel, BorderLayout.SOUTH);
    pack();
    jButtonTask1.addActionListener(e -> {
          jLabelEnterNumbers.setText("result:");
          char[] ArrayExemple = jTextFieldTask1.getText().toCharArray();
          StringBuilder result = new StringBuilder();

          for (int i = 0; i < ArrayExemple.length; i++) {
            if (Character.isDigit(ArrayExemple[i])) {
              result.append(" " + (ArrayExemple[i]));
            }
          }
          String[] results = result.toString().trim().split(" ");
          int[] numbers = new int[results.length];
          for (int i = 0; i < results.length; i++) {
            numbers[i] = Integer.parseInt(results[i]);
          }
          jTextFieldTask1.setText(String.valueOf(
              new UniqueCharactersFromArray().ReturnTheNumberOfUniqueCharactersFromArray(numbers)));
        }
    );
    jButtonTask2.addActionListener(e -> {
          setVisible(false);
          //new WindowApp().setVisible(true);
        }
    );
    jButtonTask3.addActionListener(e -> {
          setVisible(false);
          //new WindowApp().setVisible(true);
        }
    );
    jButtonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );
    jButtonHorseMove.addActionListener(e -> {
          setVisible(false);
          new HorseMove().setVisible(true);
        }
    );
    jButtonTrianhle.addActionListener(e -> {
          setVisible(false);
          new HorseMove().setVisible(true);
        }
    );


  }
}