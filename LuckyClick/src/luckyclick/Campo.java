/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckyclick;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Matteo
 */
public class Campo extends GridPane {

    Cella[][] campo;

    public Campo() {

        campo = new Cella[Commons.DIMCAMPO][Commons.DIMCAMPO];

        ArrayList<Cella> array_celle = new ArrayList<Cella>();
        for (int i = 0; i < 75; i++) {
            array_celle.add(new Base());
        }
        for (int i = 0; i < 10; i++) {
            array_celle.add(new Moltiplicatore());
        }
        for (int i = 0; i < 10; i++) {
            array_celle.add(new Divisore());
        }
        for (int i = 0; i < 5; i++) {
            array_celle.add(new Bomba());
        }

        //System.err.println("array_celle: " + array_celle);
        Collections.shuffle(array_celle);
        //System.out.println("array_celle: " + array_celle);

        /*for (int i = 0; i < Commons.DIMCAMPO; i++) {
            for (int j = 0; j < Commons.DIMCAMPO; j++) {
                Cella c;
                if (i % 4 == 0) {
                    c = new Base();
                    this.add(c, i, j);
                } else if (i % 3 == 0) {
                    c = new Moltiplicatore();
                    this.add(c, i, j);
                } else if (i % 2 == 0) {
                    c = new Divisore();
                    this.add(c, i, j);
                } else {
                    c = new Bomba();
                    this.add(c, i, j);
                }
                campo[i][j] = c;
                System.err.print(c + " ");

            }
            System.err.println();
        }*/
        
        int indice_celle=0;
        for (int i = 0; i < Commons.DIMCAMPO; i++) {
            for (int j = 0; j < Commons.DIMCAMPO; j++) {
                Cella c = array_celle.get(indice_celle);
                this.add(c, i, j);
                indice_celle++;
                //System.out.println("rowindex: "+GridPane.getRowIndex(c));
            }
        }
        
    }
}
