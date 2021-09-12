package ry.rudenko.yevhenii.windows;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import ry.rudenko.yevhenii.nixSONlib.TestJson;
import ry.rudenko.yevhenii.nixSONlib.UniversalMapper;

public class ParserWindow extends JFrame {

  private static String s ;
  public ParserWindow() {
    super("HEllo take a choice");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    JLabel jLabelname = new JLabel("Enter Json");
    JTextArea jTextArea = new JTextArea(50, 50);
    jTextArea.setText("[\n"
        + "{\n"
        + "  \"key1\" : \"v;jksdhf;sadjhf;sajdhf;aksjhfd;a\",\n"
        + "  \"key2\" : \"val2\",\n"
        + "  \"key3\" : \"val3\",\n"
        + "  \"key4\" : 4,\n"
        + "  \"key5\" : [\n"
        + "    1,4,6\n"
        + "  ],\n"
        + "  \"key6\" : \"test\",\n"
        + "  \"key65\" : {\n"
        + "    \"key1\" : 1\n"
        + "  },\n"
        + "  \"key7\" : {\n"
        + "    \"key11\" : [\n"
        + "      {\n"
        + "        \"key1\" : \"val1\",\n"
        + "        \"key2\" : \"val2\"\n"
        + "      },\n"
        + "      {\n"
        + "        \"key44\" : \"val1\",\n"
        + "        \"fhgiwuasofhdads\" : \"val2\"\n"
        + "      },\n"
        + "      {\n"
        + "        \"key1\" : \"val1\",\n"
        + "        \"key2\" : \"val2\"\n"
        + "      },\n"
        + "      {\n"
        + "        \"key1\" : \"val1\",\n"
        + "        \"key2\" : 17\n"
        + "      }\n"
        + "    ],\n"
        + "    \"key12\" : \"val2\",\n"
        + "    \"key13\" : \"val3\",\n"
        + "    \"key14\" : 14,\n"
        + "    \"key15\" : {\n"
        + "      \"key1\" : 2\n"
        + "    }\n"
        + "\n"
        + "  },\n"
        + "  \"key8\" : \"val8\"\n"
        + "},\n"
        + "  {\n"
        + "    \"key1\" : \"v;jksdhf;sadjhf;sajdhf;aksjhfd;a\",\n"
        + "    \"key2\" : \"val2\",\n"
        + "    \"key3\" : \"val3\",\n"
        + "    \"key4\" : 4,\n"
        + "    \"key5\" : [\n"
        + "      \"1\",\"4\",\"6\"\n"
        + "    ]\n"
        + "  },\n"
        + "  {\n"
        + "    \"key2\" : \"val2\",\n"
        + "    \"key3\" : \"val3\"\n"
        + "  }\n"
        + "  ]");
    JButton jButton = new JButton("ENTER");
    JButton jButtonRegistration = new JButton("RETURN TO CHOICE");
    mainPanel.add(jLabelname);
    mainPanel.add(jTextArea);
    mainPanel.add(jButton);
    mainPanel.add(jButtonRegistration);
    add(mainPanel, BorderLayout.SOUTH);
    pack();
    jButton.addActionListener(actionEvent -> {
      String json = jTextArea.getText();
      UniversalMapper universalMapper = new UniversalMapper();
      TestJson testJsonSome = new TestJson();
      final List<TestJson> testJsons = universalMapper.parseJson(json, testJsonSome);
      s ="final List<TestJson> testJsons = universalMapper.parseJson(json, new TestJson());\n";
      s=s+"for (TestJson testJson : testJsons){ \n";
      int count = 1;
      for (TestJson testJson : testJsons) {
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
      jTextArea.setText(s);
    });
    jButtonRegistration.addActionListener(actionEvent -> {
      this.setVisible(false);
      this.removeAll();
      new HelloWindow().setVisible(true);
    });

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
          String outPutArray = "Integer[]{";
          for (Integer integer : (Integer[]) field1) {
            outPutArray = outPutArray + integer+", ";
          }
          outPutArray = outPutArray.substring(0, outPutArray.length()-2);
          outPutArray = outPutArray + "}";
          field1 = outPutArray;
        }

        if (field1.getClass().getSimpleName().equals("ArrayList")){
          String outPutArray = "ArrayList<TestJson>{";
          for (TestJson testJson : (ArrayList<TestJson>) field1) {
            outPutArray = outPutArray + testJson + ",";
          }
          outPutArray = outPutArray.substring(0, outPutArray.length()-1);
          outPutArray = outPutArray + "}";
          field1 = outPutArray;
        }
        if (field1.getClass().getSimpleName().equals("String[]")){
          String outPutArray = "String[]{";
          for (String d : (String[]) field1) {
            outPutArray = outPutArray +  d + ",";
          }
          outPutArray = outPutArray.substring(0,outPutArray.length()-1) + "}";
          field1 = outPutArray;
        }
      }
      print(count, field1);
    }
  }
  private static void print(int count, Object o) {
    String obStr = o.toString();
    String outStr = "";
    final char[] chars = obStr.toCharArray();
    int lenthCount = 0;
    for (char aChar : chars) {
      lenthCount++;
      outStr = outStr + aChar;
      if (lenthCount> 70){
        lenthCount = 0;
        outStr = outStr + "\n         ";
      }
    }
    s = s +("    ".repeat(Math.max(0, count)) + "TestJson.field = " + outStr + " \n");
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
          String outPutArray = "Integer[]{";
          for (Integer integer : (Integer[]) field1) {
            outPutArray = outPutArray + integer+", ";
          }
          outPutArray = outPutArray.substring(0, outPutArray.length()-1);
          outPutArray = outPutArray + "}";
          field1 = outPutArray;
        }

        if (field1.getClass().getSimpleName().equals("ArrayList")){
          String outPutArray = "ArrayList<TestJson>{";
          for (TestJson testJson : (ArrayList<TestJson>) field1) {
            outPutArray = outPutArray + testJson + ",";
          }
          outPutArray = outPutArray.substring(0, outPutArray.length()-1);
          outPutArray = outPutArray + "}";
          field1 = outPutArray;
        }
        if (field1.getClass().getSimpleName().equals("String[]")){
          String outPutArray = "String[]{";
          for (String d : (String[]) field1) {
            outPutArray = outPutArray +  d + ",";
          }
          outPutArray = outPutArray.substring(0,outPutArray.length()-1) + "}";
          field1 = outPutArray;
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
