package ry.rudenko.taskLevel2.task1;

import java.util.ArrayList;
import java.util.List;

public class StringValidatorForTheTask1Lvl2 {

  private String inputText;
  private boolean valid = true;

  public StringValidatorForTheTask1Lvl2(String inputText) {
    this.inputText = inputText;
  }

  public boolean isValid() {
    List<Character> findElementsOfInputText = new ArrayList();
    char[] elementsOfInputText = inputText.toCharArray();
    for (char element : elementsOfInputText
    ) {
      if ((element == '(') || (element == ')') || (element == '{')
          || (element == '}') || (element == '[') || (element == ']')) {
        if ((element == '(') || (element == '{') || (element == '[')) {
          findElementsOfInputText.add(element);
        } else {

          switch (element) {
            case ')':
              element = '(';
              break;
            case '}':
              element = '{';
              break;
            case ']':
              element = '[';
              break;
            default:
              element = ' ';
          }
          if (findElementsOfInputText.contains(element)) {
            findElementsOfInputText.remove(findElementsOfInputText.indexOf(element));
          } else {
            System.out.println(" First need open " + element + " than close!");
            return false;
          }
        }
      }
    }
    if (!findElementsOfInputText.isEmpty()){
      System.out.println(" you need to close - " + findElementsOfInputText.get(0));
      valid = false;
    }
    return valid;
  }
}
