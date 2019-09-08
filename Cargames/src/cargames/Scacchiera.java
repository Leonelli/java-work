/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargames;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Matteo
 */
public class Scacchiera extends GridPane {

    final int N_CELLE = 8;
    int row, col;
    GameArea parent;
    public Terreno[][] campo = new Terreno[N_CELLE][N_CELLE];

    public Scacchiera(GameArea parent, int row, int col) {
        this.parent = parent;
        this.row = row;
        this.col = col;

        for (int i = 0; i < N_CELLE; i++) {
            for (int j = 0; j < N_CELLE; j++) {
                if (i == 0 || j == 0 || i == N_CELLE - 1 || j == N_CELLE - 1) {
                    Strada strada = new Strada(parent);
                    this.add(strada, i, j);
                    campo[i][j] = strada;
                } else {
                    Prato prato = new Prato(parent);
                    this.add(prato, i, j);
                    campo[i][j] = prato;
                }
            }
        }
        
        
        
    }

    void stampaCampo() {
        Auto a = new Auto(parent);

        for (int i = 0; i < N_CELLE; i++) {
            for (int j = 0; j < N_CELLE; j++) {
                System.err.print(campo[i][j] + " ");
            }
            System.err.println("");
        }
    }

    void Move(String command) {
        if ("top".equals(command)) {
            for (int i = 0; i < N_CELLE; i++) {
                for (int j = 0; j < N_CELLE; j++) {
                    if (campo[i][j] instanceof Auto) {
                        //se non è sul bordo, fare controllo
                        //campo[i][j] = 
                        System.out.println("cìè un auto in "+ i +" "+j);
                    }
                }
            }
        }
    }
    
    
    

}
