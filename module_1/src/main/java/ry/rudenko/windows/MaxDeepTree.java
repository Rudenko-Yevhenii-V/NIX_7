package ry.rudenko.windows;

import static ry.rudenko.taskLevel2.task2.MaximumDepthOfBinaryTree.MaximumDepthOfBinaryTree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ry.rudenko.taskLevel2.task2.TreeNode;

public class MaxDeepTree extends JFrame {
  private  boolean visible = false;
  private static TreeNode root;
  public MaxDeepTree() {
    super("MaxDeepTree");
    setBounds(100, 100, 800, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//JPanel
    JPanel mainPanel = new JPanel(new GridLayout(9,1));
    JPanel jPanel = new JPanel();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    JPanel jPanel6 = new JPanel();
    JPanel jPanel7 = new JPanel();
    JPanel jPanelbottom = new JPanel();
 //JPanel
    JButton jButtonGoToMain = new JButton("Go To Main");
    JButton jButtonEnter = new JButton("Calculate deep");
    JLabel labelEnter = new JLabel("RESULT = ");
    JLabel labelSayEnter = new JLabel("PLEACE write number only(not letter or null!!!) and press enter every time!");
    JTextField jTextField1 = new JTextField(2);

    JTextField jTextField21 = new JTextField(2);
    JTextField jTextField22 = new JTextField(2);

    JTextField jTextField31 = new JTextField(2);
    JTextField jTextField32 = new JTextField(2);
    JTextField jTextField33 = new JTextField(2);
    JTextField jTextField34 = new JTextField(2);

    JTextField jTextField41 = new JTextField(2);
    JTextField jTextField42 = new JTextField(2);
    JTextField jTextField43 = new JTextField(2);
    JTextField jTextField44 = new JTextField(2);
    JTextField jTextField45 = new JTextField(2);
    JTextField jTextField46 = new JTextField(2);
    JTextField jTextField47 = new JTextField(2);
    JTextField jTextField48 = new JTextField(2);

    JTextField jTextField51 = new JTextField(2);
    JTextField jTextField52 = new JTextField(2);
    JTextField jTextField53 = new JTextField(2);
    JTextField jTextField54 = new JTextField(2);
    JTextField jTextField55 = new JTextField(2);
    JTextField jTextField56 = new JTextField(2);
    JTextField jTextField57 = new JTextField(2);
    JTextField jTextField58 = new JTextField(2);
    JTextField jTextField59 = new JTextField(2);
    JTextField jTextField510 = new JTextField(2);
    JTextField jTextField511 = new JTextField(2);
    JTextField jTextField512 = new JTextField(2);
    JTextField jTextField513 = new JTextField(2);
    JTextField jTextField514 = new JTextField(2);
    JTextField jTextField515 = new JTextField(2);
    JTextField jTextField516 = new JTextField(2);

    JTextField jTextField61 = new JTextField(2);
    JTextField jTextField62 = new JTextField(2);
    JTextField jTextField63 = new JTextField(2);
    JTextField jTextField64 = new JTextField(2);
    JTextField jTextField65 = new JTextField(2);
    JTextField jTextField66 = new JTextField(2);
    JTextField jTextField67 = new JTextField(2);
    JTextField jTextField68 = new JTextField(2);
    JTextField jTextField69 = new JTextField(2);
    JTextField jTextField610 = new JTextField(2);
    JTextField jTextField611 = new JTextField(2);
    JTextField jTextField612 = new JTextField(2);
    JTextField jTextField613 = new JTextField(2);
    JTextField jTextField614 = new JTextField(2);
    JTextField jTextField615 = new JTextField(2);
    JTextField jTextField616 = new JTextField(2);
    JTextField jTextField617 = new JTextField(2);
    JTextField jTextField618 = new JTextField(2);
    JTextField jTextField619 = new JTextField(2);
    JTextField jTextField620 = new JTextField(2);
    JTextField jTextField621 = new JTextField(2);
    JTextField jTextField622 = new JTextField(2);
    JTextField jTextField623 = new JTextField(2);
    JTextField jTextField624 = new JTextField(2);
    JTextField jTextField625 = new JTextField(2);
    JTextField jTextField626 = new JTextField(2);
    JTextField jTextField627 = new JTextField(2);
    JTextField jTextField628 = new JTextField(2);
    JTextField jTextField629 = new JTextField(2);
    JTextField jTextField630 = new JTextField(2);
    JTextField jTextField631 = new JTextField(2);
    JTextField jTextField632 = new JTextField(2);


//ADD
    jPanel1.add(jTextField1);
    jPanel.add(labelSayEnter);
    jPanel2.add(jTextField21);
    jPanel2.add(jTextField22);
    jPanel2.setVisible(visible);
    jPanel3.add(jTextField31);
    jPanel3.add(jTextField32);
    jPanel3.add(jTextField33);
    jPanel3.add(jTextField34);
    jPanel3.setVisible(visible);
    jPanel4.add(jTextField41);
    jPanel4.add(jTextField42);
    jPanel4.add(jTextField43);
    jPanel4.add(jTextField44);
    jPanel4.add(jTextField45);
    jPanel4.add(jTextField46);
    jPanel4.add(jTextField47);
    jPanel4.add(jTextField48);
    jPanel4.setVisible(visible);
    jPanel5.add(jTextField51);
    jPanel5.add(jTextField52);
    jPanel5.add(jTextField53);
    jPanel5.add(jTextField54);
    jPanel5.add(jTextField55);
    jPanel5.add(jTextField56);
    jPanel5.add(jTextField57);
    jPanel5.add(jTextField58);
    jPanel5.add(jTextField59);
    jPanel5.add(jTextField510);
    jPanel5.add(jTextField511);
    jPanel5.add(jTextField512);
    jPanel5.add(jTextField513);
    jPanel5.add(jTextField514);
    jPanel5.add(jTextField515);
    jPanel5.add(jTextField516);
    jPanel5.setVisible(visible);
    jPanel6.add(jTextField61);
    jPanel6.add(jTextField62);
    jPanel6.add(jTextField63);
    jPanel6.add(jTextField64);
    jPanel6.add(jTextField65);
    jPanel6.add(jTextField66);
    jPanel6.add(jTextField67);
    jPanel6.add(jTextField68);
    jPanel6.add(jTextField69);
    jPanel6.add(jTextField610);
    jPanel6.add(jTextField611);
    jPanel6.add(jTextField612);
    jPanel6.add(jTextField613);
    jPanel6.add(jTextField614);
    jPanel6.add(jTextField615);
    jPanel6.add(jTextField616);
    jPanel6.add(jTextField617);
    jPanel6.add(jTextField618);
    jPanel6.add(jTextField619);
    jPanel6.add(jTextField620);
    jPanel6.add(jTextField621);
    jPanel6.add(jTextField622);
    jPanel6.add(jTextField623);
    jPanel6.add(jTextField624);
    jPanel6.add(jTextField625);
    jPanel6.add(jTextField626);
    jPanel6.add(jTextField627);
    jPanel6.add(jTextField628);
    jPanel6.add(jTextField629);
    jPanel6.add(jTextField630);
    jPanel6.add(jTextField631);
    jPanel6.add(jTextField632);
    jPanel6.setVisible(visible);
    jPanel7.add(jButtonEnter);
    jPanel7.add(labelEnter);

    mainPanel.add(jPanel);
    mainPanel.add(jPanel1);
    mainPanel.add(jPanel2);
    mainPanel.add(jPanel3);
    mainPanel.add(jPanel4);
    mainPanel.add(jPanel5);
    mainPanel.add(jPanel6);
    mainPanel.add(jPanel7);

    mainPanel.add(jPanelbottom);
    jPanelbottom.add(jButtonGoToMain);
//addActionListener1
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel2.setVisible(true);
        root = new TreeNode(Integer.parseInt(jTextField1.getText()));
      }
    });
