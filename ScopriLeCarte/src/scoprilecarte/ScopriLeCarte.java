/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoprilecarte;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class ScopriLeCarte extends Application {

    Scacchiera scacchiera = null;
    public int punti=0;
    public int vincite=0;
    
    @Override
    public void start(Stage primaryStage) {

        BorderPane borderpane = new BorderPane();

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
       
        Label punteggio = new Label("Punteggio: "+ punti);
        Label vittorie = new Label("Partite vinte: "+vincite);
        HBox hbox_top = new HBox();
        hbox_top.getChildren().addAll(punteggio, vittorie);
        BorderPane.setAlignment(hbox_top, Pos.TOP_CENTER);
        borderpane.setTop(hbox_top);

        Button reset = new Button("reset");
        Button cheat = new Button("cheat");

        HBox hbox_button = new HBox();
        hbox_button.getChildren().addAll(reset, cheat);
        BorderPane.setAlignment(hbox_button, Pos.BOTTOM_CENTER);
        borderpane.setBottom(hbox_button);

        EventHandler<MouseEvent> cellController = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Casella c = (Casella) (event.getSource());
                System.out.println(c);
                Tessera t = new Tessera("ok", scacchiera,Tipo.V);
                c.setPezzo(t);
            }
        };

        scacchiera = new Scacchiera(cellController);
        BorderPane.setAlignment(scacchiera, Pos.CENTER);
        borderpane.setCenter(scacchiera);

        Scene scene = new Scene(borderpane, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
