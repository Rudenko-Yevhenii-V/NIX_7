package ry.rudenko.taskLevel2.task1;

import java.util.Stack;

public class StringValidatorForTheTask1Lvl2 {

  private String inputText;
  private boolean valid = true;

  public StringValidatorForTheTask1Lvl2(String inputText) {
    this.inputText = inputText;
  }

  public boolean isValid() {
    Stack stack = new Stack();
    char[] elementsOfInputText = inputText.toCharArray();
    for (char element : elementsOfInputText
    ) {
      if ((element == '(') || (element == ')') || (element == '{')
          || (element == '}') || (element == '[') || (element == ']')) {
        if ((element == '(') || (element == '{') || (element == '[')) {
          stack.push(element);
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
          if (stack.empty()) {
            System.out.println(" First need open " + element + " than close!");
            return false;
          }
          if (stack.lastElement().equals(element)) {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }
    if (!stack.empty()) {
      return false;
    }
    return valid;
  }
}
