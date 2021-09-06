package ry.rudenko.yevhenii;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ry.rudenko.yevhenii.windows.RegWindow;
import ry.rudenko.yevhenii.windows.ShowModule;

/**
 * @author Rudenko Yevhenii
 * @created 05/09/2021 - 10:35 AM
 * @project NIX_7
 */
public class MainIONIO {
  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  public static void main(String[] args) {
    LOGGER_INFO.info("test main");
//    RegWindow loginWindow = new RegWindow();
//    loginWindow.setVisible(true);
    ShowModule showModule = new ShowModule();
    showModule.setVisible(true);




  }
}
