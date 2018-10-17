public abstract class AssemblyComputer {
    private String producent;
    private String model;
    private String serialNumber;

    public AssemblyComputer() {
    }

    public AssemblyComputer(String producent, String model, String serialNumber) {
        this.producent = producent;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
