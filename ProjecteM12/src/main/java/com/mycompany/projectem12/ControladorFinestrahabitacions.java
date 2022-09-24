/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Habitacions;
import com.mycompany.controlAccess.Recepcionistes;
import static com.mycompany.projectem12.App.connection;
import static com.mycompany.projectem12.App.usuari;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Maiol
 */
public class ControladorFinestrahabitacions implements Initializable {
    //atributs
    private Habitacions habitacio;
    
    @FXML private TableView<Recepcionistes> habitacionsTaula;
    @FXML private Label nomUsuariLabel;
    @FXML private Label estatManipulacio;
    @FXML private Label estatOrdre;
    //inputs
    @FXML private TextField numHabitaciohab;
    @FXML private TextField plantahab;
    @FXML private TextField preuhab;
    @FXML private ComboBox tipushab;
    @FXML private TextField numeroLlitsDobleshab;
    @FXML private TextField numeroLlitsNormalshab;
    @FXML private CheckBox cuinahab;
    @FXML private CheckBox vistaMarhab;
    @FXML private CheckBox estathab;
    //get and set

    public Label getNomUsuariLabel() {
        return nomUsuariLabel;
    }

    public void setNomUsuariLabel(Label nomUsuariLabel) {
        this.nomUsuariLabel = nomUsuariLabel;
    }

    public TextField getNumHabitaciohab() {
        return numHabitaciohab;
    }

    public void setNumHabitaciohab(TextField numHabitaciohab) {
        this.numHabitaciohab = numHabitaciohab;
    }

    public TextField getPlantahab() {
        return plantahab;
    }

    public void setPlantahab(TextField plantahab) {
        this.plantahab = plantahab;
    }

    public TextField getPreuhab() {
        return preuhab;
    }

    public void setPreuhab(TextField preuhab) {
        this.preuhab = preuhab;
    }

    public ComboBox getTipushab() {
        return tipushab;
    }

    public void setTipushab(ComboBox tipushab) {
        this.tipushab = tipushab;
    }

    public TextField getNumeroLlitsDobleshab() {
        return numeroLlitsDobleshab;
    }

    public void setNumeroLlitsDobleshab(TextField numeroLlitsDobleshab) {
        this.numeroLlitsDobleshab = numeroLlitsDobleshab;
    }

    public TextField getNumeroLlitsNormalshab() {
        return numeroLlitsNormalshab;
    }

    public void setNumeroLlitsNormalshab(TextField numeroLlitsNormalshab) {
        this.numeroLlitsNormalshab = numeroLlitsNormalshab;
    }

    public CheckBox getCuinahab() {
        return cuinahab;
    }

    public void setCuinahab(CheckBox cuinahab) {
        this.cuinahab = cuinahab;
    }

    public CheckBox getVistaMarhab() {
        return vistaMarhab;
    }

    public void setVistaMarhab(CheckBox vistaMarhab) {
        this.vistaMarhab = vistaMarhab;
    }

    public CheckBox getEstathab() {
        return estathab;
    }

    public void setEstathab(CheckBox estathab) {
        this.estathab = estathab;
    }

    public TableView<Recepcionistes> getHabitacionsTaula() {
        return habitacionsTaula;
    }

    public void setHabitacionsTaula(TableView<Recepcionistes> habitacionsTaula) {
        this.habitacionsTaula = habitacionsTaula;
    }

