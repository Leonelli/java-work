/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparazione_esame;

/**
 *
 * @author Matteo
 */

import java.util.*;


public class E4 {
    int x=2;
    E4(int x) {
        f(x); f();
        System.out.print(x);
    }
    void f() { x++; System.out.print(x);}
    void f(int x) {this.x++; x--; System.out.print(x);}
    public static void main(String arg[]) {
        int x=2;
        new E4(2);
}}