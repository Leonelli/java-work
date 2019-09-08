package it.unitn.disi.lingprog.esame1906;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * classe principale
 * @author ronchet
 */
public class Esame1906 extends Application implements EventHandler<KeyEvent> {
    /**
     * costante che definisce la posizione in alto
     */
    static public final int TOP = 0;
    /**
     * costante che definisce la posizione in basso
     */    static public final int BOTTOM = 1;
    HBox hbox = new HBox();
    VerticalContainer vbox = null;

    @Override
    public void start(Stage primaryStage) {
        vbox = new VerticalContainer(this);
        int nTiles = getNumberFromUser();
        vbox.populate(nTiles);
        //
        Button btn = new Button();
        btn.setText("Riordina");
        btn.setAlignment(Pos.CENTER);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.sort();
            }
        });
        //
        BorderPane gc = new BorderPane();
        gc.setTop(btn);
        gc.setBottom(hbox);
        gc.setCenter(vbox);
        //
        Scene scene = new Scene(gc, 500, 500);
        scene.addEventFilter(KeyEvent.KEY_TYPED, this);
        //
        primaryStage.setTitle("Tiles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * metodo per chiedere all'utente il numero di tiles
     * @return valore scelto dall'utente
     */
    private int getNumberFromUser() {
        String response = null;
        int n = 0;
        response = "";
        do {
            TextInputDialog dialog = new TextInputDialog("8");
            dialog.setTitle("Dammi un numero");
            dialog.setHeaderText(response + "Dammi un numero pari compreso tra 4 e 10");
            dialog.setContentText("Numero:");
            response = "";
            String s = dialog.showAndWait().get();
            try {
                n = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                response = new String(s + " non è un numero. ");
            }
            if (response.equals("")) {
                if (n % 2 == 1) {
                    response = new String(n + " non è un numero pari. ");
                } else if (n < 4 || n > 10) {
                    response = new String(n + " è fuori dal range [4-10]. ");
                }
            }
            System.out.println("R: " + response);
        } while (!response.equals(""));
        return n;
    }

    /**
     * Gestione degli eventi di tastiera
     *
     * @param event evento
     */
    // versione con gli if
    @Override
    public void handle(KeyEvent event) {
        String c = event.getCharacter();
        System.out.println(event.getCode().isDigitKey() + " " + event.getCode() + " " + c);
        if (c.equalsIgnoreCase("r"))
            vbox.sort();
        else if ("0123456789".contains(c))
            vbox.push(Integer.parseInt(c));
        else
            System.out.println("carattere " + c + " non previsto");
    }
    // versione con lo switch
    /*
    @Override
    public void handle(KeyEvent event) {
        String c=event.getCharacter();
        System.out.println(event.getCode().isDigitKey()+" "+event.getCode()+" "+c);
        switch (c) {
            case "r": 
            case "R":
                vbox.sort();
                break;
            case "0":    
            case "1":    
            case "2":    
            case "3":    
            case "4":    
            case "5":    
            case "6":    
            case "7":    
            case "8":    
            case "9":
                vbox.push(Integer.parseInt(c));
                break;
            default: 
                System.out.println("carattere "+c+" non previsto");
        }
    }
    */
}