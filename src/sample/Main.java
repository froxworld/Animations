package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group racine = new Group();
        Instrument monInstrument = new Instrument();

        Clavier monClavier = new Clavier(monInstrument);

        racine.getChildren().add(monClavier);
        stage.setTitle("Mon piano");
        stage.setScene(new Scene(racine, 600, 600));
        stage.show();
        monClavier.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
