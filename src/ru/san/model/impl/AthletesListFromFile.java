package ru.san.model.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ru.san.model.Athlete;
import ru.san.model.api.AthletesList;

/**
 * Created by san on 1/16/17.
 */
public class AthletesListFromFile extends ArrayList<Athlete> implements AthletesList{

  public AthletesListFromFile() {
    try {
      this.populateList(this.getRawData(this.getPathFromProperties(this.getProperties())));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Properties getProperties() {
    Properties properties = new Properties();
    String propertyFileName = "config.properties";
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
    if (inputStream != null) {
      try {
        properties.load(inputStream);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        throw new FileNotFoundException("property file '" + propertyFileName + "' not found in the classpath");
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return properties;
  }

  private Path getPathFromProperties(Properties properties) {
    return Paths.get(properties.getProperty("filePath"));
  }

  private List<String> getRawData(Path filePath){
    List<String> rawData = null;
    try {
      rawData = Files.readAllLines(filePath, Charset.defaultCharset());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return rawData;
  }

  private void populateList(List<String> rawData) throws Exception {
    if(rawData!=null){
      for(String line: rawData) {
        String[] splitedLine = line.split(", ");
        if(splitedLine.length == 4){
          try {
            this.add(new Athlete(splitedLine[0],splitedLine[1],Double.parseDouble(splitedLine[2]), Integer.parseInt(splitedLine[3])));
          }catch (NumberFormatException e){
            throw new Exception("Проверьте правильность числовых данных (количество баллов и место в итоге)!");
          }
        } else {
          throw new Exception("Строка с данными атлета должна состоять из 4 колонок!");
        }
      }
    }
  }

}
