/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazzoCarte;

import java.util.Comparator;

/**
 *
 * @author Matteo
 */
public class CartaValore implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Carta c1 = (Carta) o1;
        Carta c2 = (Carta) o2;
        int retval= c1.numero - c1.numero;
        if (retval == 0) {
            retval = c1.seme - c2.seme;
        }
        return retval;
    }
    
}
