package com.mycompany.projectem12;

import com.mycompany.controlAccess.user;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControladorRegistrar {
    //atributs
    @FXML
    private Label errorRegistrar;
    @FXML
    private TextField usuariregistrar;
    @FXML
    private TextField nomRegistrar;
    @FXML
    private TextField cognomsRegistrar;
    @FXML
    private TextField dniRegistrar;
    @FXML
    private TextField nacionalitatRegistrar;
    @FXML
    private TextField telefonRegistrar;
    @FXML
    private TextField correuRegistrar;
    @FXML
    private TextField contrasenyaRegistrar;
    //get and set

    public Label getErrorRegistrar() {
        return errorRegistrar;
    }

    public TextField getUsuariregistrar() {
        return usuariregistrar;
    }

    public TextField getNomRegistrar() {
        return nomRegistrar;
    }

    public TextField getCognomsRegistrar() {
        return cognomsRegistrar;
    }

    public TextField getDniRegistrar() {
        return dniRegistrar;
    }

    public TextField getNacionalitatRegistrar() {
        return nacionalitatRegistrar;
    }

    public TextField getTelefonRegistrar() {
        return telefonRegistrar;
    }

    public TextField getCorreuRegistrar() {
        return correuRegistrar;
    }

    public TextField getContrasenyaRegistrar() {
        return contrasenyaRegistrar;
    }
    
    //metodes
    @FXML
    //fa les comprobacions al registrar un nou recepcionista
    private void registrarUsuari(ActionEvent event) throws IOException {
        user usuariAregistrar = new user(getDniRegistrar().getText(),getNomRegistrar().getText(),getUsuariregistrar().getText(),getCognomsRegistrar().getText(),getContrasenyaRegistrar().getText(), getNacionalitatRegistrar().getText(), getTelefonRegistrar().getText(), getCorreuRegistrar().getText());
        String resultat="";
        if((getDniRegistrar().getText() == null || getDniRegistrar().getText().trim().isEmpty()) || (getNomRegistrar().getText() == null || getNomRegistrar().getText().trim().isEmpty()) || (getUsuariregistrar().getText() == null || getUsuariregistrar().getText().trim().isEmpty()) || (getCognomsRegistrar().getText() == null || getCognomsRegistrar().getText().trim().isEmpty()) || (getContrasenyaRegistrar().getText() == null || getContrasenyaRegistrar().getText().trim().isEmpty()) || (getNacionalitatRegistrar().getText() == null || getNacionalitatRegistrar().getText().trim().isEmpty()) || (getTelefonRegistrar().getText() == null || getTelefonRegistrar().getText().trim().isEmpty()) || (getCorreuRegistrar().getText() == null || getCorreuRegistrar().getText().trim().isEmpty())){
            resultat="tots els camps son obligatoris";
        }else{
            resultat=usuariAregistrar.crearUsuari();
        }

        
        if(resultat=="S"){
            errorRegistrar.setText("Usuari registrar\ncorrectament!");
            getUsuariregistrar().setText("");
            getNomRegistrar().setText("");
            getDniRegistrar().setText(""); 
            getNacionalitatRegistrar().setText(""); 
            getTelefonRegistrar().setText(""); 
            getCorreuRegistrar().setText(""); 
            getContrasenyaRegistrar().setText("");
            getCognomsRegistrar().setText(""); 
            
        }
        else{
            errorRegistrar.setText(resultat);
        }
    }
    @FXML
    //tanca la finestra actual i obra el login
    private void tornarALogin(ActionEvent event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(App.class.getResource("Login" + ".fxml"));
        Stage stage = new Stage();
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
