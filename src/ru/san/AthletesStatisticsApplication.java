package ru.san;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ru.san.model.AthletesListFactory;
import ru.san.model.Athlete;
import ru.san.model.ListType;

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
    String[] columnNames = {"Фамилия участника", "Код команды", "Колличество баллов", "Место в итоге"};

    TableColumn surnameCol = new TableColumn(columnNames[0]);
    surnameCol.setMinWidth(150);
    surnameCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, String>("surname"));

    TableColumn teamCodeCol = new TableColumn(columnNames[1]);
    teamCodeCol.setMinWidth(150);
    teamCodeCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, String>("teamCode"));

    TableColumn amountOfPointsCol = new TableColumn(columnNames[2]);
    amountOfPointsCol.setMinWidth(150);
    amountOfPointsCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, Double>("amountOfPoints"));

    TableColumn placeCol = new TableColumn(columnNames[3]);
    placeCol.setMinWidth(150);
    placeCol.setCellValueFactory(
        new PropertyValueFactory<Athlete, Integer>("place"));

    AthletesListFactory  athletesListFactory = new AthletesListFactory();
    ObservableList<Athlete> data = FXCollections.observableList(athletesListFactory.getAthleteList(ListType.FROM_FILE));


    final TextField addSurname = new TextField();
    addSurname.setMaxWidth(surnameCol.getWidth());
    addSurname.setPromptText(columnNames[0]);

    final TextField addTeamCode = new TextField();
    addTeamCode.setMaxWidth(teamCodeCol.getWidth());
    addTeamCode.setPromptText(columnNames[1]);

    final TextField addAmountOfPoints = new TextField();
    addAmountOfPoints.setMaxWidth(amountOfPointsCol.getWidth());
    addAmountOfPoints.setPromptText(columnNames[2]);

    final TextField addPlace = new TextField();
    addPlace.setMaxWidth(placeCol.getWidth());
    addPlace.setPromptText(columnNames[3]);

    final Button addButton = new Button("Add");
    addButton.setOnAction(e -> {
      data.add(
          new Athlete(
          addSurname.getText(),
          addTeamCode.getText(),
          Double.parseDouble(addAmountOfPoints.getText()),
          Integer.parseInt(addPlace.getText()))
      );
      addSurname.clear();
      addTeamCode.clear();
      addAmountOfPoints.clear();
      addPlace.clear();
    });
    final HBox hb = new HBox();

    hb.getChildren().addAll(addSurname, addTeamCode, addAmountOfPoints, addPlace, addButton);
    hb.setMaxWidth(500);
    hb.setSpacing(3);

    table.setItems(data);
    table.getColumns().addAll(surnameCol, teamCodeCol, amountOfPointsCol, placeCol);

    final VBox vbox = new VBox();

    vbox.getChildren().addAll(table, hb);

    Scene scene = new Scene(new Group());

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
  }


}