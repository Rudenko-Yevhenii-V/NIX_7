package ry.rudenko.yevhenii.nixSONlib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMapper {

  public String writeListToJson(List list) {
    StringBuilder returnJson = new StringBuilder("[");
    for (Object o : list) {
      final Field[] fields = o.getClass().getDeclaredFields();
      returnJson.append("{");
      for (Field field : fields) {
        Object value = null;
        field.setAccessible(true);
        try {
          value = field.get(o);
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

  public <T> List<T> readJsonToList(String json, T someObj) {
    if (json != null) {
      json = json.replaceAll("\n", "");
    }
    List<T> list = new ArrayList<>();
    if (!(json == null)) {
      List<Field> fieldList = new ArrayList<>();
      int counter = 0;
      int counField = 0;
      boolean ones = true;
      list = new ArrayList<>();
      final Class<?> clazz = someObj.getClass();
      json = json.substring(1, json.length() - 1);
      json = json.replaceAll("\\{", "(");
      json = json.replaceAll("}", ")");
      Pattern pattern = Pattern.compile("\\((.*?)\\)");
      Matcher matcher = pattern.matcher(json);
      while (matcher.find()) {
        final Object object = createObject(clazz);
        final Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
          declaredField.setAccessible(true);
          try {
            Field field = object.getClass().getDeclaredField(declaredField.getName());
            field.setAccessible(true);
            if (counField <= declaredFields.length - 1 && ones) {
              fieldList.add(field);
              counField++;
            } else {
              ones = false;
            }
          } catch (NoSuchFieldException e) {
            e.printStackTrace();
          }
        }
        String objStr = json.substring(matcher.start(), matcher.end());
        objStr = objStr.substring(1, objStr.length() - 1);
        Pattern pattern1 = Pattern.compile("\"(.*?)\"[:]\"(.*?)\"");
        Matcher matcher1 = pattern1.matcher(objStr);
        while (matcher1.find()) {
          String fieldStr = objStr.substring(matcher1.start(), matcher1.end());
          StringBuilder value = new StringBuilder();
          final char[] chars = fieldStr.toCharArray();
          boolean cheker = false;
          for (char aChar : chars) {
            if (aChar == ':') {
              cheker = true;
            }
            if (cheker) {
              value.append(aChar);
            }
          }
          value = new StringBuilder(value.substring(2, value.length() - 1));
          try {
            fieldList.get(counter).set(object, value.toString());
            counter++;
            if (counter >= fieldList.size()) {
              counter = 0;
              list.add((T) object);
            }
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
        }
      }
      return list;
    }
    return list;
  }

  private Object createObject(Class clazz) {
    Object o = null;
    try {
      o = clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return o;
  }

}
