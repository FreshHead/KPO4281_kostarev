package ru.san.validation;

/**
 * Created by san on 1/16/17.
 */
public final class StringValidator {

  public static boolean isNotCyrillic(String text) {
    for (int i = 0; i < text.length(); i++) {
      if (!Character.UnicodeBlock.of(text.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
        return true;
      }
    }
    return false;
  }

  public static boolean caseIsInvalid(String text){
    if(!isStartsWithCapitalLetter(text)) {
      return true;
    }
      for(int i = 1 ; i < text.length(); i++) {
        if(Character.isUpperCase(text.charAt(i))) {
          return true;
        }
      }
    return false;
  }

  private static boolean isStartsWithCapitalLetter(String text) {
    if(Character.isUpperCase(text.charAt(0))){
      return true;
    }
    return false;
  }

}
