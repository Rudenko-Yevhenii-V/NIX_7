package ru.rudenko.nix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.Windows.ShowModule;

public class Unit6Main {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

  public static void main(String[] args) {
    LOGGER_INFO.info("Main test log info");
    LOGGER_WARN.warn("Main test log warn");
    LOGGER_ERROR.error("Main test log error");
    ShowModule showModule = new ShowModule();
    showModule.setVisible(true);
  }
}
