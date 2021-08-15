package ru.rudenko.nix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import ru.rudenko.nix.Windows.LoginWindow;
import ru.rudenko.nix.Windows.RegWindow;
import ru.rudenko.nix.Windows.ShowModule;
import ua.com.alevel.controller.UserController;

public class Unit6Main {

  public static void main(String[] args) {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    UserController userController = new UserController();
//    userController.createForCRUD(reader);
//    String tokken = userController.loginForCRUD(reader);
//    System.out.println(tokken);
    RegWindow loginWindow = new RegWindow();
    loginWindow.setVisible(true);

  }
}
