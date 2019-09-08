/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Matteo
 */
public class Automobile extends Record{
    /**
     *
     * @param nome
     * @param cognome
     * @param anno
     */
    public Automobile(String marca, String modello,int prezzo){
        super(marca,modello,prezzo);
    }
}
