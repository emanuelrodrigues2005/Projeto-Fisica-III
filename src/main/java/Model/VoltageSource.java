package Model;

public abstract class VoltageSource {
    public abstract Double getVoltage(Double time);
    public abstract Double getDerivate(Double time);
}
