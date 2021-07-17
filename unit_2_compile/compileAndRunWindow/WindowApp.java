import javax.swing.*;
import java.awt.*;

public class WindowApp extends JFrame {

    public WindowApp(){
        super("Compiler and runner java app");
        setBounds(100, 100, 1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("COMPILE AND RUN - ");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JTextArea jTextArea = new JTextArea(20, 40);
        JButton jButton1 = new JButton("console");
        JButton jButton2 = new JButton("ant");
        JButton jButton3 = new JButton("maven");
        buttonsPanel.add(jTextArea);
        jTextArea.setText("for windows is being developed!!!!!!!!!!");
        buttonsPanel.add(label, BorderLayout.WEST);
        buttonsPanel.add(jButton1);
        buttonsPanel.add(jButton2);
        buttonsPanel.add(jButton3);
        add(buttonsPanel, BorderLayout.SOUTH);
        pack();
        jButton1.addActionListener(e -> System.out.println("for windows is being developed"));
        jButton2.addActionListener(e -> System.out.println("for windows is being developed"));
        jButton3.addActionListener(e -> System.out.println("for windows is being developed"));
    }
}
