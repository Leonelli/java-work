/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class Poker extends Application {

    @Override
    public void start(Stage primaryStage) {

        TilePane PaneGiocatore1 = new TilePane();
        Label nome1 = new Label("PIPPO");
        PaneGiocatore1.getChildren().add(nome1);
        Button pescaAvversario1 = new Button("PESCA DALL'AVVERSARIO");
        PaneGiocatore1.getChildren().add(pescaAvversario1);
        Button cercaCoppie1 = new Button("CERCA LE COPPIE");
        PaneGiocatore1.getChildren().add(cercaCoppie1);
        Button PescaMazzo1 = new Button("PESCA DAL MAZZO");
        PaneGiocatore1.getChildren().add(PescaMazzo1);

        TilePane PaneGiocatore2 = new TilePane();
        Label nome2 = new Label("PLUTO");
        PaneGiocatore2.getChildren().add(nome2);
        Button pescaAvversario2 = new Button("PESCA DALL'AVVERSARIO");
        PaneGiocatore2.getChildren().add(pescaAvversario2);
        Button cercaCoppie2 = new Button("CERCA LE COPPIE");
        PaneGiocatore2.getChildren().add(cercaCoppie2);
        Button PescaMazzo2 = new Button("PESCA DAL MAZZO");
        PaneGiocatore2.getChildren().add(PescaMazzo2);

        cercaCoppie1.setDisable(true);
        PescaMazzo1.setDisable(true);
        pescaAvversario2.setDisable(true);
        cercaCoppie2.setDisable(true);
        PescaMazzo2.setDisable(true);

        //onclick events che riabilitano i vari bottoni mano a mano ecc..
        BorderPane borderpane = new BorderPane();

        BorderPane.setAlignment(PaneGiocatore1, Pos.TOP_CENTER);
        borderpane.setTop(PaneGiocatore1);

        Mazzo mazzo = new Mazzo();
        System.out.println(mazzo.mazzo);

        ArrayList<Carta> manoGiocatore1 = new ArrayList<>();
        ArrayList<Carta> manoGiocatore2 = new ArrayList<>();

        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();

        ArrayList<Carta> scartateGiocatore1 = new ArrayList();
        ArrayList<Carta> scartateGiocatore2 = new ArrayList();

        for (int i = 0; i < 4; i++) {

            manoGiocatore1.add(mazzo.mazzo.get(0));
            mazzo.mazzo.remove(mazzo.mazzo.get(0));

            manoGiocatore2.add(mazzo.mazzo.get(0));
            mazzo.mazzo.remove(mazzo.mazzo.get(0));

        }

        System.out.println("mano Giocatore1: " + manoGiocatore1);
        System.out.println("mano Giocatore2: " + manoGiocatore2);
        System.out.println("Mazzo: " + mazzo.mazzo);

        hbox1.getChildren().addAll(manoGiocatore1);

        hbox2.getChildren().addAll(manoGiocatore2);

        BorderPane.setAlignment(PaneGiocatore2, Pos.BOTTOM_CENTER);
        borderpane.setBottom(PaneGiocatore2);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox1, hbox2);

        BorderPane.setAlignment(vbox, Pos.TOP_CENTER);
        borderpane.setCenter(vbox);

        //sistemare index --> se prende due volte lo 0 aggiunge l'elemento anche se è stato rimosso dalla lista
        pescaAvversario1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("premuto bottone: " + e.getSource());
                Random random = new Random();
                int index = (random.nextInt(manoGiocatore2.size() - 1));
                System.out.println("index " + index);
                manoGiocatore1.add(manoGiocatore2.get(index));
                manoGiocatore2.remove(index);

                System.out.println(manoGiocatore1);
                System.out.println(manoGiocatore2);

                hbox1.getChildren().removeAll(manoGiocatore1);
                hbox1.getChildren().addAll(manoGiocatore1);
                hbox2.getChildren().removeAll(manoGiocatore2);
                hbox2.getChildren().addAll(manoGiocatore2);

                pescaAvversario1.setDisable(true);
                cercaCoppie1.setDisable(false);
            }
        });

        boolean haScartatoGiocatore1 = false;

        cercaCoppie1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("premuto bottone: " + e.getSource());
                int i;
                int j;
                HashSet<Integer> indici_scartare = new HashSet<Integer>();
                for (i = 0; i < manoGiocatore1.size(); i++) {
                    for (j = 0; j < manoGiocatore1.size(); j++) {
                        if (manoGiocatore1.get(i).numero == manoGiocatore1.get(j).numero && i != j) {
                            indici_scartare.add(j);
                            indici_scartare.add(j);
                        }
                    }
                }
                /*if(indici_scartare.size()!=0)
                {
                    haScartatoGiocatore1=true;
                }*/
                System.err.println(indici_scartare);

                System.err.println(manoGiocatore1);
                System.err.println(manoGiocatore2);
                System.err.println("rimuovo...");

                ArrayList<Integer> list = new ArrayList<Integer>();

                Iterator<Integer> itr = indici_scartare.iterator();
                while (itr.hasNext()) {
                    //System.err.println("itr.next: " + itr.next());
                    list.add(itr.next());

                }

                Collections.reverse(list);

                hbox1.getChildren().removeAll(manoGiocatore1);
                hbox2.getChildren().removeAll(manoGiocatore2);

                for (int k : list) {
                    scartateGiocatore1.add(manoGiocatore1.get(k));
                    manoGiocatore1.remove(k);
                }

                System.err.println(manoGiocatore1);
                System.err.println(manoGiocatore2);

                hbox1.getChildren().addAll(manoGiocatore1);
                hbox2.getChildren().addAll(manoGiocatore2);

                cercaCoppie1.setDisable(true);
                PescaMazzo1.setDisable(false);
            }
        });

        PescaMazzo1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("premuto bottone: " + e.getSource());
                if (scartateGiocatore1.size() != 0) {
                    System.out.println("il giocatore 1 ha scartato: " + scartateGiocatore1);
                }
                else{
                    hbox1.getChildren().removeAll(manoGiocatore1);
                    manoGiocatore1.add(mazzo.mazzo.get(0));
                    hbox1.getChildren().addAll(manoGiocatore1);
                }

                System.out.println(manoGiocatore1);
                PescaMazzo1.setDisable(true);
                pescaAvversario2.setDisable(false);
            }
        });

        Scene scene = new Scene(borderpane, 800, 500);

        primaryStage.setTitle(
                "Poker!");
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