//addActionListener2
    jTextField21.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel3.setVisible(true);
        root.left =new TreeNode(Integer.parseInt(jTextField21.getText()));

      }
    });
    jTextField22.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel3.setVisible(true);
        root.right = new TreeNode(Integer.parseInt(jTextField22.getText()));
      }
    });
//addActionListener3
    jTextField31.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel4.setVisible(true);
        root.left.right = new TreeNode(Integer.parseInt(jTextField31.getText()));
      }
    });
    jTextField32.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel4.setVisible(true);
        root.left.left = new TreeNode(Integer.parseInt(jTextField32.getText()));
      }
    });
    jTextField33.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel4.setVisible(true);
        root.right.left = new TreeNode(Integer.parseInt(jTextField33.getText()));
      }
    });
    jTextField34.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel4.setVisible(true);
        root.right.right = new TreeNode(Integer.parseInt(jTextField34.getText()));
      }
    });
    //addActionListener4
    jTextField41.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.left.right.left = new TreeNode(Integer.parseInt(jTextField41.getText()));
      }
    });
    jTextField42.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.left.left.right = new TreeNode(Integer.parseInt(jTextField42.getText()));
      }
    });
    jTextField43.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.right.left.left = new TreeNode(Integer.parseInt(jTextField43.getText()));
      }
    });
    jTextField44.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.right.right.right = new TreeNode(Integer.parseInt(jTextField44.getText()));
      }
    });

    jTextField45.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.left.right.left = new TreeNode(Integer.parseInt(jTextField45.getText()));
      }
    });
    jTextField46.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.left.left.right = new TreeNode(Integer.parseInt(jTextField46.getText()));
      }
    });
    jTextField47.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.right.left.left = new TreeNode(Integer.parseInt(jTextField47.getText()));
      }
    });
    jTextField48.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel5.setVisible(true);
        root.right.right.right = new TreeNode(Integer.parseInt(jTextField48.getText()));
      }
    });
