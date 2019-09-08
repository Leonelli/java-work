/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanciodadi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author andre
 */
public class LancioDadi extends Application {
    
    private Button reset;
    private Button stampa;
    private ValueBox contatore;
    private Campo centro;
    
    public LancioDadi()  {
        reset = new Button("RESET");
        stampa = new Button("STAMPA");
        
        
        stampa.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Alert finestra = new Alert(Alert.AlertType.INFORMATION);
                finestra.setContentText(centro.toString());
                finestra.showAndWait();
            }
        });
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        
        BorderPane root = new BorderPane();
        contatore = new ValueBox("CONTATORE", 10);
        centro = new Campo(contatore);
        
        reset.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                start(primaryStage);
            }
        });
        
        root.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler() {
            @Override
            public void handle(Event event) {
                if(((KeyEvent)event).getCode() == KeyCode.R) {
                    reset.fireEvent(new ActionEvent());
                }
                if(((KeyEvent)event).getCode() == KeyCode.S) {
                    stampa.fireEvent(new ActionEvent());
                }
            }
        });
        
        HBox controlli = new HBox(reset,stampa,contatore);
        root.setBottom(controlli);
        root.setCenter(centro);
        
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.setTitle("DADI");
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
