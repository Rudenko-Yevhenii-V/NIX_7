package ry.rudenko.yevhenii.service.impl;

import ua.com.alevel.dao.TokenDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.impl.TokenDaoImpl;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.entity.Token;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.SecurityService;
import ua.com.alevel.util.SecurityUtil;

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
