/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Recepcionistes;
import static com.mycompany.projectem12.App.connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Maiol
 */
public class ControladorFinestrarecepcionistes implements Initializable {
    //atributs
    @FXML private TableView<Recepcionistes> RecepcionistesTaula;
    
    @FXML private TableColumn<Recepcionistes, String> dniColumna;
    @FXML private TableColumn<Recepcionistes, String> nomColumna;
    @FXML private TableColumn<Recepcionistes, String> cognomsColumna;
    @FXML private TableColumn<Recepcionistes, String> usuariColumna;
    @FXML private TableColumn<Recepcionistes, String> nacionalitatColumna;
    @FXML private TableColumn<Recepcionistes, String> emailColumna;
    @FXML private TableColumn<Recepcionistes, String> telefonColumna;
    @FXML private TableColumn<Recepcionistes, String> validacioColumna;
    
    //sets i gets
    @FXML
    public TableView getRecepcionistesTaula() {
        return RecepcionistesTaula;
    }
    @FXML
    public void setRecepcionistesTaula(TableView RecepcionistesTaula) {
        this.RecepcionistesTaula = RecepcionistesTaula;
    }
    
    //metods
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            iniciarCeles();
            extreureRecepcionistes();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void iniciarCeles(){
        dniColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("dni"));
        nomColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("nom"));
        cognomsColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("cognom"));
        usuariColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("nomUsuari"));
        nacionalitatColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("nacionalitat"));
        emailColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("email"));
        telefonColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("telefon"));
        validacioColumna.setCellValueFactory(new PropertyValueFactory<Recepcionistes, String>("validat"));
    }
    //crear llista de recepcionistes
    public void extreureRecepcionistes() throws SQLException{
        ObservableList<Recepcionistes> recepcionistesList = FXCollections.observableArrayList();
        Statement stmt = connection.getStmt();
        ResultSet rs = null;
        rs = stmt.executeQuery("SELECT * FROM `empleats` WHERE `admin`!='admin'");
        while(rs.next()){
            String validat = "no";
            if(rs.getString("validat")!=null){
                validat = "si";
            }
            recepcionistesList.add(new Recepcionistes(rs.getString("dni"),rs.getString("nom"),rs.getString("nomUsuari"),rs.getString("cognoms"),rs.getString("contrasenya"),rs.getString("nacionalitat"),rs.getString("telefon"),rs.getString("email"),validat));
        }
        getRecepcionistesTaula().setItems(recepcionistesList);
        //getRecepcionistesTaula().getItems().addAll(recepcionistesList);
        
    }


}
