package com.fisica.projeto.controller;

import com.fisica.projeto.Main;
import javafx.fxml.FXML;

public class WelcomeController {

    // Referência à aplicação principal
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleDCClick() {
        mainApp.showDCScreen();
    }

    @FXML
    private void handleACClick() {
        mainApp.showACScreen();
    }
}
