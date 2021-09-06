package ry.rudenko.yevhenii.bd;

import org.junit.jupiter.api.Test;


class DelTEstSONTest {

  @Test
  void makeJSON() {
    DelTEstSON delTEstSON = new DelTEstSON();
    delTEstSON.MakeJSON();
  }
  @Test
  void ExecJSON() {
    DelTEstSON delTEstSON = new DelTEstSON();
    delTEstSON.ExecJson();
  }

}