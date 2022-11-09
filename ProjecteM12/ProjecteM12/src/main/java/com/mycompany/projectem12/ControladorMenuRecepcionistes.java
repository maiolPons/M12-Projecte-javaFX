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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Maiol
 */
public class ControladorMenuRecepcionistes extends ControladorMenuGlobal {
    //atributs
    private Stage stageClient;
    private Stage stageReserves;
    private Stage stageLlistarReserves;
    private static ControladorFinestraReserves ControladorFinestraReserves;
    private static ControladorLlistarReserves ControladorFinestraLlistarReserves;
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

    public static ControladorFinestraReserves getControladorFinestraReserves() {
        return ControladorFinestraReserves;
    }

    public void setControladorFinestraReserves(ControladorFinestraReserves ControladorFinestraReserves) {
        this.ControladorFinestraReserves = ControladorFinestraReserves;
    }

    public Stage getStageLlistarReserves() {
        return stageLlistarReserves;
    }

    public void setStageLlistarReserves(Stage stageLlistarReserves) {
        this.stageLlistarReserves = stageLlistarReserves;
    }

    public static ControladorLlistarReserves getControladorFinestraLlistarReserves() {
        return ControladorFinestraLlistarReserves;
    }

    public static void setControladorFinestraLlistarReserves(ControladorLlistarReserves ControladorFinestraLlistarReserves) {
        ControladorMenuRecepcionistes.ControladorFinestraLlistarReserves = ControladorFinestraLlistarReserves;
    }



    
    //metodes
    
        //obrir finestra de reserves del recepcionista
        @FXML
        public void obrirReserves(ActionEvent event){
            if(getStageReserves()== null){
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FinestraReserves" + ".fxml"));
                    Parent root = (Parent) loader.load();
                    setControladorFinestraReserves(loader.getController());
                    setStageReserves(new Stage());
                    getStageReserves().getIcons().add(new Image("file:src/main/resources/media/icon.png"));
                    getStageReserves().setTitle("Reserves");
                    getStageReserves().setScene(new Scene(root));
                    getStageReserves().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            
            } 
        else if(getStageReserves().isShowing()){
            getStageReserves().toFront();
        }
        else {
            getStageReserves().show();
            }
        }
         //obrir finestra de clients del recepcionista
        @FXML
        public void obrirClients(ActionEvent event){
        if(getStageClient()== null){
            try {
                Parent root = FXMLLoader.load(App.class.getResource("FinestraClients" + ".fxml"));
                setStageClient(new Stage());
                Scene scene3 =new Scene(root);
                getStageClient().setScene(scene3);
                getStageClient().getIcons().add(new Image("file:src/main/resources/media/icon.png"));
                getStageClient().setTitle("Clients");
                getStageClient().show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            } 
        else if(getStageClient().isShowing()){
            getStageClient().toFront();
        }
        else {
            getStageClient().show();
        }
    }
        //obrir finestra de llistar reserves del recepcionista
        @FXML
        public void obrirLlistarReserves(ActionEvent event){
            if(getStageLlistarReserves()== null){
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("LlistarReserves" + ".fxml"));
                    Parent root = (Parent) loader.load();
                    setControladorFinestraLlistarReserves(loader.getController());
                    setStageLlistarReserves(new Stage());
                    getStageLlistarReserves().setScene(new Scene(root));
                    getStageLlistarReserves().getIcons().add(new Image("file:src/main/resources/media/icon.png"));
                    getStageLlistarReserves().setTitle("Llistar reserves");
                    getStageLlistarReserves().show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            
            } 
        else if(getStageLlistarReserves().isShowing()){
            getStageLlistarReserves().toFront();
        }
        else {
            getStageLlistarReserves().show();
            }
        }
}
