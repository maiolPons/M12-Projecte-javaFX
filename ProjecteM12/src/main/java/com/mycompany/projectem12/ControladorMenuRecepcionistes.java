/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Maiol
 */
public class ControladorMenuRecepcionistes extends ControladorMenuGlobal {
    //atributs
    private Stage stageClient;
    private Stage stageReserves;
    private ControladorFinestraReserves ControladorFinestraReserves;
    //get and set

    public Stage getStageClient() {
        return stageClient;
    }

    public void setStageClient(Stage stageClient) {
        this.stageClient = stageClient;
    }

    public Stage getStageReserves() {
        return stageReserves;
    }

    public void setStageReserves(Stage stageReserves) {
        this.stageReserves = stageReserves;
    }

    public ControladorFinestraReserves getControladorFinestraReserves() {
        return ControladorFinestraReserves;
    }

    public void setControladorFinestraReserves(ControladorFinestraReserves ControladorFinestraReserves) {
        this.ControladorFinestraReserves = ControladorFinestraReserves;
    }

    
    //metodes
    
    //obrar finestra de clients del recepcionista
        @FXML
        public void obrirReserves(ActionEvent event) throws IOException{
            if(getStageReserves()== null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FinestraReserves" + ".fxml"));
            Parent root = (Parent) loader.load();
            setControladorFinestraReserves(loader.getController());
            setStageReserves(new Stage());
            getStageReserves().setScene(new Scene(root));
            getStageReserves().show();
            
            } 
        else if(getStageReserves().isShowing()){
            getStageReserves().toFront();
        }
    }
         //obrar finestra de clients del recepcionista
        @FXML
        public void obrirClients(ActionEvent event) throws IOException{
        if(getStageClient()== null){
            Parent root = FXMLLoader.load(App.class.getResource("FinestraClients" + ".fxml"));
            setStageClient(new Stage());
            Scene scene3 =new Scene(root);
            getStageClient().setScene(scene3);
            getStageClient().show();
            } 
        else if(getStageClient().isShowing()){
            getStageClient().toFront();
        }
        else {
            getStageClient().show();
        }
    }
}
