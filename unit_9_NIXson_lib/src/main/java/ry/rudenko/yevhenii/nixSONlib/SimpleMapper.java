package ry.rudenko.yevhenii.nixSONlib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMapper {

  public String writeListToJson(List list) {
    StringBuilder returnJson = new StringBuilder("[");
    for (int i = 0; i < list.size(); i++) {
      final Field[] fields = list.get(i).getClass().getDeclaredFields();
      returnJson.append("{");
      for (Field field : fields) {
        Object value = null;
        field.setAccessible(true);
        try {
          value = field.get(list.get(i));
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
        String parseFieldShort = "\"" + field.getName() + "\":\"" + value + "\"";
        returnJson.append(parseFieldShort).append(",");
      }
      returnJson = new StringBuilder(returnJson.substring(0, returnJson.length() - 1));
      returnJson.append("},");
    }
    returnJson = new StringBuilder(returnJson.substring(0, returnJson.length() - 1));
    returnJson.append("]");
    return returnJson.toString();
  }
  public String writeArrayToJson(Object[] array) {
    StringBuilder returnJson = new StringBuilder("[");
    for (Object object : array) {
      final Field[] fields = object.getClass().getDeclaredFields();
      returnJson.append("{");
      for (Field field : fields) {
        Object value = null;
        field.setAccessible(true);
        try {
          value = field.get(object);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
        String parseFieldShort = "\"" + field.getName() + "\":\"" + value + "\"";
        returnJson.append(parseFieldShort).append(",");
      }
      returnJson = new StringBuilder(returnJson.substring(0, returnJson.length() - 1));
      returnJson.append("},");
    }
    returnJson = new StringBuilder(returnJson.substring(0, returnJson.length() - 1));
    returnJson.append("]");
    return returnJson.toString();
  }
  public <T> List<T> readJsonToList(String json, T clazz){
    List<Field> fieldList = new ArrayList<>();
    int counter = 0;
    List<T> list = new ArrayList<>();
    final Field[] declaredFields = clazz.getClass().getDeclaredFields();
    for (Field declaredField : declaredFields) {
      declaredField.setAccessible(true);
      try {
        Field field = clazz.getClass().getDeclaredField(declaredField.getName());
        field.setAccessible(true);
        fieldList.add(field);

//        field.set(clazz, "1");

      } catch (NoSuchFieldException e) {
        e.printStackTrace();
      }
    }

    json = json.substring(1, json.length() - 1);
    json = json.replaceAll("\\{", "(");
    json = json.replaceAll("\\}", ")");
    Pattern pattern = Pattern.compile("\\((.*?)\\)");
    Matcher matcher = pattern.matcher(json);
    while (matcher.find()) {
//      createObject(clazz);
      String objStr =  json.substring(matcher.start(), matcher.end());
      objStr = objStr.substring(1, objStr.length() - 1);
      System.out.println("objStr = " + objStr);
      Pattern pattern1 = Pattern.compile("\"(.*?)\"[:]\"(.*?)\"");
      Matcher matcher1 = pattern1.matcher(objStr);
      while (matcher1.find()){
        String fieldStr =  objStr.substring(matcher1.start(), matcher1.end());
        System.out.println("fieldStr = " + fieldStr);
        String value = "";
        final char[] chars = fieldStr.toCharArray();
        boolean cheker = false;
        for (char aChar : chars) {
          if(aChar == ':'){
            cheker = true;
          }
          if (cheker){
            value += aChar;
          }
        }
        value = value.substring(2, value.length()-1);
        try {
          fieldList.get(counter).set(clazz, value);
          counter++;
          if (counter>=fieldList.size()){
            counter = 0;
            System.out.println("clazz.toString() = " + clazz.toString());
            list.add(clazz);
          }
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }

  private Object  createObject(Class clazz) {
    Object o = null;

    try {
       o = clazz.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return o;
  }

  public Object[] readJsonToArray(String json){

    return null;
  }
}
