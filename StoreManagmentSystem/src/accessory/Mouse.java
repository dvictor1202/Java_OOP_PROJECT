package accessory;

public class Mouse extends Accessory {
    private String manufacturer;
    private String model;
    private int weight;

    public Mouse(String manufacturer, String model, int weight){
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
    }

    @Override
    public void wearableID() {
        System.out.println("Mouse: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("Weight of mouse: " + this.weight + "g");
        System.out.println();
        System.out.println();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}