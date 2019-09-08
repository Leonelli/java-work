/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.LinkedList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class SchermataAggiunta extends TilePane {

    Stage stage = new Stage();
    Label lbl1, lbl2, lbl3;
    TextField txfiel1, txfiel2, txfiel3;
    Button inserisciRecord;
    boolean automobile = true;

    public SchermataAggiunta(String classe) {

        switch (classe) {
            case "automobile":
                lbl1 = new Label("marca");
                txfiel1 = new TextField();
                lbl2 = new Label("modello");
                txfiel2 = new TextField();
                lbl3 = new Label("prezzo");
                txfiel3 = new TextField();
                inserisciRecord = new Button("Inserisci record");
                automobile = true;
                break;
            case "persona":
                lbl1 = new Label("nome");
                txfiel1 = new TextField();
                lbl2 = new Label("cognome");
                txfiel2 = new TextField();
                lbl3 = new Label("anno di nascita");
                txfiel3 = new TextField();
                inserisciRecord = new Button("Inserisci record");
                automobile = false;

                break;
            default:
                throw new AssertionError();
        }
        /*Label marca = new Label("marca");
        TextField tx_marca = new TextField();
        Label modello = new Label("modello");
        TextField tx_modello = new TextField();
        Label prezzo = new Label("prezzo");
        TextField tx_prezzo = new TextField();
        Button inserisciRecord = new Button("Iscerisci record");*/

        TilePane layout = new TilePane();
        layout.setVgap(10);
        layout.setHgap(20);
        layout.setPrefColumns(2);

        layout.getChildren().addAll(lbl1, txfiel1, lbl2, txfiel2, lbl3, txfiel3);
        layout.getChildren().add(inserisciRecord);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

        inserisciRecord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (automobile == true) {
                    aggiungi(Database.lista_automibili, txfiel1.getText(), txfiel2.getText(), txfiel3.getText());
                    System.out.println("lista_automibili: "+Database.lista_automibili);
                } else {
                    aggiungi(Database.lista_persone, txfiel1.getText(), txfiel2.getText(), txfiel3.getText());
                    System.out.println("lista_persone: "+Database.lista_persone);
                }
            }
        });
    }

    public void aggiungi(LinkedList<String> list, String field1, String field2, String field3) {
        list.add(field1 + " " + field2 + " " + field3);
    }

}
