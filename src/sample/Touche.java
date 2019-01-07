package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author (francois Auxietre)
 */
public class Touche extends Parent {


    public String lettre;
    public String noteTexte;
    private int positionX =0;
    private int positionY =0;
    private int note =0;
    private Instrument instrument;

    Rectangle fond_touche;
    Text lettre_touche;

    public Touche(String lettre, String noteText, int positionX, int positionY, int note, Instrument instrument){

        this.lettre = lettre;
        this.noteTexte = noteText;
        this.noteTexte = noteText;
        this.positionX =positionX;
        this.positionY = positionY;
        this.note = note;
        this.instrument = instrument;

        switch (noteTexte){

            case "DO#" : fond_touche = new Rectangle(75,175,Color.PINK); break;
            case "RE#" : fond_touche = new Rectangle(75,175,Color.PINK); break;
            case "FA#" : fond_touche = new Rectangle(75,175,Color.PINK); break;
            case "SOL#" : fond_touche = new Rectangle(75,175,Color.PINK); break;
            case "LA#" : fond_touche = new Rectangle(75,175,Color.PINK); break;
            default: fond_touche = new Rectangle(75,175,Color.WHITE); break;
        }

        //fond_touche = new Rectangle(75,75,Color.WHITE);
        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        this.getChildren().add(fond_touche);//ajout du rectangle de fond de la touche

        lettre_touche = new Text(noteText);
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.GREY);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche);//ajout de la lettre de la touche

        lettre_touche = new Text(lettre);
        lettre_touche.setFont(new Font(12));
        lettre_touche.setFill(Color.RED);
        lettre_touche.setX(20);
        lettre_touche.setY(20);
        this.getChildren().add(lettre_touche);//ajout de la lettre de la touche



        this.setTranslateX(positionX);//positionnement de la touche sur le clavier
        this.setTranslateY(positionY);

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void  handle(MouseEvent event){

                fond_touche.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void  handle(MouseEvent event){

                fond_touche.setFill(Color.WHITE);
                relacher();
            }
        });

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

            }
        });



        this.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void  handle(MouseEvent event){


            }
        });


        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("touches" + note);
                appuyer();
            }
        });

    }
    public void appuyer(){
        fond_touche.setFill(Color.DARKGREY);
        this.setTranslateY(positionY+2);
        instrument.note_on(note);
    }

    public void relacher(){
        fond_touche.setFill(Color.WHITE);
        this.setTranslateY(positionY-2);
        instrument.note_off(note);
    }


}
