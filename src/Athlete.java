/**
 * Created by san on 1/15/17.
 */
public class Athlete {
  private String surname;
  private char code;
  private int place;

  public Athlete(String surname, char code, int place) {
    this.surname = surname;
    this.code = code;
    this.place = place;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public char getCode() {
    return code;
  }

  public void setCode(char code) {
    this.code = code;
  }

  public int getPlace() {
    return place;
  }

  public void setPlace(int place) throws Exception {
    if(place < 1) throw new Exception("Место участника не может быть нулём или отрицательным числом");
    this.place = place;
  }

}
