package ru.san;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.san.model.Athlete;

public class AthletesStatisticsApplication extends Application {

  private TableView table = new TableView();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {

    table.setEditable(true);
    stage.setTitle("Ведомость спортивних состязаний");
    stage.setWidth(600);
    stage.setHeight(500);

    TableColumn surnameCol = new TableColumn("Фамилия участника");
    surnameCol.setMinWidth(150);
    surnameCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, String>("surname"));

    TableColumn teamCodeCol = new TableColumn("Код команды");
    teamCodeCol.setMinWidth(150);
    teamCodeCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, String>("teamCode"));

    TableColumn amountOfPointsCol = new TableColumn("Колличество баллов");
    amountOfPointsCol.setMinWidth(150);
    amountOfPointsCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, Double>("amountOfPoints"));

    TableColumn placeCol = new TableColumn("Место в итоге");
    placeCol.setMinWidth(150);
    placeCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, Integer>("place"));


    List<String> rawData = null;
    try {
      rawData = Files.readAllLines(Paths.get("res/AthleteStatisticsData.txt"), Charset.defaultCharset());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    ObservableList<Athlete> data = FXCollections.observableArrayList();
    if(rawData!=null){
      for(String line: rawData) {
        String[] splitedLine = line.split(", ");
        if(splitedLine.length == 4){
          try {
            data.add(new Athlete(splitedLine[0],splitedLine[1],Double.parseDouble(splitedLine[2]), Integer.parseInt(splitedLine[3])));
          }catch (NumberFormatException e){
            throw new Exception("Проверьте правильность числовых данных (количество баллов и место в итоге)!");
          }
        } else {
          throw new Exception("Строка с данными атлета должна состоять из 4 колонок!");
        }

      }
    }

    table.setItems(data);
    table.getColumns().addAll(surnameCol, teamCodeCol, amountOfPointsCol, placeCol);

    final VBox vbox = new VBox();

    vbox.getChildren().addAll(table);

    Scene scene = new Scene(new Group());

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
  }
}