/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Recepcionistes;
import static com.mycompany.projectem12.App.connection;
import static com.mycompany.projectem12.App.usuari;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    //buscador
    @FXML private TextField buscarRecepcionista;
    @FXML private RadioButton totsRadio,noValidatsRadio,validatsRadio;
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

    public TextField getBuscarRecepcionista() {
        return buscarRecepcionista;
    }

    public void setBuscarRecepcionista(TextField buscarRecepcionista) {
        this.buscarRecepcionista = buscarRecepcionista;
    }

    public RadioButton getTotsRadio() {
        return totsRadio;
    }

    public void setTotsRadio(RadioButton totsRadio) {
        this.totsRadio = totsRadio;
    }

    public RadioButton getNoValidatsRadio() {
        return noValidatsRadio;
    }

    public void setNoValidatsRadio(RadioButton noValidatsRadio) {
        this.noValidatsRadio = noValidatsRadio;
    }

    public RadioButton getValidatsRadio() {
        return validatsRadio;
    }

    public void setValidatsRadio(RadioButton validatsRadio) {
        this.validatsRadio = validatsRadio;
    }
    
    
    
    //metods

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomUsuariLabel.setText(usuari.getNom());
        iniciarCeles();
        extreureRecepcionistes();
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
    public void extreureRecepcionistes(){
        try {
            ObservableList<Recepcionistes> recepcionistesList = FXCollections.observableArrayList();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `empleats` WHERE `admin` IS NULL");
            while(rs.next()){
                recepcionistesList.add(new Recepcionistes(rs.getString("dni"),rs.getString("nom"),rs.getString("nomUsuari"),rs.getString("cognoms"),rs.getString("contrasenya"),rs.getString("nacionalitat"),rs.getString("telefon"),rs.getString("email"),rs.getString("validat")));
            }
            getRecepcionistesTaula().setItems(recepcionistesList);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
            getEstatOrdre().setText("");
        }catch(Exception e){
            getEstatOrdre().setText("Cap recepcionista seleccionat!");
        }
        
    }
    
    //valida recepcionistes
    @FXML
    private void validarRecep(){
        Recepcionistes recepcionista = (Recepcionistes) getRecepcionistesTaula().getSelectionModel().getSelectedItem();
        if(recepcionista!=null){
            Statement stmt = connection.getStmt();
            try {
                stmt.executeUpdate("UPDATE `empleats` SET `validat`='si' WHERE `dni`='"+recepcionista.getDni()+"'");
                extreureRecepcionistes();
                RecepcionistesTaula.refresh();
                getEstatOrdre().setText("Recepcionista "+recepcionista.getDni()+" validat");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    //retira drets de validacio del recepcionista
    @FXML
    public void declinarRecep(){
        Recepcionistes recepcionista = (Recepcionistes) getRecepcionistesTaula().getSelectionModel().getSelectedItem();
        if(recepcionista!=null){
            Statement stmt = connection.getStmt();
            try {
                stmt.executeUpdate("UPDATE `empleats` SET `validat`='no' WHERE `dni`='"+recepcionista.getDni()+"'");
                extreureRecepcionistes();
                RecepcionistesTaula.refresh();
                getEstatOrdre().setText("Recepcionista "+recepcionista.getDni()+" desabilitat!");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    @FXML
    //Buscar llista de clients
    public void buscarRecepcionistes(){
        try {
            String query="%"+getBuscarRecepcionista().getText()+"%";
            ObservableList<Recepcionistes> recepcionistesList = FXCollections.observableArrayList();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            String validatQuery = "";
            if(getNoValidatsRadio().isSelected()){
                validatQuery="AND `validat`='no'";
            }
            else if(getValidatsRadio().isSelected()){
                validatQuery="AND `validat`='si'";
            }
            rs = stmt.executeQuery("SELECT * FROM `empleats` WHERE (`dni` LIKE '"+query+"' OR `nom` LIKE '"+query+"' OR `cognoms` LIKE '"+query+"' OR `nomUsuari` LIKE '"+query+"' OR `nacionalitat` LIKE '"+query+"' OR `telefon` LIKE '"+query+"' OR `email` LIKE '"+query+"') AND `admin` IS NULL "+validatQuery);
            while(rs.next()){
                recepcionistesList.add(new Recepcionistes(rs.getString("dni"),rs.getString("nom"),rs.getString("nomUsuari"),rs.getString("cognoms"),rs.getString("contrasenya"),rs.getString("nacionalitat"),rs.getString("telefon"),rs.getString("email"),rs.getString("validat")));
            }
            getRecepcionistesTaula().setItems(recepcionistesList);
            getRecepcionistesTaula().refresh();
            System.out.println("SELECT * FROM `empleats` WHERE (`dni` LIKE '"+query+"' OR `nom` LIKE '"+query+"' OR `cognoms` LIKE '"+query+"' OR `nomUsuari` LIKE '"+query+"' OR `nacionalitat` LIKE '"+query+"' OR `telefon` LIKE '"+query+"' OR `email` LIKE '"+query+"') AND `admin` IS NULL AND `validat` LIKE '"+validatQuery+"'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//    //elimina el recepcionista
//    @FXML
//    public void EliminarRecep(){
//        Alert alert = new Alert(AlertType.CONFIRMATION);
//        Optional<ButtonType> result = alert.showAndWait();
//        if(result.isPresent() && result.get() == ButtonType.OK){
//            Recepcionistes recepcionista = (Recepcionistes) getRecepcionistesTaula().getSelectionModel().getSelectedItem();
//            RecepcionistesTaula.getItems().removeAll(recepcionista);
//            Statement stmt = connection.getStmt();
//            try {
//                stmt.executeUpdate("UPDATE `empleats` SET `eliminat`=1 WHERE `dni`='"+recepcionista.getDni()+"'");
//                extreureRecepcionistes();
//                RecepcionistesTaula.refresh();
//                getEstatOrdre().setText("Recepcionista "+recepcionista.getDni()+" Eliminat!");
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }

}
