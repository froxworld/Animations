package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 * @author (francois Auxietre)
 */
public class Clavier extends Parent {

    private Touche [] touches;
    private Instrument instrument;

    public Clavier(Instrument instrument){
        this.instrument = instrument;

        //creation d'un rectangle
        Rectangle fond_clavier = new Rectangle();
        fond_clavier.setWidth(800);

        //taille en x y et arrondi
        fond_clavier.setHeight(300);
        fond_clavier.setArcWidth(500);
        fond_clavier.setArcHeight(30);
        fond_clavier.setArcWidth(30);


        //on ajoute les touches
        touches = new Touche[]{
                new Touche("q","DO" ,50,100,60, this.instrument),
                new Touche("z","DO#" ,90,50,61, this.instrument),
                new Touche("s", "RE",130,100,62, this.instrument),
                new Touche("e", "RE#",170,50,63, this.instrument),
                new Touche("d", "MI",210,100,64, this.instrument),
                new Touche("f", "FA",290,100,66, this.instrument),
                new Touche("t", "FA#",330,50,67, this.instrument),
                new Touche("g", "SOL",370,100,68, this.instrument),
                new Touche("y", "SOL#",410,50,69, this.instrument),
                new Touche("h", "LA",450,100,70, this.instrument),
                new Touche("u", "LA#",490,50,71, this.instrument),
                new Touche("j", "SI",530,100,72, this.instrument),
                new Touche("k", "DO",610,100,74, this.instrument),
                };

        this.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                System.out.println("" +ke.getText());
               switch (ke.getText()){
                   case "q" :  Touche touche = touches[0];
                       touche.appuyer(); break;
                   case "z" :  Touche touche1 = touches[1];
                       touche1.appuyer(); break;
                   case "s" :  Touche touche10 =touches[2];
                       touche10.appuyer(); break;
                   case "e" :  Touche touche11 = touches[3];
                       touche11.appuyer(); break;
                   case "d" :  Touche touche2 = touches[4];
                       touche2.appuyer(); break;
                   case "f" : Touche touche3= touches[5];
                       touche3.appuyer(); break;
                   case "t" :  Touche touche12 = touches[6];
                           touche12.appuyer(); break;
                   case "g" :  Touche touche4 = touches[7];
                       touche4.appuyer(); break;
                   case "y" :  Touche touche5 = touches[8];
                       touche5.appuyer(); break;
                   case "h" :  Touche touche6 = touches[9];
                       touche6.appuyer(); break;
                   case "u" :  Touche touche7 = touches[10];
                       touche7.appuyer(); break;
                   case "j" :  Touche touche8 = touches[11];
                       touche8.appuyer(); break;
                   case "k" :  Touche touche9 = touches[12];
                       touche9.appuyer(); break;
                }
            }
        });
        this.setOnKeyReleased(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                for (Touche touche: touches){
                    if(touche.lettre.equals( ke.getText().toUpperCase() ) )
                        touche.relacher();
                }
            }
        });


        //on remplie notre rectangle avec un dégradé
        fond_clavier.setFill(
                new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                        new Stop[] {
                                new Stop(0, Color.web("#333333")),
                                new Stop(1, Color.web("#000000"))
                        }
                )
        );
        Reflection r = new Reflection();//on applique un effet de réflection
        r.setFraction(0.4);
        r.setBottomOpacity(0);
        r.setTopOpacity(0.5);
        fond_clavier.setEffect(r);

        this.setTranslateX(50);
        this.setTranslateY(250);


        this.getChildren().add(fond_clavier);
        for (Touche touche: touches){
            this.getChildren().add(touche);
        }

    }
}
