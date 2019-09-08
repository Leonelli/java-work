/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoautomobili;

/**
 *
 * @author Matteo
 */
public class Automobile extends Record implements Comparable {

    String marca;
    String modello;
    Integer prezzo;

    @Override
    public String toString() {
        return "Automobile{" + "marca=" + marca + ", modello=" + modello + ", prezzo=" + prezzo + '}';
    }

    public Automobile(String marca, String modello, Integer prezzo) {
        super(marca, modello, prezzo);
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
    }

    @Override
    public int compareTo(Object o) {
        if (this.equals(o)) {
            return 0;
        }
        if (this.prezzo < ((Automobile) o).prezzo) {
            return -1;
        }
        return 1;
    }

}
