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

public class WindowMethods extends JFrame {
  private int widthColumText = 25;
  private int widthColumTextinput = 10;


  public WindowMethods() {
    super("CollectionsMethods");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel buttonsPanel = new JPanel(new GridLayout(0,1));
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
        String input = "mathSet elements = " ;
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
        String input = "mathSet elements = " ;
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
      String input = "mathSet elements = " ;
      for (int i = 0; i < mathSetMain.getNumbers().length; i++) {
        input = input + mathSetMain.getNumbers()[i] + ", ";
      }
      jTextField3.setText(input);
    });
    buttonsPanel.add(one3);

        JPanel one4 = new JPanel(new FlowLayout());
    JLabel label4 = new JLabel("new MathSet().join(new MathSet().add(7.5, 7, 3, null, null), new MathSet().add(11, 12, 12, 13), new MathSet().add(1000, 9999))\n");
    JButton jButton4 = new JButton("OK");
    JTextField jTextField4 = new JTextField(widthColumText+7);
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
      String input = "mathSet elements = " ;
      for (int i = 0; i < mathSetMain.getNumbers().length; i++) {
        input = input + mathSetMain.getNumbers()[i] + ", ";
      }
      jTextField4.setText(input);
    });
    buttonsPanel.add(one4);

    JPanel one5 = new JPanel(new FlowLayout());
    JLabel label5 = new JLabel("new MathSet(7, 7, 3, null, null).intersection(new MathSet(11, 12, 12, 13, 7, 3, null))");
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
      String input = "mathSet elements = " ;
      for (int i = 0; i < mathSetMain.getNumbers().length; i++) {
        input = input + mathSetMain.getNumbers()[i] + ", ";
      }
      jTextField5.setText(input);
    });
    buttonsPanel.add(one5);

    JPanel one6 = new JPanel(new FlowLayout());
    JLabel label6 = new JLabel("");
    JTextField jTextFieldiput6 = new JTextField(widthColumTextinput);
    JButton jButton6 = new JButton("OK");
    JTextField jTextField6 = new JTextField(widthColumText);
    one6.add(label6);
    one6.add(jTextFieldiput6);
    one6.add(jButton6);
    one6.add(jTextField6);
    jButton6.addActionListener(actionEvent -> {

      String input = "mathSet elements = " ;
      jTextField6.setText(input);
    });
    buttonsPanel.add(one6);

    JPanel one7 = new JPanel(new FlowLayout());
    JLabel label7 = new JLabel("MathSet()");
    JTextField jTextFieldiput7 = new JTextField(widthColumTextinput);
    JButton jButton7 = new JButton("OK");
    JTextField jTextField7 = new JTextField(widthColumText);
    one7.add(label7);
    one7.add(jTextFieldiput7);
    one7.add(jButton7);
    one7.add(jTextField7);
    jButton7.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField7.setText(input);
    });
    buttonsPanel.add(one7);

    JPanel one8 = new JPanel(new FlowLayout());
    JLabel label8 = new JLabel("MathSet()");
    JTextField jTextFieldiput8 = new JTextField(widthColumTextinput);
    JButton jButton8 = new JButton("OK");
    JTextField jTextField8 = new JTextField(widthColumText);
    one8.add(label8);
    one8.add(jTextFieldiput8);
    one8.add(jButton8);
    one8.add(jTextField8);
    jButton8.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField8.setText(input);
    });
    buttonsPanel.add(one8);

    JPanel one9 = new JPanel(new FlowLayout());
    JLabel label9 = new JLabel("MathSet()");
    JTextField jTextFieldiput9 = new JTextField(widthColumTextinput);
    JButton jButton9 = new JButton("OK");
    JTextField jTextField9 = new JTextField(widthColumText);
    one9.add(label9);
    one9.add(jTextFieldiput9);
    one9.add(jButton9);
    one9.add(jTextField9);
    jButton9.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField9.setText(input);
    });
    buttonsPanel.add(one9);

    JPanel one10 = new JPanel(new FlowLayout());
    JLabel label10 = new JLabel("MathSet()");
    JTextField jTextFieldiput10 = new JTextField(widthColumTextinput);
    JButton jButton10 = new JButton("OK");
    JTextField jTextField10 = new JTextField(widthColumText);
    one10.add(label10);
    one10.add(jTextFieldiput10);
    one10.add(jButton10);
    one10.add(jTextField10);
    jButton10.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField10.setText(input);
    });
    buttonsPanel.add(one10);

    JPanel one11 = new JPanel(new FlowLayout());
    JLabel label11 = new JLabel("MathSet()11");
    JTextField jTextFieldiput11 = new JTextField(widthColumTextinput);
    JButton jButton11 = new JButton("OK");
    JTextField jTextField11 = new JTextField(widthColumText);
    one11.add(label11);
    one11.add(jTextFieldiput11);
    one11.add(jButton11);
    one11.add(jTextField11);
    jButton11.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField11.setText(input);
    });
    buttonsPanel.add(one11);

    JPanel one12 = new JPanel(new FlowLayout());
    JLabel label12 = new JLabel("MathSet()12");
    JTextField jTextFieldiput12 = new JTextField(widthColumTextinput);
    JButton jButton12 = new JButton("OK");
    JTextField jTextField12 = new JTextField(widthColumText);
    one12.add(label12);
    one12.add(jTextFieldiput12);
    one12.add(jButton12);
    one12.add(jTextField12);
    jButton12.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField12.setText(input);
    });
    buttonsPanel.add(one12);

    JPanel one13 = new JPanel(new FlowLayout());
    JLabel label13 = new JLabel("MathSet()13");
    JTextField jTextFieldiput13 = new JTextField(widthColumTextinput);
    JButton jButton13 = new JButton("OK");
    JTextField jTextField13 = new JTextField(widthColumText);
    one13.add(label13);
    one13.add(jTextFieldiput13);
    one13.add(jButton13);
    one13.add(jTextField13);
    jButton13.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField13.setText(input);
    });
    buttonsPanel.add(one13);

    JPanel one14 = new JPanel(new FlowLayout());
    JLabel label14 = new JLabel("MathSet()14");
    JTextField jTextFieldiput14 = new JTextField(widthColumTextinput);
    JButton jButton14 = new JButton("OK");
    JTextField jTextField14 = new JTextField(widthColumText);
    one14.add(label14);
    one14.add(jTextFieldiput14);
    one14.add(jButton14);
    one14.add(jTextField14);
    jButton14.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField14.setText(input);
    });
    buttonsPanel.add(one14);

    JPanel one15 = new JPanel(new FlowLayout());
    JLabel label15 = new JLabel("MathSet()");
    JTextField jTextFieldiput15 = new JTextField(widthColumTextinput);
    JButton jButton15 = new JButton("OK");
    JTextField jTextField15 = new JTextField(widthColumText);
    one15.add(label15);
    one15.add(jTextFieldiput15);
    one15.add(jButton15);
    one15.add(jTextField15);
    jButton15.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField15.setText(input);
    });
    buttonsPanel.add(one15);

    JPanel one16 = new JPanel(new FlowLayout());
    JLabel label16 = new JLabel("MathSet()16");
    JTextField jTextFieldiput16 = new JTextField(widthColumTextinput);
    JButton jButton16 = new JButton("OK");
    JTextField jTextField16 = new JTextField(widthColumText);
    one16.add(label16);
    one16.add(jTextFieldiput16);
    one16.add(jButton16);
    one16.add(jTextField16);
    jButton16.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField16.setText(input);
    });
    buttonsPanel.add(one16);

    JPanel one17 = new JPanel(new FlowLayout());
    JLabel label17 = new JLabel("MathSet()");
    JTextField jTextFieldiput17 = new JTextField(widthColumTextinput);
    JButton jButton17 = new JButton("OK");
    JTextField jTextField17 = new JTextField(widthColumText);
    one17.add(label17);
    one17.add(jTextFieldiput17);
    one17.add(jButton17);
    one17.add(jTextField17);
    jButton17.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField17.setText(input);
    });
    buttonsPanel.add(one17);

    JPanel one18 = new JPanel(new FlowLayout());
    JLabel label18 = new JLabel("MathSet()");
    JTextField jTextFieldiput18 = new JTextField(widthColumTextinput);
    JButton jButton18 = new JButton("OK");
    JTextField jTextField18 = new JTextField(widthColumText);
    one18.add(label18);
    one18.add(jTextFieldiput18);
    one18.add(jButton18);
    one18.add(jTextField18);
    jButton18.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField18.setText(input);
    });
    buttonsPanel.add(one18);

    JPanel one19 = new JPanel(new FlowLayout());
    JLabel label19 = new JLabel("MathSet()");
    JTextField jTextFieldiput19 = new JTextField(widthColumTextinput);
    JButton jButton19 = new JButton("OK");
    JTextField jTextField19 = new JTextField(widthColumText);
    one19.add(label19);
    one19.add(jTextFieldiput19);
    one19.add(jButton19);
    one19.add(jTextField19);
    jButton19.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField19.setText(input);
    });
    buttonsPanel.add(one19);

    JPanel one20 = new JPanel(new FlowLayout());
    JLabel label20 = new JLabel("MathSet()20");
    JTextField jTextFieldiput20 = new JTextField(widthColumTextinput);
    JButton jButton20 = new JButton("OK");
    JTextField jTextField20 = new JTextField(widthColumText);
    one20.add(label20);
    one20.add(jTextFieldiput20);
    one20.add(jButton20);
    one20.add(jTextField20);
    jButton20.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField20.setText(input);
    });
    buttonsPanel.add(one20);

    JPanel one21 = new JPanel(new FlowLayout());
    JLabel label21 = new JLabel("MathSet()21");
    JTextField jTextFieldiput21 = new JTextField(widthColumTextinput);
    JButton jButton21 = new JButton("OK");
    JTextField jTextField21 = new JTextField(widthColumText);
    one21.add(label21);
    one21.add(jTextFieldiput21);
    one21.add(jButton21);
    one21.add(jTextField21);
    jButton21.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField21.setText(input);
    });
    buttonsPanel.add(one21);

    JPanel one22 = new JPanel(new FlowLayout());
    JLabel label22 = new JLabel("MathSet()22");
    JTextField jTextFieldiput22 = new JTextField(widthColumTextinput);
    JButton jButton22 = new JButton("OK");
    JTextField jTextField22 = new JTextField(widthColumText);
    one22.add(label22);
    one22.add(jTextFieldiput22);
    one22.add(jButton22);
    one22.add(jTextField22);
    jButton22.addActionListener(actionEvent -> {
      MathSet mathSet = new MathSet();
      String input = "mathSet = " + mathSet;
      jTextField22.setText(input);
    });
    buttonsPanel.add(one22);

//    JPanel one = new JPanel(new FlowLayout());
//    JLabel label = new JLabel("MathSet()");
//    JTextField jTextFieldiput = new JTextField(widthColumTextinput);
//    JButton jButton = new JButton("OK");
//    JTextField jTextField = new JTextField(widthColumText);
//    one.add(label);
//    one.add(jTextFieldiput);
//    one.add(jButton);
//    one.add(jTextField);
//    jButton.addActionListener(actionEvent -> {
//      MathSet mathSet = new MathSet();
//      String input = "mathSet = " + mathSet;
//      jTextField.setText(input);
//    });
//    buttonsPanel.add(one);



    add(buttonsPanel, BorderLayout.SOUTH);
    pack();
  }
}