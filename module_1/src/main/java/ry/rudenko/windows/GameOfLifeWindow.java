package ry.rudenko.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ry.rudenko.taskLevel3.task1.GameOfLife;

public class GameOfLifeWindow extends JFrame {

  static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment()
      .getScreenDevices()[0];
  private int rows;
  private int colums;
  private GameOfLife gameOfLife;
  private boolean[][] oneIteration;
  private JButton buttonGoToMain;
  private JButton buttonIterations;
  private JButton buttonStart;
  private JButton buttonStop;
  private JPanel mainPanel;
  private JPanel buttonsPanel;
  private JPanel botbuttonsPanel;
  private JPanel botbuttonsPanelStartStop;
  boolean start = true;

  public GameOfLifeWindow(String rows, String colums, GameOfLife gameOfLife) {

    super("Game of Life");
    this.rows = Integer.parseInt(rows);
    this.colums = Integer.parseInt(colums);
    this.gameOfLife = gameOfLife;
    if (this.rows > 30 || this.colums > 30) {
      this.device.setFullScreenWindow(this);
    }
    setBounds(1, 1, 800, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    oneIteration = gameOfLife.oneIteration();
    drawFrame(oneIteration);
    buttonIterations.addActionListener(e -> {
          this.setVisible(false);
          this.removeAll();
          new GameOfLifeWindow(rows, colums, gameOfLife).setVisible(true);
        }
    );
    buttonStop.addActionListener(e -> {
          start = false;
        }
    );
    buttonGoToMain.addActionListener(e -> {
          setVisible(false);
          new ShowModule().setVisible(true);
        }
    );
  }

  private void drawFrame(boolean[][] oneIterationBuff) {
    buttonGoToMain = new JButton("go to main");
    buttonIterations = new JButton("Press to next ITERATION");
    buttonStart = new JButton("Press to autoRUN");
    buttonStop = new JButton("Press to Stop");
    buttonIterations.setActionCommand("Press to next ITERATION");
    mainPanel = new JPanel(new BorderLayout());
    buttonsPanel = new JPanel(new GridLayout(this.rows, this.colums));
    botbuttonsPanel = new JPanel(new BorderLayout());
    botbuttonsPanelStartStop = new JPanel(new BorderLayout());
    botbuttonsPanel.setBackground(Color.GRAY);
    System.out.println(gameOfLife.printArray(oneIterationBuff));
    for (int i = 0; i < oneIterationBuff.length; i++) {
      for (int j = 0; j < oneIterationBuff[i].length; j++) {
        JButton b = new JButton();
        if (oneIterationBuff[i][j]) {
          b.setBackground(Color.RED);
        } else {
          b.setBackground(Color.WHITE);
        }
        buttonsPanel.add(b);
        b.setVisible(true);
      }
    }
    botbuttonsPanel.add(buttonIterations, BorderLayout.EAST);
    botbuttonsPanel.add(botbuttonsPanelStartStop, BorderLayout.CENTER);
    botbuttonsPanel.add(buttonGoToMain, BorderLayout.WEST);
    mainPanel.add(buttonsPanel, BorderLayout.NORTH);
    mainPanel.add(botbuttonsPanel, BorderLayout.SOUTH);
    add(mainPanel);
    pack();
  }
}
