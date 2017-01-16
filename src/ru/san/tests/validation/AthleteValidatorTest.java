package ru.san.tests.validation;

import org.junit.jupiter.api.Test;
import ru.san.model.Athlete;
import ru.san.validation.AthleteValidator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by san on 1/16/17.
 */
class AthleteValidatorTest {
  @Test
  void validate() {
    Athlete validAthlete = new Athlete("Яковлев", "М", 100.2, 3);
    assertEquals("", AthleteValidator.validate(validAthlete));
  }

}