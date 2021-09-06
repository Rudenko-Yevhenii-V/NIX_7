package ry.rudenko.yevhenii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ry.rudenko.yevhenii.nixSONlib.SimplMapper;

public class Main {

  public static void main(String[] args) {
    System.out.println("Main.main");
    List<String> list = new ArrayList<>();
    SimplMapper simplMapper = new SimplMapper();
    System.out.println("simplMapper.writeValue(Collections.singletonList(list)) = " + simplMapper
        .writeValue(Collections.singletonList(list)));
  }
}