    public Habitacions getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(Habitacions habitacio) {
        this.habitacio = habitacio;
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
    
    
    
    //metodes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomUsuariLabel.setText(usuari.getNom());
        initiateComboBox();
    }
    private void initiateComboBox(){
        getTipushab().getItems().addAll(
                "Familiar",
                "Suite",
                "Individual",
                "Grand suite"
        );
    }
    @FXML
    private void crearHabitacio(){
        getEstatManipulacio().setText("Creant nova habitacio");
        getNumHabitaciohab().setText("");
        getPlantahab().setText("");
        getPreuhab().setText("");
        getTipushab().setValue("");
        getNumeroLlitsDobleshab().setText("");
        getNumeroLlitsNormalshab().setText("");
        getCuinahab().setSelected(false);
        getVistaMarhab().setSelected(false);
        getEstathab().setSelected(false);
        getEstatOrdre().setText("");
    }
    @FXML
    private void executarOrdre() throws SQLException{
        if(getEstatManipulacio().getText()=="Creant nova habitacio"){
            comprovarValors();
        }
    }
    // || !getPlantahab().getText().equals("") || !getPreuhab().getText().equals("") || !getTipushab().getItems().isEmpty() || !getNumeroLlitsDobleshab().getText().equals("") || !getNumeroLlitsNormalshab().getText().equals("") || getCuinahab().isSelected() || getVistaMarhab().isSelected() || getEstathab().isSelected()
    private void comprovarValors() throws SQLException{
        if((getNumHabitaciohab().getText() == null || getNumHabitaciohab().getText().trim().isEmpty()) || (getPlantahab().getText() == null || getPlantahab().getText().trim().isEmpty()) || (getPreuhab().getText() == null || getPreuhab().getText().trim().isEmpty()) || (getNumeroLlitsDobleshab().getText() == null || getNumeroLlitsDobleshab().getText().trim().isEmpty()) || (getNumeroLlitsNormalshab().getText() == null || getNumeroLlitsNormalshab().getText().trim().isEmpty()) || getTipushab().getSelectionModel().isEmpty()){
            getEstatOrdre().setText("Tots els camps son obligatoris");
        }else{
            getEstatOrdre().setText("");
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE `numHabitacio`='"+getNumHabitaciohab().getText()+"'");
            if(rs.next() == true){
                getEstatOrdre().setText("La habitacio ja existeix");
            }else{
                int estat = 0;
                int vista = 0;
                int cuina = 0;
                if(getEstathab().isSelected()){estat = 1;}
                if(getVistaMarhab().isSelected()){vista = 1;}
                if(getCuinahab().isSelected()){cuina = 1;}
                //System.out.println("INSERT INTO `habitacio` (`numHabitacio`,`planta`,`preu`,`tipus`,`estat`,`numeroLlitsDobles`,`numeroLlitsNormals`,`cuina`,`vistaMar`) VALUES ('"+getNumHabitaciohab().getText()+"','"+getPlantahab().getText()+"','"+getPreuhab().getText()+"','"+getTipushab().getValue()+"','"+estat+"','"+getNumeroLlitsDobleshab().getText()+"','"+getNumeroLlitsNormalshab().getText()+"','"+cuina+"','"+vista+"')");
                stmt.executeUpdate("INSERT INTO `habitacio` (`numHabitacio`,`planta`,`preu`,`tipus`,`estat`,`numeroLlitsDobles`,`numeroLlitsNormals`,`cuina`,`vistaMar`) VALUES ('"+getNumHabitaciohab().getText()+"','"+getPlantahab().getText()+"','"+getPreuhab().getText()+"','"+getTipushab().getValue()+"','"+estat+"','"+getNumeroLlitsDobleshab().getText()+"','"+getNumeroLlitsNormalshab().getText()+"','"+cuina+"','"+vista+"')");  
                getEstatOrdre().setText("Habitacio Creada!");
                getEstatManipulacio().setText("");
                getNumHabitaciohab().setText("");
                getPlantahab().setText("");
                getPreuhab().setText("");
                getTipushab().setValue("");
                getNumeroLlitsDobleshab().setText("");
                getNumeroLlitsNormalshab().setText("");
                getCuinahab().setSelected(false);
                getVistaMarhab().setSelected(false);
                getEstathab().setSelected(false);
                getEstatOrdre().setText("");
                }
            }
    }
    @FXML
    private void seleccionaRecepcionista(MouseEvent event){
        Recepcionistes recepcionista = (Recepcionistes) getHabitacionsTaula().getSelectionModel().getSelectedItem();
        //dnirep.setText(recepcionista.getDni());

    }
}
