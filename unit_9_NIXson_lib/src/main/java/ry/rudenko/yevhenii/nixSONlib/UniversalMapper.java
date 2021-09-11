package ry.rudenko.yevhenii.nixSONlib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversalMapper {

  public <T> List<T> parseJson(String json, T someObj){
    List<T> listT = new ArrayList<>();
    Object o = null;
    if (json != null) {
      json = json.replaceAll("\n", "");
      json = json.replaceAll("\\s+", "");
      if (json.charAt(0) == '[') {
        System.out.println("ELEMENTS OF JSON!!!!");
//        Pattern pattern1 = Pattern.compile(
//            "\"([\\w\\d]*?)\"[:]((18945213155465498732139654(.+?)18945213155465498732139654)|"
//                + "([\\[](.*?)[]])|((.*?)[,]))");
//
//        Matcher matcher1 = pattern1.matcher(elementJson);
//        while (matcher1.find()) {



      } else {
      json = json.substring(1, json.length() - 1) + ",";
      Class<?> clazz = someObj.getClass();
        final Object object = createObject(clazz);
        final Field[] fields = object.getClass().getFields();
        String elementJson = json;
        elementJson = replaceBrackets(elementJson);
        List<String> fieldsAndValuesList = findFieldsAndValuesInJsonElement(elementJson);
        for (int i = 0; i < fieldsAndValuesList.size(); i++) {
          String fieldsAndValues = fieldsAndValuesList.get(i);
          String value = "";
          final char[] chars = fieldsAndValues.toCharArray();
          boolean cheker = false;
          for (char aChar : chars) {
            if (cheker) {
              value = value + (aChar);
            }
            if (aChar == ':') {
              cheker = true;
            }
          }
          try {
            boolean isObjekt = isObjekt(value);
            if (isObjekt){
              fieldsAndValues = fieldsAndValues.replaceAll("18945213155465498732139654", "");
              fieldsAndValues = fieldsAndValues + ',';
              final List<T> list = parseJson(fieldsAndValues, someObj);
              fields[i].set(object, list.get(0));
              continue;
            }
              fields[i].set(object, value);
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
        }
        listT.add((T) object);
      }
    }
    return listT;
  }

  private boolean isObjekt(String value) {
    Pattern pattern = Pattern.compile("18945213155465498732139654");
    Matcher matcher = pattern.matcher(value);
    if(matcher.find()){
      return true;
    }
    return false;
  }


  private String replaceBrackets(String inputText) {
    Stack stack = new Stack();
    String buffer = "";
    boolean chec = false;
    char[] elementsOfInputText = inputText.toCharArray();
    inputText = "";
    for (int i = 0; i < elementsOfInputText.length; i++) {
      char element = elementsOfInputText[i];
      if(chec){
        buffer = buffer + element;
      }else {
        inputText = inputText + element;
      }
      if ((element == '{')) {
        stack.push(element);
        chec = true;
      }
      if (element == '}') {
        stack.pop();
        if (stack.empty()){
          chec = false;
          inputText = inputText.substring(0, inputText.length()-1)+  "18945213155465498732139654" + buffer.substring(0, buffer.length()-1) + "18945213155465498732139654";
        buffer = "";
        }
      }
    }
    return inputText;
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
  private List<String> findFieldsAndValuesInJsonElement(String elementJson) {
    List<String> list = new ArrayList<>();
    Pattern pattern1 = Pattern.compile(
        "\"([\\w\\d]*?)\"[:]((18945213155465498732139654(.+?)18945213155465498732139654)|"
            + "([\\[](.*?)[]])|((.*?)[,]))");

    Matcher matcher1 = pattern1.matcher(elementJson);
    while (matcher1.find()) {
      String fieldAndValueStr = elementJson.substring(matcher1.start(), matcher1.end());
      if (fieldAndValueStr.charAt(fieldAndValueStr.length()-1) == ','){
        fieldAndValueStr = fieldAndValueStr.substring(0, fieldAndValueStr.length()-1);
      }
      list.add(fieldAndValueStr);
    }
    return list;
  }
}
