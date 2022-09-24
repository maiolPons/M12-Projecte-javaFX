/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Habitacions;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
public class ControladorFinestrahabitacions implements Initializable {
    //atributs
    private Habitacions habitacio;
    
    @FXML private TableView<Habitacions> habitacionsTaula;
    @FXML private Label nomUsuariLabel;
    @FXML private Label estatManipulacio;
    @FXML private Label estatOrdre;
    //inputs
    @FXML private TextField numHabitaciohab;
    @FXML private TextField plantahab;
    @FXML private TextField preuhab;
    @FXML private ComboBox tipushab;
    @FXML private ComboBox numeroLlitsDobleshab;
    @FXML private ComboBox numeroLlitsNormalshab;
    @FXML private CheckBox cuinahab;
    @FXML private CheckBox vistaMarhab;
    @FXML private CheckBox estathab;
    //columnas
    @FXML private TableColumn<Habitacions, String> numeroColumna;
    @FXML private TableColumn<Habitacions, String> plantaColumna;
    @FXML private TableColumn<Habitacions, String> preuColumna;
    @FXML private TableColumn<Habitacions, String> tipusColumna;
    @FXML private TableColumn<Habitacions, String> llistaDoblesColumna;
    @FXML private TableColumn<Habitacions, String> llitsNormalsColumna;
    @FXML private TableColumn<Habitacions, String> cuinaColumna;
    @FXML private TableColumn<Habitacions, String> vistaColumna;
    @FXML private TableColumn<Habitacions, String> estatColumna;
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

    public ComboBox getNumeroLlitsDobleshab() {
        return numeroLlitsDobleshab;
    }

    public void setNumeroLlitsDobleshab(ComboBox numeroLlitsDobleshab) {
        this.numeroLlitsDobleshab = numeroLlitsDobleshab;
    }

    public ComboBox getNumeroLlitsNormalshab() {
        return numeroLlitsNormalshab;
    }

    public void setNumeroLlitsNormalshab(ComboBox numeroLlitsNormalshab) {
        this.numeroLlitsNormalshab = numeroLlitsNormalshab;
    }

    public TableColumn<Habitacions, String> getNumeroColumna() {
        return numeroColumna;
    }

    public void setNumeroColumna(TableColumn<Habitacions, String> numeroColumna) {
        this.numeroColumna = numeroColumna;
    }

    public TableColumn<Habitacions, String> getPlantaColumna() {
        return plantaColumna;
    }

    public void setPlantaColumna(TableColumn<Habitacions, String> plantaColumna) {
        this.plantaColumna = plantaColumna;
    }

    public TableColumn<Habitacions, String> getPreuColumna() {
        return preuColumna;
    }

    public void setPreuColumna(TableColumn<Habitacions, String> preuColumna) {
        this.preuColumna = preuColumna;
    }

    public TableColumn<Habitacions, String> getTipusColumna() {
        return tipusColumna;
    }

    public void setTipusColumna(TableColumn<Habitacions, String> tipusColumna) {
        this.tipusColumna = tipusColumna;
    }

    public TableColumn<Habitacions, String> getLlistaDoblesColumna() {
        return llistaDoblesColumna;
    }

    public void setLlistaDoblesColumna(TableColumn<Habitacions, String> llistaDoblesColumna) {
        this.llistaDoblesColumna = llistaDoblesColumna;
    }

    public TableColumn<Habitacions, String> getLlitsNormalsColumna() {
        return llitsNormalsColumna;
    }

    public void setLlitsNormalsColumna(TableColumn<Habitacions, String> llitsNormalsColumna) {
        this.llitsNormalsColumna = llitsNormalsColumna;
    }

    public TableColumn<Habitacions, String> getCuinaColumna() {
        return cuinaColumna;
    }

    public void setCuinaColumna(TableColumn<Habitacions, String> cuinaColumna) {
        this.cuinaColumna = cuinaColumna;
    }

    public TableColumn<Habitacions, String> getVistaColumna() {
        return vistaColumna;
    }

    public void setVistaColumna(TableColumn<Habitacions, String> vistaColumna) {
        this.vistaColumna = vistaColumna;
    }

    public TableColumn<Habitacions, String> getEstatColumna() {
        return estatColumna;
    }

