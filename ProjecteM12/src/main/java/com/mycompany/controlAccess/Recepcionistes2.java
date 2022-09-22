package com.mycompany.controlAccess;

import static com.mycompany.projectem12.App.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Maiol
 */
public class Recepcionistes2 {
    //Atributs
    
    private SimpleStringProperty dni;
    private SimpleStringProperty nom;
    private SimpleStringProperty nomUsuari;
    private SimpleStringProperty cognom;
    private SimpleStringProperty contrasenya;
    private SimpleStringProperty nacionalitat;
    private SimpleStringProperty telefon;
    private SimpleStringProperty email;
    private SimpleStringProperty validat;
    //constructor

    public Recepcionistes2(String dni, String nom, String nomUsuari, String cognom, String contrasenya, String nacionalitat, String telefon, String email, String validat) {
        this.dni = new SimpleStringProperty(dni);
        this.nom = new SimpleStringProperty(nom);
        this.nomUsuari = new SimpleStringProperty(nomUsuari);
        this.cognom = new SimpleStringProperty(cognom);
        this.contrasenya = new SimpleStringProperty(contrasenya);
        this.nacionalitat = new SimpleStringProperty(nacionalitat);
        this.telefon = new SimpleStringProperty(telefon);
        this.email = new SimpleStringProperty(email);
        this.validat = new SimpleStringProperty(validat);
    }
    
    //gets and sets
    public SimpleStringProperty getDni() {
        return dni;
    }

    public void setDni(SimpleStringProperty dni) {
        this.dni = dni;
    }

    public SimpleStringProperty getNom() {
        return nom;
    }

    public void setNom(SimpleStringProperty nom) {
        this.nom = nom;
    }

    public SimpleStringProperty getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(SimpleStringProperty nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public SimpleStringProperty getCognom() {
        return cognom;
    }

    public void setCognom(SimpleStringProperty cognom) {
        this.cognom = cognom;
    }

    public SimpleStringProperty getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(SimpleStringProperty contrasenya) {
        this.contrasenya = contrasenya;
    }

    public SimpleStringProperty getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(SimpleStringProperty nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public SimpleStringProperty getTelefon() {
        return telefon;
    }

    public void setTelefon(SimpleStringProperty telefon) {
        this.telefon = telefon;
    }

    public SimpleStringProperty getEmail() {
        return email;
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

    public SimpleStringProperty getValidat() {
        return validat;
    }

    public void setValidat(SimpleStringProperty validat) {    
        this.validat = validat;
    }

    //metodes
    @Override
    public String toString() {
        return "recepcionistes{" + "dni=" + dni + ", nom=" + nom + ", nomUsuari=" + nomUsuari + ", cognom=" + cognom + ", contrasenya=" + contrasenya + ", nacionalitat=" + nacionalitat + ", telefon=" + telefon + ", email=" + email + ", validat=" + validat + '}';
    }
}
