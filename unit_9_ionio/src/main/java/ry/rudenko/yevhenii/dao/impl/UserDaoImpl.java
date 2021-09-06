package ry.rudenko.yevhenii.dao.impl;

import ry.rudenko.yevhenii.bd.JsonDBUsers;
import ry.rudenko.yevhenii.dao.UserDao;
import ry.rudenko.yevhenii.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void create(User user) {
        JsonDBUsers.getInstance().create(user);
    }

    @Override
    public void update(User user) {
        JsonDBUsers.getInstance().update(user);
    }

    @Override
    public void delete(String id) {
        JsonDBUsers.getInstance().delete(id);
    }

    @Override
    public User findById(String id) {
        return JsonDBUsers.getInstance().findById(id);
    }

    @Override
    public List<User> findAll() {
        return JsonDBUsers.getInstance().findAll();
    }

    @Override
    public boolean existByEmail(String email) {
        return JsonDBUsers.getInstance().existByEmail(email);
    }

    @Override
    public boolean existById(String id) {
        return false;
    }

    @Override
    public User findUserIdByEmailAndPassword(String email, String password) {
        return JsonDBUsers.getInstance().findUserIdByEmailAndPassword(email, password);
    }
}
