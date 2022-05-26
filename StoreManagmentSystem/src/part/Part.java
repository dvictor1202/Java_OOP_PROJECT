package part;
import java.util.*;

public class Part {
    private static Part single = null;
    protected String manufacturer;
    protected String model;

    public static Part getInstance() {
        if (single == null)
            single = new Part();

        return single;
    }

    private List<Gpu> gpus;
    private List<Motherboard> motherboards;
    private List<Cpu> cpus;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Part() {
        this.gpus = new ArrayList<Gpu>();
        this.motherboards = new ArrayList<Motherboard>();
        this.cpus = new ArrayList<Cpu>();
    }

    public List<Gpu> getGpus() {
        return this.gpus;
    }

    public List<Motherboard> getMotherboards() {
        return this.motherboards;
    }

    public List<Cpu> getCpus() {
        return this.cpus;
    }

    protected void deviceID(){
    }

    public void addGpu(Gpu gpu){
        this.gpus.add(gpu);
    }

    public void addMotherboard(Motherboard motherboard){
        this.motherboards.add(motherboard);
    }

    public void addCpu(Cpu cpu){
        this.cpus.add(cpu);
    }

    public static <T> void displayFunction(T[] array) {
        for (T element : array)
            System.out.println(element);
    }

    public void displayGpus() {
        System.out.println("Graphics Cards: \n");

        for (Gpu item : this.gpus)
            item.deviceID();
    }

    public void displayGpusByGraphicsRam(){
        System.out.println("Gpus by graphics RAM size: \n");

        gpus.sort(new Comparator<Gpu>() {
            @Override
            public int compare(Gpu gpu1, Gpu gpu2) {
                return gpu1.getGraphicsRam() - gpu2.getGraphicsRam();
            }
        });

        for (Gpu item : gpus) {
            item.deviceID();
        }
    }

    public void displayGamingGraphics(){
        System.out.println("Gaming Graphics Cards: \n");

        for (Gpu item : gpus){
            if (item.getMemoryBus() >= 192) //presupunem ca e de gaming daca indeplineste conditia asta
                item.deviceID();
        }
    }

    public void displayMotherboards() {
        System.out.println("Motherboards: \n");

        for (Motherboard item : this.motherboards)
            item.deviceID();
    }

    public void displayCpus() {
        System.out.println("Cpus: \n");

        for (Cpu item : this.cpus)
            item.deviceID();
    }

    public void displayCpusbyNofCores(){
        System.out.println("Cpus by number of cores: \n");

        cpus.sort(new Comparator<Cpu>() {
            @Override
            public int compare(Cpu cpu1, Cpu cpu2) {
                return cpu1.getNofCores() - cpu2.getNofCores();
            }
        });

        for (Cpu item : cpus) {
            item.deviceID();
        }
    }

    public void displayCpusByGeneration(){
        System.out.println("Cpus by generation: \n");

        cpus.sort(new Comparator<Cpu>() {
            @Override
            public int compare(Cpu cpu1, Cpu cpu2) {
                return cpu1.getGeneration() - cpu2.getGeneration();
            }
        });

        for (Cpu item : cpus) {
            item.deviceID();
        }
    }
}
