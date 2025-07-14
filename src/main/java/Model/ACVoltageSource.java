package Model;

public class ACVoltageSource extends VoltageSource {
    private double amplitudeVolts;
    private double frequencyHertz;

    public ACVoltageSource(double amplitudeVolts, double frequencyHertz) {
        this.amplitudeVolts = amplitudeVolts;
        this.frequencyHertz = frequencyHertz;
    }

    @Override
    public Double getVoltage(Double time) {
        return amplitudeVolts * Math.sin(2 * Math.PI * frequencyHertz * time);
    }
    @Override
    public Double getDerivate(Double time) {
        return 2 * Math.PI * frequencyHertz * amplitudeVolts * Math.cos(2 * Math.PI * frequencyHertz * time);
    }
}
