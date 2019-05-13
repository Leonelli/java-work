package mazzocarte;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matteo
 */
public class Carta {
    int numero;
    int seme;
    
    Carta(int numero,int seme){
        this.numero=numero;
        this.seme = seme;
    }

    @Override
    public String toString() {
        return "Carta{" + "numero=" + numero + ", seme=" + seme + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.seme != other.seme) {
            return false;
        }
        return true;
    }
    
    
}
