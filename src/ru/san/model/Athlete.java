package ru.san.model;

/**
 * Created by san on 1/15/17.
 */
public class Athlete {
  private String surname;
  private String teamCode;
  private double amountOfPoints;
  private int place;

  public Athlete(String surname, String teamCode, double amountOfPoints, int place) {
    this.surname = surname;
    this.teamCode = teamCode;
    this.amountOfPoints = amountOfPoints;
    this.place = place;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getTeamCode() {
    return teamCode;
  }

  public void setTeamCode(String teamCode) {
    this.teamCode = teamCode;
  }

  public double getAmountOfPoints() {
    return amountOfPoints;
  }

  public void setAmountOfPoints(float amountOfPoints) {
    this.amountOfPoints = amountOfPoints;
  }


  public int getPlace() {
    return place;
  }

  public void setPlace(int place) throws Exception {
    this.place = place;
  }

}
