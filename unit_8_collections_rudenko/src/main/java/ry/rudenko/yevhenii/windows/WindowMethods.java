package ry.rudenko.yevhenii.windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ry.rudenko.yevhenii.util.homeWorkCollections.MathSet;

public class WindowMethods extends JFrame {

  private int widthColumText = 25;
  private int widthColumTextinput = 10;


  public WindowMethods() {
    super("CollectionsMethods");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel buttonsPanel = new JPanel(new GridLayout(0, 1));
    JPanel one1 = new JPanel(new FlowLayout());
    JLabel label1 = new JLabel("void add(Number n)");
    JTextField jTextFieldiput1 = new JTextField(widthColumTextinput);
    JButton jButton1 = new JButton("OK");
    JTextField jTextField1 = new JTextField(widthColumText);
    one1.add(label1);
    one1.add(jTextFieldiput1);
    one1.add(jButton1);
    one1.add(jTextField1);
    MathSet mathSet1 = new MathSet();
    jButton1.addActionListener(actionEvent -> {
      if (jTextFieldiput1.getText().matches("\\d+")) {
        mathSet1.add(Integer.parseInt(jTextFieldiput1.getText()));
        String input = "elements = ";
        for (int i = 0; i < mathSet1.getNumbers().length; i++) {
          input = input + mathSet1.getNumbers()[i] + ", ";
        }
        jTextField1.setText(input);
      }
    });
    JLabel label2 = new JLabel("mathSet.add(7, 7, 3, null, null)");
    JButton jButton2 = new JButton("OK");
    JTextField jTextField2 = new JTextField(widthColumText);
    one1.add(label2);
    one1.add(jButton2);
    one1.add(jTextField2);
    jButton2.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      mathSet.add(7, 7, 3, null, null);
      String input = "elements = ";
      for (int i = 0; i < mathSet.getNumbers().length; i++) {
        input = input + mathSet.getNumbers()[i] + ", ";
      }
      jTextField2.setText(input);

    });
    buttonsPanel.add(one1);

    JPanel one3 = new JPanel(new FlowLayout());
    JLabel label3 = new JLabel("new MathSet().join(new MathSet().add(7, 7, 3, null, null))");
    JButton jButton3 = new JButton("OK");
    JTextField jTextField3 = new JTextField(widthColumText);
    one3.add(label3);
    one3.add(jButton3);
    one3.add(jTextField3);
    jButton3.addActionListener(actionEvent -> {
      MathSet mathSetMain = new MathSet();
      MathSet mathSet11 = new MathSet();
      mathSet11.add(7, 7, 3, null, null);
      mathSetMain.join(mathSet11);
      String input = "elements = ";
      for (int i = 0; i < mathSetMain.getNumbers().length; i++) {
        input = input + mathSetMain.getNumbers()[i] + ", ";
      }
      jTextField3.setText(input);
    });
    buttonsPanel.add(one3);

    JPanel one4 = new JPanel(new FlowLayout());
    JLabel label4 = new JLabel(
        "new MathSet().join(new MathSet().add(7.5, 7, 3, null, null), new MathSet().add(11, 12, 12, 13), new MathSet().add(1000, 9999))\n");
    JButton jButton4 = new JButton("OK");
    JTextField jTextField4 = new JTextField(widthColumText + 7);
    one4.add(label4);
    one4.add(jButton4);
    one4.add(jTextField4);
    jButton4.addActionListener(actionEvent -> {
      MathSet mathSetMain = new MathSet();
      MathSet mathSet11 = new MathSet();
      mathSet11.add(7.5, 7, 3, null, null);
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 12, 13);
      MathSet mathSet3 = new MathSet();
      mathSet3.add(1000, 9999);
      mathSetMain.join(mathSet11, mathSet2, mathSet3);
      String input = "elements = ";
      for (int i = 0; i < mathSetMain.getNumbers().length; i++) {
        input = input + mathSetMain.getNumbers()[i] + ", ";
      }
      jTextField4.setText(input);
    });
    buttonsPanel.add(one4);

    JPanel one5 = new JPanel(new FlowLayout());
    JLabel label5 = new JLabel(
        "new MathSet(7, 7, 3, null, null).intersection(new MathSet(11, 12, 12, 13, 7, 3, null))");
    JButton jButton5 = new JButton("OK");
    JTextField jTextField5 = new JTextField(widthColumText);
    one5.add(label5);
    one5.add(jButton5);
    one5.add(jTextField5);
    jButton5.addActionListener(actionEvent -> {
      MathSet mathSetMain = new MathSet();
      mathSetMain.add(7, 7, 3, null, null);
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 12, 13, 7, 3, null);
      mathSetMain.intersection(mathSet2);
      String input = "elements = ";
      for (int i = 0; i < mathSetMain.getNumbers().length; i++) {
        input = input + mathSetMain.getNumbers()[i] + ", ";
      }
      jTextField5.setText(input);
    });
    buttonsPanel.add(one5);

    JPanel one6 = new JPanel(new FlowLayout());
    JLabel label6 = new JLabel(
        "new MathSet(7, 7, 3).intersection(new MathSet(11, 12, 3), new MathSet(123, 234234, 3),new MathSet(3, 3456435));");
    JButton jButton6 = new JButton("OK");
    JTextField jTextField6 = new JTextField(widthColumText);
    one6.add(label6);
    one6.add(jButton6);
    one6.add(jTextField6);
    jButton6.addActionListener(actionEvent -> {
      MathSet mathSetMain = new MathSet();
      mathSetMain.add(7, 7, 3);
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 3);
      MathSet mathSet3 = new MathSet();
      mathSet3.add(123, 234234, 3);
      MathSet mathSet4 = new MathSet();
      mathSet4.add(3, 3456435, 7);
      mathSetMain.intersection(mathSet2, mathSet3, mathSet4);
      String input = "elements = ";
      for (int i = 0; i < mathSetMain.getNumbers().length; i++) {
        input = input + mathSetMain.getNumbers()[i] + ", ";
      }
      jTextField6.setText(input);
    });
    buttonsPanel.add(one6);

    JPanel one7 = new JPanel(new FlowLayout());
    JLabel label7 = new JLabel("new MathSet(11, 12, 12, 13, 7, 3, null).sortDesc()");
    JButton jButton7 = new JButton("OK");
    JTextField jTextField7 = new JTextField(widthColumText);
    one7.add(label7);
    one7.add(jButton7);
    one7.add(jTextField7);
    jButton7.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 12, 13, 7, 3, null);
      mathSet2.sortDesc();
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField7.setText(input);
    });
    buttonsPanel.add(one7);

    JPanel one8 = new JPanel(new FlowLayout());
    JLabel label8 = new JLabel("new MathSet(11, 12, 12, 13, 7, 3, null).sortDesc(2, 5)");
    JButton jButton8 = new JButton("OK");
    JTextField jTextField8 = new JTextField(widthColumText);
    one8.add(label8);
    one8.add(jButton8);
    one8.add(jTextField8);
    jButton8.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 12, 13, 7, 3, null);
      mathSet2.sortDesc(2, 5);
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField8.setText(input);
    });
    buttonsPanel.add(one8);

    JPanel one9 = new JPanel(new FlowLayout());
    JLabel label9 = new JLabel("new MathSet(11, 12, 99, 12, 13, 7, 3).sortDesc(99)");
    JButton jButton9 = new JButton("OK");
    JTextField jTextField9 = new JTextField(widthColumText);
    one9.add(label9);
    one9.add(jButton9);
    one9.add(jTextField9);
    jButton9.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 12, 13, 7, 3);
      mathSet2.sortDesc(99);
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField9.setText(input);
    });
    buttonsPanel.add(one9);

    JPanel one10 = new JPanel(new FlowLayout());
    JLabel label10 = new JLabel("new MathSet(11, 12, 12, 13, 7, 3, null).sortAsc()");
    JButton jButton10 = new JButton("OK");
    JTextField jTextField10 = new JTextField(widthColumText);
    one10.add(label10);
    one10.add(jButton10);
    one10.add(jTextField10);
    jButton10.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 12, 13, 7, 3, null);
      mathSet2.sortAsc();
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField10.setText(input);
    });
    buttonsPanel.add(one10);

    JPanel one11 = new JPanel(new FlowLayout());
    JLabel label11 = new JLabel("new MathSet(11, 12, 12, 13, 7, 3, null).sortAsc(2, 5)");
    JButton jButton11 = new JButton("OK");
    JTextField jTextField11 = new JTextField(widthColumText);
    one11.add(label11);
    one11.add(jButton11);
    one11.add(jTextField11);
    jButton11.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 12, 13, 7, 3, null);
      mathSet2.sortAsc(2, 5);
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField11.setText(input);
    });
    buttonsPanel.add(one11);

    JPanel one12 = new JPanel(new FlowLayout());
    JLabel label12 = new JLabel("new MathSet(11, 12, 99, 12, 13, 7, 3).sortAsc(99)");
    JButton jButton12 = new JButton("OK");
    JTextField jTextField12 = new JTextField(widthColumText);
    one12.add(label12);
    one12.add(jButton12);
    one12.add(jTextField12);
    jButton12.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 12, 13, 7, 3);
      mathSet2.sortAsc(99);
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField12.setText(input);
    });
    buttonsPanel.add(one12);

    JPanel one13 = new JPanel(new FlowLayout());
    JLabel label13 = new JLabel("new MathSet(11, 12, 99, 12, 13, 7, 3).get(2)");
    JButton jButton13 = new JButton("OK");
    JTextField jTextField13 = new JTextField(widthColumText);
    one13.add(label13);
    one13.add(jButton13);
    one13.add(jTextField13);
    jButton13.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 12, 13, 7, 3);
      String input = "Number element = " + mathSet2.get(2);
      jTextField13.setText(input);
    });
    buttonsPanel.add(one13);

    JPanel one14 = new JPanel(new FlowLayout());
    JLabel label14 = new JLabel("new MathSet(11, 12, 99, 12, 13, 7, 3).getMax()");
    JButton jButton14 = new JButton("OK");
    JTextField jTextField14 = new JTextField(widthColumText);
    one14.add(label14);
    one14.add(jButton14);
    one14.add(jTextField14);
    jButton14.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 12, 13, 7, 3);
      String input = "Number MAXelement = " + mathSet2.getMax();
      jTextField14.setText(input);
    });
    buttonsPanel.add(one14);

    JPanel one15 = new JPanel(new FlowLayout());
    JLabel label15 = new JLabel("new MathSet(11, 12, 99, 12, 13, 7, 3).getMin()");
    JButton jButton15 = new JButton("OK");
    JTextField jTextField15 = new JTextField(widthColumText);
    one15.add(label15);
    one15.add(jButton15);
    one15.add(jTextField15);
    jButton15.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 12, 13, 7, 3);
      String input = "Number MINelement = " + mathSet2.getMin();
      jTextField15.setText(input);
    });
    buttonsPanel.add(one15);

    JPanel one16 = new JPanel(new FlowLayout());
    JLabel label16 = new JLabel("new MathSet(11, 12, 99, 12, 13, 7, 3).getAverage()");
    JButton jButton16 = new JButton("OK");
    JTextField jTextField16 = new JTextField(widthColumText);
    one16.add(label16);
    one16.add(jButton16);
    one16.add(jTextField16);
    jButton16.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 13, 7, 3);
      String input = "Average = " + mathSet2.getAverage();
      jTextField16.setText(input);
    });
    buttonsPanel.add(one16);

    JPanel one17 = new JPanel(new FlowLayout());
    JLabel label17 = new JLabel("new MathSet(11, 12, 99, 12, 13, 7, 3, 9).getMedian");
    JButton jButton17 = new JButton("OK");
    JTextField jTextField17 = new JTextField(widthColumText);
    one17.add(label17);
    one17.add(jButton17);
    one17.add(jTextField17);
    jButton17.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 13, 7, 3, 9);
      String input = "Average = " + mathSet2.getMedian();
      jTextField17.setText(input);
    });
    buttonsPanel.add(one17);

    JPanel one18 = new JPanel(new FlowLayout());
    JLabel label18 = new JLabel("new MathSet(11, 12, 99, 13, 13, 7, 3, 9).toArray().toString()");
    JButton jButton18 = new JButton("OK");
    JTextField jTextField18 = new JTextField(widthColumText + 10);
    one18.add(label18);
    one18.add(jButton18);
    one18.add(jTextField18);
    jButton18.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 13, 13, 7, 3, 9);
      String input = mathSet2.toArray().toString() + " = ";
      for (int i = 0; i < mathSet2.toArray().length; i++) {
        input = input + mathSet2.toArray()[i] + ", ";
      }
      jTextField18.setText(input);
    });
    buttonsPanel.add(one18);

    JPanel one19 = new JPanel(new FlowLayout());
    JLabel label19 = new JLabel(
        "new MathSet(11, 12, 99, 13, 13, 7, 3, 9).toArray(2, 5).toString()");
    JButton jButton19 = new JButton("OK");
    JTextField jTextField19 = new JTextField(widthColumText);
    one19.add(label19);
    one19.add(jButton19);
    one19.add(jTextField19);
    jButton19.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 13, 13, 7, 3, 9);
      final Number[] numbers = mathSet2.toArray(2, 5);
      String input = numbers.toString() + " = ";
      for (int i = 0; i < numbers.length; i++) {
        input = input + numbers[i] + ", ";
      }
      jTextField19.setText(input);
    });
    buttonsPanel.add(one19);

    JPanel one20 = new JPanel(new FlowLayout());
    JLabel label20 = new JLabel("new MathSet(11, 12, 99, 13, 13, 7, 3, 9).cut(2, 5)");
    JButton jButton20 = new JButton("OK");
    JTextField jTextField20 = new JTextField(widthColumText);
    one20.add(label20);
    one20.add(jButton20);
    one20.add(jTextField20);
    jButton20.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 13, 13, 7, 3, 9);
      MathSet mathSet = mathSet2.cut(2, 5);
      String input = "elements = ";
      for (int i = 0; i < mathSet.getNumbers().length; i++) {
        input = input + mathSet.getNumbers()[i] + ", ";
      }
      jTextField20.setText(input);
    });
    buttonsPanel.add(one20);

    JPanel one21 = new JPanel(new FlowLayout());
    JLabel label21 = new JLabel("new MathSet(11, 12).clear()");
    JButton jButton21 = new JButton("OK");
    JTextField jTextField21 = new JTextField(widthColumText);
    one21.add(label21);
    one21.add(jButton21);
    one21.add(jTextField21);
    jButton21.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12);
      mathSet2.clear();
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField21.setText(input);
    });

    JLabel label22 = new JLabel("new MathSet(11, 12, 99, 13, 13, 7, 3, 9).clear(11, 13, 2, 3)");
    JButton jButton22 = new JButton("OK");
    JTextField jTextField22 = new JTextField(widthColumText);
    one21.add(label22);
    one21.add(jButton22);
    one21.add(jTextField22);
    jButton22.addActionListener(actionEvent -> {
      MathSet mathSet2 = new MathSet();
      mathSet2.add(11, 12, 99, 13, 13, 7, 3, 9);
      Number[] clear = {11, 13, 2, 3};
      mathSet2.clear(clear);
      String input = "elements = ";
      for (int i = 0; i < mathSet2.getNumbers().length; i++) {
        input = input + mathSet2.getNumbers()[i] + ", ";
      }
      jTextField22.setText(input);
    });
    buttonsPanel.add(one21);
    add(buttonsPanel, BorderLayout.SOUTH);
    pack();
  }
}