package ry.rudenko.yevhenii.service;

public interface SecurityService {

    String login(String email, String password);
    String findUserIdByToken(String token);
}
