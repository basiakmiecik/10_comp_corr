public class Processor extends AssemblyComputer implements OverclockableComponent,DecreaseclockComponent {
    private double clocking;
    private int workTemp;
    private int maxTemp;
    int fabricTemp;
    double fabricClocking;


    public Processor() {
    }

    public Processor(String producent, String model, String serialNumber, double clocking, int workTemp, int maxTemp) {
        super(producent, model, serialNumber);
        this.clocking = clocking;
        this.workTemp = workTemp;
        this.maxTemp = maxTemp;
        fabricTemp = workTemp;
        fabricClocking = clocking;

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


    @Override
    public double overClock(int mhz) {
        double clockingMax = fabricClocking + Math.round(maxTemp - fabricTemp) * 10;
        System.out.println("Max Clocking processor: " + clockingMax);
        clocking = clocking + mhz;
        int NewTemp = workTemp + (mhz / 10);
        workTemp = NewTemp;
        if (clocking > clockingMax) {
            throw new TempertureToHighException();
        }
        return clocking;
    }

    @Override
    public double decreaseClock(int mhz) {
        clocking = clocking - mhz;
        if (clocking < fabricClocking) {
            clocking = fabricClocking;
            workTemp = fabricTemp;
            System.err.println("Nie można zmniejszyć o zadaną wartośc, ustwawiono wartości fabryczne");
        }
        return clocking;
    }
}
