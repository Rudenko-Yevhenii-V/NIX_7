package ru.rudenko.nix.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.rudenko.nix.service.Parser;

/**
 * @author Rudenko Yevhenii
 * @created 20/08/2021 - 6:26 PM
 * @project NIX_7
 */
public class CommonTest {

  @Test
  void createTime() {
    Calendar calendar1;
    Calendar calendar2 = new Calendar(001, 00, 00, 00, 01,1, 1);
    Calendar calendar3 = new Calendar(1000*60*60*24+1);

    calendar1 = (Calendar) Parser.getInstance().ParseDdMmYyyyHhMmSsMSmsToCalendarDateFormat(
        "ome text 01-01-0001 Some text 00:00:00:001 Some tex", "dd/mm/yy hh:mm:ss:msmsms");
    Assertions.assertEquals(calendar2.getTime(), calendar3.getTime());
    Assertions.assertEquals(calendar1.getTime(), calendar2.getTime());
  }


}
