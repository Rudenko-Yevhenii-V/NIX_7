package ry.rudenko.taskLevel1.task3;

public class AreaOfTriangle {

  public AreaOfTriangle() {

  }

  public long CalculateAreaOfTriangleFromVertices(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
    if (((Ax == Bx) && (Ay == By)) || ((Ax == Cx) && (Ay == Cy)) || ((Cx == Bx) && (Cy == By))) {
      return 0;
    } else {
      long S = ((Ax * By + Bx * Cy + Cx * Ay) - (Ay * Bx + By * Cx + Cy * Ax)) / 2;
      return Math.abs(S);
    }

  }
}
