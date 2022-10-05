/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectem12;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Maiol
 */
public class ControladorFinestraReserves {
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
    @FXML private CheckBox estathab;
    //buscar habitacio numero
    @FXML private TextField buscarHabitacio;
    //labels
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

    public CheckBox getEstathab() {
        return estathab;
    }

    public void setEstathab(CheckBox estathab) {
        this.estathab = estathab;
    }

    public TextField getBuscarHabitacio() {
        return buscarHabitacio;
    }

    public void setBuscarHabitacio(TextField buscarHabitacio) {
        this.buscarHabitacio = buscarHabitacio;
    }
    //Obrir buscador clients
    //obrir buscador habitacions
    //Buscar Client dni funcio
    //Buscar Habitacio numero funcio

 
}