    public void setEstatColumna(TableColumn<Habitacions, String> estatColumna) {
        this.estatColumna = estatColumna;
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

    public TableView<Habitacions> getHabitacionsTaula() {
        return habitacionsTaula;
    }

    public void setHabitacionsTaula(TableView<Habitacions> habitacionsTaula) {
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
        iniciarCeles();
        try {
            extreureHabitacions();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrahabitacions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initiateComboBox(){
        getTipushab().getItems().addAll(
                "Familiar",
                "Suite",
                "Individual",
                "Grand suite"
        );
        getNumeroLlitsDobleshab().getItems().addAll(
                "1","2","3","4","5","6","7","8","9","10"
        );
        getNumeroLlitsNormalshab().getItems().addAll(
                "1","2","3","4","5","6","7","8","9","10"
        );
    }
    @FXML
    private void iniciarCeles(){
        numeroColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("numHabitacio"));
        plantaColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("planta"));
        preuColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("preu"));
        tipusColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("tipus"));
        llistaDoblesColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("numeroLlitsDobles"));
        llitsNormalsColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("numeroLlitsNormals"));
        cuinaColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("cuinaVisualitzar"));
        vistaColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("vistaMarVisualitzar"));
        estatColumna.setCellValueFactory(new PropertyValueFactory<Habitacions, String>("estatVisualitzar"));
    }
    //crear llista de recepcionistes
    public void extreureHabitacions() throws SQLException{
        ObservableList<Habitacions> habitacionsList = FXCollections.observableArrayList();
        Statement stmt = connection.getStmt();
        ResultSet rs = null;
        rs = stmt.executeQuery("SELECT * FROM `habitacio`");
        while(rs.next()){
            boolean estat=false;
            if(rs.getString("estat").equals("1")){estat=true; }
            boolean cuina=false;
            if(rs.getString("cuina").equals("1")){cuina=true; }
            boolean vistaMar=false;
            if(rs.getString("vistaMar").equals("1")){vistaMar=true; }
            

            
            habitacionsList.add(new Habitacions(rs.getString("numHabitacio"),rs.getString("planta"),Double.parseDouble(rs.getString("preu")),rs.getString("tipus"),estat,Integer.parseInt(rs.getString("numeroLlitsDobles")),Integer.parseInt(rs.getString("numeroLlitsNormals")),cuina,vistaMar));
        }
        getHabitacionsTaula().setItems(habitacionsList);
    }
    @FXML
    private void crearHabitacio(){
        getEstatManipulacio().setText("Creant nova habitacio");
        getNumHabitaciohab().setText("");
        getPlantahab().setText("");
        getPreuhab().setText("");
        getTipushab().setValue("");
        getNumeroLlitsDobleshab().setValue("");
        getNumeroLlitsNormalshab().setValue("");
        getCuinahab().setSelected(false);
        getVistaMarhab().setSelected(false);
        getEstathab().setSelected(false);
        getEstatOrdre().setText("");
        
    }
    @FXML
    private void executarOrdre() throws SQLException{
        if(getEstatManipulacio().getText()=="Creant nova habitacio"){
            comprovarValorsCrear();
        }
        if(getEstatManipulacio().getText()=="Modificar habitacio"){
            comprovarValorsModificar();
        }
    }
    // || !getPlantahab().getText().equals("") || !getPreuhab().getText().equals("") || !getTipushab().getItems().isEmpty() || !getNumeroLlitsDobleshab().getText().equals("") || !getNumeroLlitsNormalshab().getText().equals("") || getCuinahab().isSelected() || getVistaMarhab().isSelected() || getEstathab().isSelected()
    private void comprovarValorsCrear() throws SQLException{
        if((getNumHabitaciohab().getText() == null || getNumHabitaciohab().getText().trim().isEmpty()) || (getPlantahab().getText() == null || getPlantahab().getText().trim().isEmpty()) || (getPreuhab().getText() == null || getPreuhab().getText().trim().isEmpty()) || getNumeroLlitsDobleshab().getSelectionModel().isEmpty() || getNumeroLlitsNormalshab().getSelectionModel().isEmpty() || getTipushab().getSelectionModel().isEmpty()){
            getEstatOrdre().setText("Tots els camps son obligatoris");
        }else{
            getEstatOrdre().setText("");
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE `numHabitacio`='"+getNumHabitaciohab().getText()+"'");
            if(rs.next() == true){
                getEstatOrdre().setText("La habitacio ja existeix");
            }else{
                try{
                    Double.parseDouble(getPreuhab().getText());
                    int estat = 0;
                    int vista = 0;
                    int cuina = 0;
                    if(getEstathab().isSelected()){estat = 1;}
                    if(getVistaMarhab().isSelected()){vista = 1;}
                    if(getCuinahab().isSelected()){cuina = 1;}
                    //System.out.println("INSERT INTO `habitacio` (`numHabitacio`,`planta`,`preu`,`tipus`,`estat`,`numeroLlitsDobles`,`numeroLlitsNormals`,`cuina`,`vistaMar`) VALUES ('"+getNumHabitaciohab().getText()+"','"+getPlantahab().getText()+"','"+getPreuhab().getText()+"','"+getTipushab().getValue()+"','"+estat+"','"+getNumeroLlitsDobleshab().getText()+"','"+getNumeroLlitsNormalshab().getText()+"','"+cuina+"','"+vista+"')");
                    stmt.executeUpdate("INSERT INTO `habitacio` (`numHabitacio`,`planta`,`preu`,`tipus`,`estat`,`numeroLlitsDobles`,`numeroLlitsNormals`,`cuina`,`vistaMar`) VALUES ('"+getNumHabitaciohab().getText()+"','"+getPlantahab().getText()+"','"+getPreuhab().getText()+"','"+getTipushab().getValue()+"','"+estat+"','"+getNumeroLlitsDobleshab().getValue()+"','"+getNumeroLlitsNormalshab().getValue()+"','"+cuina+"','"+vista+"')");  
                    getEstatOrdre().setText("Habitacio Creada!");
                    getEstatManipulacio().setText("");
                    getNumHabitaciohab().setText("");
                    getPlantahab().setText("");
                    getPreuhab().setText("");
                    getTipushab().setValue("");
                    getNumeroLlitsDobleshab().setValue("");
                    getNumeroLlitsNormalshab().setValue("");
                    getCuinahab().setSelected(false);
                    getVistaMarhab().setSelected(false);
                    getEstathab().setSelected(false);

                    extreureHabitacions();
                    habitacionsTaula.refresh();
                }catch(Exception e){
                    getEstatOrdre().setText("Preu invalid");
                }
            }
        }
    }
    @FXML
    private void modificarHabitacio(MouseEvent event){
        Habitacions Habitacion = (Habitacions) getHabitacionsTaula().getSelectionModel().getSelectedItem();
        getEstatOrdre().setText("");
        getEstatManipulacio().setText("Modificar habitacio");
        getNumHabitaciohab().setText(Habitacion.getNumHabitacio());
        getPlantahab().setText(Habitacion.getPlanta());
        getPreuhab().setText(String.valueOf(Habitacion.getPreu()));
        getTipushab().setValue(Habitacion.getTipus());
        getNumeroLlitsDobleshab().setValue(Habitacion.getNumeroLlitsDobles());
        getNumeroLlitsNormalshab().setValue(Habitacion.getNumeroLlitsNormals());
        getCuinahab().setSelected(Habitacion.isCuina());
        getVistaMarhab().setSelected(Habitacion.isVistaMar());
        getEstathab().setSelected(Habitacion.isEstat());
    }
    private void comprovarValorsModificar() throws SQLException{
        Habitacions Habitacion = (Habitacions) getHabitacionsTaula().getSelectionModel().getSelectedItem();
        if((getNumHabitaciohab().getText() == null || getNumHabitaciohab().getText().trim().isEmpty()) || (getPlantahab().getText() == null || getPlantahab().getText().trim().isEmpty()) || (getPreuhab().getText() == null || getPreuhab().getText().trim().isEmpty()) || getNumeroLlitsDobleshab().getSelectionModel().isEmpty() || getNumeroLlitsNormalshab().getSelectionModel().isEmpty() || getTipushab().getSelectionModel().isEmpty()){
            getEstatOrdre().setText("Tots els camps son obligatoris");
        }else{
            getEstatOrdre().setText("");
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE `numHabitacio`='"+getNumHabitaciohab().getText()+"'");
            if(rs.next() == true){
                getEstatOrdre().setText("La habitacio ja existeix");
            }else{
                try{
                    
                }catch(Exception e){
                    Double.parseDouble(getPreuhab().getText());
                    int estat = 0;
                    int vista = 0;
                    int cuina = 0;
                    if(getEstathab().isSelected()){estat = 1;}
                    if(getVistaMarhab().isSelected()){vista = 1;}
                    if(getCuinahab().isSelected()){cuina = 1;}
                    stmt.executeUpdate("UPDATE `habitacio` SET ``numHabitacio`='"+getNumHabitaciohab().getText()+"',`planta`='"+getPlantahab().getText()+"',`preu`='"+getPreuhab().getText()+"',`tipus`='"+getTipushab().getValue()+"',`estat`='"+estat+"',`numeroLlitsDobles`='"+getNumeroLlitsDobleshab().getValue()+"',`numeroLlitsNormals`='"+getNumeroLlitsNormalshab().getValue()+"',`cuina`='"+cuina+"',`vistaMar`='"+vista+"' WHERE `dni`='"+Habitacion.getNumHabitacio()+"'");
                    getEstatOrdre().setText("Habitacio Modificada!");
                    getEstatManipulacio().setText("");
                    getNumHabitaciohab().setText("");
                    getPlantahab().setText("");
                    getPreuhab().setText("");
                    getTipushab().setValue("");
                    getNumeroLlitsDobleshab().setValue("");
                    getNumeroLlitsNormalshab().setValue("");
                    getCuinahab().setSelected(false);
                    getVistaMarhab().setSelected(false);
                    getEstathab().setSelected(false);

                    extreureHabitacions();
                    habitacionsTaula.refresh();
                }
            }
        }    
    }
}
