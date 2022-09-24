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
    private double preu;
    private String tipus;
    private boolean estat;
    private int numeroLlitsDobles;
    private int numeroLlitsNormals;
    private boolean cuina;
    private boolean vistaMar;
    private String cuinaVisualitzar;
    private String vistaMarVisualitzar;
    private String estatVisualitzar;
    //constructor
    public Habitacions(String numHabitacio, String planta, double preu, String tipus, boolean estat, int numeroLlitsDobles, int numeroLlitsNormals, boolean cuina, boolean vistaMar) {
        this.numHabitacio = numHabitacio;
        this.planta = planta;
        this.preu = preu;
        this.tipus = tipus;
        this.estat = estat;
        this.numeroLlitsDobles = numeroLlitsDobles;
        this.numeroLlitsNormals = numeroLlitsNormals;
        this.cuina = cuina;
        this.vistaMar = vistaMar;
        if(cuina){ this.cuinaVisualitzar = "Si";}else{this.cuinaVisualitzar = "No";}
        if(vistaMar){ this.vistaMarVisualitzar = "Si";}else{this.vistaMarVisualitzar = "No";}
        if(estat){ this.estatVisualitzar = "Si";}else{this.estatVisualitzar = "No";}  
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
    public double getPreu() {
        return preu;
    }
    public void setPreu(double preu) {
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
    public int getNumeroLlitsDobles() {
        return numeroLlitsDobles;
    }
    public void setNumeroLlitsDobles(int numeroLlitsDobles) {
        this.numeroLlitsDobles = numeroLlitsDobles;
    }
    public int getNumeroLlitsNormals() {
        return numeroLlitsNormals;
    }
    public void setNumeroLlitsNormals(int numeroLlitsNormals) {
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

    public String getCuinaVisualitzar() {
        return cuinaVisualitzar;
    }

    public void setCuinaVisualitzar(String cuinaVisualitzar) {
        this.cuinaVisualitzar = cuinaVisualitzar;
    }

    public String getVistaMarVisualitzar() {
        return vistaMarVisualitzar;
    }

    public void setVistaMarVisualitzar(String vistaMarVisualitzar) {
        this.vistaMarVisualitzar = vistaMarVisualitzar;
    }

    public String getEstatVisualitzar() {
        return estatVisualitzar;
    }

    public void setEstatVisualitzar(String estatVisualitzar) {
        this.estatVisualitzar = estatVisualitzar;
    }
    
    //metodes

    @Override
    public String toString() {
        return "Habitacions{" + "numHabitacio=" + numHabitacio + ", planta=" + planta + ", preu=" + preu + ", tipus=" + tipus + ", estat=" + estat + ", numeroLlitsDobles=" + numeroLlitsDobles + ", numeroLlitsNormals=" + numeroLlitsNormals + ", cuina=" + cuina + ", vistaMar=" + vistaMar + '}';
    }

    
    
}
