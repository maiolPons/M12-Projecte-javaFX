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

    
   
    @Override
    public String toString() {
        return "Reseva{" + "numeroReserva=" + numeroReserva + ", client=" + client + ", habitacio=" + habitacio + ", recepcionista=" + recepcionista + ", tipusPagament=" + tipusPagament + ", diaEntrada=" + diaEntrada + ", diaSortida=" + diaSortida + '}';
    }
    
    
}
