package Solver;

import java.util.List;

public class SimulationResult {
    private final List<Double> timePoints;
    private final List<Double> currentPoints;

    public SimulationResult(List<Double> timePoints, List<Double> currentPoints) {
        this.timePoints = timePoints;
        this.currentPoints = currentPoints;
    }

    public List<Double> getTimePoints() {
        return timePoints;
    }

    public List<Double> getCurrentPoints() {
        return currentPoints;
    }
}