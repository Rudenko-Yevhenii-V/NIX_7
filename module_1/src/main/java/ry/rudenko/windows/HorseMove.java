package ry.rudenko.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ry.rudenko.taskLevel1.task2.KnightsMoveValidator;

public class HorseMove extends JFrame {

  public HorseMove() {
    super("HorseMove");
    setBounds(100, 100, 800, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon iconKoHb = new ImageIcon(
        getClass().getClassLoader().getResource("images" + File.separator + "kohb.jpg"));
    iconKoHb.getImage().flush();

    JButton button1 = new JButton();
    button1.setBackground(Color.WHITE);
    JButton button2 = new JButton();
    button2.setBackground(Color.black);
    JButton button3 = new JButton();
    button3.setBackground(Color.WHITE);
    JButton button4 = new JButton();
    button4.setBackground(Color.black);
    JButton button5 = new JButton();
    button5.setBackground(Color.WHITE);
    JButton button6 = new JButton();
    button6.setBackground(Color.black);
    JButton button7 = new JButton();
    button7.setBackground(Color.WHITE);
    JButton button8 = new JButton();
    button8.setBackground(Color.black);
    JButton button9 = new JButton();
    button9.setBackground(Color.WHITE);
    JButton button10 = new JButton();
    button10.setBackground(Color.black);
    JButton button11 = new JButton();
    button11.setBackground(Color.WHITE);
    JButton button12 = new JButton();
    button12.setBackground(Color.black);
    JButton button13 = new JButton();
    button13.setBackground(Color.WHITE);
    JButton button14 = new JButton();
    button14.setBackground(Color.black);
    JButton button15 = new JButton();
    button15.setBackground(Color.WHITE);
    JButton button16 = new JButton();
    button16.setBackground(Color.black);
    JButton button17 = new JButton();
    button17.setBackground(Color.WHITE);
    JButton button18 = new JButton();
    button18.setBackground(Color.black);
    JButton button19 = new JButton();
    button19.setBackground(Color.WHITE);
    JButton button20 = new JButton();
    button20.setBackground(Color.black);
    JButton button21 = new JButton();
    button21.setBackground(Color.WHITE);
    JButton button22 = new JButton();
    button22.setBackground(Color.black);
    JButton button23 = new JButton();
    button23.setBackground(Color.WHITE);
    JButton button24 = new JButton();
    button24.setBackground(Color.black);
    JButton button25 = new JButton();
    button25.setBackground(Color.WHITE);
    button25.setIcon(iconKoHb);
    JButton button26 = new JButton();
    button26.setBackground(Color.black);
    JButton button27 = new JButton();
    button27.setBackground(Color.WHITE);
    JButton button28 = new JButton();
    button28.setBackground(Color.black);
    JButton button29 = new JButton();
    button29.setBackground(Color.WHITE);
    JButton button30 = new JButton();
    button30.setBackground(Color.black);
    JButton button31 = new JButton();
    button31.setBackground(Color.WHITE);
    JButton button32 = new JButton();
    button32.setBackground(Color.black);
    JButton button33 = new JButton();
    button33.setBackground(Color.WHITE);
    JButton button34 = new JButton();
    button34.setBackground(Color.black);
    JButton button35 = new JButton();
    button35.setBackground(Color.WHITE);
    JButton button36 = new JButton();
    button36.setBackground(Color.black);
    JButton button37 = new JButton();
    button37.setBackground(Color.white);
    JButton button38 = new JButton();
    button38.setBackground(Color.black);
    JButton button39 = new JButton();
    button39.setBackground(Color.white);
    JButton button40 = new JButton();
    button40.setBackground(Color.black);
    JButton button41 = new JButton();
    button41.setBackground(Color.white);
    JButton button42 = new JButton();
    button42.setBackground(Color.black);
    JButton button43 = new JButton();
    button43.setBackground(Color.white);
    JButton button44 = new JButton();
    button44.setBackground(Color.black);
    JButton button45 = new JButton();
    button45.setBackground(Color.white);
    JButton button46 = new JButton();
    button46.setBackground(Color.black);
    JButton button47 = new JButton();
    button47.setBackground(Color.white);
    JButton button48 = new JButton();
    button48.setBackground(Color.black);
    JButton button49 = new JButton();
    button49.setBackground(Color.white);

    JButton buttonGoToMain = new JButton("go to main");
    JPanel buttonsPanel = new JPanel(new GridLayout(8, 7));
    JPanel botbuttonsPanel = new JPanel(new FlowLayout());
    buttonsPanel.add(button1);
    buttonsPanel.add(button2);
    buttonsPanel.add(button3);
    buttonsPanel.add(button4);
    buttonsPanel.add(button5);
    buttonsPanel.add(button6);
    buttonsPanel.add(button7);
    buttonsPanel.add(button8);
    buttonsPanel.add(button9);
    buttonsPanel.add(button10);
    buttonsPanel.add(button11);
    buttonsPanel.add(button12);
    buttonsPanel.add(button13);
    buttonsPanel.add(button14);
    buttonsPanel.add(button15);
    buttonsPanel.add(button16);
    buttonsPanel.add(button17);
    buttonsPanel.add(button18);
    buttonsPanel.add(button19);
    buttonsPanel.add(button20);
    buttonsPanel.add(button21);
    buttonsPanel.add(button22);
    buttonsPanel.add(button23);
    buttonsPanel.add(button24);
    buttonsPanel.add(button25);
    buttonsPanel.add(button26);
    buttonsPanel.add(button27);
    buttonsPanel.add(button28);
    buttonsPanel.add(button29);
    buttonsPanel.add(button30);
    buttonsPanel.add(button31);
    buttonsPanel.add(button32);
    buttonsPanel.add(button33);
    buttonsPanel.add(button34);
    buttonsPanel.add(button35);
    buttonsPanel.add(button36);
    buttonsPanel.add(button37);
    buttonsPanel.add(button38);
    buttonsPanel.add(button39);
    buttonsPanel.add(button40);
    buttonsPanel.add(button41);
    buttonsPanel.add(button42);
    buttonsPanel.add(button43);
    buttonsPanel.add(button44);
    buttonsPanel.add(button45);
    buttonsPanel.add(button46);
    buttonsPanel.add(button47);
    buttonsPanel.add(button48);
    buttonsPanel.add(button49);
    buttonsPanel.add(botbuttonsPanel);

    botbuttonsPanel.add(buttonGoToMain);

    add(buttonsPanel, BorderLayout.SOUTH);
    pack();

    button1.addActionListener(e -> {
      if (new KnightsMoveValidator(4,4,1,1).isPossiblePath()){
        button1.setBackground(Color.GREEN);
      }else {
        button1.setBackground(Color.RED);
      }
        }
    );

    button2.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,1,2).isPossiblePath()){
            button2.setBackground(Color.GREEN);
          }else {
            button2.setBackground(Color.RED);
          }
        }
    );
    button3.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,1,3).isPossiblePath()){
            button3.setBackground(Color.GREEN);
          }else {
            button3.setBackground(Color.RED);
          }
        }
    );
    button4.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,1,4).isPossiblePath()){
            button4.setBackground(Color.GREEN);
          }else {
            button4.setBackground(Color.RED);
          }
        }
    );
    button5.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,1,5).isPossiblePath()){
            button5.setBackground(Color.GREEN);
          }else {
            button5.setBackground(Color.RED);
          }
        }
    );
    button6.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,1,6).isPossiblePath()){
            button6.setBackground(Color.GREEN);
          }else {
            button6.setBackground(Color.RED);
          }
        }
    );
    button7.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,1,7).isPossiblePath()){
            button7.setBackground(Color.GREEN);
          }else {
            button7.setBackground(Color.RED);
          }
        }
    );
    button8.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,2,1).isPossiblePath()){
            button8.setBackground(Color.GREEN);
          }else {
            button8.setBackground(Color.RED);
          }
        }
    );
    button9.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,2,2).isPossiblePath()){
            button9.setBackground(Color.GREEN);
          }else {
            button9.setBackground(Color.RED);
          }
        }
    );
    button10.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,2,3).isPossiblePath()){
            button10.setBackground(Color.GREEN);
          }else {
            button10.setBackground(Color.RED);
          }
        }
    );
    button11.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,2,4).isPossiblePath()){
            button11.setBackground(Color.GREEN);
          }else {
            button11.setBackground(Color.RED);
          }
        }
    );
    button12.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,2,5).isPossiblePath()){
            button12.setBackground(Color.GREEN);
          }else {
            button12.setBackground(Color.RED);
          }
        }
    );
    button13.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,2,6).isPossiblePath()){
            button13.setBackground(Color.GREEN);
          }else {
            button13.setBackground(Color.RED);
          }
        }
    );
    button14.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,2,7).isPossiblePath()){
            button14.setBackground(Color.GREEN);
          }else {
            button14.setBackground(Color.RED);
          }
        }
    );
    button15.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,3,1).isPossiblePath()){
            button15.setBackground(Color.GREEN);
          }else {
            button15.setBackground(Color.RED);
          }
        }
    );
    button16.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,3,2).isPossiblePath()){
            button16.setBackground(Color.GREEN);
          }else {
            button16.setBackground(Color.RED);
          }
        }
    );
    button17.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,3,3).isPossiblePath()){
            button17.setBackground(Color.GREEN);
          }else {
            button17.setBackground(Color.RED);
          }
        }
    );
    button18.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,3,4).isPossiblePath()){
            button18.setBackground(Color.GREEN);
          }else {
            button18.setBackground(Color.RED);
          }
        }
    );
    button19.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,3,5).isPossiblePath()){
            button19.setBackground(Color.GREEN);
          }else {
            button19.setBackground(Color.RED);
          }
        }
    );
    button20.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,3,6).isPossiblePath()){
            button20.setBackground(Color.GREEN);
          }else {
            button20.setBackground(Color.RED);
          }
        }
    );
    button21.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,3,7).isPossiblePath()){
            button21.setBackground(Color.GREEN);
          }else {
            button21.setBackground(Color.RED);
          }
        }
    );
    button22.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,4,1).isPossiblePath()){
            button22.setBackground(Color.GREEN);
          }else {
            button22.setBackground(Color.RED);
          }
        }
    );
    button23.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,4,2).isPossiblePath()){
            button23.setBackground(Color.GREEN);
          }else {
            button23.setBackground(Color.RED);
          }
        }
    );
    button24.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,4,3).isPossiblePath()){
            button24.setBackground(Color.GREEN);
          }else {
            button24.setBackground(Color.RED);
          }
        }
    );
    button25.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,4,4).isPossiblePath()){
            button25.setBackground(Color.GREEN);
          }else {
            button25.setBackground(Color.RED);
          }
        }
    );
    button26.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,4,5).isPossiblePath()){
            button26.setBackground(Color.GREEN);
          }else {
            button26.setBackground(Color.RED);
          }
        }
    );
    button27.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,4,6).isPossiblePath()){
            button27.setBackground(Color.GREEN);
          }else {
            button27.setBackground(Color.RED);
          }
        }
    );
    button28.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,4,7).isPossiblePath()){
            button28.setBackground(Color.GREEN);
          }else {
            button28.setBackground(Color.RED);
          }
        }
    );
    button29.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,5,1).isPossiblePath()){
            button29.setBackground(Color.GREEN);
          }else {
            button29.setBackground(Color.RED);
          }
        }
    );
    button30.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,5,2).isPossiblePath()){
            button30.setBackground(Color.GREEN);
          }else {
            button30.setBackground(Color.RED);
          }
        }
    );
    button31.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,5,3).isPossiblePath()){
            button31.setBackground(Color.GREEN);
          }else {
            button31.setBackground(Color.RED);
          }
        }
    );
    button32.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,5,4).isPossiblePath()){
            button32.setBackground(Color.GREEN);
          }else {
            button32.setBackground(Color.RED);
          }
        }
    );
    button33.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,5,5).isPossiblePath()){
            button33.setBackground(Color.GREEN);
          }else {
            button33.setBackground(Color.RED);
          }
        }
    );
    button34.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,5,6).isPossiblePath()){
            button34.setBackground(Color.GREEN);
          }else {
            button34.setBackground(Color.RED);
          }
        }
    );
    button35.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,5,7).isPossiblePath()){
            button35.setBackground(Color.GREEN);
          }else {
            button35.setBackground(Color.RED);
          }
        }
    );
    button36.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,6,1).isPossiblePath()){
            button36.setBackground(Color.GREEN);
          }else {
            button36.setBackground(Color.RED);
          }
        }
    );
    button37.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,6,2).isPossiblePath()){
            button37.setBackground(Color.GREEN);
          }else {
            button37.setBackground(Color.RED);
          }
        }
    );
    button38.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,6,3).isPossiblePath()){
            button38.setBackground(Color.GREEN);
          }else {
            button38.setBackground(Color.RED);
          }
        }
    );
    button39.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,6,4).isPossiblePath()){
            button39.setBackground(Color.GREEN);
          }else {
            button39.setBackground(Color.RED);
          }
        }
    );
    button40.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,6,5).isPossiblePath()){
            button40.setBackground(Color.GREEN);
          }else {
            button40.setBackground(Color.RED);
          }
        }
    );
    button41.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,6,6).isPossiblePath()){
            button41.setBackground(Color.GREEN);
          }else {
            button41.setBackground(Color.RED);
          }
        }
    );
    button42.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,6,7).isPossiblePath()){
            button42.setBackground(Color.GREEN);
          }else {
            button42.setBackground(Color.RED);
          }
        }
    );
    button43.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,7,1).isPossiblePath()){
            button43.setBackground(Color.GREEN);
          }else {
            button43.setBackground(Color.RED);
          }
        }
    );
    button44.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,7,2).isPossiblePath()){
            button44.setBackground(Color.GREEN);
          }else {
            button44.setBackground(Color.RED);
          }
        }
    );
    button45.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,7,3).isPossiblePath()){
            button45.setBackground(Color.GREEN);
          }else {
            button45.setBackground(Color.RED);
          }
        }
    );
    button46.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,7,4).isPossiblePath()){
            button46.setBackground(Color.GREEN);
          }else {
            button46.setBackground(Color.RED);
          }
        }
    );
    button47.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,7,5).isPossiblePath()){
            button47.setBackground(Color.GREEN);
          }else {
            button47.setBackground(Color.RED);
          }
        }
    );
    button48.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,7,6).isPossiblePath()){
            button48.setBackground(Color.GREEN);
          }else {
            button48.setBackground(Color.RED);
          }
        }
    );
    button49.addActionListener(e -> {
          if (new KnightsMoveValidator(4,4,7,7).isPossiblePath()){
            button49.setBackground(Color.GREEN);
          }else {
            button49.setBackground(Color.RED);
          }
        }
    );
    buttonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );

  }
}