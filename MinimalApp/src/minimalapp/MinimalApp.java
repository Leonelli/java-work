/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimalapp;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class MinimalApp extends Application {
     public void start(Stage stage) {
         Circle circ = new Circle(40, 40, 30);
         Group root = new Group(circ);
         Scene scene = new Scene(root, 400, 300);
         stage.setTitle("My JavaFX Application");
         stage.setScene(scene);
         stage.show();
     }
     public static void main(String[] args) {
       Application.launch(args);
} }