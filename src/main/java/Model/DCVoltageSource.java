package Model;

public class DCVoltageSource extends VoltageSource {
    private Double constantVoltage;

    public DCVoltageSource(Double constantVoltage) {
        this.constantVoltage = constantVoltage;
    }

    @Override
    public Double getVoltage(Double time) {
        return constantVoltage;
    }
    @Override
    public Double getDerivate(Double time) {
        return 0.0;
    }
}
