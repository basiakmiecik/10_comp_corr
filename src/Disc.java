public class Disc extends AssemblyComputer{
        private int capacity;

    public Disc(String producent, String model, String serialNumber, int capacity) {
        super(producent, model, serialNumber);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
