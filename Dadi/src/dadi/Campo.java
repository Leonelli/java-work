/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

import java.util.ArrayList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Matteo
 */
public class Campo extends StackPane {

    HBox hbox;

    Rectangle r;
    int contatore_dadi = 0;
    int contantore = 10;
    ArrayList<Dado> dadiList;
    DadiMain root;

    public Campo(DadiMain root) {
        this.root = root;
        dadiList = new ArrayList<Dado>();
        r = new Rectangle(400, 200);
        r.setFill(Color.GREEN);

        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler() {
            @Override
            public void handle(Event event) {
                aggiungiDado();
            }
        });

        /*hbox.getChildren().add(new Dado(1));
        hbox.getChildren().add(new Dado(2));
        hbox.getChildren().add(new Dado(3));
        hbox.getChildren().add(new Dado(4));
        hbox.getChildren().add(new Dado(5));
        hbox.getChildren().add(new Dado(6));*/
        this.getChildren().addAll(r, hbox);
    }

    void CheckVittoria() {
        System.err.println("dadiList: " + dadiList);
        root.label.setText("contatore: " + contantore);

        if (dadiList.get(0).numero == dadiList.get(1).numero - 1 && dadiList.get(1).numero - 1 == dadiList.get(2).numero - 2) {
            Dialog alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("HAI VINTO!");
            alert.setContentText("Hai vinto!");
            alert.show();
        }
    }

    void aggiungiDado() {
        if (contatore_dadi < 3) {
            Dado dado = new Dado(Commons.R.nextInt(6) + 1, this);
            hbox.getChildren().add(dado);
            dadiList.add(dado);
            contatore_dadi++;
            System.err.println("contatore " + contatore_dadi + ", contatore click " + contantore);
        }
    }
}
