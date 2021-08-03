package ry.rudenko.taskLevel1.task3;

public class AreaOfTriangle {

  public AreaOfTriangle() {

  }

  public long CalculateAreaOfTriangleFromVertices(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
    long S = ((Ax * By + Bx * Cy + Cx * Ay) - (Ay * Bx + By * Cx + Cy * Ax)) / 2;
    return Math.abs(S);
  }
}
