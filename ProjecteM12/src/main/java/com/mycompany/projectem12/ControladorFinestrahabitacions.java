/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import static com.mycompany.projectem12.App.usuari;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Maiol
 */
public class ControladorFinestrahabitacions implements Initializable {
    //atributs
    @FXML
    private Label nomUsuariLabel;
    //metodes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomUsuariLabel.setText(usuari.getNom());
    }
    @FXML
    private void crearHabitacio(){
        
    }
}
