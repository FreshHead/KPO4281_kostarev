package ru.san.model.impl;

import java.util.ArrayList;

import ru.san.model.Athlete;
import ru.san.model.api.AthletesList;

/**
 * Created by san on 1/16/17.
 */
public class AthletesListDefined extends ArrayList<Athlete> implements AthletesList {

  public AthletesListDefined() {
    this.add(new Athlete("Васильев", "М", 120.1, 1));
    this.add(new Athlete("Поляков", "Ш", 100.23, 2));
  }
}
