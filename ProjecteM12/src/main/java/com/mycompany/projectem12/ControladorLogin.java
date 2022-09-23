
package com.mycompany.projectem12;
import static com.mycompany.projectem12.App.usuari;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ControladorLogin {
    //atributs
    @FXML
    private Label errorLogin;
    @FXML
    private TextField usuariLogin;
    @FXML
    private TextField contrasenyaLogin;
    //get and set

    public Label getErrorLogin() {
        return errorLogin;
    }

    public void setErrorLogin(Label errorLogin) {
        this.errorLogin = errorLogin;
    }

    public TextField getUsuariLogin() {
        return usuariLogin;
    }

    public void setUsuariLogin(TextField usuariLogin) {
        this.usuariLogin = usuariLogin;
    }

    public TextField getContrasenyaLogin() {
        return contrasenyaLogin;
    }

    public void setContrasenyaLogin(TextField contrasenyaLogin) {
        this.contrasenyaLogin = contrasenyaLogin;
    }
    
    @FXML
    private void login(ActionEvent event) throws UnsupportedEncodingException, IOException{
        usuari.login(getUsuariLogin().getText(), getContrasenyaLogin().getText());
        String menu;
        if(usuari.getLogged()){
            if(usuari.getAdmin()){
                menu = "menuPrincipalAdmin";
            }else{
                menu = "menuPrincipal";
            }
            ((Node)event.getSource()).getScene().getWindow().hide();
            ControladorMenuAdmin cma = new ControladorMenuAdmin();
            cma.obrirMenuAdmin(menu);
        }else{
            errorLogin.setText("Error amb la identificacio!");
        }
        
    }
    @FXML
    private void obrirRegistrar(ActionEvent event) throws IOException {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(App.class.getResource("registrarUsuari" + ".fxml"));
            Stage stage = new Stage();
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
}
