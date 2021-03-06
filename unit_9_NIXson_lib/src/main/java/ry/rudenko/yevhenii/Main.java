package ry.rudenko.yevhenii;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import ry.rudenko.yevhenii.nixSONlib.TestJson;
import ry.rudenko.yevhenii.nixSONlib.UniversalMapper;

public class Main {

  public static void main(String[] args) {
    String json = null;
    UniversalMapper universalMapper = new UniversalMapper();
    try {
      json = Files.readString(Paths.get("some.json"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    final List<TestJson> testJsons = universalMapper.parseJson(json, new TestJson());

    int count = 1;
    for (TestJson testJson : testJsons) {
      System.out.println("\n\n" + count + " Object of List<TestJson>");
      writeObject(testJson.field1);
      writeObject(testJson.field2);
      writeObject(testJson.field3);
      writeObject(testJson.field4);
      writeObject(testJson.field5);
      writeObject(testJson.field6);
      writeObject(testJson.field7);
      writeObject(testJson.field8);
      writeObject(testJson.field9);
      writeObject(testJson.field10);
      writeObject(testJson.field11);
      writeObject(testJson.field12);
      writeObject(testJson.field13);
      writeObject(testJson.field14);
      writeObject(testJson.field15);
      writeObject(testJson.field16);
      writeObject(testJson.field17);
      writeObject(testJson.field18);
      writeObject(testJson.field19);
      writeObject(testJson.field20);
      writeObject(testJson.field21);
      count++;
    }
  }

  private static void writeObject(Object field1) {
    if (field1 == null) {
      return;
    }
    int count = 0;
    if (isClassObj(field1)) {
      nextWriteObj(count, field1);
    } else {
     if(field1.toString().charAt(0) == '['){
       if(field1.getClass().getSimpleName().equals("Integer[]")){
         StringBuilder outPutArray = new StringBuilder("Integer[]{");
         for (Integer integer : (Integer[]) field1) {
           outPutArray.append(integer).append(", ");
         }
         outPutArray = new StringBuilder(outPutArray.substring(0, outPutArray.length() - 2));
         outPutArray.append("}");
         field1 = outPutArray.toString();
       }

        if (field1.getClass().getSimpleName().equals("ArrayList")){
          StringBuilder outPutArray = new StringBuilder("ArrayList<TestJson>{");
          for (TestJson testJson : (ArrayList<TestJson>) field1) {
            outPutArray.append(testJson).append(",");
          }
          outPutArray = new StringBuilder(outPutArray.substring(0, outPutArray.length() - 1));
          outPutArray.append("}");
          field1 = outPutArray.toString();
        }
       if (field1.getClass().getSimpleName().equals("String[]")){
         StringBuilder outPutArray = new StringBuilder("String[]{");
         for (String d : (String[]) field1) {
           outPutArray.append(d).append(",");
         }
         outPutArray = new StringBuilder(outPutArray.substring(0, outPutArray.length() - 1) + "}");
         field1 = outPutArray.toString();
       }
     }
      print(count, field1);
    }
  }

  private static void print(int count, Object o) {
    System.out.println("    ".repeat(Math.max(0, count)) + "TestJson.field = " + o);
  }
  private static void writeObject(Object field1, int count) {
    if (field1 == null) {
      return;
    }
    if (isClassObj(field1)) {
        nextWriteObj(count, field1);
    } else {
      if(field1.toString().charAt(0) == '['){
        if(field1.getClass().getSimpleName().equals("Integer[]")){
          StringBuilder outPutArray = new StringBuilder("Integer[]{");
          for (Integer integer : (Integer[]) field1) {
            outPutArray.append(integer).append(", ");
          }
          outPutArray = new StringBuilder(outPutArray.substring(0, outPutArray.length() - 1));
          outPutArray.append("}");
          field1 = outPutArray.toString();
        }

        if (field1.getClass().getSimpleName().equals("ArrayList")){
          StringBuilder outPutArray = new StringBuilder("ArrayList<TestJson>{");
          for (TestJson testJson : (ArrayList<TestJson>) field1) {
            outPutArray.append(testJson).append(",");
          }
          outPutArray = new StringBuilder(outPutArray.substring(0, outPutArray.length() - 1));
          outPutArray.append("}");
          field1 = outPutArray.toString();
        }
        if (field1.getClass().getSimpleName().equals("String[]")){
          StringBuilder outPutArray = new StringBuilder("String[]{");
          for (String d : (String[]) field1) {
            outPutArray.append(d).append(",");
          }
          outPutArray = new StringBuilder(outPutArray.substring(0, outPutArray.length() - 1) + "}");
          field1 = outPutArray.toString();
        }
      }

      print(count, field1);
    }
  }

  private static void nextWriteObj(Integer count, Object field1) {
    count++;
    System.out.println("TestJson.field " + " = ");
    TestJson testJsonNext = (TestJson) field1;
    writeObject(testJsonNext.field1, count);
    writeObject(testJsonNext.field2, count);
    writeObject(testJsonNext.field3, count);
    writeObject(testJsonNext.field4, count);
    writeObject(testJsonNext.field5, count);
    writeObject(testJsonNext.field6, count);
    writeObject(testJsonNext.field7, count);
    writeObject(testJsonNext.field8, count);
    writeObject(testJsonNext.field9, count);
    writeObject(testJsonNext.field10, count);
    writeObject(testJsonNext.field11, count);
    writeObject(testJsonNext.field12, count);
    writeObject(testJsonNext.field13, count);
    writeObject(testJsonNext.field14, count);
    writeObject(testJsonNext.field15, count);
    writeObject(testJsonNext.field16, count);
    writeObject(testJsonNext.field17, count);
    writeObject(testJsonNext.field18, count);
    writeObject(testJsonNext.field19, count);
    writeObject(testJsonNext.field20, count);
    writeObject(testJsonNext.field21, count);
  }

  private static boolean isClassObj(Object field1) {
    if (field1 == null) {
      return false;
    }
    return field1.getClass().getSimpleName().equals("TestJson");
  }
}

