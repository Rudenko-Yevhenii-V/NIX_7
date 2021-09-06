package ry.rudenko.yevhenii.facade.impl;

import ry.rudenko.yevhenii.facade.SecurityFacade;
import ry.rudenko.yevhenii.service.SecurityService;
import ry.rudenko.yevhenii.service.impl.SecurityServiceImpl;

public class SecurityFacadeImpl implements SecurityFacade {

    private final SecurityService securityService = new SecurityServiceImpl();

    @Override
    public String login(String email, String password) throws NullPointerException{
        return securityService.login(email, password);
    }
}
