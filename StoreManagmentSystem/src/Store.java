import part.*;
import accessory.*;
import services.Audit;
import services.CSVWriter;

import java.util.List;
import java.util.Scanner;

public class Store {
    private static Store single = null;

    public static Store getInstance() {
        if (single == null)
            single = new Store();

        return single;
    }

    public Part part;
    public Accessory accessory;

    Audit audit = new Audit();

    Store() {
        this.part = new Part();
        this.accessory = new Accessory();
    }

    public void newPart() {
        Scanner inPart = new Scanner(System.in);
        System.out.println("Hello! To add a new part follow these instructions:");
        System.out.println("Choose what part you want to add.");
        System.out.println();

        boolean input = true;
        displayAddPartMenu();
        do {
            System.out.print("Enter your choice: ");
            String choice = inPart.nextLine();

            switch (choice.trim()){
                case "1":
                    userAddGpu();
                    audit.write("Gpu Added");
                    break;
                case "2":
                    userAddMotherboard();
                    audit.write("Motherboard Added");
                    break;
                case "3":
                    userAddCpu();
                    audit.write("Cpu Added");
                    break;
                case "S":
                    displayAddPartMenu();
                    break;
                case "B":
                    System.out.println("You will be taken to the main menu.");
                    input = false;
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    public static void displayAddPartMenu(){
        System.out.println("1. Add a gpu");
        System.out.println("2. Add a motherboard");
        System.out.println("3. Add a cpu");
        System.out.println();
        System.out.println("To show the submenu again type'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    public void newAccessory() {
        Scanner inAccessory = new Scanner(System.in);
        System.out.println("Hello! To add a new accessory follow these instructions:");
        System.out.println("Choose what accessory you want to add.");

        boolean input = true;
        displayAddAccessoryMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = inAccessory.nextLine();

            switch (choice.trim()){
                case "1":
                    userAddKeyboard();
                    audit.write("Keyboard Added");
                    break;
                case "2":
                    addMouse();
                    audit.write("Mouse Added");
                    break;
                case "S":
                    displayAddAccessoryMenu();
                    break;
                case "B":
                    System.out.println("You will be taken to the main menu.");
                    input = false;
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    public static void displayAddAccessoryMenu(){
        System.out.println("1. Add a keyboard");
        System.out.println("2. Add a mouse");
        System.out.println();
        System.out.println("To show the submenu again type 'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    public void removePart() {
        Scanner inPart = new Scanner(System.in);
        System.out.println("Hello! To remove a part follow these instructions:");
        System.out.println("Choose what part you want to remove.");
        System.out.println();

        Audit audit = new Audit();

        boolean input = true;
        displayRemovePartMenu();
        do {
            System.out.print("Enter your choice: ");
            String choice = inPart.nextLine();

            switch (choice.trim()){
                case "1":
                    removeGpu();
                    audit.write("Gpu Removed");
                    break;
                case "2":
                    removeMotherboard();
                    audit.write("Motherboard Removed");
                    break;
                case "3":
                    removeCpu();
                    audit.write("Cpu Removed");
                    break;
                case "S":
                    displayRemovePartMenu();
                    break;
                case "B":
                    System.out.println("You will be taken to the main menu.");
                    input = false;
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    public static void displayRemovePartMenu(){
        System.out.println("1. Remove a gpu");
        System.out.println("2. Remove a motherboard");
        System.out.println("3. Remove a cpu");
        System.out.println();
        System.out.println("To show the submenu again type'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }

    public void removeAccessory() {
        Scanner inAccessory = new Scanner(System.in);
        System.out.println("Hello! To remove an accessory follow these instructions:");
        System.out.println("Choose what accessory you want to remove.");

        boolean input = true;
        displayRemoveAccessoryMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = inAccessory.nextLine();

            switch (choice.trim()){
                case "1":
                    removeKeyboard();
                    audit.write("Keyboard Removed");
                    displayRemoveAccessoryMenu();
                    break;
                case "2":
                    removeMouse();
                    audit.write("Mouse Removed");
                    displayRemoveAccessoryMenu();
                    break;
                case "S":
                    displayRemoveAccessoryMenu();
                    break;
                case "B":
                    System.out.println("You will be taken to the main menu.");
                    input = false;
                    break;
                default:
                    System.out.println("Error! Invalid input.");
            }
        }while (input);
    }

    public static void displayRemoveAccessoryMenu(){
        System.out.println("1. Remove a keyboard");
        System.out.println("2. Remove a mouse");
        System.out.println();
        System.out.println("To show the submenu again type 'S'.");
        System.out.println("To go to the main menu type 'B'.");
        System.out.println();
    }


    public Gpu userAddGpu() {
        Scanner inGpu = new Scanner(System.in);
        System.out.println("Hello! To add a new gpu please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inGpu.nextLine();

        System.out.print("Model: ");
        String model = inGpu.nextLine();

        List<Gpu> gpus = part.getGpus();
        for (Gpu item : gpus) {
            if (item.getModel().equals(model)) {
                System.out.println("This gpu is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inGpu.nextLine();
            }
        }

        System.out.print("Graphics Ram Size (GB): ");
        int graphicsRam = inGpu.nextInt();

        System.out.println("Memory Bus Width(bits): ");
        int memoryBusWidth = inGpu.nextInt();

        Gpu gpu = new Gpu(manufacturer, model, graphicsRam, memoryBusWidth);
        part.addGpu(gpu);

        CSVWriter addItem = new CSVWriter();
        addItem.write_gpu(part.getGpus());

        System.out.println("The gpu was added.");

        return gpu;
    }

    public void userAddMotherboard() {
        Scanner inMotherboard = new Scanner(System.in);
        System.out.println("Hello! To add a new motherboard please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inMotherboard.nextLine();

        System.out.print("Model: ");
        String model = inMotherboard.nextLine();

        System.out.print("Cpu Socket type: ");
        String SocketCpu = inMotherboard.nextLine();

        List<Motherboard> motherboards = part.getMotherboards();
        for (Motherboard item : motherboards) {
            if (item.getSocketCpu().equals(SocketCpu)) {
                System.out.println("This motherboard is already in store. Please enter a different socket type.");
                System.out.print("Cpu Socket Type: ");
                SocketCpu = inMotherboard.nextLine();
            }
        }

        Motherboard motherboard = new Motherboard(manufacturer, model, SocketCpu);
        part.addMotherboard(motherboard);

        CSVWriter addItem = new CSVWriter();
        addItem.write_motherboard(part.getMotherboards());

        System.out.println("The motherboard was added.");

    }

    public Cpu userAddCpu() {
        Scanner inCpu = new Scanner(System.in);
        System.out.println("Hello! To add a new cpu please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inCpu.nextLine();

        System.out.print("Model: ");
        String model = inCpu.nextLine();

        List<Cpu> cpus = part.getCpus();
        for (Cpu item : cpus) {
            if (item.getModel().equals(model)) {
                System.out.println("This cpu is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inCpu.nextLine();
            }
        }

        System.out.print("Number of Cores: ");
        int nofCores = inCpu.nextInt();

        System.out.print("Generation: ");
        int generation = inCpu.nextInt();

        Cpu cpu = new Cpu(manufacturer, model, nofCores, generation);
        part.addCpu(cpu);

        CSVWriter addItem = new CSVWriter();
        addItem.write_cpu(part.getCpus());

        System.out.println("The gpu was added.");

        return cpu;
    }



    public Keyboard userAddKeyboard() {
        Scanner inKeyboard = new Scanner(System.in);
        System.out.println("Hello! To add a new keyboard please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inKeyboard.nextLine();

        System.out.print("Model: ");
        String model = inKeyboard.nextLine();

        List<Keyboard> keyboards = accessory.getKeyboards();
        for (Keyboard item : keyboards) {
            if (item.getModel().equals(model)) {
                System.out.println("This keyboard is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inKeyboard.nextLine();
            }
        }

        System.out.println("Is it for gaming? Type '1' if it is, or '0' otherwise.");
        int gaming = inKeyboard.nextInt();

        Keyboard keyboard = new Keyboard(manufacturer, model, gaming);
        accessory.addKeyboard(keyboard);

        CSVWriter addItem = new CSVWriter();
        addItem.write_keyboard(accessory.getKeyboards());

        System.out.println("The keyboard was added.");

        return keyboard;
    }

    public Mouse addMouse() {
        Scanner inMouse = new Scanner(System.in);
        System.out.println("Hello! To add a new mouse please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inMouse.nextLine();

        System.out.print("Model: ");
        String model = inMouse.nextLine();

        List<Mouse> mice = accessory.getMice();
        for (Mouse item : mice) {
            if (item.getModel().equals(model)) {
                System.out.println("This mouse is already in store. Please enter a different model.");
                System.out.print("Model: ");
                model = inMouse.nextLine();
            }
        }

        System.out.print("Weight of mouse(in grams):");
        int weight = inMouse.nextInt();

        Mouse mouse = new Mouse(manufacturer, model, weight);
        accessory.addMouse(mouse);

        CSVWriter addItem = new CSVWriter();
        addItem.write_mouse(accessory.getMice());

        System.out.println("The mouse was added.");

        return mouse;
    }

    private void removeGpu() {
        Scanner inGpu = new Scanner(System.in);
        System.out.println("Hello! To remove a gpu please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inGpu.nextLine();

        System.out.print("Model: ");
        String model = inGpu.nextLine();

        List<Gpu> Gpus = part.getGpus();
        Gpus.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_gpu(part.getGpus());

        System.out.println("The Gpu was removed.");
    }

    private void removeMotherboard() {
        Scanner inMotherboard = new Scanner(System.in);
        System.out.println("Hello! To remove a motherboard please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inMotherboard.nextLine();

        System.out.print("Model: ");
        String model = inMotherboard.nextLine();

        List<Motherboard> motherboards = part.getMotherboards();
        motherboards.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_motherboard(part.getMotherboards());

        System.out.println("The motherboard was removed.");
    }

    private void removeCpu() {
        Scanner inCpu = new Scanner(System.in);
        System.out.println("Hello! To remove a cpu please enter the following:");

        System.out.print("Manufacturer: ");
        String manufacturer = inCpu.nextLine();

        System.out.print("Model: ");
        String model = inCpu.nextLine();

        List<Cpu> cpus = part.getCpus();
        cpus.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_cpu(part.getCpus());

        System.out.println("The cpu was removed.");
    }



    private void removeKeyboard() {
        Scanner inKeyboard = new Scanner(System.in);
        System.out.println("Hello! To remove a keyboard please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inKeyboard.nextLine();

        System.out.print("Model: ");
        String model = inKeyboard.nextLine();

        List<Keyboard> keyboards = accessory.getKeyboards();
        keyboards.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_keyboard(accessory.getKeyboards());

        System.out.println("The keyboard was removed.");
    }

    private void removeMouse() {
        Scanner inMouse = new Scanner(System.in);
        System.out.println("Hello! To remove a mouse please enter the following:");

        System.out.print("Manufacturer:");
        String manufacturer = inMouse.nextLine();

        System.out.print("Model: ");
        String model = inMouse.nextLine();

        List<Mouse> mice = accessory.getMice();
        mice.removeIf(item -> (item.getManufacturer().equals(manufacturer)) && (item.getModel().equals(model)));

        CSVWriter addItem = new CSVWriter();
        addItem.write_mouse(accessory.getMice());

        System.out.println("The mouse was removed.");
    }
}
