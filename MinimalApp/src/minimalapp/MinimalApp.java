/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimalapp;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class MinimalApp extends Application {
     public void start(Stage stage) {
        
        TextInputDialog dialog = new TextInputDialog("40");

        //try chatch
        int raggio=40;
        boolean failure = true;
         do {
             try{
                dialog.setTitle("Raggio cerchio");
                dialog.setContentText("Inserisci il raggio del cerchio");
                dialog.setContentText("Raggio:"); 
                raggio = Integer.parseInt(dialog.showAndWait().get());
                failure = false;
             }
            catch(NumberFormatException ex)  {
                failure=true;
            }
         } while (failure || raggio <10 || raggio > 100);  
       
        Circle circ = new Circle(40+raggio, 40+raggio , raggio);
        Group root = new Group();
        root.getChildren().addAll(circ);
        Scene scene = new Scene(root, 400, 300);
         stage.setTitle("My JavaFX Application");
         stage.setScene(scene);
         stage.show();
     }
     public static void main(String[] args) {
       Application.launch(args);
} }