/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckyclick;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Matteo
 */
public class MainGame extends BorderPane
{
    Header header;
    Campo campo;
    public MainGame(){
        header = new Header();
        this.setTop(header);
        header.setAlignment(Pos.CENTER);
        
        campo = new Campo();
        this.setCenter(campo);
        campo.setAlignment(Pos.CENTER);
        
    }
}
