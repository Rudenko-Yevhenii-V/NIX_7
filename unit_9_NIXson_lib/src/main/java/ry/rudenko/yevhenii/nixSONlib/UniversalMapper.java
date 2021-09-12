package ry.rudenko.yevhenii.nixSONlib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversalMapper {

  public <T> List<T> parseJson(String json, T someObj) {
    List<T> listT = new ArrayList<>();
    if (json != null) {
      json = json.replaceAll("\n", "");
      json = json.replaceAll("\\s+", "");
      if (json.charAt(0) == '[') {
        json = json.substring(1, json.length() - 1);
        json = replaceBrackets(json);
        Pattern pattern1 = Pattern.compile(
            "18945213155465498732139654(.+?)18945213155465498732139654");
        Matcher matcher1 = pattern1.matcher(json);
        while (matcher1.find()) {
          String objJson = json.substring(matcher1.start(), matcher1.end());
          objJson = objJson.replaceAll("18945213155465498732139654", "");
          objJson = "{" + objJson + "}";
          final List<T> list = parseJson(objJson, someObj);
          listT.add(list.get(0));
        }
      } else {
        boolean isArraObj = false;
        boolean isArraInt = false;

        json = json.substring(1, json.length() - 1) + ",";
        Class<?> clazz = someObj.getClass();
        final Object object = createObject(clazz);
        final Field[] fields = object.getClass().getFields();
        String elementJson = json;
        elementJson = replaceBrackets(elementJson);
        List<String> fieldsAndValuesList = findFieldsAndValuesInJsonElement(elementJson);
        for (int i = 0; i < fieldsAndValuesList.size(); i++) {
          String fieldsAndValues = fieldsAndValuesList.get(i);
          StringBuilder value = new StringBuilder();
          final char[] chars = fieldsAndValues.toCharArray();
          boolean cheker = false;
          for (char aChar : chars) {
            if (cheker) {
              value.append(aChar);
            }
            if (aChar == ':') {
              cheker = true;
            }
          }
          if (value.charAt(0) == '[') {
            List<T> listT1 = new ArrayList<>();
            String valueArr = String.valueOf(value).substring(1, value.length() - 1);
            Pattern testPatt = Pattern.compile(
                "\"(.+?)\":(.+?),");
            Matcher matcherTest = testPatt.matcher(valueArr);
            if (matcherTest.find()) {
              isArraObj = true;
              Object oArray;
              valueArr = valueArr.replaceAll("18945213155465498732139654", "");
              valueArr = valueArr + ",";
              String needListOfObjekts = String.valueOf(value);
              needListOfObjekts = needListOfObjekts.substring(1, needListOfObjekts.length() - 1);
              System.out.println("needListOfObjekts = " + needListOfObjekts);
              Pattern pattern1tt = Pattern.compile(
                  "18945213155465498732139654(.+?)18945213155465498732139654");
              Matcher matcher1tt = pattern1tt.matcher(needListOfObjekts);
              while (matcher1tt.find()) {
                String objJson = needListOfObjekts.substring(matcher1tt.start(), matcher1tt.end());
                objJson = objJson.replaceAll("18945213155465498732139654", "");
                objJson = "{" + objJson + "}";
                System.out.println("fffffffffffffffobjJson = " + objJson);
                final List<T> list = parseJson(objJson, someObj);
                listT1.add(list.get(0));
              }
              System.out.println("listT1.size() = " + listT1.size());
              oArray = listT1;
              listT.add((T) oArray);
            }
            String first = String.valueOf(valueArr.charAt(0));

            if (first.matches("\\d")) {
              isArraInt = true;
              final char[] chars1 = valueArr.toCharArray();
              int counterNumbersInArray = 1;
              for (char c : chars1) {
                if (c == ',') {
                  counterNumbersInArray++;
                }
              }
              Integer[] arrayIntObj = new Integer[counterNumbersInArray];
              counterNumbersInArray = 0;
              for (char c : chars1) {
                if (!(c == ',')) {
                  arrayIntObj[counterNumbersInArray] = Integer.parseInt(String.valueOf(c));
                  counterNumbersInArray++;
                }
              }
              try {
                fields[i].set(object, arrayIntObj);
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              }
              continue;
            }
            if (!isArraObj || !isArraInt) {
              final String[] split = valueArr.split(",");
              Object objStr;
              objStr = split;
              try {
                fields[i].set(object, objStr);
                continue;
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              }
            }
          }
          try {
            boolean isObjekt = isObjekt(value.toString());
            if (isObjekt) {
              fieldsAndValues = fieldsAndValues.replaceAll("18945213155465498732139654", "");
              fieldsAndValues = fieldsAndValues + ',';
              final List<T> list = parseJson(fieldsAndValues, someObj);
              fields[i].set(object, list.get(0));
              continue;
            }
            fields[i].set(object, value.toString());
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
    return matcher.find();
  }

  private String replaceBrackets(String inputText) {
    Stack stack = new Stack();
    StringBuilder buffer = new StringBuilder();
    boolean chec = false;
    char[] elementsOfInputText = inputText.toCharArray();
    StringBuilder inputTextBuilder = new StringBuilder();
    for (char element : elementsOfInputText) {
      if (chec) {
        buffer.append(element);
      } else {
        inputTextBuilder.append(element);
      }
      if ((element == '{')) {
        stack.push(element);
        chec = true;
      }
      if (element == '}') {
        stack.pop();
        if (stack.empty()) {
          chec = false;
          inputTextBuilder = new StringBuilder(
              inputTextBuilder.substring(0, inputTextBuilder.length() - 1)
                  + "18945213155465498732139654" + buffer
                  .substring(0, buffer.length() - 1) + "18945213155465498732139654");
          buffer = new StringBuilder();
        }
      }
    }
    inputText = inputTextBuilder.toString();
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
      if (fieldAndValueStr.charAt(fieldAndValueStr.length() - 1) == ',') {
        fieldAndValueStr = fieldAndValueStr.substring(0, fieldAndValueStr.length() - 1);
      }
      list.add(fieldAndValueStr);
    }
    return list;
  }
}
