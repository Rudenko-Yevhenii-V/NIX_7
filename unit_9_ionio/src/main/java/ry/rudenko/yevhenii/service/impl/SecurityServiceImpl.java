package ry.rudenko.yevhenii.service.impl;

import ry.rudenko.yevhenii.dao.TokenDao;
import ry.rudenko.yevhenii.dao.UserDao;
import ry.rudenko.yevhenii.dao.impl.TokenDaoImpl;
import ry.rudenko.yevhenii.dao.impl.UserDaoImpl;
import ry.rudenko.yevhenii.entity.Token;
import ry.rudenko.yevhenii.entity.User;
import ry.rudenko.yevhenii.service.SecurityService;
import ry.rudenko.yevhenii.util.SecurityUtil;

import java.util.UUID;

public class SecurityServiceImpl implements SecurityService {

    private final UserDao userDao = new UserDaoImpl();
    private final TokenDao tokenDao = new TokenDaoImpl();

    @Override
    public String login(String email, String password) throws NullPointerException  {
        Token token = new Token();
        String hashPassword = SecurityUtil.hashPassword(password);
        User user = userDao.findUserIdByEmailAndPassword(email, hashPassword);
        token.setUserId(user.getId());
        token.setToken(generateToken());
        tokenDao.create(token);
        return token.getToken();
    }

    @Override
    public String findUserIdByToken(String token) {
        Token tokenEntity = tokenDao.findByToken(token);
        return tokenEntity.getUserId();
    }

    private String generateToken() {
        String token = UUID.randomUUID().toString();
        if (tokenDao.existByToken(token)) {
            return generateToken();
        }
        return token;
    }
}
