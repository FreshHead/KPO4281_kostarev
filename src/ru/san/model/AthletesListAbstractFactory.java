package ru.san.model;

import java.util.List;

import ru.san.model.Athlete;
import ru.san.model.ListType;

/**
 * Created by san on 1/16/17.
 */
public abstract class AthletesListAbstractFactory {
  public abstract List<Athlete> getAthleteList(ListType listType);
}
