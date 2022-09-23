/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlAccess;

/**
 *
 * @author Maiol
 */
public class Habitacions {
    //Atributs
    private String numHabitacio;
    private String planta;
    private String preu;
    private String tipus;
    private boolean estat;
    private String numeroLlitsDobles;
    private String numeroLlitsNormals;
    private boolean cuina;
    private boolean vistaMar;
    //constructor
    public Habitacions(String numHabitacio, String planta, String preu, String tipus, boolean estat, String numeroLlitsDobles, String numeroLlitsNormals, boolean cuina, boolean vistaMar) {
        this.numHabitacio = numHabitacio;
        this.planta = planta;
        this.preu = preu;
        this.tipus = tipus;
        this.estat = estat;
        this.numeroLlitsDobles = numeroLlitsDobles;
        this.numeroLlitsNormals = numeroLlitsNormals;
        this.cuina = cuina;
        this.vistaMar = vistaMar;
    }
    //gets i sets
    public String getNumHabitacio() {
        return numHabitacio;
    }
    public void setNumHabitacio(String numHabitacio) {
        this.numHabitacio = numHabitacio;
    }
    public String getPlanta() {
        return planta;
    }
    public void setPlanta(String planta) {
        this.planta = planta;
    }
    public String getPreu() {
        return preu;
    }
    public void setPreu(String preu) {
        this.preu = preu;
    }
    public String getTipus() {
        return tipus;
    }
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    public boolean isEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }
    public String getNumeroLlitsDobles() {
        return numeroLlitsDobles;
    }
    public void setNumeroLlitsDobles(String numeroLlitsDobles) {
        this.numeroLlitsDobles = numeroLlitsDobles;
    }
    public String getNumeroLlitsNormals() {
        return numeroLlitsNormals;
    }
    public void setNumeroLlitsNormals(String numeroLlitsNormals) {
        this.numeroLlitsNormals = numeroLlitsNormals;
    }
    public boolean isCuina() {
        return cuina;
    }
    public void setCuina(boolean cuina) {
        this.cuina = cuina;
    }
    public boolean isVistaMar() {
        return vistaMar;
    }
    public void setVistaMar(boolean vistaMar) {
        this.vistaMar = vistaMar;
    }
    //metodes

    @Override
    public String toString() {
        return "Habitacions{" + "numHabitacio=" + numHabitacio + ", planta=" + planta + ", preu=" + preu + ", tipus=" + tipus + ", estat=" + estat + ", numeroLlitsDobles=" + numeroLlitsDobles + ", numeroLlitsNormals=" + numeroLlitsNormals + ", cuina=" + cuina + ", vistaMar=" + vistaMar + '}';
    }

    
    
}