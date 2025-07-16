package com.fisica.projeto;

import com.fisica.projeto.controller.ACController;
import com.fisica.projeto.controller.DCController;
import com.fisica.projeto.controller.WelcomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private Scene welcomeScene;
    private Scene dcScene;
    private Scene acScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Simulador de Circuito RLC");

        // Carrega todas as cenas na inicialização
        loadScenes();

        // Define a cena inicial
        showWelcomeScreen();
    }

    private void loadScenes() throws IOException {
        // Carrega WelcomeScreen.fxml
        FXMLLoader welcomeLoader = new FXMLLoader(getClass().getResource("/WelcomeScreen.fxml"));
        Parent welcomeRoot = welcomeLoader.load();
        WelcomeController welcomeController = welcomeLoader.getController();
        welcomeController.setMainApp(this);
        welcomeScene = new Scene(welcomeRoot);

        // Carrega DCScreen.fxml
        FXMLLoader dcLoader = new FXMLLoader(getClass().getResource("/DCScreen.fxml"));
        Parent dcRoot = dcLoader.load();
        DCController dcController = dcLoader.getController();
        dcController.setMainApp(this);
        dcScene = new Scene(dcRoot);

        // Carrega ACScreen.fxml
        FXMLLoader acLoader = new FXMLLoader(getClass().getResource("/ACScreen.fxml"));
        Parent acRoot = acLoader.load();
        ACController acController = acLoader.getController();
        acController.setMainApp(this);
        acScene = new Scene(acRoot);
    }

    // Métodos públicos para trocar as cenas
    public void showWelcomeScreen() {
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    public void showDCScreen() {
        primaryStage.setScene(dcScene);
        primaryStage.show();
    }

    public void showACScreen() {
        primaryStage.setScene(acScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}