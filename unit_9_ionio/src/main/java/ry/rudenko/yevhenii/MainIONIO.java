package ry.rudenko.yevhenii;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ry.rudenko.yevhenii.windows.LoginWindow;

public class MainIONIO {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");

  public static void main(String[] args) {
    LOGGER_INFO.info("test main");
    LoginWindow loginWindow = new LoginWindow();
    loginWindow.setVisible(true);
  }
}
