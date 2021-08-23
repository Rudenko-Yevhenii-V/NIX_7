package ru.rudenko.nix.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.rudenko.nix.service.Parser;

public class CommonTest {

  @Test
  void createTime() {
    Calendar calendar1;
    Calendar calendar2 = new Calendar(1, 0, 0, 0, 1, 1, 1);
    Calendar calendar3 = new Calendar(1000 * 60 * 60 * 24 + 1);
    calendar1 = (Calendar) Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "ome text 01-01-0001 Some text 00:00:00:001 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Assertions.assertEquals(calendar2.getTime(), calendar3.getTime());
    Assertions.assertEquals(calendar1.getTime(), calendar2.getTime());
  }

  @Test
  void checkConvert() {
    Calendar calendar1 = new Calendar(0, 0, 0, 0, 0, 3, 1);
    Calendar calendar2 = new Calendar(calendar1.getTime());
    Assertions.assertEquals(calendar1.mounths, calendar2.mounths);
  }
}
