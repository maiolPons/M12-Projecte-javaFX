/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Habitacions;
import static com.mycompany.projectem12.App.connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 *
 * @author Maiol
 */
public class ControladorBuscadorHabitacio implements Initializable {
    //atributs
    private Habitacions habitacio;
    //taula
    @FXML private TableView<Habitacions> habitacionsTaula;
    //datepicker
    @FXML private DatePicker disponibilitat;
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
    //buscador formulari
    @FXML private TextField buscarHabitacioData;
    @FXML private ComboBox llitsDobles;
    @FXML private ComboBox llitsIndividuals;
    @FXML private ComboBox tipus;
    @FXML private CheckBox vistaMar;
    @FXML private CheckBox cuina;
    @FXML private DatePicker dataSortida;
    @FXML private DatePicker dataEntrada;
    @FXML private Label errorBuscar;
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

    public DatePicker getDisponibilitat() {
        return disponibilitat;
    }

    public void setDisponibilitat(DatePicker disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    public TextField getBuscarHabitacioData() {
        return buscarHabitacioData;
    }

    public void setBuscarHabitacioData(TextField buscarHabitacioData) {
        this.buscarHabitacioData = buscarHabitacioData;
    }

    public TextField getHabitacioSeleccionat() {
        return habitacioSeleccionat;
    }

    public void setHabitacioSeleccionat(TextField habitacioSeleccionat) {
        this.habitacioSeleccionat = habitacioSeleccionat;
    }

    public ComboBox getLlitsDobles() {
        return llitsDobles;
    }

    public void setLlitsDobles(ComboBox llitsDobles) {
        this.llitsDobles = llitsDobles;
    }

    public ComboBox getLlitsIndividuals() {
        return llitsIndividuals;
    }

    public void setLlitsIndividuals(ComboBox llitsIndividuals) {
        this.llitsIndividuals = llitsIndividuals;
    }

    public ComboBox getTipus() {
        return tipus;
    }

    public void setTipus(ComboBox tipus) {
        this.tipus = tipus;
    }

    public CheckBox getVistaMar() {
        return vistaMar;
    }

    public void setVistaMar(CheckBox vistaMar) {
        this.vistaMar = vistaMar;
    }

    public CheckBox getCuina() {
        return cuina;
    }

    public void setCuina(CheckBox cuina) {
        this.cuina = cuina;
    }

    public DatePicker getDataSortida() {
        return dataSortida;
    }

    public void setDataSortida(DatePicker dataSortida) {
        this.dataSortida = dataSortida;
    }

    public DatePicker getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(DatePicker dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Label getErrorBuscar() {
        return errorBuscar;
    }

    public void setErrorBuscar(Label errorBuscar) {
        this.errorBuscar = errorBuscar;
    }
    
    
    
    //metode
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniciarCeles();
        extreureHabitacions();
        initiateComboBox();
        getTipus().getSelectionModel().selectFirst();
        getLlitsDobles().getSelectionModel().selectFirst();
        getLlitsIndividuals().getSelectionModel().selectFirst();
    }
    //iniciar combobox
    private void initiateComboBox(){
        getTipus().getItems().addAll(
                "Tots",
                "Familiar",
                "Suite",
                "Individual",
                "Grand suite"
        );
        getLlitsDobles().getItems().addAll(
                "0","1","2","3","4","5","6","7","8","9","10"
        );
        getLlitsIndividuals().getItems().addAll(
                "0","1","2","3","4","5","6","7","8","9","10"
        );
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
    }
    //crear llista de recepcionistes
    public void extreureHabitacions(){
        try {
            ObservableList<Habitacions> habitacionsList = FXCollections.observableArrayList();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE `estat`=1");
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //marca i desevilita les dates que ja estan reservades
    private void dateHighLight(){
        try {
            List<LocalDate> ocupat = new ArrayList<>();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `reserva` WHERE `fknumHabitacio`='"+getHabitacio().getNumHabitacio()+"'");
            while(rs.next()){
                LocalDate date1 = LocalDate.parse(rs.getString("dataEntrada"));
                LocalDate date2 = LocalDate.parse(rs.getString("dataSortida"));
                long daysBetween = ChronoUnit.DAYS.between(date1, date2);
                for(int i =0;i<daysBetween+1;i++){
                    ocupat.add(date1.plusDays(i));
                }
            }
           
            getDisponibilitat().setDayCellFactory(new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(DatePicker param) {
                    return new DateCell(){
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            if (!empty && item != null) {
                                if(ocupat.contains(item)) {
                                    this.getStyleClass().add("ocupat");
                                    this.setDisable(true);
                                }
                            }
                        }
                    };
                }
            });
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //selecciona i mostra la informacio necesaria la Habitacio
    @FXML
    public void selecionaHabitacio(MouseEvent event){
        try{
            setHabitacio((Habitacions) getHabitacionsTaula().getSelectionModel().getSelectedItem()); 
            getHabitacioSeleccionat().setText(getHabitacio().getNumHabitacio());
            dateHighLight();
            getDisponibilitat().setValue(null);
        }catch(Exception e){
            getHabitacioSeleccionat().setText("Cap habitacio Seleccionada");
        }
    }
    @FXML
    //Buscar llista de clients
    public void buscarExtreureHabitacio(){
        try {
            String query="%"+getBuscarHabitacioData().getText()+"%";
            ObservableList<Habitacions> habitacioList = FXCollections.observableArrayList();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            String vistaC="0";
            if(getVistaMar().isSelected()){vistaC="1";}
            String cuinaC="0";
            if(getCuina().isSelected()){cuinaC="1";}
            String tipus=getTipus().getValue().toString();
            if(getTipus().getValue()=="Tots"){
                tipus="%";
            }
            boolean flag = true;

            if(getDataEntrada().getValue()!=null && getDataSortida().getValue()!=null){
                LocalDate today = LocalDate.now();
                if(getDataEntrada().getValue().compareTo(today) > 0){
                    if(getDataEntrada().getValue().isBefore(getDataSortida().getValue()) || getDataEntrada().getValue().equals(getDataSortida().getValue())){
                        rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE numHabitacio NOT IN (SELECT numHabitacio FROM `habitacio` INNER JOIN `reserva` ON numHabitacio = fknumHabitacio WHERE '"+getDataEntrada().getValue()+"' BETWEEN dataEntrada AND dataSortida OR '"+getDataSortida().getValue()+"' BETWEEN dataEntrada AND dataSortida OR dataEntrada BETWEEN '"+getDataEntrada().getValue()+"' AND '"+getDataSortida().getValue()+"' OR dataSortida BETWEEN '"+getDataEntrada().getValue()+"' AND '"+getDataSortida().getValue()+"') AND (`numHabitacio` LIKE '"+query+"' OR `planta` LIKE '"+query+"' OR `preu` LIKE '"+query+"') AND (`vistaMar` = '"+vistaC+"' AND `cuina` = '"+cuinaC+"' AND `numeroLlitsDobles` >='"+getLlitsDobles().getValue()+"' AND `numeroLlitsNormals` >='"+getLlitsIndividuals().getValue()+"' AND `tipus` >='"+tipus+"') AND estat = 1");
                    }
                    else{
                        flag = false;
                    }
                }
                else{
                    flag = false;
                }
            }
            else{
                rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE (`numHabitacio` LIKE '"+query+"' OR `planta` LIKE '"+query+"' OR `preu` LIKE '"+query+"') AND (`vistaMar` = '"+vistaC+"' AND `cuina` = '"+cuinaC+"' AND `numeroLlitsDobles` >='"+getLlitsDobles().getValue()+"' AND `numeroLlitsNormals` >='"+getLlitsIndividuals().getValue()+"' AND `tipus` >='"+tipus+"') AND `estat` = 1");  
            }
            if(flag){
                while(rs.next()){
                boolean estat=false;
                if(rs.getString("estat").equals("1")){estat=true; }
                
                boolean cuina=false;
                if(rs.getString("cuina").equals("1")){cuina=true; }
                
                boolean vistaMar=false;
                if(rs.getString("vistaMar").equals("1")){vistaMar=true; }
                
                habitacioList.add(new Habitacions(rs.getString("numHabitacio"),rs.getString("planta"),Double.parseDouble(rs.getString("preu")),rs.getString("tipus"),estat,Integer.parseInt(rs.getString("numeroLlitsDobles")),Integer.parseInt(rs.getString("numeroLlitsNormals")),cuina,vistaMar));
            }
            getHabitacionsTaula().setItems(habitacioList);
            getHabitacionsTaula().refresh();
            getErrorBuscar().setText("");
            }else{
                getErrorBuscar().setText("Error amb els parametres de busqueda!");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void mostrarTot(){
        try {
            ObservableList<Habitacions> habitacioList = FXCollections.observableArrayList();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE `estat`=1");
            while(rs.next()){
                boolean estat=false;
                if(rs.getString("estat").equals("1")){estat=true; }
                
                boolean cuina=false;
                if(rs.getString("cuina").equals("1")){cuina=true; }
                
                boolean vistaMar=false;
                if(rs.getString("vistaMar").equals("1")){vistaMar=true; }
                
                habitacioList.add(new Habitacions(rs.getString("numHabitacio"),rs.getString("planta"),Double.parseDouble(rs.getString("preu")),rs.getString("tipus"),estat,Integer.parseInt(rs.getString("numeroLlitsDobles")),Integer.parseInt(rs.getString("numeroLlitsNormals")),cuina,vistaMar));
            }
            getHabitacionsTaula().setItems(habitacioList);
            getHabitacionsTaula().refresh();
            getErrorBuscar().setText("");
            getDataEntrada().setValue(null);
            getDataSortida().setValue(null);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //confirmar client
    @FXML
    public void confirmarHabitacio(ActionEvent event){
        if(habitacio!=null){
            ControladorMenuRecepcionistes.getControladorFinestraReserves().afegirHabitacio(habitacio);
        }
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
