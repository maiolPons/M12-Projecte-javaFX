package com.mycompany.controlAccess;
/**
 *
 * @author Maiol
 */
public class Recepcionistes {
    //Atributs
    private String dni;
    private String nom;
    private String nomUsuari;
    private String cognom;
    private String contrasenya;
    private String nacionalitat;
    private String telefon;
    private String email;
    private String validat;
    //constructor
    public Recepcionistes(String dni, String nom, String nomUsuari, String cognom, String contrasenya, String nacionalitat, String telefon, String email, String validat) {
        this.dni = dni;
        this.nom = nom;
        this.nomUsuari = nomUsuari;
        this.cognom = cognom;
        this.contrasenya = contrasenya;
        this.nacionalitat = nacionalitat;
        this.telefon = telefon;
        this.email = email;
        this.validat = validat;
    }

    public Recepcionistes(String dni, String nom, String cognom) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
    }
    
    //gets and sets
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

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
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

    public String isValidat() {
        return validat;
    }

    public void setValidat(String validat) {
        this.validat = validat;
    }

    public String getValidat() {
        return validat;
    }
    
    //metodes
    
    @Override
    public String toString() {
        return "recepcionistes{" + "dni=" + dni + ", nom=" + nom + ", nomUsuari=" + nomUsuari + ", cognom=" + cognom + ", contrasenya=" + contrasenya + ", nacionalitat=" + nacionalitat + ", telefon=" + telefon + ", email=" + email + ", validat=" + validat + '}';
    }
}
