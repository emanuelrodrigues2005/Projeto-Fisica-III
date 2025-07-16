package com.fisica.projeto.controller;

import java.io.File;

import com.fisica.projeto.Main;
import com.fisica.projeto.exporter.CsvExporter;
import com.fisica.projeto.solver.SimulationResult;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class GraphController {

    @FXML private LineChart<Number, Number> chart;
    @FXML private NumberAxis xAxis;
    @FXML private NumberAxis yAxis;
    @FXML private Button exportButton;
    @FXML private Button backButton;

    private SimulationResult result;
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setSimulationResult(SimulationResult result) {
        this.result = result;
        plotGraph();
    }

    private void plotGraph() {
        // Configurar eixos
        xAxis.setLabel("Tempo (s)");
        yAxis.setLabel("Corrente (A)");
        
        // Criar série de dados
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Corrente no circuito");

        // Adicionar pontos
        for (int i = 0; i < result.getTimePoints().size(); i++) {
            series.getData().add(new XYChart.Data<>(
                result.getTimePoints().get(i),
                result.getCurrentPoints().get(i)
            ));
        }

        chart.getData().add(series);
    }

    @FXML
    private void handleExportClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar dados da simulação");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            CsvExporter exporter = new CsvExporter();
            exporter.export(result, file.getAbsolutePath());
            showAlert("Exportação Concluída", "Dados exportados para:\n" + file.getAbsolutePath());
        }
    }

    @FXML
    private void handleBackClick() {
        mainApp.showWelcomeScreen();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}