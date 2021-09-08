package ry.rudenko.yevhenii.bd;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ry.rudenko.yevhenii.entity.Token;
import ry.rudenko.yevhenii.entity.User;
import ry.rudenko.yevhenii.nixSONlib.SimpleMapper;

public class JsonDBUsers {

  private static final JsonDBUsers instance = new JsonDBUsers();
  private  List<User> users = new ArrayList<>();
  private  List<Token> tokens = new ArrayList<>();
  private final ObjectMapper objectMapper = new ObjectMapper();
  private SimpleMapper simpleMapper = new SimpleMapper();

  private JsonDBUsers() {
  }

  public static JsonDBUsers getInstance() {
    return instance;
  }

  public void create(User user) {
    users=readUser();
    user.setId(generateId(Entity.USER));
    users.add(user);
    writeUsers(users);
  }

  public void createToken(Token token) {
    tokens=readToken();
    token.setId(generateId(Entity.TOKEN));
    tokens.add(token);
    writeToken(tokens);
  }

  public void update(User user) {
    User current = findById(user.getId());
    current.setFirstName(user.getFirstName());
    current.setLastName(user.getLastName());
  }

  public void delete(String id) {
    users.removeIf(user -> user.getId().equals(id));
  }

  public List<User> findAll() {
    return readUser();
  }

  public boolean existByEmail(String email) {
    return readUser().stream().anyMatch(user -> user.getEmail().equals(email));
  }

  public boolean existById(String id) {
    return readUser().stream().anyMatch(user -> user.getId().equals(id));
  }

  public User findById(String id) {
    return readUser().stream().filter(user -> user.getId().equals(id)).findFirst().get();
  }

  public User findUserIdByEmailAndPassword(String email, String password) {
    return readUser().stream()
        .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
        .findAny()
        .orElse(null);
  }



  public boolean existByToken(String token) {
    return readToken().stream().anyMatch(token1 -> token.equals(token1.getToken()));
  }

  public Token findByToken(String token) {
    return readToken().stream().filter(token1 -> token1.getToken().equals(token)).findFirst().get();
  }

  private String generateId(Entity entity) {
    String id = UUID.randomUUID().toString();
    switch (entity) {
      case USER: {
        if (readUser().stream().anyMatch(user -> user.getId().equals(id))) {
          return generateId(entity);
        }
      }
      break;
      case TOKEN: {
        if (readToken().stream().anyMatch(token -> token.getId().equals(id))) {
          return generateId(entity);
        }
      }
    }
    return id;
  }

  private enum Entity {
    USER, TOKEN
  }

  public void writeUsers(List<User> list) {

    String stringJson = simpleMapper.writeListToJson(list);
    File file = new File("userArray.json");
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
    ) {
      bufferedWriter.write(stringJson);
    }catch (IOException e){
      System.out.println("e = " + e.getMessage());
    }


//    try {
//      objectMapper.writeValue(new File("userArray.json"), list);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }

  public void writeToken(List<Token> list) {
    String stringJson = simpleMapper.writeListToJson(list);
    File file = new File("tokenArray.json");
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))
    ) {
      bufferedWriter.write(stringJson);
    }catch (IOException e){
      System.out.println("e = " + e.getMessage());
    }

//    try {
//      objectMapper.writeValue(new File("tokenArray.json"), list);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }

  public List<Token> readToken() {
    List<Token> readOUT = new ArrayList<>();

    try {
      List<Token> authorsOUT = new ArrayList<>();
      if (new File("tokenArray.json").exists()) {
        authorsOUT = objectMapper.readValue(
            new File("tokenArray.json"),
            new TypeReference<List<Token>>() {
            });
      }
      readOUT = authorsOUT;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return readOUT;
  }

  public List<User> readUser() {
    List<User> readOUT = new ArrayList<>();
    try {
        List<User> bookOUT = new ArrayList<>();
        if (new File("userArray.json").exists()) {
          bookOUT = objectMapper.readValue(
              new File("userArray.json"),
              new TypeReference<List<User>>() {
              });
        }
        readOUT = bookOUT;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return readOUT;
  }
}
