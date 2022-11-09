/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import com.mycompany.controlAccess.Clients;
import com.mycompany.controlAccess.Habitacions;
import com.mycompany.controlAccess.Reserva;
import static com.mycompany.projectem12.App.connection;
import static com.mycompany.projectem12.App.usuari;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Maiol
 */
public class ControladorFinestraReserves implements Initializable {
    @FXML private Label nomUsuariLabel;
    //objecte reserva
    private static Reserva reserva = new Reserva();
    //Stages finestres buscadors
    private Stage stageBuscadorClient;
    private Stage stageBuscadorHabitacio;
    private Stage stageConfirmacio;
    //informacio client
    @FXML private TextField dniClient;
    @FXML private TextField nomClient;
    @FXML private DatePicker naixamentClient;
    @FXML private TextField sexeClient;
    @FXML private TextField nacionalitatClient;
    @FXML private TextField telefonClient;
    @FXML private TextField emailClient;
    @FXML private TextField estatCivilClient;    
    @FXML private TextField ocupacioClient;
    //buscar client dni
    @FXML private TextField buscarClient;
    //informacio habitacio
    @FXML private TextField numHabitaciohab;
    @FXML private TextField plantahab;
    @FXML private TextField preuhab;
    @FXML private TextField tipushab;
    @FXML private TextField numeroLlitsDobleshab;
    @FXML private TextField numeroLlitsNormalshab;
    @FXML private CheckBox cuinahab;
    @FXML private CheckBox vistaMarhab;
    //informacio reserva
    @FXML private TextField numHabitaciohab2;
    @FXML private TextField dniClient2;
    @FXML private DatePicker entradaReserva;
    @FXML private DatePicker sortidaReserva;
    @FXML private RadioButton pagamentPendent,pagamentRealitzat;
    //buscar habitacio numero
    @FXML private TextField buscarHabitacio;
    //labels
    @FXML private Label clientLabelError;
    @FXML private Label habitacioLabelError;
    @FXML private Label reservaLabelError;
    //gets and sets
       
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

    public TextField getSexeClient() {
        return sexeClient;
    }

