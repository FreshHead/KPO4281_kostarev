package ru.san.tests.validation;

import org.junit.jupiter.api.Test;
import ru.san.validation.StringValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by san on 1/16/17.
 */
class StringValidatorTest {
  @Test
  void isCyrillic() {
    assertEquals(false, StringValidator.isNotCyrillic("Якупов"));
    assertEquals(true, StringValidator.isNotCyrillic("ЯкупоF"));
    assertEquals(true, StringValidator.isNotCyrillic("Rкупов"));
    assertEquals(true, StringValidator.isNotCyrillic("Mouse"));
  }

  @Test
  void isStartsWithCapitalLetter() {
    assertEquals(false, StringValidator.caseIsInvalid("Якупов"));
    assertEquals(false, StringValidator.caseIsInvalid("Ш"));
    assertEquals(true, StringValidator.caseIsInvalid("якупов"));
    assertEquals(true, StringValidator.caseIsInvalid("яКупов"));
  }

}