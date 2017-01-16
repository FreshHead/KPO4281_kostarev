package ru.san.validation;

import ru.san.model.Athlete;

/**
 * Created by san on 1/15/17.
 */
public final class AthleteValidator {

  public static String validate(Athlete athlete) {
    String errorMessages = "";

    errorMessages.concat(validateSurname(athlete.getSurname()));
    errorMessages.concat(validateTeamCode(athlete.getTeamCode()));
    errorMessages.concat(validateAmountOfPoints(athlete.getAmountOfPoints()));
    errorMessages.concat(validatePlace(athlete.getPlace()));

    return errorMessages;
  }

  private static String validateSurname(String surname) {
    String errorMessages = "";
    if (StringValidator.isNotCyrillic(surname)) {
      errorMessages += "Фамилия атлета должена состоять только из симоволов русского алфавита!";
    }
    if (StringValidator.caseIsInvalid(surname)) {
      errorMessages += "Фамилия атлета должна начинаться с заглавной буквы, а остальные символы должны быть строчными!";
    }
    if (surname.contains(" ")) {
      errorMessages += "Фамилия атлета не может содержать пробелы!";
    }

    return errorMessages;
  }

  private static String validateTeamCode(String teamCode) {
    String errorMessages = "";
    if (StringValidator.isNotCyrillic(teamCode)) {
      errorMessages += "Код команды должен состоять только из симоволов русского алфавита!";
    }
    if (StringValidator.caseIsInvalid(teamCode)) {
      errorMessages += "Код команды должн начинаться с заглавной буквы, а остальные символы должны быть строчными!";
    }

    return errorMessages;
  }

  private static String validateAmountOfPoints(double amountOfPoints) {
    String errorMessages = "";

    return errorMessages;
  }

  private static String validatePlace(int place) {
    String errorMessages = "";
    if (place < 1) {
      errorMessages += "Номер занятого атлетом места не может быть меньше 1!";
    }

    return errorMessages;
  }

}
