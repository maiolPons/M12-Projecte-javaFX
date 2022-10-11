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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Maiol
 */
public class ControladorBuscadorHabitacio implements Initializable {
    //atributs
    private Habitacions habitacio;
    //taula
    @FXML private TableView<Habitacions> habitacionsTaula;
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
    //buscador
    @FXML private TextField buscarHabitacioData;
    //seleccionat
    @FXML private TextField habitacioSeleccionat;
    //set i get

    public Habitacions getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(Habitacions habitacio) {
        this.habitacio = habitacio;
    }

    public TableView<Habitacions> getHabitacionsTaula() {
        return habitacionsTaula;
    }

    public void setHabitacionsTaula(TableView<Habitacions> habitacionsTaula) {
        this.habitacionsTaula = habitacionsTaula;
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
    
    //metodes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarCeles();
        try {
            extreureHabitacions();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrahabitacions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    //iniciar celles taula
    private void iniciarCeles(){
        getNumeroColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("numHabitacio"));
        getPlantaColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("planta"));
        getPreuColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("preu"));
        getTipusColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("tipus"));
        getLlistaDoblesColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("numeroLlitsDobles"));
        getLlitsNormalsColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("numeroLlitsNormals"));
        getCuinaColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("cuinaVisualitzar"));
        getVistaColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("vistaMarVisualitzar"));
        getEstatColumna().setCellValueFactory(new PropertyValueFactory<Habitacions, String>("estatVisualitzar"));
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
}
