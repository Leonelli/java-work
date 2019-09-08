/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Matteo
 */
public class Scacchi extends Application {

    public static final int TILE_SIZE = 100;
    public static int HEIGHT = 8;
    public static int WIDTH = 8;

    private Tile[][] board = new Tile[WIDTH][HEIGHT];
    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();

    private Piece makePiece(PieceType type, int x, int y) {
        Piece piece = new Piece(type, x, y);
        //board[x][y].setPiece(piece);
        pieceGroup.getChildren().add(piece);
        return piece;
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane schermata = new BorderPane();

        HBox hb = new HBox();
        Button reset = new Button("Reset");
        Button pedone = new Button("pedone");
        Button torre = new Button("torre");
        Button alfiere = new Button("alfiere");
        Text eticchetta = new Text("selected=");
        Text txt = new Text("none");

        hb.getChildren().addAll(reset, pedone, torre, alfiere, eticchetta, txt);

        int n = getNumberFromUser();
        HEIGHT = n;
        WIDTH = n;

        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);

        EventHandler<MouseEvent> clickEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                System.out.println("aggiungo pezzo");

                PieceType tipoPedina = null;
                String tipoPedinaTxt = txt.getText().toString();
                if (tipoPedinaTxt == "pedone") {
                    tipoPedina = PieceType.P;
                    makePiece(tipoPedina, 4, 3);

                } else if (tipoPedinaTxt == "alfiere") {
                    tipoPedina = PieceType.A;
                    makePiece(tipoPedina, 4, 3);

                } else if (tipoPedinaTxt == "torre") {
                    tipoPedina = PieceType.T;
                    makePiece(tipoPedina, 4, 3);

                } else {
                    System.out.println("Non hai selezionato nessuna pedina");
                }

            }
        };

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile((x + y) % 2 == 0, x, y);
                board[x][y] = tile;

                tile.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, clickEventHandler);

                tileGroup.getChildren().add(tile);

                Piece piece = null;

                if (piece != null) {

                    tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }

        pedone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                txt.setText("pedone");
            }
        });

        alfiere.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                txt.setText("alfiere");
            }
        });

        torre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                txt.setText("torre");
            }
        });

        schermata.setCenter(root);
        schermata.setBottom(hb);

        Scene scene = new Scene(schermata);

        primaryStage.setTitle("Scacchi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

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