    public void setSexeClient(TextField sexeClient) {
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

    public TextField getEstatCivilClient() {
        return estatCivilClient;
    }

    public void setEstatCivilClient(TextField estatCivilClient) {
        this.estatCivilClient = estatCivilClient;
    }

    public TextField getOcupacioClient() {
        return ocupacioClient;
    }

    public void setOcupacioClient(TextField ocupacioClient) {
        this.ocupacioClient = ocupacioClient;
    }

    public TextField getBuscarClient() {
        return buscarClient;
    }

    public void setBuscarClient(TextField buscarClient) {
        this.buscarClient = buscarClient;
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

    public TextField getTipushab() {
        return tipushab;
    }

    public void setTipushab(TextField tipushab) {
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

    public TextField getBuscarHabitacio() {
        return buscarHabitacio;
    }

    public void setBuscarHabitacio(TextField buscarHabitacio) {
        this.buscarHabitacio = buscarHabitacio;
    }

    public Stage getStageBuscadorClient() {
        return stageBuscadorClient;
    }

    public Stage getStageBuscadorHabitacio() {
        return stageBuscadorHabitacio;
    }

    public void setStageBuscadorClient(Stage stageBuscadorClient) {
        this.stageBuscadorClient = stageBuscadorClient;
    }

    public void setStageBuscadorHabitacio(Stage stageBuscadorHabitacio) {
        this.stageBuscadorHabitacio = stageBuscadorHabitacio;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Label getClientLabelError() {
        return clientLabelError;
    }

    public void setClientLabelError(Label clientLabelError) {
        this.clientLabelError = clientLabelError;
    }

    public TextField getNumHabitaciohab2() {
        return numHabitaciohab2;
    }

    public void setNumHabitaciohab2(TextField numHabitaciohab2) {
        this.numHabitaciohab2 = numHabitaciohab2;
    }

    public TextField getDniClient2() {
        return dniClient2;
    }

    public void setDniClient2(TextField dniClient2) {
        this.dniClient2 = dniClient2;
    }

    public DatePicker getEntradaReserva() {
        return entradaReserva;
    }

    public void setEntradaReserva(DatePicker entradaReserva) {
        this.entradaReserva = entradaReserva;
    }

    public DatePicker getSortidaReserva() {
        return sortidaReserva;
    }

    public void setSortidaReserva(DatePicker sortidaReserva) {
        this.sortidaReserva = sortidaReserva;
    }

    public RadioButton getPagamentPendent() {
        return pagamentPendent;
    }

    public void setPagamentPendent(RadioButton pagamentPendent) {
        this.pagamentPendent = pagamentPendent;
    }

    public RadioButton getPagamentRealitzat() {
        return pagamentRealitzat;
    }

    public void setPagamentRealitzat(RadioButton pagamentRealitzat) {
        this.pagamentRealitzat = pagamentRealitzat;
    }

    public Label getHabitacioLabelError() {
        return habitacioLabelError;
    }

    public void setHabitacioLabelError(Label habitacioLabelError) {
        this.habitacioLabelError = habitacioLabelError;
    }

    public Label getReservaLabelError() {
        return reservaLabelError;
    }

    public void setReservaLabelError(Label reservaLabelError) {
        this.reservaLabelError = reservaLabelError;
    }

    public Stage getStageConfirmacio() {
        return stageConfirmacio;
    }

    public void setStageConfirmacio(Stage stageConfirmacio) {
        this.stageConfirmacio = stageConfirmacio;
    }

    public Label getNomUsuariLabel() {
        return nomUsuariLabel;
    }

    public void setNomUsuariLabel(Label nomUsuariLabel) {
        this.nomUsuariLabel = nomUsuariLabel;
    }

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getNomUsuariLabel().setText(usuari.getNom());
    }
    //Obrir buscador clients
    @FXML
    public void obrirBuscadorClient(ActionEvent event) throws IOException{
        if(getStageBuscadorClient()== null){
            Parent root = FXMLLoader.load(App.class.getResource("buscarClient" + ".fxml"));
            setStageBuscadorClient(new Stage());
            Scene scene3 =new Scene(root);
            getStageBuscadorClient().setScene(scene3);
            getStageBuscadorClient().setTitle("Clients");
            getStageBuscadorClient().getIcons().add(new Image("file:src/main/resources/media/icon.png"));
            getStageBuscadorClient().show();
            } 
        else if(getStageBuscadorClient().isShowing()){
            getStageBuscadorClient().toFront();
        }
        else {
            getStageBuscadorClient().show();
            }
    }
    //Obrir buscador habitacio
    public void obrirBuscadorHabitacio(ActionEvent event) throws IOException{
        if(getStageBuscadorHabitacio()== null){
            Parent root = FXMLLoader.load(App.class.getResource("buscarHabitacio" + ".fxml"));
            setStageBuscadorHabitacio(new Stage());
            Scene scene3 =new Scene(root);
            getStageBuscadorHabitacio().setScene(scene3);
            getStageBuscadorHabitacio().setTitle("Habitacions");
            getStageBuscadorHabitacio().getIcons().add(new Image("file:src/main/resources/media/icon.png"));
            getStageBuscadorHabitacio().show();
            } 
        else if(getStageBuscadorHabitacio().isShowing()){
            getStageBuscadorHabitacio().toFront();
        }
        else {
            getStageBuscadorHabitacio().show();
            }
    }
    //Buscar Client dni funcio
    @FXML
    public void buscarDni(MouseEvent event) throws SQLException{
        if(getBuscarClient().getText() != null || !getBuscarClient().getText().trim().isEmpty()){
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `client` WHERE `dni`='"+getBuscarClient().getText()+"'  AND `eliminatClient`=0");
            if(!rs.next()){
                getClientLabelError().setText("Client no existeix");
            }else{
                Clients client = new Clients(rs.getString("dni"),rs.getString("nomClient"),rs.getString("dataNaixament"),rs.getString("sexe"),rs.getString("nacionalitat"),rs.getString("telefon"),rs.getString("email"),rs.getString("ocupacio"),rs.getString("estatCivil"));
                afegirClient(client);
            }
        }
    }
    //Buscar Habitacio numero funcio
    @FXML
    private void buscarNumero(MouseEvent event) throws SQLException{
        if(getBuscarHabitacio().getText() != null || !getBuscarHabitacio().getText().trim().isEmpty()){
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `habitacio` WHERE `numHabitacio`='"+getBuscarHabitacio().getText()+"'");
            if(!rs.next()){
                getHabitacioLabelError().setText("Habitacio no existeix");
            }else{

                if(rs.getString("estat").equals("0")){
                    getClientLabelError().setText("Habitacio no disponible");
                }else{
                    boolean estat=false;
                    if(rs.getString("estat").equals("1")){estat=true; }
                    boolean cuina=false;
                    if(rs.getString("cuina").equals("1")){cuina=true; }
                    boolean vistaMar=false;
                    if(rs.getString("vistaMar").equals("1")){vistaMar=true; }
                    Habitacions habitacio = new Habitacions(rs.getString("numHabitacio"),rs.getString("planta"),Double.parseDouble(rs.getString("preu")),rs.getString("tipus"),estat,Integer.parseInt(rs.getString("numeroLlitsDobles")),Integer.parseInt(rs.getString("numeroLlitsNormals")),cuina,vistaMar);
                    afegirHabitacio(habitacio);
                }
            }
        }
    }
    //afegir client a la reserva
    public void afegirClient(Clients client){
        getReserva().setClient(client);
        getDniClient().setText(getReserva().getClient().getDni());
        getDniClient2().setText(getReserva().getClient().getDni());
        getNomClient().setText(getReserva().getClient().getNom());
        LocalDate naixamentDate = LocalDate.parse(getReserva().getClient().getNaixamen());
        getNaixamentClient().setValue(naixamentDate);
        getSexeClient().setText(getReserva().getClient().getSexe());
        getNacionalitatClient().setText(getReserva().getClient().getNacionalitat());
        getTelefonClient().setText(getReserva().getClient().getTelefon());
        getEmailClient().setText(getReserva().getClient().getEmail());
        getEstatCivilClient().setText(getReserva().getClient().getEstatCivil());
        getOcupacioClient().setText(getReserva().getClient().getOcupacio());
        getClientLabelError().setText("");
    }
    //afegir habitacio a la reserva
    public void afegirHabitacio(Habitacions habitacio){
        getReserva().setHabitacio(habitacio);
        getNumHabitaciohab().setText(habitacio.getNumHabitacio());
        getNumHabitaciohab2().setText(habitacio.getNumHabitacio());
        getPlantahab().setText(habitacio.getPlanta());
        getPreuhab().setText(Double.toString(habitacio.getPreu()));
        getTipushab().setText(habitacio.getTipus());
        getNumeroLlitsDobleshab().setText(Integer.toString(habitacio.getNumeroLlitsDobles()));
        getNumeroLlitsNormalshab().setText(Integer.toString(habitacio.getNumeroLlitsNormals()));
        getCuinahab().setSelected(habitacio.isCuina());
        System.out.println(habitacio);
        getVistaMarhab().setSelected(habitacio.isVistaMar());
        getHabitacioLabelError().setText("");
        dateHighLight();
    }
    //posa tots el valors per defecte
    @FXML
    public void reiniciarValors(){
        //reserva
        getReserva().setClient(null);
        getReserva().setHabitacio(null);
        //dades habitacio
        getNumHabitaciohab().setText("");
        getNumHabitaciohab2().setText("");
        getPlantahab().setText("");
        getPreuhab().setText("");
        getTipushab().setText("");
        getNumeroLlitsDobleshab().setText("");
        getNumeroLlitsNormalshab().setText("");
        getCuinahab().setSelected(false);
        getVistaMarhab().setSelected(false);
        getHabitacioLabelError().setText("");
        //dades client
        getDniClient().setText("");
        getDniClient2().setText("");
        getNomClient().setText("");
        getNaixamentClient().setValue(null);
        getSexeClient().setText("");
        getNacionalitatClient().setText("");
        getTelefonClient().setText("");
        getEmailClient().setText("");
        getEstatCivilClient().setText("");
        getOcupacioClient().setText("");
        getClientLabelError().setText("");
        //dies
        getEntradaReserva().setValue(null);
        getSortidaReserva().setValue(null);
    }
    //marca dies que la habitacio ja esta reservada
    private void dateHighLight(){
        try {
            List<LocalDate> ocupat = new ArrayList<>();
            Statement stmt = connection.getStmt();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT * FROM `reserva` WHERE `fknumHabitacio`='"+getReserva().getHabitacio().getNumHabitacio()+"'");
            while(rs.next()){
                LocalDate date1 = LocalDate.parse(rs.getString("dataEntrada"));
                LocalDate date2 = LocalDate.parse(rs.getString("dataSortida"));
                long daysBetween = ChronoUnit.DAYS.between(date1, date2);
                for(int i =0;i<daysBetween+1;i++){
                    ocupat.add(date1.plusDays(i));
                }
            }
           
            getSortidaReserva().setDayCellFactory(new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(DatePicker param) {
                    return new DateCell(){
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            LocalDate today = LocalDate.now();
                            setDisable(empty || item.compareTo(today) < 0 );
                            
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
            getEntradaReserva().setDayCellFactory(new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(DatePicker param) {
                    return new DateCell(){
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            LocalDate today = LocalDate.now();
                            setDisable(empty || item.compareTo(today) < 0 );
                            
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
            Logger.getLogger(ControladorBuscadorHabitacio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //fa les comprovacions de que les dades de la reserva siguin correctes
    @FXML
    private void comprovarFormulariReserva(MouseEvent event){
        if(getReserva().getClient()!=null){
            if(getReserva().getHabitacio()!=null){
                if(getEntradaReserva().getValue()!=null && getSortidaReserva().getValue()!=null){
                    if(getEntradaReserva().getValue().isBefore(getSortidaReserva().getValue()) || getEntradaReserva().getValue().equals(getSortidaReserva().getValue())){
                        boolean flag = false;
                        Statement stmt = connection.getStmt();
                        ResultSet rs = null;
                        try {
                            rs = stmt.executeQuery("SELECT * FROM `reserva` WHERE `fknumHabitacio`='"+getReserva().getHabitacio().getNumHabitacio()+"'");
                            //comprova si no i a cap data reservada entre mitg de la reserva
                            while(rs.next()){
                                LocalDate date1 = LocalDate.parse(rs.getString("dataEntrada"));
                                
                                if(date1.isAfter(getEntradaReserva().getValue()) && date1.isBefore(getSortidaReserva().getValue())){
                                    System.out.println("yes");
                                    flag=true;
                                }
                            }
                        } catch (SQLException ex) {
                            System.out.println("Error: "+ex.getMessage());
                        }
                        if(flag==false){
                            getReservaLabelError().setText("");
                            getReserva().setDiaEntrada(getEntradaReserva().getValue().toString());
                            getReserva().setDiaSortida(getSortidaReserva().getValue().toString());
                            getReserva().setRecepcionista(usuari);
                            if(getPagamentRealitzat().isSelected()){
                                getReserva().setTipusPagament("Pagament pendent");
                            }
                            else{
                                getReserva().setTipusPagament("Pagament realitzat");
                            }
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("FinestraConfirmarReserva" + ".fxml"));
                            Parent root;
                            try {
                                root = loader.load();
                                ControladorConfirmacioReserva controladorConfirmar = loader.getController();
                                controladorConfirmar.getDniClient().setText(controladorConfirmar.getReserva().getClient().getDni());
                                Stage stage=new Stage();
                                Scene scene3 =new Scene(root);
                                stage.setScene(scene3);
                                stage.show();
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }else{
                            getReservaLabelError().setText("Dates no valides!");
                        }
                    }
                    else{
                        getReservaLabelError().setText("Dates no valides!");
                    }
                }
                else{
                    getReservaLabelError().setText("Dates en blanc!");
                }
            }
            else{
                getReservaLabelError().setText("Habitacio no seleccionada!");
            }
        }
        else{
            getReservaLabelError().setText("Client no seleccionat!");
        }
    }
    @FXML
    private void tancarReserves(MouseEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}