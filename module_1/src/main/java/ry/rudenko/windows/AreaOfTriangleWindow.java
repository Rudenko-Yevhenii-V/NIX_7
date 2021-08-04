package ry.rudenko.windows;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ry.rudenko.windows.triangle.TriangleTest;

public class AreaOfTriangleWindow extends JFrame {
  JTextField jTextFieldAx;
  JLabel Error = new JLabel();
  public AreaOfTriangleWindow() {
    super("AreaOfTriangle");
    setBounds(130, 130, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel buttonsPanel = new JPanel(new GridLayout(3, 1));
    JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel jPanel2 = new JPanel();
    buttonsPanel.add(jPanel1);
    JLabel labelAx = new JLabel("Ax");
    jTextFieldAx = new JTextField("1");
    jTextFieldAx.setColumns(2);
    JLabel labelAy = new JLabel("Ay");
    JTextField jTextFieldAy = new JTextField("1");
    jTextFieldAy.setColumns(2);
    JLabel labelBx = new JLabel("Bx");
    JTextField jTextFieldBx = new JTextField("2");
    jTextFieldBx.setColumns(2);
    JLabel labelBy = new JLabel("By");
    JTextField jTextFieldBy = new JTextField("4");
    jTextFieldBy.setColumns(2);
    JLabel labelCx = new JLabel("Cx");
    JTextField jTextFieldCx = new JTextField("5");
    jTextFieldCx.setColumns(2);
    JLabel labelCy = new JLabel("Cy");
    JTextField jTextFieldCy = new JTextField("5");
    jTextFieldCy.setColumns(2);
    JButton jButtonEnter = new JButton("enter");
    jPanel1.add(labelAx);
    jPanel1.add(jTextFieldAx);
    jPanel1.add(labelAy);
    jPanel1.add(jTextFieldAy);
    jPanel1.add(labelBx);
    jPanel1.add(jTextFieldBx);
    jPanel1.add(labelBy);
    jPanel1.add(jTextFieldBy);
    jPanel1.add(labelCx);
    jPanel1.add(jTextFieldCx);
    jPanel1.add(labelCy);
    jPanel1.add(jTextFieldCy);
    jPanel1.add(jButtonEnter);
    buttonsPanel.add(jPanel2);
    JButton buttonGoToMain = new JButton("go to main");
    jPanel2.add(buttonGoToMain);
    buttonsPanel.add(Error);
    add(buttonsPanel, BorderLayout.SOUTH);
    pack();

    jButtonEnter.addActionListener(e -> {
          setVisible(false);
          new TriangleTest(jTextFieldAx.getText(), jTextFieldAy.getText(),
              jTextFieldBx.getText(),jTextFieldBy.getText(),
              jTextFieldCx.getText(),jTextFieldCy.getText()
              );
        }
    );
    buttonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );

  }
  public  void  setFalse(String s){
    Error.setText(s + " is no a numbers");
    Error.setForeground(Color.RED);

  }
}