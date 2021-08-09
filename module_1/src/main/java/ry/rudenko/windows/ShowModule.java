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
import javax.swing.SwingConstants;

public class ShowModule extends JFrame {

    private String jLabelLVL1SetText;
    private JLabel labelTitle;
    private ImageIcon icon;

    public void setjLabelLVL1SetText(String jLabelLVL1SetText) {
        this.jLabelLVL1SetText = jLabelLVL1SetText;
    }

    public ShowModule() {
        super("MODULE1 for NIX 7!!!");
        setBounds(0, 0, 1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (System.getProperty("os.name").contains("W")) {
            icon = new ImageIcon(
                    getClass().getClassLoader().getResource("images/title.jpg"));
            icon.getImage().flush();
            labelTitle = new JLabel();
        } else {
            icon = new ImageIcon(
                    getClass().getClassLoader().getResource("images" + File.separator + "title.jpg"));
            icon.getImage().flush();
            labelTitle = new JLabel();
        }


        JLabel jLabelTest = new JLabel("<html>JUnit TEST</html>", SwingConstants.CENTER);
        JLabel jLabelLVL1 = new JLabel("<html>LEVEL 1</html>", SwingConstants.CENTER);
        JLabel jLabelLVL2 = new JLabel("<html>LEVEL 2</html>", SwingConstants.CENTER);
        JLabel jLabelLVL3 = new JLabel("<html>LEVEL 3</html>", SwingConstants.CENTER);
        labelTitle.setIcon(icon);
        JButton jButton1 = new JButton("select");
        JButton jButton2 = new JButton("select");
        JButton jButton3 = new JButton("select");
        JButton jButtonTest = new JButton("select");

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        JPanel jPanel1 = new JPanel(new FlowLayout());
        JPanel jPanel2 = new JPanel(new GridLayout(4, 2));

        JPanel jPanelForButton2 = new JPanel(new FlowLayout());
        JPanel jPanelForButton3 = new JPanel(new FlowLayout());
        JPanel jPanelForButton1 = new JPanel(new FlowLayout());
        JPanel jPanelForButtonTest = new JPanel(new FlowLayout());

        buttonsPanel.add(jPanel1);
        buttonsPanel.add(jPanel2);
        jPanel1.add(labelTitle);

        jPanelForButtonTest.add(jButtonTest);
        jPanel2.add(jLabelLVL1);
        jPanel2.add(jPanelForButton1);
        jPanelForButton1.add(jButton1);
        jPanel2.add(jLabelLVL2);
        jPanel2.add(jPanelForButton2);
        jPanelForButton2.add(jButton2);
        jPanel2.add(jLabelLVL3);
        jPanel2.add(jPanelForButton3);
        jPanelForButton3.add(jButton3);
        add(buttonsPanel, BorderLayout.SOUTH);
        pack();

        jButtonTest.addActionListener(e -> {
                    setVisible(false);
                    new StartTests().setVisible(true);
                }
        );
        jButton1.addActionListener(e -> {
                    setVisible(false);
                    new LevelOne().setVisible(true);
                }
        );

        jButton2.addActionListener(e -> {
                    setVisible(false);
                    new LevelTwo().setVisible(true);
                }
        );
        jButton3.addActionListener(e -> {
                    setVisible(false);
                    new LevelThree().setVisible(true);
                }
        );

    }
}