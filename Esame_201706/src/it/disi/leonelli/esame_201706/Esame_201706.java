/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.disi.leonelli.esame_201706;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class Esame_201706 extends Application {

    Scacchiera scacchiera = null;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        EventHandler<MouseEvent> cellController = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Casella c = (Casella) (event.getSource());
                System.out.println(c);
                c.setPezzo(new Pezzo(scacchiera));
            }
        };

        //richiesta di scelta dimensioni (valore di n)
        int n = 10;
        scacchiera = new Scacchiera(n, cellController);

        BorderPane borderpane = new BorderPane();
        
        HBox hbox = new HBox();
        Button linear = new Button("linear");
        Button sin = new Button("sin");
        Button cos = new Button("cos");
        Button random = new Button("random");
        Button all_on = new Button("all on");
        Button all_off = new Button("all  off");
        hbox.getChildren().addAll(linear, sin, cos, random, all_on, all_off);

        GridPane root = new GridPane();
        int width = 600;
        int height = 600;
        root.getChildren().add(scacchiera);

        BorderPane.setAlignment(root, Pos.TOP_CENTER);
        borderpane.setCenter(root);
        
        BorderPane.setAlignment(hbox, Pos.BOTTOM_CENTER);
        borderpane.setBottom(hbox);

        //test allign
        Button top = new Button("Top");
        BorderPane.setAlignment(top, Pos.TOP_CENTER);
        borderpane.setTop(top);
        
        
        
        //non serve getchildren nel borderpane se setTop ecc..
        //borderpane.getChildren().addAll(root, hbox);
        Scene scene = new Scene(borderpane, width, height, Color.BLANCHEDALMOND);

        primaryStage.setTitle("Plotter!");
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
