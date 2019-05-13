/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione_grafica;

import java.awt.event.KeyEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class Esercitazione_Grafica extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        
        BorderPane root =new BorderPane();
        Pane contenitore_centrale = new VBox();
        Pane layout = new HBox();
        Pane rightVB = new VBox();


        Label titolo = new Label("Minicalculator");   
        titolo.setFont(new Font(40));
        Label left = new Label("left");
        Label diritti = new Label ("Created by Leonelli Matteo");
       
        
        TextField campo1 = new TextField();
        campo1.setMaxWidth(320);
        campo1.setEditable(true);

        
        TextField campo2 = new TextField();
        campo2.setMaxWidth(320);
        campo2.setEditable(true);

        TextField risultato = new TextField();
        risultato.setMaxWidth(320);
        risultato.setEditable(false);
        
        
        Button clear = new Button("Clear");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                campo1.clear();
                campo2.clear();
                risultato.clear();
            }
        });
                
        Button plus= new Button();
        plus.setText("Più");
        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Più!");
                try{
                    Integer valore_risultato =  Integer.parseInt(campo1.getCharacters().toString()) + Integer.parseInt(campo2.getCharacters().toString());
                    risultato.setText(valore_risultato.toString());
                }
                catch(NumberFormatException ex){
                    System.err.println(ex);
                    //gestire l'eccezione con un pop up!
                }
            }
        });
        
        /*EventHandler <KeyEvent> keyEventHandler= new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getText().equals("+")) {
                    System.out.println("Buttom + pressed"); 
                }
            } 
        };
        plus.addEventHandler(KeyEvent.KEY_PRESSED,keyEventHandler);*/
        

        Button minus = new Button();
        minus.setText("Meno");
        minus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Meno!");
                try{
                    Integer valore_risultato =  Integer.parseInt(campo1.getCharacters().toString()) - Integer.parseInt(campo2.getCharacters().toString());
                    risultato.setText(valore_risultato.toString());
                }
                catch(NumberFormatException ex){
                    System.err.println(ex);
                    //gestire l'eccezione con un pop up!
                }
            }
        });
        
        
        Button moltiplicazione = new Button();
        moltiplicazione.setText("Per");
        moltiplicazione.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("moltiplicazione!");
                try{
                    Integer valore_risultato =  Integer.parseInt(campo1.getCharacters().toString()) * Integer.parseInt(campo2.getCharacters().toString());
                    risultato.setText(valore_risultato.toString());
                }
                catch(NumberFormatException ex){
                    System.err.println(ex);
                    //gestire l'eccezione con un pop up!
                }
            }
        });
        
        
        Button divisione = new Button();
        divisione.setText("Diviso");
        divisione.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("divisione!");
                try{
                    Integer valore_risultato =  Integer.parseInt(campo1.getCharacters().toString()) / Integer.parseInt(campo2.getCharacters().toString());
                    risultato.setText(valore_risultato.toString());
                }
                catch(NumberFormatException ex){
                    System.err.println(ex);
                    //gestire l'eccezione con un pop up!
                }
            }
        });
        
   
        Group bottoni = new Group(layout);
        Group centro = new Group(contenitore_centrale);
        
        layout.getChildren().addAll(plus,minus,moltiplicazione,divisione);
        contenitore_centrale.getChildren().addAll(campo1,campo2, bottoni,risultato);
        
        root.setCenter(centro);
        BorderPane.setAlignment(centro,Pos.CENTER);

        
        root.setTop(titolo);
        BorderPane.setAlignment(titolo,Pos.TOP_CENTER);

        root.setLeft(left);
        BorderPane.setAlignment(left,Pos.CENTER_LEFT);
        
        root.setRight(clear);
        BorderPane.setAlignment(clear,Pos.CENTER_RIGHT);
        BorderPane.setMargin(clear, new Insets(20,20,20,20));
        
        root.setBottom(diritti);
        BorderPane.setAlignment(diritti,Pos.BOTTOM_RIGHT);


        Scene scene = new Scene(root,400,200);
        primaryStage.setTitle("MiniCalculator");
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
