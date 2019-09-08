/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Text;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class DadiMain extends Application {

    Button reset, stampa, spostamento_dissolvenza;
    int contatore_click = 10;
    Label label = new Label("Contatore: " + contatore_click);
    Text contatore_field = new Text("");
    boolean dissolvenza_appare = false;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        HBox hbox_bottoni = new HBox();
        reset = new Button("RESET");
        stampa = new Button("STAMPA");
        spostamento_dissolvenza = new Button("Spostamento");

        spostamento_dissolvenza.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!dissolvenza_appare) {
                    dissolvenza_appare = !dissolvenza_appare;
                    spostamento_dissolvenza.setText("Dissolvenza");
                } else {
                    spostamento_dissolvenza.setText("Spostamento");
                    dissolvenza_appare = !dissolvenza_appare;
                }
            }
        });

        hbox_bottoni.getChildren().addAll(reset, stampa, spostamento_dissolvenza, label, contatore_field);

        /*hbox.getChildren().add(new Dado(1));
        hbox.getChildren().add(new Dado(2));
        hbox.getChildren().add(new Dado(3));
        hbox.getChildren().add(new Dado(4));
        hbox.getChildren().add(new Dado(5));
        hbox.getChildren().add(new Dado(6));
        hbox.getChildren().add(new Dado(6));*/
        Campo campo = new Campo(this);

        campo.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(campo, Pos.CENTER);
        root.setCenter(campo);

        hbox_bottoni.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(hbox_bottoni, Pos.TOP_CENTER);
        root.setTop(hbox_bottoni);

        stampa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage finestra = new Stage();

                BorderPane pane_finestra = new BorderPane();
                Label etichetta1 = new Label("punteggio: " + punteggio(campo.dadiList) + " " + lista_dadi(campo.dadiList));
                pane_finestra.setCenter(etichetta1);
                Scene scene = new Scene(pane_finestra, 300, 300);

                finestra.setTitle("Stampa!");
                finestra.setScene(scene);
                finestra.show();

            }
        });

        reset.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                start(primaryStage);
            }
        });

        EventHandler<KeyEvent> KeyEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCharacter().equals("ss")) {
                    System.out.println("Buttom 'S' pressed");
                }
            }
        };

        root.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.S) {
                    stampa.fire();
                }
                else if (e.getCode() == KeyCode.R) {
                    reset.fire();
                }
            }
        });

        Scene scene = new Scene(root, 800, 500);

        primaryStage.setTitle("Gioco dei dadi!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    String lista_dadi(ArrayList lista_dadi) {
        String dadi_in_gioco = "\n";
        Iterator<Dado> iter = lista_dadi.iterator();
        while (iter.hasNext()) {
            dadi_in_gioco += iter.next().toString() + "\n";
        }
        return dadi_in_gioco;
    }

    int punteggio(ArrayList lista_dadi) {
        int punteggio_totale = 0;
        Iterator<Dado> iter = lista_dadi.iterator();
        while (iter.hasNext()) {
            punteggio_totale += iter.next().numero;
        }
        return punteggio_totale;
    }

}
