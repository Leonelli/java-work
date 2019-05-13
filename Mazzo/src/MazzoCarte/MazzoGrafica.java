/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazzoCarte;

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class MazzoGrafica extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        
        MazzoCarte mazzo=new MazzoCarte();   
        List <Carta> carte_estratte = mazzo.getCarteEstratte(11, (List<Carta>) mazzo);
        
        int numero = mazzo.CartaVincente(carte_estratte, 11).numero;
        int seme = mazzo.CartaVincente(carte_estratte, 11).seme;
        System.out.println("__________MAIN___________");
        System.out.println(numero);
        System.out.println(seme);

        /*
        
        int numero=1;
        int seme=2;
        
        StackPane root = new StackPane();

        
        switch(seme){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Mazzo");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
