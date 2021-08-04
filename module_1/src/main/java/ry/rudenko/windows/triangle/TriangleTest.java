package ry.rudenko.windows.triangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ry.rudenko.taskLevel1.task3.AreaOfTriangle;
import ry.rudenko.windows.AreaOfTriangleWindow;
import ry.rudenko.windows.LevelOne;
import ry.rudenko.windows.ShowModule;

public class TriangleTest {

  private int Ax;
  private int Bx;
  private int By;
  private int Cx;
  private int Cy;
  private int Ay;
  private int Axprint;
  private int Bxprint;
  private int Byprint;
  private int Cxprint;
  private int Cyprint;
  private int Ayprint;
private boolean stop = false;

  public TriangleTest(String ax, String ay, String bx, String by, String cx, String cy) {
    Ax = checAndSetNumber(ax);
    Bx = checAndSetNumber(bx);
    By = checAndSetNumber(by);
    Cx = checAndSetNumber(cx);
    Cy = checAndSetNumber(cy);
    Ay = checAndSetNumber(ay);
    Axprint = checAndSetNumber(ax);
    Bxprint = checAndSetNumber(bx);
    Byprint = checAndSetNumber(by);
    Cxprint = checAndSetNumber(cx);
    Cyprint = checAndSetNumber(cy);
    Ayprint = checAndSetNumber(ay);


    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }

        JFrame frame = new JFrame("AreaOfTriangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(new TestPane());
        JButton jButtonToMain = new JButton("toMAIN");
        jButtonToMain.addActionListener(e -> {
              frame.setVisible(false);
              new ShowModule().setVisible(true);
            }
        );
        frame.add(jButtonToMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        if (stop){
          frame.setVisible(false);
        }else {
          frame.setVisible(true);
        }

      }
    });
  }

  public class TestPane extends JPanel {

    private TriangleShape triangleShape;
    private Polygon poly;

    public TestPane() {
      if ((Ax <= 10) && (Ay <= 10) && (Bx <= 10) && (By <= 10) && (Cx <= 10) && (Cy <= 10)) {
        Ax = Ax * 100;
        Bx = Bx * 100;
        By = By * 100;
        Cx = Cx * 100;
        Cy = Cy * 100;
        Ay = Ay * 100;
      } else if (((Ax <= 100) && (Bx <= 100) && (By <= 100) && (Cx <= 100) && (Cy <= 100) && (Ay
          <= 100))) {
        Ax = Ax * 10;
        Bx = Bx * 10;
        By = By * 10;
        Cx = Cx * 10;
        Cy = Cy * 10;
        Ay = Ay * 10;
      } else if (((Ax >= 1000) && (Bx >= 1000) && (By >= 1000) && (Cx >= 1000) && (Cy >= 1000) && (Ay
          >= 1000))) {
        Ax = Ax / 10;
        Bx = Bx / 10;
        By = By / 10;
        Cx = Cx / 10;
        Cy = Cy / 10;
        Ay = Ay / 10;
      } else {
        Ax = Ax;
        Bx = Bx;
        By = By;
        Cx = Cx;
        Cy = Cy;
        Ay = Ay;
      }
      triangleShape = new TriangleShape(
          new Point2D.Double(Ax, Ay),
          new Point2D.Double(Bx, By),
          new Point2D.Double(Cx, Cy)
      );

      poly = new Polygon(
          new int[]{Ax, Bx, Cx},
          new int[]{Ay, By, Cy},
          3);
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(1000, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();
      g2d.setColor(Color.GREEN);
      g2d.fill(poly);
      g2d.setColor(Color.RED);
      g2d.drawString("A(" + Axprint + "," + Ayprint + ")", Ax, Ay);
      g2d.drawString("B(" + Bxprint + "," + Byprint + ")", Bx, By);
      g2d.drawString("C(" + Cxprint + "," + Cyprint + ")", Cx, Cy);
      g2d.drawString("Area = "+
          new AreaOfTriangle().CalculateAreaOfTriangleFromVertices(Axprint, Ayprint,
              Bxprint, Byprint, Cxprint, Cyprint)
          + "CM3", Math.abs(Ax+Bx+Cx)/3, Math.abs(Ay+By+Cy)/3);

    }
  }

  public class TriangleShape extends Path2D.Double {

    public TriangleShape(Point2D... points) {
      moveTo(points[0].getX(), points[0].getY());
      lineTo(points[1].getX(), points[1].getY());
      lineTo(points[2].getX(), points[2].getY());
      closePath();
    }

  }
  int checAndSetNumber(String element){
    if ((element.matches("\\d+")) || (element.matches("-\\d+"))){
      return Integer.parseInt(element);
    }else {
        stop = true;
      AreaOfTriangleWindow areaOfTriangleWindow =  new AreaOfTriangleWindow();
      areaOfTriangleWindow.setFalse(element);
     areaOfTriangleWindow.setVisible(true);
    }
    return 1;
  }
}