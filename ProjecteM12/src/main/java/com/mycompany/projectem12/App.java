package com.mycompany.projectem12;

import com.mycompany.controlAccess.user;
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
    public void start(Stage stageLogin) throws IOException {
        scene = new Scene(loadFXML("Login"));
        stageLogin.setScene(scene);
        stageLogin.show();
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static user usuari = new user();
    public static DataBaseConnection connection = new DataBaseConnection();
    public static void main(String[] args) {
        connection.createConnection();
        launch();
    }

}