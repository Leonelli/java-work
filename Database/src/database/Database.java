/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class Database extends Application {

    static LinkedList<String> lista_automibili = new LinkedList<String>();
    static LinkedList<String> lista_persone = new LinkedList<String>();

    @Override
    public void start(Stage stage) {

        TextFlow lista1 = new TextFlow();
        TextFlow lista2 = new TextFlow();
        Button mescola1 = new Button("Mescola");
        Button ordina1 = new Button("Ordina");
        Button conta1 = new Button("Conta");
        Button ordina_per_anno1 = new Button("Ordina per anno");
        Button mescola2 = new Button("Mescola");
        Button ordina2 = new Button("Ordina");
        Button conta2 = new Button("Conta");
        Button ordina_per_anno2 = new Button("Ordina per anno");
        Button new_person_btt = new Button("New person");
        Button new_auto_btt = new Button("New auto");

        TilePane layout2 = new TilePane();
        layout2.setVgap(10);
        layout2.setHgap(20);
        layout2.setPrefColumns(2);

         //Retrieving the observable list of the TextFlow Pane             
       
        layout2.getChildren().addAll(lista1, lista2, mescola1, mescola2, ordina1, ordina2, conta1, conta2, ordina_per_anno1, ordina_per_anno2, new_person_btt, new_auto_btt);
        Scene scene2 = new Scene(layout2);
        stage.setScene(scene2);
        stage.show();

        new_person_btt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SchermataAggiunta schermata_nserisci = new SchermataAggiunta("persona");
            }
        });

        new_auto_btt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SchermataAggiunta schermata_nserisci = new SchermataAggiunta("automobile");
            }
        });
        
        VBox paneGirone = new VBox();
        paneGirone.getChildren().add(new TextFlow(new Text("Automobili")));
        //paneGirone.getChildren().add(new TextFlow(new Text(this.toString())));
    }

    public VBox getRiassunto(Color background) {
        VBox paneGirone = new VBox();
        paneGirone.getChildren().add(new TextFlow(new Text(this.toString())));
        paneGirone.getChildren().add(new TextFlow(new Text("CLASSIFICA")));
        paneGirone.setBackground(new Background(new BackgroundFill(background, CornerRadii.EMPTY, Insets.EMPTY)));
        return paneGirone;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
