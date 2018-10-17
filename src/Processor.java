public class Processor extends AssemblyComputer{
 private double clocking;
 private int workTemp;
 private int maxTemp;

    public Processor() {
    }

    public Processor(String producent, String model, String serialNumber, double clocking, int workTemp, int maxTemp) {
        super(producent, model, serialNumber);
        this.clocking = clocking;
        this.workTemp = workTemp;
        this.maxTemp = maxTemp;
    }

    public double getClocking() {
        return clocking;
    }

    public void setClocking(double clocking) {
        this.clocking = clocking;
    }

    public int getWorkTemp() {
        return workTemp;
    }

    public void setWorkTemp(int workTemp) {
        this.workTemp = workTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }
}
