package sample;

import com.jfoenix.controls.JFXButton;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.*;

/**
 * @author (francois Auxietre)
 */


public class sampleController {

    @FXML
    private JFXButton button;
    private Circle cercle;

    @FXML
    public void initialize(){
        TranslateTransition tr1 = new TranslateTransition();
        tr1.setDuration(Duration.seconds(2));
        tr1.setNode(cercle);
        tr1.setToY(-100);
        tr1.play();

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(4));
        translateTransition.setNode(button);
        translateTransition.setToX(-100);
        translateTransition.setAutoReverse(true);
        //translateTransition.setCycleCount(translateTransition.INDEFINITE);
        translateTransition.setOnFinished(this::clickMe);
        translateTransition.play();



    }

    public void handleButtonAction(ActionEvent event){

        System.out.println("click");
    }

    public void clickMe(ActionEvent actionEvent) {
        System.out.println("anim fini");

        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("essai");
        alert.show();*/
    }
}
