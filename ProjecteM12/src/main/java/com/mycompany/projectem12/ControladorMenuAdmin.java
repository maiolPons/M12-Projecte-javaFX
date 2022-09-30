/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;


import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Maiol
 */

public class ControladorMenuAdmin extends ControladorMenuGlobal {
    //atributs
    private Stage stageMenuAdmin= new Stage();
    private Stage stageHabitacio;
    private Stage stageRecepcionistes;
    //get and set

    public Stage getStageMenuAdmin() {
        return stageMenuAdmin;
    }

    public void setStageMenuAdmin(Stage stageMenuAdmin) {
        this.stageMenuAdmin = stageMenuAdmin;
    }

    public Stage getStageHabitacio() {
        return stageHabitacio;
    }

    public void setStageHabitacio(Stage stageHabitacio) {
        this.stageHabitacio = stageHabitacio;
    }

    public Stage getStageRecepcionistes() {
        return stageRecepcionistes;
    }

    public void setStageRecepcionistes(Stage stageRecepcionistes) {
        this.stageRecepcionistes = stageRecepcionistes;
    }
    
    
    //metodes
    //obrar finestra de menu administrador
    public void obrirMenuAdmin(String menu) throws IOException{
        Parent root = FXMLLoader.load(App.class.getResource(menu + ".fxml"));
        Scene scene =new Scene(root);
        getStageMenuAdmin().setScene(scene);
        getStageMenuAdmin().show();
    }
    @FXML
    //obrar finestra de habitacions del admin
        public void obrirAdminHabitacions(ActionEvent event) throws IOException{
        if(getStageHabitacio() == null){
            Parent root = FXMLLoader.load(App.class.getResource("finestraHabitacions" + ".fxml"));
            setStageHabitacio(new Stage());
            Scene scene3 =new Scene(root);
            getStageHabitacio().setScene(scene3);
            getStageHabitacio().show();
            } 
        else if(getStageHabitacio().isShowing()){
            getStageHabitacio().toFront();
        }
        else {
            getStageHabitacio().show();
        }
    }
    //obrar finestra de recepcionistes del admin
    public void obrirAdminRecepcionistes(ActionEvent event) throws IOException{
        if(getStageRecepcionistes() == null){
            Parent root = FXMLLoader.load(App.class.getResource("finestraRecepcionistes" + ".fxml"));
            setStageRecepcionistes(new Stage());
            Scene scene2 =new Scene(root);
            getStageRecepcionistes().setScene(scene2);
            getStageRecepcionistes().show();
        }
        else if(getStageRecepcionistes().isShowing()){
            getStageRecepcionistes().toFront();
        }
        else {
            getStageRecepcionistes().show();
        }
        
    }
}
