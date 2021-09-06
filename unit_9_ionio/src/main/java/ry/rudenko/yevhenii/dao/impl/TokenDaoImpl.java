package ry.rudenko.yevhenii.dao.impl;


import ry.rudenko.yevhenii.bd.JsonDBUsers;
import ry.rudenko.yevhenii.dao.TokenDao;
import ry.rudenko.yevhenii.entity.Token;

public class TokenDaoImpl implements TokenDao {

    @Override
    public void create(Token token) {
        JsonDBUsers.getInstance().createToken(token);
    }

    @Override
    public boolean existByToken(String token) {
        return JsonDBUsers.getInstance().existByToken(token);
    }

    @Override
    public Token findByToken(String token) {
        return JsonDBUsers.getInstance().findByToken(token);
    }
}
