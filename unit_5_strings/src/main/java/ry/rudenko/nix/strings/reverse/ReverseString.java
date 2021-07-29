package ry.rudenko.nix.strings.reverse;

public class ReverseString extends AbstractReverse {


  //  public static String reverse(String src){
//    return  src;
//  }
  @Override
  public String reverse(String src) {
    StringBuilder buffer = new StringBuilder();
    buffer.append(src);
    buffer.reverse();
//    char[] charsSrc = src.toCharArray();
//    for (int i = charsSrc.length - 1; i > 1; i--) {
//      buffer.append(charsSrc[i]);
//    }
   return String.valueOf(buffer);
  }

  public static String reverse(String src, String dest) {
    return src;
  }

  public static String reverse(String src, int firstIndex, int
      lastIndex) {
    return src;
  }


}
