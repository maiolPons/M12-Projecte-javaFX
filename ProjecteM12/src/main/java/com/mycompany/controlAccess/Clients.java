/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlAccess;

/**
 *
 * @author Maiol
 */
public class Clients {
    //Atributs
    private String dni;
    private String nom;
    private String naixamen;
    private String sexe;
    private String nacionalitat;
    private String telefon;
    private String email;
    private String ocupacio;
    private String estatCivil;
    //constructor

    public Clients(String dni, String nom, String naixamen, String sexe, String nacionalitat, String telefon, String email, String ocupacio, String estatCivil) {
        this.dni = dni;
        this.nom = nom;
        this.naixamen = naixamen;
        this.sexe = sexe;
        this.nacionalitat = nacionalitat;
        this.telefon = telefon;
        this.email = email;
        this.ocupacio = ocupacio;
        this.estatCivil = estatCivil;
    }
    //get and set

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNaixamen() {
        return naixamen;
    }

    public void setNaixamen(String naixamen) {
        this.naixamen = naixamen;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupacio() {
        return ocupacio;
    }

    public void setOcupacio(String ocupacio) {
        this.ocupacio = ocupacio;
    }

    public String getEstatCivil() {
        return estatCivil;
    }

    public void setEstatCivil(String estatCivil) {
        this.estatCivil = estatCivil;
    }
    
    
    //metodes

    @Override
    public String toString() {
        return "Clients{" + "dni=" + dni + ", nom=" + nom + ", naixamen=" + naixamen + ", sexe=" + sexe + ", nacionalitat=" + nacionalitat + ", telefon=" + telefon + ", email=" + email + ", ocupacio=" + ocupacio + ", estatCivil=" + estatCivil + '}';
    }
    
}
