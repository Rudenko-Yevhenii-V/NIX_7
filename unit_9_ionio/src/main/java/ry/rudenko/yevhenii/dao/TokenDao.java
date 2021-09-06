package ry.rudenko.yevhenii.dao;

import ry.rudenko.yevhenii.entity.Token;

public interface TokenDao {

    void create(Token token);
    boolean existByToken(String token);
    Token findByToken(String token);
}
