package part;

public class Cpu extends Part {
    private int nofCores;
    private int generation;

    public Cpu(String manufacturer, String model, int nofCores, int generation){
        this.manufacturer = manufacturer;
        this.model = model;
        this.nofCores = nofCores;
        this.generation = generation;
    }

    @Override
    public void deviceID() {
        System.out.println("Cpu: " + this.getManufacturer() + " " + this.getModel());
        System.out.println("Number of cores: " + this.nofCores);
        System.out.print("Generation: ");
        System.out.print(this.generation);
        if(generation == 1)
            System.out.print("st");
        else if(generation == 2)
            System.out.print("nd");
        else if(generation == 3)
            System.out.print("rd");
        else
             System.out.print("th");
        System.out.println();
        System.out.println();
    }

    public int getNofCores() {
        return this.nofCores;
    }

    public int getGeneration() {
        return this.generation;
    }

    public void setRAM(int nofCores) {
        this.nofCores = nofCores;
    }

    public void setStorage(int generation) {
        this.generation = generation;
    }
}