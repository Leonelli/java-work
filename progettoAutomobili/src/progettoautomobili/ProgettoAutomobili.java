/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoautomobili;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class ProgettoAutomobili extends Application {

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

        HBox hbox = new HBox();
        TextArea textAreaPersone = new TextArea();
        TextArea textAreaAutomobili = new TextArea();
        hbox.getChildren().addAll(textAreaPersone, textAreaAutomobili);

        VBox vbox1 = new VBox();
        Button Mescola1 = new Button("Mescola");
        Button Ordina1 = new Button("Ordina");
        Button Conta1 = new Button("Conta");
        Button ordinaPrezzo1 = new Button("Ordina per anno");
        Button addAutomobile1 = new Button("aggiungi automobile");

        vbox1.getChildren().addAll(Mescola1, Ordina1, Conta1, ordinaPrezzo1, addAutomobile1);

        VBox vbox2 = new VBox();
        Button Mescola2 = new Button("Mescola");
        Button Ordina2 = new Button("Ordina");
        Button Conta2 = new Button("Conta");
        Button ordinaAnno2 = new Button("Ordina per età");
        Button addPersona2 = new Button("aggiungi persona");
        vbox2.getChildren().addAll(Mescola2, Ordina2, Conta2, ordinaAnno2, addPersona2);

        HBox hbox_button = new HBox();
        hbox_button.getChildren().addAll(vbox1, vbox2);

        HashSet<Automobile> lista_macchine = new HashSet();

        Conta1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.err.println("Elementi nella lista automobili = " + lista_macchine.size());
            }
        });

        Mescola1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Automobile> copia_lista = new ArrayList<Automobile>();
                Iterator iterator = lista_macchine.iterator();
                while (iterator.hasNext()) {
                    copia_lista.add((Automobile) iterator.next());
                }
                Collections.shuffle(copia_lista);
                textAreaAutomobili.clear();
                for (Automobile auto : copia_lista) {
                    textAreaAutomobili.appendText(auto.marca + " " + auto.modello + " " + auto.prezzo + "\n");
                }

            }
        });
        
         Ordina1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Automobile> copia_lista = new ArrayList<Automobile>();
                Iterator iterator = lista_macchine.iterator();
                while (iterator.hasNext()) {
                    copia_lista.add((Automobile) iterator.next());
                }
                Collections.sort(copia_lista);
                textAreaAutomobili.clear();
                for (Automobile auto : copia_lista) {
                    textAreaAutomobili.appendText(auto.marca + " " + auto.modello + " " + auto.prezzo + "\n");
                }

            }
        });
         
         
         ordinaPrezzo1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Automobile> copia_lista = new ArrayList<Automobile>();
                Iterator iterator = lista_macchine.iterator();
                while (iterator.hasNext()) {
                    copia_lista.add((Automobile) iterator.next());
                }
                Collections.sort(copia_lista);
                textAreaAutomobili.clear();
                for (Automobile auto : copia_lista) {
                    textAreaAutomobili.appendText(auto.marca + " " + auto.modello + " " + auto.prezzo + "\n");
                }

            }
        });
         

        
        
        
        
        addAutomobile1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Aggiungi auto");

                BorderPane finestra = new BorderPane();
                Label lbl1 = new Label("Marca");
                Label lbl2 = new Label("Modello");
                Label lbl3 = new Label("Prezzo");
                TextField txt1 = new TextField();
                TextField txt2 = new TextField();
                TextField txt3 = new TextField();

                Button inserisci_auto = new Button("Controlla e inserisci");

                HBox hbox1 = new HBox();
                hbox1.getChildren().addAll(lbl1, txt1);
                HBox hbox2 = new HBox();
                hbox2.getChildren().addAll(lbl2, txt2);
                HBox hbox3 = new HBox();
                hbox3.getChildren().addAll(lbl3, txt3);
                VBox vbox1 = new VBox();
                vbox1.getChildren().addAll(hbox1, hbox2, hbox3, inserisci_auto);

                inserisci_auto.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Controllo auto");
                        System.out.println(txt1.getText());
                        System.out.println(txt2.getText());
                        System.out.println(txt3.getText());
                        //check if all right nella conversione da int a string e se non sono vuoti
                        //controllo se ripetuto ecc..
                        String marca_aggiunta = txt1.getText();
                        String modello_aggiunta = txt2.getText();
                        String prezzo_aggiunta = txt3.getText();

                        AggiungiAuto(marca_aggiunta, modello_aggiunta, prezzo_aggiunta, lista_macchine, textAreaAutomobili);

                    }
                });

                BorderPane.setAlignment(vbox1, Pos.CENTER);
                finestra.setTop(vbox1);
                Stage stage_auto = new Stage();
                Scene scena_auto = new Scene(finestra, 300, 300);
                stage_auto.setScene(scena_auto);
                stage_auto.show();
            }
        });

        BorderPane root = new BorderPane();
        BorderPane.setAlignment(hbox, Pos.TOP_CENTER);
        root.setTop(hbox);

        BorderPane.setAlignment(vbox1, Pos.CENTER_RIGHT);
        root.setCenter(hbox_button);

        Scene scene = new Scene(root, 500, 800);

        primaryStage.setTitle("AAA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void AggiungiAuto(String marca_aggiunta, String modello_aggiunta, String prezzo_aggiunta, HashSet<Automobile> lista_macchine, TextArea textAreaAutomobili) {
        System.out.println("Aggiungo elemento");
        try {
            int prezzo = Integer.parseInt(prezzo_aggiunta);
            Automobile a = new Automobile(marca_aggiunta, modello_aggiunta, prezzo);
            System.err.println(a);

            if (marca_aggiunta == null || "".equals(marca_aggiunta) || modello_aggiunta == null || "".equals(modello_aggiunta) || prezzo_aggiunta == null || "".equals(prezzo_aggiunta)) {
                System.err.println("Inserisci tutti i valori nei campi");

            } else {
                lista_macchine.add(a);
                //if (lista_macchine.isEmpty()) {
                //} else {
                /*Iterator<Automobile> i = lista_macchine.iterator();
                while(i.hasNext()) {
                    if (i.next().equals(a)) {
                        System.err.println("L'auto " + a + " è già presente nella lista");
                    } else {
                        lista_macchine.add(a);
                    }
                }*/
                //}
            }

            textAreaAutomobili.clear();
            for (Automobile auto : lista_macchine) {
                textAreaAutomobili.appendText(auto.marca + " " + auto.modello + " " + auto.prezzo + "\n");
            }
            System.err.println(lista_macchine);
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
