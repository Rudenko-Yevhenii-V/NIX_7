import javax.swing.*;
import java.awt.*;

public class WindowApp extends JFrame {

    public WindowApp(){
        super("Compiler and runner java app");
        setBounds(5, 5, 1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("COMPILE AND RUN - ");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JTextArea jTextArea = new JTextArea(40, 40);
        JScrollPane sp = new JScrollPane(jTextArea);
        JButton jButton1 = new JButton("console");
        JButton jButton2 = new JButton("ant");
        JButton jButton3 = new JButton("maven");
        buttonsPanel.add(sp);
        buttonsPanel.add(label, BorderLayout.WEST);

        buttonsPanel.add(jButton1);
        buttonsPanel.add(jButton2);
        buttonsPanel.add(jButton3);
        add(buttonsPanel, BorderLayout.SOUTH);
        pack();
        jButton1.addActionListener(e -> new BatStarter().start("startConsole.bat", jTextArea));
        jButton2.addActionListener(e -> new BatStarter().start("startAnt.bat", jTextArea));
        jButton3.addActionListener(e -> new BatStarter().start("startMaven.bat", jTextArea));
    }
}
