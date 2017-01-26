package ru.san.model;

import java.util.List;

import ru.san.model.Athlete;
import ru.san.model.ListType;
import ru.san.model.AthletesListAbstractFactory;
import ru.san.model.impl.AthletesListDefined;
import ru.san.model.impl.AthletesListFromFile;

/**
 * Created by san on 1/16/17.
 */
public class  AthletesListFactory extends AthletesListAbstractFactory {
  @Override
  public List<Athlete> getAthleteList(ListType listType) {
    if(listType == ListType.DEFINED){
      return new AthletesListDefined();
    } else if (listType == ListType.FROM_FILE) {
      return new AthletesListFromFile();
    }
    return null;
  }
}
