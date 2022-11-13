package com.mycompany.projectem12;

import com.mycompany.controlAccess.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stageLogin;

    public static Stage getStageLogin() {
        return stageLogin;
    }
    
    

    @Override
    public void start(Stage stageLogin) {
        try {
            scene = new Scene(loadFXML("Login"));
            stageLogin.getIcons().add(new Image("file:src/main/resources/media/icon.png"));
            stageLogin.setTitle("Login");
            stageLogin.setScene(scene);
            stageLogin.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    //crea objecte usuari
    public static User usuari = new User();
    //crea conexio amb la base de dades
    public static DataBaseConnection connection = new DataBaseConnection();
    public static void main(String[] args) {
        connection.createConnection();
        launch();
    }

}