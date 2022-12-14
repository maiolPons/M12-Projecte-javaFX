/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Clients;
import static com.mycompany.projectem12.App.connection;
import static com.mycompany.projectem12.App.usuari;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Maiol
 */
public class ControladorFinestraClients implements Initializable {
    //atributs
    private Clients client;
    
    @FXML private TableView<Clients> ClientsTaula;
    @FXML private Label nomUsuariLabel;
    @FXML private Label estatManipulacio;
    @FXML private Label estatOrdre;
    //inputs
    @FXML private TextField dniClient;
    @FXML private TextField nomClient;
    @FXML private DatePicker naixamentClient;
    @FXML private ComboBox sexeClient;
    @FXML private TextField nacionalitatClient;
    @FXML private TextField telefonClient;
    @FXML private TextField emailClient;
    @FXML private ComboBox estatCivilClient;
    @FXML private TextField ocupacioClient;
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
    //buscador
    @FXML private TextField buscarClientData;
    //get and set

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public TableView<Clients> getClientsTaula() {
        return ClientsTaula;
    }

    public void setClientsTaula(TableView<Clients> ClientsTaula) {
        this.ClientsTaula = ClientsTaula;
    }

    public Label getNomUsuariLabel() {
        return nomUsuariLabel;
    }

    public void setNomUsuariLabel(Label nomUsuariLabel) {
        this.nomUsuariLabel = nomUsuariLabel;
    }

    public Label getEstatManipulacio() {
        return estatManipulacio;
    }

    public void setEstatManipulacio(Label estatManipulacio) {
        this.estatManipulacio = estatManipulacio;
    }

    public Label getEstatOrdre() {
        return estatOrdre;
    }

    public void setEstatOrdre(Label estatOrdre) {
        this.estatOrdre = estatOrdre;
    }

    public TextField getDniClient() {
        return dniClient;
    }

    public void setDniClient(TextField dniClient) {
        this.dniClient = dniClient;
    }

    public TextField getNomClient() {
        return nomClient;
    }

    public void setNomClient(TextField nomClient) {
        this.nomClient = nomClient;
    }

    public DatePicker getNaixamentClient() {
        return naixamentClient;
    }

    public void setNaixamentClient(DatePicker naixamentClient) {
        this.naixamentClient = naixamentClient;
    }

    public ComboBox getSexeClient() {
        return sexeClient;
    }

    public void setSexeClient(ComboBox sexeClient) {
        this.sexeClient = sexeClient;
    }

    public TextField getNacionalitatClient() {
        return nacionalitatClient;
    }

    public void setNacionalitatClient(TextField nacionalitatClient) {
        this.nacionalitatClient = nacionalitatClient;
    }

    public TextField getTelefonClient() {
        return telefonClient;
    }

    public void setTelefonClient(TextField telefonClient) {
        this.telefonClient = telefonClient;
    }

    public TextField getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(TextField emailClient) {
        this.emailClient = emailClient;
    }

    public ComboBox getEstatCivilClient() {
        return estatCivilClient;
    }

    public void setEstatCivilClient(ComboBox estatCivilClient) {
        this.estatCivilClient = estatCivilClient;
    }

    public TextField getOcupacioClient() {
        return ocupacioClient;
    }

