public class Memory extends AssemblyComputer implements OverclockableComponent,DecreaseclockComponent{
    private double clocking;
    private int workTemp;
    private int maxTemp;
    private int memoryCount;
    double fabricClocking;
    int fabricTemp;

    public Memory(String producent, String model, String serialNumber, double clocking, int workTemp, int maxTemp, int memoryCount) {
        super(producent, model, serialNumber);
        this.clocking = clocking;
        this.workTemp = workTemp;
        this.maxTemp = maxTemp;
        this.memoryCount = memoryCount;
        fabricTemp=workTemp;
        fabricClocking=clocking;
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


    @Override
    public double overClock(int mhz) {

        double mclockingMax= Math.round((fabricClocking+maxTemp- fabricTemp)*100/15);
        System.out.println("Max Clocking memory: "+mclockingMax);
        setClocking(fabricClocking+mhz);
            int NewTemp=workTemp+(mhz/15);
            workTemp=NewTemp;
            if(clocking>mclockingMax){
                throw new TempertureToHighException();
            }
        return clocking;
        }


    @Override
    public double decreaseClock(int mhz) {
        clocking= clocking-mhz;
        if(clocking<fabricClocking) {
            clocking = fabricClocking;
            workTemp = fabricTemp;
            System.err.println("Nie można zmniejszyć o zadaną wartośc, ustwawiono wartości fabryczne");
        }
        return clocking;
    }
}
