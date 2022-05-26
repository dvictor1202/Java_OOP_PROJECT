package part;

public class Motherboard extends Part {

    private String socketCpu;

    public Motherboard(String manufacturer, String model, String socketCpu){
        this.manufacturer = manufacturer;
        this.model = model;
        this.socketCpu = socketCpu;
    }

    @Override
    public void deviceID() {
        System.out.println("Motherboard: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("Cpu socket type: " + this.socketCpu);
        System.out.println();
        System.out.println();
    }

    public String getSocketCpu() {
        return socketCpu;
    }


    public void setSocketCpu(String socketCpu) {
        this.socketCpu = socketCpu;
    }
}