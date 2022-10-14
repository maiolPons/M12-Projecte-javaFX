/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Recepcionistes;
import static com.mycompany.projectem12.App.connection;
import static com.mycompany.projectem12.App.usuari;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Maiol
 */
public class ControladorFinestrarecepcionistes implements Initializable {
    //atributs
    
    @FXML private Label estatOrdre;
    @FXML private Label nomUsuariLabel;
    //inputs
    @FXML private TextField dnirep;
    @FXML private TextField nomrep;
    @FXML private TextField cognomrep;
    @FXML private TextField usuarirep;
    @FXML private TextField nacionalitatrep;
    @FXML private TextField emailrep;
    @FXML private TextField telefonrep;
    @FXML private TextField validaciorep;
    
    //table
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

    public Label getEstatOrdre() {
        return estatOrdre;
    }

    public void setEstatOrdre(Label estatOrdre) {
        this.estatOrdre = estatOrdre;
    }
    
    
    //metods

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomUsuariLabel.setText(usuari.getNom());
        try {
            iniciarCeles();
            extreureRecepcionistes();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //declara el valor que representen les columnes
    @FXML
    private void iniciarCeles(){
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
        rs = stmt.executeQuery("SELECT * FROM `empleats` WHERE `admin` IS NULL");
        while(rs.next()){
            recepcionistesList.add(new Recepcionistes(rs.getString("dni"),rs.getString("nom"),rs.getString("nomUsuari"),rs.getString("cognoms"),rs.getString("contrasenya"),rs.getString("nacionalitat"),rs.getString("telefon"),rs.getString("email"),rs.getString("validat")));
        }
        getRecepcionistesTaula().setItems(recepcionistesList);
    }
    //seleccionar recepcionistes i mostra les dades en el display del centra de la pantalla
    @FXML
    private void seleccionaRecepcionista(MouseEvent event){
        try{
            Recepcionistes recepcionista = (Recepcionistes) getRecepcionistesTaula().getSelectionModel().getSelectedItem();
            dnirep.setText(recepcionista.getDni());
            nomrep.setText(recepcionista.getNom());
            cognomrep.setText(recepcionista.getCognom());
            usuarirep.setText(recepcionista.getNomUsuari());
            nacionalitatrep.setText(recepcionista.getNacionalitat());
            emailrep.setText(recepcionista.getEmail());
            telefonrep.setText(recepcionista.getTelefon());
            validaciorep.setText(recepcionista.getValidat());
        }catch(Exception e){
            getEstatOrdre().setText("Cap recepcionista seleccionat!");
        }
        
    }
    
    //valida recepcionistes
    @FXML
    private void validarRecep() throws IOException{
        Recepcionistes recepcionista = (Recepcionistes) getRecepcionistesTaula().getSelectionModel().getSelectedItem();
        //recepcionista.setValidat("si");
        //RecepcionistesTaula.getItems().removeAll(recepcionista);
        //getRecepcionistesTaula().getItems().add(recepcionista);
        Statement stmt = connection.getStmt();
        try {
            stmt.executeUpdate("UPDATE `empleats` SET `validat`='si' WHERE `dni`='"+recepcionista.getDni()+"'");
            extreureRecepcionistes();
            RecepcionistesTaula.refresh();
            getEstatOrdre().setText("Recepcionista "+recepcionista.getDni()+" validat");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //retira drets de validacio del recepcionista
    @FXML
    public void declinarRecep() throws IOException{
        Recepcionistes recepcionista = (Recepcionistes) getRecepcionistesTaula().getSelectionModel().getSelectedItem();
        //recepcionista.setValidat("no");
        //RecepcionistesTaula.getItems().removeAll(recepcionista);
        //getRecepcionistesTaula().getItems().add(recepcionista);
        Statement stmt = connection.getStmt();
        try {
            stmt.executeUpdate("UPDATE `empleats` SET `validat`='no' WHERE `dni`='"+recepcionista.getDni()+"'");
            extreureRecepcionistes();
            RecepcionistesTaula.refresh();
            getEstatOrdre().setText("Recepcionista "+recepcionista.getDni()+" desabilitat!");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //elimina el recepcionista
    @FXML
    public void EliminarRecep() throws IOException{
        Recepcionistes recepcionista = (Recepcionistes) getRecepcionistesTaula().getSelectionModel().getSelectedItem();
        RecepcionistesTaula.getItems().removeAll(recepcionista);
        Statement stmt = connection.getStmt();
        try {
            stmt.executeUpdate("DELETE FROM `empleats` WHERE `dni`='"+recepcionista.getDni()+"'");
            extreureRecepcionistes();
            RecepcionistesTaula.refresh();
            getEstatOrdre().setText("Recepcionista "+recepcionista.getDni()+" Eliminat!");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
