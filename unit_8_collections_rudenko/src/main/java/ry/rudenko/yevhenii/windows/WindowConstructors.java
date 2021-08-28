package ry.rudenko.yevhenii.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ry.rudenko.yevhenii.homeWorkCollections.MathSet;

public class WindowConstructors extends JFrame {

  private int widthColumText = 30;
  private int widthColumTextinput = 10;


  public WindowConstructors() {
    super("CollectionsConstructors");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel buttonsPanel = new JPanel(new GridLayout(0, 1));
    JPanel one1 = new JPanel(new FlowLayout());
    JLabel label1 = new JLabel("MathSet()");
    JButton jButton1 = new JButton("create");
    JTextField jTextField1 = new JTextField(widthColumText);
    one1.add(label1);
    one1.add(jButton1);
    one1.add(jTextField1);
    jButton1.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField1.setText(input);
    });
    buttonsPanel.add(one1);
    JPanel one2 = new JPanel(new FlowLayout());
    JLabel label2 = new JLabel("MathSet(int capacity)");
    JTextField jTextFieldiput2 = new JTextField(widthColumTextinput);
    JButton jButton2 = new JButton("create");
    JTextField jTextField2 = new JTextField(widthColumText);
    one2.add(label2);
    one2.add(jTextFieldiput2);
    one2.add(jButton2);
    one2.add(jTextField2);
    jButton2.addActionListener(actionEvent -> {
      if (jTextFieldiput2.getText().matches("\\d+")) {
        MathSet mathSet = new MathSet(Integer.parseInt(jTextFieldiput2.getText()));
        String input = "mathSet.getCapacity = " + mathSet.getCapacity();
        jTextField2.setText(input);
      }
    });
    buttonsPanel.add(one2);
    JPanel one3 = new JPanel(new FlowLayout());
    JLabel label3 = new JLabel("new MathSet(numbers)");
    JLabel labelinp3 = new JLabel("numbers = {1, 4, 5, 6, 5, 11}");
    JButton jButton3 = new JButton("create");
    JTextField jTextField3 = new JTextField(widthColumText);
    one3.add(label3);
    one3.add(labelinp3);
    one3.add(jButton3);
    one3.add(jTextField3);
    jButton3.addActionListener(actionEvent -> {
      Number[] numbers = {1, 4, 5, 6, 5, 11};
      MathSet mathSet = new MathSet(numbers);
      String input = "mathSet.getNumbers() = ";
      for (int i = 0; i < mathSet.getNumbers().length; i++) {
        input = input + mathSet.getNumbers()[i] + " ";
      }
      jTextField3.setText(input);
    });
    buttonsPanel.add(one3);
    JPanel one4 = new JPanel(new FlowLayout());
    JLabel label4 = new JLabel(
        "MathSet({11, 17, 18, 18, null}, {21, 28, 28, null}, { 37, 38, 38})");
    JButton jButton4 = new JButton("create");
    JTextField jTextField4 = new JTextField(widthColumText);
    one4.add(label4);
    one4.add(jButton4);
    one4.add(jTextField4);
    jButton4.addActionListener(actionEvent -> {
      Number[] numbers1 = {11, 17, 18, 18, null};
      Number[] numbers2 = {21, 28, 28, null};
      Number[] numbers3 = {37, 38, 38};
      MathSet mathSet = new MathSet(numbers1, numbers2, numbers3);
      String input = "mathSet.getNumbers()= ";
      for (int i = 0; i < mathSet.getNumbers().length; i++) {
        input = input + mathSet.getNumbers()[i] + " ";
      }
      jTextField4.setText(input);
    });
    buttonsPanel.add(one4);
    JPanel one5 = new JPanel(new FlowLayout());
    JLabel label5 = new JLabel("MathSet(new MathSet(new Number[]{1, 8, 2345, 5, 11}))");
    JButton jButton5 = new JButton("create");
    JTextField jTextField5 = new JTextField(widthColumText);
    one5.add(label5);
    one5.add(jButton5);
    one5.add(jTextField5);
    jButton5.addActionListener(actionEvent -> {
      MathSet mathSet1 = new MathSet(new Number[]{1, 8, 2345, 5, 11});
      MathSet mathSet2 = new MathSet(mathSet1);
      String input = "mathSet = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + " ";
      }
      jTextField5.setText(input);
    });
    buttonsPanel.add(one5);
    JPanel one6 = new JPanel(new FlowLayout());
    JLabel label6 = new JLabel(
        "MathSet(new MathSet({ 17, 18, 18, null}), new MathSet({ 28, 28, null}),"
            + "MathSet(new MathSet({31, 38, null}))");
    JButton jButton6 = new JButton("create");
    JTextField jTextField6 = new JTextField(widthColumText);
    one6.add(label6);
    one6.add(jButton6);
    one6.add(jTextField6);
    jButton6.addActionListener(actionEvent -> {
      Number[] numbers1 = {17, 18, 18, null};
      Number[] numbers2 = {28, 28, null};
      Number[] numbers3 = {31, 38, null};
      MathSet mathSet1 = new MathSet(numbers1);
      MathSet mathSet2 = new MathSet(numbers2);
      MathSet mathSet3 = new MathSet(numbers3);
      MathSet mathSet = new MathSet(mathSet1, mathSet2, mathSet3);
      String input = "mathSet = ";
      for (int i = 0; i < mathSet.getNumbers().length; i++) {
        input = input + mathSet.getNumbers()[i] + " ";
      }
      jTextField6.setText(input);
    });
    buttonsPanel.add(one6);
    JPanel one = new JPanel(new FlowLayout());
    JLabel label = new JLabel("Go to methods");
    JButton jButton = new JButton("OK");
    one.add(label);
    one.add(jButton);
    jButton.addActionListener(actionEvent -> {
      this.setVisible(false);
      this.removeAll();
      new WindowMethods().setVisible(true);
    });
    buttonsPanel.add(one);
    add(buttonsPanel, BorderLayout.SOUTH);
    pack();
  }
}