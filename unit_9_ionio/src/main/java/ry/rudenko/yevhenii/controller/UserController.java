package ry.rudenko.yevhenii.controller;

import ry.rudenko.yevhenii.facade.SecurityFacade;
import ry.rudenko.yevhenii.facade.UserFacade;
import ry.rudenko.yevhenii.facade.impl.SecurityFacadeImpl;
import ry.rudenko.yevhenii.facade.impl.UserFacadeImpl;

public class UserController {

  private final UserFacade userFacade = new UserFacadeImpl();
  private final SecurityFacade securityFacade = new SecurityFacadeImpl();


  public void createForCRUD(String email, String password) {
    userFacade.register(email, password);
  }



  public String loginForCRUD(String email, String password) {
    String token;
    try {
      token = securityFacade.login(email, password);
    }catch (Exception ex){
      return "NullPointerException";
    }
    return token;
  }
}
