import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AthleteStatisticsApplication extends Application {

  private TableView table = new TableView();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {

    table.setEditable(true);
    stage.setTitle("Ведомость спортивних состязаний");
    stage.setWidth(300);
    stage.setHeight(500);

    TableColumn surname = new TableColumn("Фамилия");
    surname.setMinWidth(100);
    TableColumn code = new TableColumn("Код");
    code.setMinWidth(100);
    TableColumn place = new TableColumn("Место");
    place.setMinWidth(100);

    table.getColumns().addAll(surname, code, place);

    final VBox vbox = new VBox();

    vbox.getChildren().addAll(table);

    Scene scene = new Scene(new Group());

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
  }
}