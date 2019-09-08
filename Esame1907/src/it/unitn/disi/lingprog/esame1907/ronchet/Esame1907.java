package it.unitn.disi.lingprog.esame1907.ronchet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Classe principale del programma
 *
 * @author ronchet
 */
public class Esame1907 extends Application {

    Button resetBtn = new Button();
    Button alfiereBtn = new Button();
    Button pedoneBtn = new Button();
    Button torreBtn = new Button();
    Button selected = resetBtn;
    Text selectedInfo = new Text("selected = none");
    Scacchiera scacchiera = null;

    /**
     * Metodo di avvio.
     * <UL><LI> crea i controller per bottoni, per le caselle e per gli eventi
     * di tastiera </LI>
     * <LI> leggi l'input dell'utente </LI>
     * <LI> crea le componenti dell'interaccia grafica (bottoni, caselle,
     * scacchiera) </LI>
     * <LI> avvia l'interazione con l'utente mostrando lo stage.</LI></UL>
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        // controllore per i bottoni 
        EventHandler<ActionEvent> buttonController = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String command = ((Button) (event.getSource())).getId();
                execCommand(command);
            }
        };
        // controllore degli eventi di tastiera
        EventHandler<KeyEvent> keyController = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String c = event.getCharacter();
                if ("rRaApPtT".contains(c))
                    execCommand(c);
                else
                    System.out.println("carattere " + c + " non previsto");
            }
        };
        // controllore per le caselle, per la creazione dei pezzi
        EventHandler<MouseEvent> cellController = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Casella c = (Casella) (event.getSource());
                System.out.println(c);
                if (c.pezzo != null)
                    return; // cella già occupata
                if (selected == resetBtn)
                    return; // nessun pezzo da creare
                else if (selected == torreBtn) {
                    c.setPezzo(new Torre(scacchiera));
                } else if (selected == alfiereBtn) {
                    c.setPezzo(new Alfiere(scacchiera));
                } else if (selected == pedoneBtn) {
                    c.setPezzo(new Pedone(scacchiera));
                }
            }
        };
        int n = getNumberFromUser();
        scacchiera = new Scacchiera(n, cellController);
        scacchiera.setAlignment(Pos.CENTER);
        resetBtn.setText("Reset");
        resetBtn.setId("R");
        resetBtn.setOnAction(buttonController);
        alfiereBtn.setText("Alfiere");
        alfiereBtn.setId("A");
        alfiereBtn.setOnAction(buttonController);
        torreBtn.setText("Torre");
        torreBtn.setId("T");
        torreBtn.setOnAction(buttonController);
        pedoneBtn.setText("Pedone");
        pedoneBtn.setId("P");
        pedoneBtn.setOnAction(buttonController);
        HBox hb = new HBox();
        TilePane tp = new TilePane();
        tp.getChildren().addAll(resetBtn, pedoneBtn, torreBtn, alfiereBtn);
        hb.getChildren().addAll(tp, selectedInfo);
        hb.setAlignment(Pos.CENTER);
        BorderPane root = new BorderPane();
        root.setCenter(scacchiera);
        root.setBottom(hb);
        root.addEventHandler(KeyEvent.KEY_TYPED, keyController);
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Scacchiera");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Controllo generalizzato dei comandi
     *
     * @param command comando
     */
    public void execCommand(String command) {
        selected.setDisable(false);
        switch (command) {
            case "R":
            case "r":
                scacchiera.rimuoviPezzi();
                selected = resetBtn;
                selectedInfo.setText("selected = none");
                break;
            case "P":
            case "p":
                selected = pedoneBtn;
                selectedInfo.setText("selected = Pedone");
                break;
            case "T":
            case "t":
                selected = torreBtn;
                selectedInfo.setText("selected = Torre");
                break;
            case "A":
            case "a":
                selected = alfiereBtn;
                selectedInfo.setText("selected = Alfiere");
                break;
            default:
                System.out.println("Unknown command " + command);
        }
        if (selected != resetBtn)
            selected.setDisable(true);
    }

    /**
     * interazione con l'utente tramite DialogBox
     *
     * @return
     */
    private int getNumberFromUser() {
        String response = null;
        int n = 0;
        response = "";
        do {
            TextInputDialog dialog = new TextInputDialog("8");
            dialog.setTitle("Dammi un numero");
            dialog.setHeaderText(response + "Dammi un numero compreso tra 4 e 10 (esclusi)");
            dialog.setContentText("Numero:");
            response = "";
            String s = dialog.showAndWait().get();
            try {
                n = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                response = new String(s + " non è un numero. ");
            }
            if (response.equals("")) {
                if (n <= 4 || n >= 10) {
                    response = new String(n + " è fuori dal range [5-9]. ");
                }
            }
            System.out.println("R: " + response);
        } while (!response.equals(""));
        return n;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
