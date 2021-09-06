package ry.rudenko.yevhenii;

import ry.rudenko.yevhenii.nixSONlib.SimplMapper;

/**
 * @author Rudenko Yevhenii
 * @created 06/09/2021 - 9:35 PM
 * @project NIX_7
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("Main.main");
    SimplMapper simplMapper = new SimplMapper();
    simplMapper.writeValue();
  }
}
