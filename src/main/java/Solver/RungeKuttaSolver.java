package Solver;

import Model.Circuit;
import Model.VoltageSource;
import java.util.ArrayList;
import java.util.List;

public class RungeKuttaSolver {

    public SimulationResult solve(Circuit circuit, VoltageSource voltageSource) {
        List<Double> timePoints = new ArrayList<>();
        List<Double> currentPoints = new ArrayList<>();

        double q = 0.0;
        double i = 0.0;

        double totalTime = circuit.getTotalTime();
        double timeStep = circuit.getTimeStep();

        for (double t = 0; t <= totalTime; t += timeStep) {
            timePoints.add(t);
            currentPoints.add(i);

            double[] nextState = calculateNextStep(circuit, voltageSource, t, q, i);
            q = nextState[0];
            i = nextState[1];
        }

        return new SimulationResult(timePoints, currentPoints);
    }

    private double[] calculateNextStep(Circuit circuit, VoltageSource voltageSource, double t, double q, double i) {
        double h = circuit.getTimeStep();

        double k1_q = h * i;
        double k1_i = h * getCurrentDerivative(t, q, i, circuit, voltageSource);

        double mid_q1 = q + k1_q / 2.0;
        double mid_i1 = i + k1_i / 2.0;
        double k2_q = h * mid_i1;
        double k2_i = h * getCurrentDerivative(t + h / 2.0, mid_q1, mid_i1, circuit, voltageSource);

        double mid_q2 = q + k2_q / 2.0;
        double mid_i2 = i + k2_i / 2.0;
        double k3_q = h * mid_i2;
        double k3_i = h * getCurrentDerivative(t + h / 2.0, mid_q2, mid_i2, circuit, voltageSource);

        double end_q = q + k3_q;
        double end_i = i + k3_i;
        double k4_q = h * end_i;
        double k4_i = h * getCurrentDerivative(t + h, end_q, end_i, circuit, voltageSource);

        double q_next = q + (k1_q + 2 * k2_q + 2 * k3_q + k4_q) / 6.0;
        double i_next = i + (k1_i + 2 * k2_i + 2 * k3_i + k4_i) / 6.0;

        return new double[]{q_next, i_next};
    }

    private double getCurrentDerivative(double t, double q, double i, Circuit circuit, VoltageSource voltageSource) {
        return (voltageSource.getVoltage(t) - circuit.getResistor() * i - q / circuit.getCapacitor()) / circuit.getInductor();
    }
}