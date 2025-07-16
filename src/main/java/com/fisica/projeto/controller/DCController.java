package com.fisica.projeto.controller;

import com.fisica.projeto.Main;
import com.fisica.projeto.model.Circuit;
import com.fisica.projeto.model.DCVoltageSource;
import com.fisica.projeto.solver.RungeKuttaSolver;
import com.fisica.projeto.solver.SimulationResult;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DCController {

    @FXML private TextField resistorField;
    @FXML private TextField capacitorField;
    @FXML private TextField inductorField;
    @FXML private TextField voltageField;
    @FXML private TextField totalTimeField;
    @FXML private TextField timeStepField;

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleBackClick() {
        mainApp.showWelcomeScreen();
    }

    @FXML
    private void handleSimulateClick() {
        try {
            double resistance = Double.parseDouble(resistorField.getText());
            double capacitance = Double.parseDouble(capacitorField.getText());
            double inductance = Double.parseDouble(inductorField.getText());
            double voltage = Double.parseDouble(voltageField.getText());
            double totalTime = Double.parseDouble(totalTimeField.getText());
            double timeStep = Double.parseDouble(timeStepField.getText());

            if (resistance <= 0 || capacitance <= 0 || inductance <= 0 || totalTime <= 0 || timeStep <= 0) {
                showAlert("Erro de Validação", "Os valores dos componentes, tempo total e passo de tempo devem ser números positivos.");
                return;
            }

            Circuit circuit = new Circuit(resistance, capacitance, inductance, totalTime, timeStep);
            DCVoltageSource dcSource = new DCVoltageSource(voltage);

            RungeKuttaSolver solver = new RungeKuttaSolver();
            SimulationResult result = solver.solve(circuit, dcSource);

            System.out.println("Simulação DC concluída com sucesso!");
            System.out.println("Total de pontos gerados: " + result.getTimePoints().size());

            // TODO: Chamar o método no Main para mostrar a tela do gráfico
            // Ex: mainApp.showGraphScreen(result);
        } catch (NumberFormatException e) {
            showAlert("Erro de Entrada", "Por favor, preencha todos os campos com valores numéricos válidos.");
        } catch (Exception e) {
            showAlert("Erro Inesperado", "Ocorreu um erro durante a simulação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}