package ry.rudenko.yevhenii;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    System.out.println("args = ");
  }
}
