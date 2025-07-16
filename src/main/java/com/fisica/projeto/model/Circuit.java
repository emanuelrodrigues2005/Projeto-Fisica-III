package com.fisica.projeto.model;

public class Circuit {
    private Double resistor;
    private Double capacitor;
    private Double inductor;
    private Double totalTime;
    private Double timeStep;

    public Circuit(Double resistor, Double capacitor, Double inductor, Double totalTime, Double timeStep) {
        this.resistor = resistor;
        this.capacitor = capacitor;
        this.inductor = inductor;
        this.totalTime = totalTime;
        this.timeStep = timeStep;
    }

    public Double getResistor() {
        return resistor;
    }

    public void setResistor(Double resistor) {
        this.resistor = resistor;
    }

    public Double getCapacitor() {
        return capacitor;
    }

    public void setCapacitor(Double capacitor) {
        this.capacitor = capacitor;
    }

    public Double getInductor() {
        return inductor;
    }

    public void setInductor(Double inductor) {
        this.inductor = inductor;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Double getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(Double timeStep) {
        this.timeStep = timeStep;
    }
}
