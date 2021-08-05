package ry.rudenko.windows;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ry.rudenko.taskLevel3.task1.GameOfLife;

public class LevelThree extends JFrame {

  public LevelThree() {
    super("GAME OF LIFE");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon iconTitle = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "gl.jpg"));
    iconTitle.getImage().flush();
    JLabel titleLabel = new JLabel();
    titleLabel.setIcon(iconTitle);

    JPanel jPanel1 = new JPanel(new FlowLayout());
    JTextField jTextFieldRows = new JTextField(3);
    JLabel rows = new JLabel("ROWS");
    JLabel colums = new JLabel("COLUMS");
    JTextField jTextFieldColums = new JTextField(3);
    JPanel jPanel2 = new JPanel(new FlowLayout());
    JButton jButtonValidate = new JButton("GAME OF LIFE START");
    JPanel jPanel4 = new JPanel(new FlowLayout());
    JButton jButtonGoToMain = new JButton("Go To Main");
    jPanel1.add(titleLabel);
    jPanel2.add(rows);
    jPanel2.add(jTextFieldRows);
    jPanel2.add(colums);
    jPanel2.add(jTextFieldColums);
    jPanel2.add(jButtonValidate);

    jPanel4.add(jButtonGoToMain);
    JPanel buttonsPanel = new JPanel(new BorderLayout());
    JPanel buttonsPanel2 = new JPanel(new BorderLayout());
    buttonsPanel.add(jPanel1, BorderLayout.NORTH);
    buttonsPanel.add(buttonsPanel2, BorderLayout.SOUTH);
    buttonsPanel2.add(jPanel2, BorderLayout.NORTH);
    buttonsPanel2.add(jPanel4, BorderLayout.SOUTH);

    add(buttonsPanel, BorderLayout.SOUTH);
    pack();

    jButtonValidate.addActionListener(e -> {
          setVisible(false);
          GameOfLife gameOfLife = new GameOfLife(Integer.parseInt(jTextFieldRows.getText()),
              Integer.parseInt(jTextFieldColums.getText()), true);
          GameOfLifeWindow gameOfLifeWindow = new GameOfLifeWindow(jTextFieldRows.getText(),
              jTextFieldColums.getText(), gameOfLife);
          gameOfLifeWindow.setVisible(true);
        }
    );

    jButtonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );
  }
}