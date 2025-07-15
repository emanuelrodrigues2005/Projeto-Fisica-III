package Exporter;

import Solver.SimulationResult;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CsvExporter {

    public void export(SimulationResult result, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            writer.write("Tempo (s),Corrente (A)");
            writer.newLine();

            List<Double> timePoints = result.getTimePoints();
            List<Double> currentPoints = result.getCurrentPoints();

            for (int i = 0; i < timePoints.size(); i++) {
                String line = String.format(Locale.US, "%.8f,%.8f", timePoints.get(i), currentPoints.get(i));
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao exportar o arquivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}