    public void setOcupacioClient(TextField ocupacioClient) {
        this.ocupacioClient = ocupacioClient;
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

    public TextField getBuscarClientData() {
        return buscarClientData;
    }

    public void setBuscarClientData(TextField buscarClientData) {
        this.buscarClientData = buscarClientData;
    }
    
    
    
    
    
    //metodes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomUsuariLabel.setText(usuari.getNom());
        initiateComboBox();
        iniciarCeles();
        try {
            extreureClient();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //inicia les combobox amb els valors corresponents
    private void initiateComboBox(){
        getEstatCivilClient().getItems().addAll(
                "Solter","Casat","Unio lliure","Separat","divorciat","Viudo/a"
        );
        getSexeClient().getItems().addAll(
                "Home","dona","altres"
        );

    }
    @FXML
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
    //prepara formulari per la creacio de client nou
    private void crearClient(){
        getEstatManipulacio().setText("Creant nou Client");
        getDniClient().setText("");
        getNomClient().setText("");
        getNaixamentClient().setValue(LocalDate.now());
        getSexeClient().setValue("");
        getNacionalitatClient().setText("");
        getTelefonClient().setText("");
        getEmailClient().setText("");
        getEstatCivilClient().setValue("");
        getOcupacioClient().setText("");
        getEstatOrdre().setText("");
        
    }
    @FXML
    //executa la ordre corresponent
    private void executarOrdre() throws SQLException{
        if(getEstatManipulacio().getText()=="Creant nou Client"){
            comprovarValorsCrear();
        }
        if(getEstatManipulacio().getText()=="Modificar Client"){
            comprovarValorsModificar();
        }
    }
    //fa les comprovacions corresponents i crea la habitacion en cas correcte
    private void comprovarValorsCrear() throws SQLException{
        if((getDniClient().getText() == null || getDniClient().getText().trim().isEmpty()) || (getNomClient().getText() == null || getNomClient().getText().trim().isEmpty())){
            getEstatOrdre().setText("Tots els camps son obligatoris");
        }else{
            
            String funciona="";
            boolean failure=false;

            //arrays amb els valors pel control de caracters
            String[] arrayVariables={getDniClient().getText(),getNomClient().getText(),getNacionalitatClient().getText(),getTelefonClient().getText(),getEmailClient().getText(),getOcupacioClient().getText()};
            String[] arrayErros={"Dni","Nom","Nacionalitat","Telefon","Email","Ocupacio"};
            int[] arrayChars={9,40,60,20,90,40};
            int index =0;
            //Contol de limit caracters
            while(failure==false && arrayVariables.length!=index+1){
                if(arrayVariables[index].length()>arrayChars[index]){
                    funciona=arrayErros[index]+" no pot tenir mes de "+arrayChars[index]+" caracters!";
                    failure=true;
                }
                index++;
            }
            if(failure){
                getEstatOrdre().setText(funciona);
            }else{
                getEstatOrdre().setText("");
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `client` WHERE `dni`='"+getDniClient().getText()+"'");
            System.out.println("INSERT INTO `client` (`dni`,`nomClient`,`dataNaixament`,`sexe`,`nacionalitat`,`telefon`,`email`,`ocupacio`,`estatCivil`) VALUES ('"+getDniClient().getText()+"','"+getNomClient().getText()+"','"+getNaixamentClient().getValue()+"','"+getSexeClient().getValue()+"','"+getNacionalitatClient().getText()+"','"+getTelefonClient().getText()+"','"+getEmailClient().getText()+"','"+getEstatCivilClient().getValue()+"','"+getOcupacioClient().getText()+"')");
            if(rs.next() == true){
                getEstatOrdre().setText("El client ja existeix");
            }else{
                try{
                    stmt.executeUpdate("INSERT INTO `client` (`dni`,`nomClient`,`dataNaixament`,`sexe`,`nacionalitat`,`telefon`,`email`,`ocupacio`,`estatCivil`) VALUES ('"+getDniClient().getText()+"','"+getNomClient().getText()+"','"+getNaixamentClient().getValue()+"','"+getSexeClient().getValue()+"','"+getNacionalitatClient().getText()+"','"+getTelefonClient().getText()+"','"+getEmailClient().getText()+"','"+getEstatCivilClient().getValue()+"','"+getOcupacioClient().getText()+"')");  
                    getEstatOrdre().setText("Client Cread!");
                    getDniClient().setText("");
                    getNomClient().setText("");
                    getNaixamentClient().setValue(LocalDate.now());
                    getSexeClient().setValue("");
                    getNacionalitatClient().setText("");
                    getTelefonClient().setText("");
                    getEmailClient().setText("");
                    getEstatCivilClient().setValue("");
                    getOcupacioClient().setText("");
                    getEstatOrdre().setText("");

                    extreureClient();
                    ClientsTaula.refresh();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        getEstatOrdre().setText("Error amb la creacio del client!");
                    }
                }
            }
        }
            
            
            
            
    }
    @FXML
    //prepara la taula per modificar la habitacio
    private void modificarClient(MouseEvent event){
        
        try{
           setClient((Clients) getClientsTaula().getSelectionModel().getSelectedItem()); 
           getEstatOrdre().setText("");
            getEstatManipulacio().setText("Modificar Client");
            getDniClient().setText(getClient().getDni());
            getNomClient().setText(getClient().getNom());
            String date = getClient().getNaixamen();
            LocalDate naixamentDate = LocalDate.parse(date);
            getNaixamentClient().setValue(naixamentDate);
            getSexeClient().setValue(getClient().getSexe());
            getNacionalitatClient().setText(getClient().getNacionalitat());
            getTelefonClient().setText(getClient().getTelefon());
            getEmailClient().setText(getClient().getEmail());
            getEstatCivilClient().setValue(getClient().getEstatCivil());
            getOcupacioClient().setText(getClient().getOcupacio());
        }catch(Exception e){
            getEstatManipulacio().setText("Cap ordre seleccionada!");
        }
    }
    //fa les comprovacions necesaries i modifica la habitacio
    private void comprovarValorsModificar() throws SQLException{
        if(false){
            getEstatOrdre().setText("Tots els camps son obligatoris");
        }else{
            
            String funciona="";
            boolean failure=false;

            //arrays amb els valors pel control de caracters
            String[] arrayVariables={getDniClient().getText(),getNomClient().getText(),getNacionalitatClient().getText(),getTelefonClient().getText(),getEmailClient().getText(),getOcupacioClient().getText()};
            String[] arrayErros={"Dni","Nom","Nacionalitat","Telefon","Email","Ocupacio"};
            int[] arrayChars={9,40,60,20,90,35};
            int index =0;
            //Contol de limit caracters
            while(failure==false && arrayVariables.length!=index+1){
                if(arrayVariables[index].length()>arrayChars[index]){
                    funciona=arrayErros[index]+" no pot tenir mes de "+arrayChars[index]+" caracters!";
                    failure=true;
                }
                index++;
            }
            if(failure){
                getEstatOrdre().setText(funciona);
            }
            else{
                getEstatOrdre().setText("");
                Statement stmt = connection.getStmt();
                ResultSet rs = null;
                rs = stmt.executeQuery("SELECT * FROM `client` WHERE `dni`='"+getClient().getDni()+"'");
                rs.next();

                try{
                    stmt.executeUpdate("UPDATE `client` SET `dni`='"+getDniClient().getText()+"',`nomClient`='"+getNomClient().getText()+"',`dataNaixament`='"+getNaixamentClient().getValue()+"',`sexe`='"+getSexeClient().getValue()+"',`nacionalitat`='"+getNacionalitatClient().getText()+"',`telefon`='"+getTelefonClient().getText()+"',`email`='"+getEmailClient().getText()+"',`ocupacio`='"+getEstatCivilClient().getValue()+"',`estatCivil`='"+getOcupacioClient().getText()+"' WHERE `dni`='"+getClient().getDni()+"'");
                    getEstatOrdre().setText("Client Modificat!");
                    getEstatManipulacio().setText("");
                    getDniClient().setText("");
                    getNomClient().setText("");
                    getNaixamentClient().setValue(LocalDate.now());
                    getSexeClient().setValue("");
                    getNacionalitatClient().setText("");
                    getTelefonClient().setText("");
                    getEmailClient().setText("");
                    getEstatCivilClient().setValue("");
                    getOcupacioClient().setText("");

                    extreureClient();
                    getClientsTaula().refresh();
                }catch(Exception e){
                    getEstatOrdre().setText("Numero ja existeix");
                }
            }
        }        
    }
    @FXML
    //Buscar llista de clients
    public void buscarExtreureClient() throws SQLException{
        String query="%"+getBuscarClientData().getText()+"%";
        ObservableList<Clients> clientList = FXCollections.observableArrayList();
        Statement stmt = connection.getStmt();
        ResultSet rs = null;
        rs = stmt.executeQuery("SELECT * FROM `client` WHERE (`dni` LIKE '"+query+"' OR `nomClient` LIKE '"+query+"' OR `dataNaixament` LIKE '"+query+"' OR `sexe` LIKE '"+query+"' OR `nacionalitat` LIKE '"+query+"' OR `telefon` LIKE '"+query+"' OR `email` LIKE '"+query+"' OR `ocupacio` LIKE '"+query+"' OR `estatCivil` LIKE '"+query+"')");
        while(rs.next()){
            clientList.add(new Clients(rs.getString("dni"),rs.getString("nomClient"),rs.getString("dataNaixament"),rs.getString("sexe"),rs.getString("nacionalitat"),rs.getString("telefon"),rs.getString("email"),rs.getString("ocupacio"),rs.getString("estatCivil")));
        }
        getClientsTaula().setItems(clientList);
        getClientsTaula().refresh();
    }
//    //elimina el habitacio
//    @FXML
//    public void EliminarClient(){
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        Optional<ButtonType> result = alert.showAndWait();
//        if(result.isPresent() && result.get() == ButtonType.OK){
//            Clients clientEliminar = getClientsTaula().getSelectionModel().getSelectedItem();
//        
//            getClientsTaula().getItems().removeAll(clientEliminar);
//            Statement stmt = connection.getStmt();
//            try {
//                stmt.executeUpdate("UPDATE `client` SET `eliminatClient`=1 WHERE `dni`='"+clientEliminar.getDni()+"'");
//                extreureClient();
//                getClientsTaula().refresh();
//            } catch (SQLException ex) {
//                Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
