/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Reserva;
import static com.mycompany.projectem12.App.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Maiol
 */
public class ControladorConfirmacioReserva {
    //atributs
    private Reserva reserva;
    @FXML private TextField dniClient;
    @FXML private TextField nomClient;
    @FXML private TextField numHabitacio;
    @FXML private TextField plantaHabitacio;
    @FXML private TextField diaEntrada;
    @FXML private TextField diaSortida;
    @FXML private TextField preu;
    @FXML private TextArea obsText;
    //label errors
    @FXML private Label errorLabel;
    
    //gets i sets
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public TextField getNumHabitacio() {
        return numHabitacio;
    }

    public void setNumHabitacio(TextField numHabitacio) {
        this.numHabitacio = numHabitacio;
    }

    public TextField getPlantaHabitacio() {
        return plantaHabitacio;
    }

    public void setPlantaHabitacio(TextField plantaHabitacio) {
        this.plantaHabitacio = plantaHabitacio;
    }

    public TextField getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(TextField diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public TextField getDiaSortida() {
        return diaSortida;
    }

    public void setDiaSortida(TextField diaSortida) {
        this.diaSortida = diaSortida;
    }

    public TextField getPreu() {
        return preu;
    }

    public void setPreu(TextField preu) {
        this.preu = preu;
    }

    public TextArea getObsText() {
        return obsText;
    }

    public void setObsText(TextArea obsText) {
        this.obsText = obsText;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(Label errorLabel) {
        this.errorLabel = errorLabel;
    }
    
    //metodes

    //funcions de inici
    @FXML
    private void initialize() throws SQLException{
        iniciarValorsDelsCamps();
        trobaNumeroFactura();
    }
    //inicia els valors dels camps de la reserva
    private void trobaNumeroFactura(){
        try {
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT MAX(`idReserva`) FROM `reserva`");
            if (rs.next()) {
                reserva.setNumeroReserva(Integer.toString(Integer.parseInt(rs.getString(1))+1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SELECT MAX(`idReserva`) FROM `reserva`");
        }
    }
    @FXML
    public void iniciarValorsDelsCamps(){
        
        //escriu valors de la reserva
        getErrorLabel().setText("");
        setReserva(ControladorMenuRecepcionistes.getControladorFinestraReserves().getReserva());
        getDniClient().setText(getReserva().getClient().getDni());
        getNomClient().setText(getReserva().getClient().getNom());
        getNumHabitacio().setText(getReserva().getHabitacio().getNumHabitacio());
        getPlantaHabitacio().setText(getReserva().getHabitacio().getPlanta());
        getDiaEntrada().setText(getReserva().getDiaEntrada());
        getDiaSortida().setText(getReserva().getDiaSortida());
        LocalDate date1 = LocalDate.parse(getReserva().getDiaEntrada());
        LocalDate date2 = LocalDate.parse(getReserva().getDiaSortida());
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        getPreu().setText(getReserva().getHabitacio().getPreu()*daysBetween+"€");
        getObsText().setText("");
        System.out.println(ControladorMenuRecepcionistes.getControladorFinestraReserves().getReserva().getClient());
    }
    @FXML
    private void crearReserva(MouseEvent event){
        if(getErrorLabel().getText()!="Reserva Creada" && getErrorLabel().getText()!= "Reserva ja creada"){
            Statement stmt = connection.getStmt();
            try {  
                String pagament="1";
                if(getReserva().getTipusPagament()=="Pagament pendent"){
                    pagament="0";
                }
                stmt.executeUpdate("INSERT INTO `reserva` (`idReserva`, `dataEntrada`, `dataSortida`, `fkdniClient`, `fkdniEmpleat`, `fknumHabitacio`, `pagamentRealitzat`, `observacions`) VALUES (NULL,'"+getReserva().getDiaEntrada()+"','"+getReserva().getDiaSortida()+"','"+getReserva().getClient().getDni()+"','"+getReserva().getRecepcionista().getDni()+"','"+getReserva().getHabitacio().getNumHabitacio()+"','"+pagament+"','"+getObsText().getText()+"')");
                getErrorLabel().setText("Reserva Creada");
                ControladorMenuRecepcionistes.getControladorFinestraReserves().reiniciarValors();
            } catch (SQLException ex) {
                //System.out.println(ex.getMessage());
                getErrorLabel().setText("Error amb la creacio de la reserva");
            }
        }
        else{
            getErrorLabel().setText("Reserva ja creada");
        }
    } 
    @FXML
    private void imprimirReserva(MouseEvent event){
        getReserva().reservaPdf((Stage)((Node) event.getSource()).getScene().getWindow());
    }
    @FXML
    private void tancarConfirmacio(MouseEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
