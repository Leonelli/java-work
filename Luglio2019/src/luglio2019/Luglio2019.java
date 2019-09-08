/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luglio2019;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Marco
 */
public class Luglio2019 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        int N=0;
        Collection<Casella> caselle = new ArrayList();
        Collection<Pedina> pedine = new ArrayList();
        
        HBox pulsanti = new HBox();
        Text sel = new Text("selected = none");
        Bottone resb = new Bottone("Reset",sel, pedine, caselle);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, resb.getOnKeyTyped());
        Bottone pedb = new Bottone("Pedone",sel, pedine, caselle);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, pedb.getOnKeyTyped());
        Bottone torb = new Bottone("Torre",sel,pedine, caselle);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, torb.getOnKeyTyped());
        Bottone alfb = new Bottone("Alfiere",sel, pedine, caselle);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, alfb.getOnKeyTyped());
        
        
        
        
        do{
            TextInputDialog dialog = new TextInputDialog("Dimensione scacchiera");
            dialog.setTitle("Dimensione");
            dialog.setHeaderText("Di che dimensione la scacchiera? (4<N<10)");
            dialog.setContentText("Inserire risposta: ");
            String s = dialog.showAndWait().get();
            N = Integer.parseInt(s);
        }while(N<=4 || N>=10);
 
        StackPane root = new StackPane();
        
        GridPane scacchiera = new GridPane();
        scacchiera.setAlignment(Pos.CENTER);
        scacchiera.setMaxHeight(300);
        Casella c=null;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                c = new Casella(i,j,sel,caselle,pedine);
                scacchiera.add(c,i,j);
                caselle.add(c);
            }
        }
        
        System.out.println(c.x);
        //primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, c.c.getOnMouseClicked());        
        
        HBox fondo = new HBox();
        
        pulsanti.setAlignment(Pos.BOTTOM_LEFT);
        pulsanti.setSpacing(10);
        pulsanti.getChildren().addAll(resb,pedb,torb,alfb);
        
        
        
        fondo.setSpacing(50);
        fondo.setAlignment(Pos.BOTTOM_CENTER);
       // fondo.setMaxHeight(250);
        fondo.getChildren().addAll(pulsanti, sel);
        
        
        root.getChildren().addAll(fondo,scacchiera);
        
        Scene scene = new Scene(root, N*100, N*100);
        
        primaryStage.setTitle("Scacchiera");
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
