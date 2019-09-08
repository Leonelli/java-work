/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargames;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class GameArea extends BorderPane {

    Label label;
    Button addAuto;
    Button avvia_btn;
    boolean abilita_inserimento_auto = true;

    public GameArea() {
        Scacchiera s = new Scacchiera(this, 8, 8);

        BorderPane.setAlignment(s, Pos.CENTER);
        this.setTop(s);

        addAuto = new Button("Add auto");
        avvia_btn = new Button("Avvia");

        label = new Label("auto rimaste: " + Auto.contatore);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(addAuto, label,avvia_btn);

        BorderPane.setAlignment(hbox, Pos.CENTER);
        this.setBottom(hbox);

        addAuto.setDisable(false);

        /*Button btn = new Button();*/
        addAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAuto.setDisable(true);
                abilita_inserimento_auto = true;
                s.stampaCampo();
            }
        });

        avvia_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage secondaryStage = new Stage();
                Scene scene = new Scene(new Finestra(), 300, 300);
                secondaryStage.setTitle("Muovi!");
                secondaryStage.setScene(scene);
                secondaryStage.show();
            }
        });
    }

}
