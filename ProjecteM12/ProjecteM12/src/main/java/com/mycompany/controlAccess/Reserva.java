/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlAccess;

import static com.mycompany.projectem12.App.connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

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
    public void reservaPdf(Stage stage){
        String path="";
        try{
            DirectoryChooser directoryChooser=new DirectoryChooser();
            File file = directoryChooser.showDialog(stage);
            if(file!=null){
                //crea document
                path = file.getPath ();
                path=path+"/Reserva_"+getNumeroReserva()+".pdf";
                PDDocument document = new PDDocument();
                PDRectangle facturaMida = new PDRectangle(900,600);
                PDPage factura = new PDPage(facturaMida);
                document.addPage(factura);
                //imatge i manager continguts
                PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/media/factura.png", document);
                PDPageContentStream content=new PDPageContentStream(document,factura);
                content.drawImage(pdImage, 0, 0);
                content.setFont(PDType1Font.TIMES_ROMAN, 16);
                //informacio completa per factura
                Statement stmt = connection.getStmt();
                ResultSet rs = null;
                rs = stmt.executeQuery("SELECT * FROM `habitacio` INNER JOIN `reserva` ON `numHabitacio` = `fknumHabitacio` INNER JOIN `client` ON `fkdniClient` = `dni` WHERE `idReserva` = '"+getNumeroReserva()+"'");
                //omplir document
                if (rs.next()) {
                    //client
                    content.beginText();
                    content.newLineAtOffset(125, 360);
                    content.showText(rs.getString("nomClient"));
                    content.endText();
                    content.beginText();
                    content.newLineAtOffset(125, 338);
                    content.showText(rs.getString("dni"));
                    content.endText();
                    content.beginText();
                    content.newLineAtOffset(125, 313);
                    content.showText(rs.getString("email"));
                    content.endText();
                    content.beginText();
                    content.newLineAtOffset(125, 288);
                    content.showText(rs.getString("telefon"));
                    content.endText();
                    //habitacio
                    content.beginText();
                    content.newLineAtOffset(550, 360);
                    content.showText(rs.getString("numHabitacio"));
                    content.endText();
                    content.beginText();
                    content.newLineAtOffset(550, 338);
                    content.showText(rs.getString("planta"));
                    content.endText();
                    content.beginText();
                    content.newLineAtOffset(550, 313);
                    content.showText(rs.getString("tipus"));
                    content.endText();
                    content.beginText();
                    content.newLineAtOffset(550, 288);
                    content.showText(rs.getString("preu"));
                    content.endText();
                    //preu
                    content.beginText();
                    content.newLineAtOffset(710, 60);
                    LocalDate date1 = LocalDate.parse(rs.getString("dataEntrada"));
                    LocalDate date2 = LocalDate.parse(rs.getString("dataSortida"));
                    long daysBetween = ChronoUnit.DAYS.between(date1, date2);
                    content.showText(Double.toString(Double.valueOf(rs.getString("preu"))*daysBetween));
                    content.endText();
                }
                content.close();
                document.save(path);
                document.close();
            } 
            try{
                if(file.exists()){
                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                    desktop.open(new File(path));
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Error obrin l'arxiu");
            }
            
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error creant l'arxiu");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
    @Override
    public String toString() {
        return "Reseva{" + "numeroReserva=" + numeroReserva + ", client=" + client + ", habitacio=" + habitacio + ", recepcionista=" + recepcionista + ", tipusPagament=" + tipusPagament + ", diaEntrada=" + diaEntrada + ", diaSortida=" + diaSortida + '}';
    }
    
    
}
