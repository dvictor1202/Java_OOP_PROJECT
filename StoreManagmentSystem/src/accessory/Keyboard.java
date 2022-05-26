package accessory;

public class Keyboard extends Accessory {
    private String manufacturer;
    private String model;
    private int gaming;

    public Keyboard(String manufacturer, String model, int gaming){
        this.manufacturer = manufacturer;
        this.model = model;
        this.gaming = gaming;
    }

    @Override
    public void wearableID() {
        System.out.println("Keyboard: " + this.getManufacturer() + " " + this.getModel());
        System.out.print("Gaming: ");
        if (gaming == 1)
            System.out.println("Gaming Keyboard!");
        else
            System.out.println("Not a gaming keyboard");
        System.out.println();
        System.out.println();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getGaming() {
        return gaming;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setGaming(int gaming) {
        this.gaming = gaming;
    }
}