//addActionListener5
    jTextField51.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.right.left.left = new TreeNode(Integer.parseInt(jTextField51.getText()));
      }
    });
    jTextField52.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.left.right.right = new TreeNode(Integer.parseInt(jTextField52.getText()));
      }
    });
    jTextField53.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.left.left.left = new TreeNode(Integer.parseInt(jTextField53.getText()));
      }
    });
    jTextField54.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.right.right.right = new TreeNode(Integer.parseInt(jTextField54.getText()));
      }
    });

    jTextField55.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.right.left.left = new TreeNode(Integer.parseInt(jTextField55.getText()));
      }
    });
    jTextField56.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.left.right.right = new TreeNode(Integer.parseInt(jTextField56.getText()));
      }
    });
    jTextField57.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.left.left.left = new TreeNode(Integer.parseInt(jTextField57.getText()));
      }
    });
    jTextField58.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.right.right.right = new TreeNode(Integer.parseInt(jTextField58.getText()));
      }
    });
    jTextField59.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.right.left.left = new TreeNode(Integer.parseInt(jTextField59.getText()));
      }
    });
    jTextField510.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.left.right.right = new TreeNode(Integer.parseInt(jTextField510.getText()));
      }
    });
    jTextField511.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.left.left.left = new TreeNode(Integer.parseInt(jTextField511.getText()));
      }
    });
    jTextField512.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.right.right.right = new TreeNode(Integer.parseInt(jTextField512.getText()));
      }
    });

    jTextField513.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.right.left.left = new TreeNode(Integer.parseInt(jTextField513.getText()));
      }
    });
    jTextField514.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.left.left.right.right = new TreeNode(Integer.parseInt(jTextField514.getText()));
      }
    });
    jTextField515.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.left.left.left = new TreeNode(Integer.parseInt(jTextField515.getText()));
      }
    });
    jTextField516.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        jPanel6.setVisible(true);
        root.right.right.right.right = new TreeNode(Integer.parseInt(jTextField516.getText()));
      }
    });
//addActionListener6
    jTextField61.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField61.getText()));
      }
    });
    jTextField62.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField62.getText()));
      }
    });
    jTextField63.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField63.getText()));
      }
    });
    jTextField64.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField64.getText()));
      }
    });

    jTextField65.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField65.getText()));
      }
    });
    jTextField66.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField66.getText()));
      }
    });
    jTextField67.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField67.getText()));
      }
    });
    jTextField68.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField68.getText()));
      }
    });
    jTextField69.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField69.getText()));
      }
    });
    jTextField610.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField610.getText()));
      }
    });
    jTextField611.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField611.getText()));
      }
    });
    jTextField612.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField612.getText()));
      }
    });

    jTextField613.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField613.getText()));
      }
    });
    jTextField614.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField614.getText()));
      }
    });
    jTextField615.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField615.getText()));
      }
    });
    jTextField616.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField616.getText()));
      }
    });
    jTextField617.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField617.getText()));
      }
    });
    jTextField618.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField618.getText()));
      }
    });
    jTextField619.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField619.getText()));
      }
    });
    jTextField620.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField620.getText()));
      }
    });

    jTextField621.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField621.getText()));
      }
    });
    jTextField622.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField622.getText()));
      }
    });
    jTextField623.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField623.getText()));
      }
    });
    jTextField624.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField624.getText()));
      }
    });
    jTextField625.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField625.getText()));
      }
    });
    jTextField626.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField626.getText()));
      }
    });
    jTextField627.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField627.getText()));
      }
    });
    jTextField628.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField628.getText()));
      }
    });

    jTextField629.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.right.left.left.left = new TreeNode(Integer.parseInt(jTextField629.getText()));
      }
    });
    jTextField630.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.left.left.right.right.right = new TreeNode(Integer.parseInt(jTextField630.getText()));
      }
    });
    jTextField631.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.left.left.left.left = new TreeNode(Integer.parseInt(jTextField631.getText()));
      }
    });
    jTextField632.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent event) {
        root.right.right.right.right.right = new TreeNode(Integer.parseInt(jTextField632.getText()));
      }
    });
//jButtonEnter
    jButtonEnter.addActionListener(e -> {
      int actual = MaximumDepthOfBinaryTree(root);
      System.out.println(actual);
      labelEnter.setText("RESULT DEEP = " + (actual));
      labelEnter.setForeground(Color.RED);
        }
    );

    jButtonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );
    add(mainPanel, BorderLayout.SOUTH);
    pack();
  }
}
