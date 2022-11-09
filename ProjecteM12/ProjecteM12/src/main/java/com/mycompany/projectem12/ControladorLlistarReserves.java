/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Reserva;
import static com.mycompany.projectem12.App.connection;
import static com.mycompany.projectem12.App.usuari;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Maiol
 */
public class ControladorLlistarReserves {
    @FXML private Label nomUsuariLabel;
    //atributs
    private Reserva reserva;
    //inputs text
    @FXML private TextField id;
    @FXML private TextField entrada;
    @FXML private TextField sortida;
    @FXML private TextField dni;
    @FXML private TextField recepcionista;
    @FXML private TextField habitacio;
    @FXML private TextField pagament;
    @FXML private TextArea observacions;
    //buscador
    @FXML private TextField buscarReserva;
    //taula
    @FXML private TableView<Reserva> reservesTaula;
    //columnes
    @FXML private TableColumn<Reserva, String> idColumna;
    @FXML private TableColumn<Reserva, String> entradaColumna;
    @FXML private TableColumn<Reserva, String> sortidaColumna;
    @FXML private TableColumn<Reserva, String> clientColumna;
    @FXML private TableColumn<Reserva, String> recepcionistaColumna;
    @FXML private TableColumn<Reserva, String> habitacioColumna;
    @FXML private TableColumn<Reserva, String> pagamentColumna;
    //labels
    @FXML private Label estatOrdre;
    //gets i sets

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public TextField getId() {
        return id;
    }

    public void setId(TextField id) {
        this.id = id;
    }

    public TextField getEntrada() {
        return entrada;
    }

    public void setEntrada(TextField entrada) {
        this.entrada = entrada;
    }

    public TextField getSortida() {
        return sortida;
    }

    public void setSortida(TextField sortida) {
        this.sortida = sortida;
    }

    public TextField getDni() {
        return dni;
    }

    public void setDni(TextField dni) {
        this.dni = dni;
    }

    public TextField getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(TextField recepcionista) {
        this.recepcionista = recepcionista;
    }

    public TextField getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(TextField habitacio) {
        this.habitacio = habitacio;
    }

    public TextField getPagament() {
        return pagament;
    }

    public void setPagament(TextField pagament) {
        this.pagament = pagament;
    }

    public TextArea getObservacions() {
        return observacions;
    }

    public void setObservacions(TextArea observacions) {
        this.observacions = observacions;
    }

    public TableView<Reserva> getReservesTaula() {
        return reservesTaula;
    }

    public void setReservesTaula(TableView<Reserva> reservesTaula) {
        this.reservesTaula = reservesTaula;
    }

    public TableColumn<Reserva, String> getIdColumna() {
        return idColumna;
    }

    public void setIdColumna(TableColumn<Reserva, String> idColumna) {
        this.idColumna = idColumna;
    }

    public TableColumn<Reserva, String> getEntradaColumna() {
        return entradaColumna;
    }

    public void setEntradaColumna(TableColumn<Reserva, String> entradaColumna) {
        this.entradaColumna = entradaColumna;
    }

    public TableColumn<Reserva, String> getSortidaColumna() {
        return sortidaColumna;
    }

    public void setSortidaColumna(TableColumn<Reserva, String> sortidaColumna) {
        this.sortidaColumna = sortidaColumna;
    }

    public TableColumn<Reserva, String> getClientColumna() {
        return clientColumna;
    }

    public void setClientColumna(TableColumn<Reserva, String> clientColumna) {
        this.clientColumna = clientColumna;
    }

    public TableColumn<Reserva, String> getRecepcionistaColumna() {
        return recepcionistaColumna;
    }

    public void setRecepcionistaColumna(TableColumn<Reserva, String> recepcionistaColumna) {
        this.recepcionistaColumna = recepcionistaColumna;
    }

    public TableColumn<Reserva, String> getHabitacioColumna() {
        return habitacioColumna;
    }

    public void setHabitacioColumna(TableColumn<Reserva, String> habitacioColumna) {
        this.habitacioColumna = habitacioColumna;
    }

    public TableColumn<Reserva, String> getPagamentColumna() {
        return pagamentColumna;
    }

    public void setPagamentColumna(TableColumn<Reserva, String> pagamentColumna) {
        this.pagamentColumna = pagamentColumna;
    }

    public Label getEstatOrdre() {
        return estatOrdre;
    }

    public void setEstatOrdre(Label estatOrdre) {
        this.estatOrdre = estatOrdre;
    }

    public TextField getBuscarReserva() {
        return buscarReserva;
    }

    public void setBuscarReserva(TextField buscarReserva) {
        this.buscarReserva = buscarReserva;
    }

    public Label getNomUsuariLabel() {
        return nomUsuariLabel;
    }

