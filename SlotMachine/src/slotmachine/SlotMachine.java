/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class SlotMachine extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        Label label = new Label("Super \n Slot");
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setMinSize(500, 200);
        label.setMaxSize(500, 200);
        label.setPrefSize(500, 200);
        label.setFont(Font.font(40));
        label.setAlignment(Pos.CENTER);
        label.setTextFill(Color.BLUE);
        
        BottonePersonalizzato new_game = new BottonePersonalizzato("Nuova partita");
        BottonePersonalizzato spin = new BottonePersonalizzato("Spin");
        BottonePersonalizzato pay = new BottonePersonalizzato("Pay");

        ImmagineSlot img1 = new ImmagineSlot("triangolo");
        ImmagineSlot img2 = new ImmagineSlot("parallelogramma");
        ImmagineSlot img3 = new ImmagineSlot("esagono");
        
        Moneta moneta1 = new Moneta();
        Moneta moneta2 = new Moneta();
        Moneta moneta3 = new Moneta();

        Contatore credito = new Contatore("Credito",0);
        Contatore punteggio = new Contatore("Punteggio",0);


        HBox tilepane = new HBox();
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        VBox vbox_monete = new VBox();

        vbox_monete.getChildren().addAll(moneta1,moneta2,moneta3);
        hbox.getChildren().addAll(new_game,spin,pay);
        vbox.getChildren().addAll(credito,punteggio,hbox);
        tilepane.getChildren().addAll(img1,img2,img3);
        
        Group bottoni = new Group(vbox);
        Group immagini = new Group(tilepane);
        Group gruppo_moneta = new Group(vbox_monete);
        
        BorderPane root = new BorderPane();
        BorderPane.setAlignment(label, Pos.TOP_CENTER);
        BorderPane.setAlignment(bottoni, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(immagini, Pos.CENTER);
        BorderPane.setAlignment(gruppo_moneta, Pos.CENTER_RIGHT);
        root.setTop(label);
        root.setBottom(bottoni);
        root.setCenter(immagini);
        root.setRight(gruppo_moneta);
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.setTitle("Slot Machine");
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
