public class Memory extends AssemblyComputer{
    private double clocking;
    private int workTemp;
    private int maxTemp;
    private int memoryCount;

    public Memory(String producent, String model, String serialNumber, double clocking, int workTemp, int maxTemp, int memoryCount) {
        super(producent, model, serialNumber);
        this.clocking = clocking;
        this.workTemp = workTemp;
        this.maxTemp = maxTemp;
        this.memoryCount = memoryCount;
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

    public int getMemoryCount() {
        return memoryCount;
    }

    public void setMemoryCount(int memoryCount) {
        this.memoryCount = memoryCount;
    }
}