    public void setNomUsuariLabel(Label nomUsuariLabel) {
        this.nomUsuariLabel = nomUsuariLabel;
    }
    
    
    //metodes
    public void initialize() {
        getNomUsuariLabel().setText(usuari.getNom());
        iniciarCeles();
        extreureReserves();
    }
    @FXML
    //inicia les celes de la taula
    private void iniciarCeles(){
        getIdColumna().setCellValueFactory(new PropertyValueFactory<Reserva, String>("numeroReserva"));
        getEntradaColumna().setCellValueFactory(new PropertyValueFactory<Reserva, String>("diaEntrada"));
        getSortidaColumna().setCellValueFactory(new PropertyValueFactory<Reserva, String>("diaSortida"));
        getClientColumna().setCellValueFactory(new PropertyValueFactory<Reserva, String>("mostrarclient"));
        getRecepcionistaColumna().setCellValueFactory(new PropertyValueFactory<Reserva, String>("mostrarRecepcionista"));
        getHabitacioColumna().setCellValueFactory(new PropertyValueFactory<Reserva, String>("mostrarHabitacio"));
        getPagamentColumna().setCellValueFactory(new PropertyValueFactory<Reserva, String>("tipusPagament"));
    }
    //crear llista de reserves
    private void extreureReserves(){
        try {
            ObservableList<Reserva> reservaLlista = FXCollections.observableArrayList();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `reserva`");
            while(rs.next()){
                String pagament="pendent";
                if(rs.getString("pagamentRealitzat").equals("1")){pagament="realitzat";}
                reservaLlista.add(new Reserva(rs.getString("idReserva"),pagament,rs.getString("dataEntrada"),rs.getString("dataSortida"),rs.getString("observacions"),rs.getString("fkdniClient"),rs.getString("fknumHabitacio"),rs.getString("fkdniEmpleat")));
            }
            getReservesTaula().setItems(reservaLlista);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //seleccionar recepcionistes i mostra les dades en el display del centra de la pantalla
    @FXML
    private void seleccionaReserva(MouseEvent event){
        try{
            Reserva reserva = (Reserva) getReservesTaula().getSelectionModel().getSelectedItem();
            getId().setText(reserva.getNumeroReserva());
            getEntrada().setText(reserva.getDiaEntrada());
            getSortida().setText(reserva.getDiaSortida());
            getDni().setText(reserva.getMostrarclient());
            getRecepcionista().setText(reserva.getMostrarRecepcionista());
            getHabitacio().setText(reserva.getMostrarHabitacio());
            getPagament().setText(reserva.getTipusPagament());
            getObservacions().setText(reserva.getObservacions());
            getEstatOrdre().setText("");
        }catch(Exception e){
            getEstatOrdre().setText("Cap recepcionista seleccionat!");
        }
    }
    //marcar reserva com a pagada
    @FXML
    private void marcaPagat(MouseEvent event) throws IOException{
        Reserva reserva = (Reserva) getReservesTaula().getSelectionModel().getSelectedItem();
        Statement stmt = connection.getStmt();
        try {
            stmt.executeUpdate("UPDATE `reserva` SET `pagamentRealitzat`=1 WHERE `idReserva`='"+reserva.getNumeroReserva()+"'");
            extreureReserves();
            getReservesTaula().refresh();
            getEstatOrdre().setText("Factura "+reserva.getNumeroReserva()+" Pagada!");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //marca reserva com a pendent
    @FXML
    public void marcaPendent(MouseEvent event){
        Reserva reserva = (Reserva) getReservesTaula().getSelectionModel().getSelectedItem();
        Statement stmt = connection.getStmt();
        try {
            stmt.executeUpdate("UPDATE `reserva` SET `pagamentRealitzat`=0 WHERE `idReserva`='"+reserva.getNumeroReserva()+"'");
            extreureReserves();
            getReservesTaula().refresh();
            getEstatOrdre().setText("Factura "+reserva.getNumeroReserva()+" Posada en penden!");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFinestrarecepcionistes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void imprimirReserva(MouseEvent event){
        Reserva reserva = (Reserva) getReservesTaula().getSelectionModel().getSelectedItem();
        if(reserva!=null){
            reserva.reservaPdf((Stage)((Node) event.getSource()).getScene().getWindow());
        }
    }
    @FXML
    //Buscar llista de clients
    public void buscarExtreureClient() {
        try {
            String query="%"+getBuscarReserva().getText()+"%";
            ObservableList<Reserva> reservaLlista = FXCollections.observableArrayList();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `reserva` WHERE `idReserva` LIKE '"+query+"' OR `fkdniClient` LIKE '"+query+"' OR `fkdniEmpleat` LIKE '"+query+"' OR `fknumHabitacio` LIKE '"+query+"'");
            while(rs.next()){
                String pagament="pendent";
                if(rs.getString("pagamentRealitzat").equals("1")){pagament="realitzat";}
                reservaLlista.add(new Reserva(rs.getString("idReserva"),pagament,rs.getString("dataEntrada"),rs.getString("dataSortida"),rs.getString("observacions"),rs.getString("fkdniClient"),rs.getString("fknumHabitacio"),rs.getString("fkdniEmpleat")));
            }
            getReservesTaula().setItems(reservaLlista);
            getReservesTaula().refresh();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            String query="%"+getBuscarReserva().getText()+"%";
            System.out.println("SELECT * FROM `reserva` WHERE `idReserva` LIKE '"+query+"' OR `fkdniClient` LIKE '"+query+"' OR `fkdniEmpleat` LIKE '"+query+"' OR `fknumHabitacio` LIKE '"+query+"'");
        }
    }
}
