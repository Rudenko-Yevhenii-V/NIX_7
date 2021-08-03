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

public class AreaOfTriangle extends JFrame {
  public AreaOfTriangle() {
    super("HorseMove");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton button1 = new JButton("go to main");



    JPanel buttonsPanel = new JPanel(new GridLayout(5, 1));

    buttonsPanel.add(button1);


    add(buttonsPanel, BorderLayout.SOUTH);
    pack();

    button1.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );

  }
}