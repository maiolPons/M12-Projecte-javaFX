/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Clients;
import static com.mycompany.projectem12.App.connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Maiol
 */
public class ControladorBuscadorClient extends ControladorFinestraReserves implements Initializable{
    //atributs
    private Clients client;
    //taula
    @FXML private TableView<Clients> ClientsTaula;
    //mostrar client seleccionat
    @FXML private TextField clientSeleccionat;
    //columnas
    @FXML private TableColumn<Clients, String> dniColumna;
    @FXML private TableColumn<Clients, String> nomColumna;
    @FXML private TableColumn<Clients, String> naixamentColumna;
    @FXML private TableColumn<Clients, String> sexeColumna;
    @FXML private TableColumn<Clients, String> nacionalitatColumna;
    @FXML private TableColumn<Clients, String> telefonColumna;
    @FXML private TableColumn<Clients, String> emailColumna;
    @FXML private TableColumn<Clients, String> estatCivilColumna;
    @FXML private TableColumn<Clients, String> ocupacioColumna;
    //gets i sets

    public TableView<Clients> getClientsTaula() {
        return ClientsTaula;
    }

    public void setClientsTaula(TableView<Clients> ClientsTaula) {
        this.ClientsTaula = ClientsTaula;
    }

    public TableColumn<Clients, String> getDniColumna() {
        return dniColumna;
    }

    public void setDniColumna(TableColumn<Clients, String> dniColumna) {
        this.dniColumna = dniColumna;
    }

    public TableColumn<Clients, String> getNomColumna() {
        return nomColumna;
    }

    public void setNomColumna(TableColumn<Clients, String> nomColumna) {
        this.nomColumna = nomColumna;
    }

    public TableColumn<Clients, String> getNaixamentColumna() {
        return naixamentColumna;
    }

    public void setNaixamentColumna(TableColumn<Clients, String> naixamentColumna) {
        this.naixamentColumna = naixamentColumna;
    }

    public TableColumn<Clients, String> getSexeColumna() {
        return sexeColumna;
    }

    public void setSexeColumna(TableColumn<Clients, String> sexeColumna) {
        this.sexeColumna = sexeColumna;
    }

    public TableColumn<Clients, String> getNacionalitatColumna() {
        return nacionalitatColumna;
    }

    public void setNacionalitatColumna(TableColumn<Clients, String> nacionalitatColumna) {
        this.nacionalitatColumna = nacionalitatColumna;
    }

    public TableColumn<Clients, String> getTelefonColumna() {
        return telefonColumna;
    }

    public void setTelefonColumna(TableColumn<Clients, String> telefonColumna) {
        this.telefonColumna = telefonColumna;
    }

    public TableColumn<Clients, String> getEmailColumna() {
        return emailColumna;
    }

    public void setEmailColumna(TableColumn<Clients, String> emailColumna) {
        this.emailColumna = emailColumna;
    }

    public TableColumn<Clients, String> getEstatCivilColumna() {
        return estatCivilColumna;
    }

    public void setEstatCivilColumna(TableColumn<Clients, String> estatCivilColumna) {
        this.estatCivilColumna = estatCivilColumna;
    }

    public TableColumn<Clients, String> getOcupacioColumna() {
        return ocupacioColumna;
    }

    public void setOcupacioColumna(TableColumn<Clients, String> ocupacioColumna) {
        this.ocupacioColumna = ocupacioColumna;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public TextField getClientSeleccionat() {
        return clientSeleccionat;
    }

    public void setClientSeleccionat(TextField clientSeleccionat) {
        this.clientSeleccionat = clientSeleccionat;
    }
    
    
    //metodes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarCeles();
        try {
            extreureClient();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrahabitacions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //inicia les celes de la taula
    private void iniciarCeles(){
        getDniColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("dni"));
        getNomColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("nom"));
        getNaixamentColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("naixamen"));
        getSexeColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("sexe"));
        getNacionalitatColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("nacionalitat"));
        getTelefonColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("telefon"));
        getEmailColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("email"));
        getEstatCivilColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("ocupacio"));
        getOcupacioColumna().setCellValueFactory(new PropertyValueFactory<Clients, String>("estatCivil"));
    }
    //crear llista de clients
    public void extreureClient() throws SQLException{
        ObservableList<Clients> clientList = FXCollections.observableArrayList();
        Statement stmt = connection.getStmt();
        ResultSet rs = null;
        rs = stmt.executeQuery("SELECT * FROM `client`");
        while(rs.next()){
            clientList.add(new Clients(rs.getString("dni"),rs.getString("nomClient"),rs.getString("dataNaixament"),rs.getString("sexe"),rs.getString("nacionalitat"),rs.getString("telefon"),rs.getString("email"),rs.getString("ocupacio"),rs.getString("estatCivil")));
        }
        getClientsTaula().setItems(clientList);
    }
    @FXML
    public void selecionaClient(MouseEvent event){
        try{
            setClient((Clients) getClientsTaula().getSelectionModel().getSelectedItem()); 
            getClientSeleccionat().setText(getClient().getDni());
        }catch(Exception e){
            getClientSeleccionat().setText("Cap client Seleccionat");
        }
    }
    //envia el client a la pagina principal i tanca aquesta
    @FXML
    public void confirmarClient(ActionEvent event){
        getControladorBuscadorClient().getDniClient().setText(getClient().getDni());
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
