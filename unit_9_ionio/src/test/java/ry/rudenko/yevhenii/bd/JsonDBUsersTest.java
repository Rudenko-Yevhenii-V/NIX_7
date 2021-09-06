package ry.rudenko.yevhenii.bd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ry.rudenko.yevhenii.entity.Token;
import ry.rudenko.yevhenii.entity.User;

/**
 * @author Rudenko Yevhenii
 * @created 06/09/2021 - 4:41 PM
 * @project NIX_7
 */
class JsonDBUsersTest {

//  @Test
//  void getInstance() {
//  }

  @Test
  void create() {
    JsonDBUsers jsonDBUsers = JsonDBUsers.getInstance();
    int chengeUser = 2;
    User user1 = new User();
    user1.setId("Id " + chengeUser);
    user1.setFirstName("FirstName" + chengeUser);
    user1.setLastName("LastName" + chengeUser);
    user1.setEmail("Email" + chengeUser);
    user1.setPassword("Password" + chengeUser);
    List<User> list = new ArrayList<>();
    list.add(user1);
    jsonDBUsers.writeUsers(list);
  }
  @Test
  void createToken() {
    JsonDBUsers jsonDBUsers = JsonDBUsers.getInstance();
    int chengeUser = 4;
    Token token1 = new Token();
    token1.setId("id " + chengeUser);
    token1.setToken("Token " + chengeUser);
    token1.setUserId("UserId " + chengeUser);
    jsonDBUsers.createToken(token1);
  }

  @Test
  void update() {
  }

  @Test
  void delete() {
  }

  @Test
  void findAll() {
  }

  @Test
  void existByEmail() {
  }

  @Test
  void existById() {
  }

  @Test
  void findById() {
  }

  @Test
  void findUserIdByEmailAndPassword() {
  }



  @Test
  void existByToken() {
  }

  @Test
  void findByToken() {
  }

  @Test
  void write() {
  }

  @Test
  void read() {
  }
}