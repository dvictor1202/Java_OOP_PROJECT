package part;

public class Gpu extends Part {
    private int graphicsRam;
    private int memoryBusWidth;

    public Gpu(String manufacturer, String model, int graphicsRam, int memoryBusWidth) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.graphicsRam = graphicsRam;
        this.memoryBusWidth = memoryBusWidth;
    }

    @Override
    public void deviceID() {
        System.out.println("GraphicsCard: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("Graphics Ram Size(GB): " + this.getGraphicsRam());
        System.out.print("Memory Bus Width: " + this.memoryBusWidth);
        System.out.println();
        System.out.println();
    }


    public int getGraphicsRam() {
        return graphicsRam;
    }

    public int getMemoryBus() {
        return memoryBusWidth;
    }

    public void setGraphicsRam(int graphicsRam) {
        this.graphicsRam = graphicsRam;
    }

    public void setFoldable(int memoryBusWidth) {
        this.memoryBusWidth = memoryBusWidth;
    }
    
    @Override
    public String toString()
    {
        return "Manufacturer: " + this.manufacturer + "\n" + "Model: " + this.model + "\n" + "Graphics Ram Size: " + graphicsRam + "GB\n" + "Memory Bus Width: " + memoryBusWidth + "bits\n";
    }
}