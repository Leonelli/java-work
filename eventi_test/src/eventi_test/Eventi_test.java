/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventi_test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class Eventi_test extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("PLUS");
        Button bnt2 = new Button("disable");
        EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCharacter().equals("+")) {
                    System.out.println("Buttom + pressed");
                    bnt2.setDisable(false);
                }
            }
        };        
        
        EventHandler<MouseEvent> clickEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (bnt2.isDisable()==false) {
                    System.out.println("disarmo");
                    bnt2.setDisable(true);
                }
            }
        };

        
                
        bnt2.addEventHandler(MouseEvent.MOUSE_CLICKED,clickEventHandler);
        btn.addEventHandler(KeyEvent.KEY_TYPED,keyEventHandler);
        
        HBox root = new HBox();
        root.getChildren().addAll(btn,bnt2);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
