/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlAccess;

/**
 *
 * @author Maiol
 */
public class Reserva {
    //atibuts
    private String numeroReserva;
    private Clients client;
    private Habitacions habitacio;
    private User recepcionista;
    private String tipusPagament;
    private String diaEntrada;
    private String diaSortida;
    private String observacions;
    private String mostrarclient;
    private String mostrarHabitacio;
    private String mostrarRecepcionista;
    //constructor

    public Reserva(String numeroReserva, Clients client, Habitacions habitacio, User recepcionista, String tipusPagament, String diaEntrada, String diaSortida, String observacions) {
        this.numeroReserva = numeroReserva;
        this.client = client;
        this.habitacio = habitacio;
        this.recepcionista = recepcionista;
        this.tipusPagament = tipusPagament;
        this.diaEntrada = diaEntrada;
        this.diaSortida = diaSortida;
        this.observacions = observacions;
    }

    public Reserva(String numeroReserva, String tipusPagament, String diaEntrada, String diaSortida, String observacions, String mostrarclient, String mostrarHabitacio, String mostrarRecepcionista) {
        this.numeroReserva = numeroReserva;
        this.tipusPagament = tipusPagament;
        this.diaEntrada = diaEntrada;
        this.diaSortida = diaSortida;
        this.observacions = observacions;
        this.mostrarclient = mostrarclient;
        this.mostrarHabitacio = mostrarHabitacio;
        this.mostrarRecepcionista = mostrarRecepcionista;
    }
    
    public Reserva() {
    }
    
    //gets i sets
    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Habitacions getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(Habitacions habitacio) {
        this.habitacio = habitacio;
    }

    public User getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(User recepcionista) {
        this.recepcionista = recepcionista;
    }

    public String getTipusPagament() {
        return tipusPagament;
    }

    public void setTipusPagament(String tipusPagament) {
        this.tipusPagament = tipusPagament;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public String getDiaSortida() {
        return diaSortida;
    }

    public void setDiaSortida(String diaSortida) {
        this.diaSortida = diaSortida;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

    public String getMostrarclient() {
        return mostrarclient;
    }

    public void setMostrarclient(String mostrarclient) {
        this.mostrarclient = mostrarclient;
    }

    public String getMostrarHabitacio() {
        return mostrarHabitacio;
    }

    public void setMostrarHabitacio(String mostrarHabitacio) {
        this.mostrarHabitacio = mostrarHabitacio;
    }

    public String getMostrarRecepcionista() {
        return mostrarRecepcionista;
    }

    public void setMostrarRecepcionista(String mostrarRecepcionista) {
        this.mostrarRecepcionista = mostrarRecepcionista;
    }

    
   
    @Override
    public String toString() {
        return "Reseva{" + "numeroReserva=" + numeroReserva + ", client=" + client + ", habitacio=" + habitacio + ", recepcionista=" + recepcionista + ", tipusPagament=" + tipusPagament + ", diaEntrada=" + diaEntrada + ", diaSortida=" + diaSortida + '}';
    }
    
    
}
