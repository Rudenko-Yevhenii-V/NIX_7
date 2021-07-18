import javax.swing.*;
import java.awt.*;

public class MyWindowApp extends JFrame { 
    public MyWindowApp(){
        super("Compiler and runner java app");
        setBounds(100, 100, 1200, 1000); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("You NEED!!! COMPILE AND RUN APP ON : " + System.getProperty("os.name") + " YOUR OS system!!!");
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton jButton1 = new JButton("linux");
        JButton jButton2 = new JButton("windows");
        buttonsPanel.add(label, BorderLayout.WEST);
        buttonsPanel.add(jButton1);
        buttonsPanel.add(jButton2);
        add(buttonsPanel, BorderLayout.SOUTH);
        pack();
        jButton1.addActionListener(e ->{
            setVisible(false);
                    new LinuxApp().setVisible(true);
        }
                );
        jButton2.addActionListener(e ->{
                    setVisible(false);
                    new WindowApp().setVisible(true);
                }
        );
    }
}