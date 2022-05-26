import part.*;
import accessory.*;
import services.CSVWriter;
import services.*;
import services.CSVReader;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Store store = new Store();
        Audit audit = new Audit();
        CSVReader CSVReader = new CSVReader();

        List<Gpu> auxGpu = CSVReader.read_gpu();
        if (auxGpu.size() > 0)
            for (Gpu item : auxGpu) {
                store.part.addGpu(item);
            }
        auxGpu.clear();

        List<Motherboard> auxMotherboard = CSVReader.read_motherboard();
        if (auxMotherboard.size() > 0)
            for (Motherboard item : auxMotherboard) {
                store.part.addMotherboard(item);
            }
        auxMotherboard.clear();

        List<Cpu> auxCpu = CSVReader.read_cpu();
        if (auxCpu.size() > 0)
            for (Cpu item : auxCpu) {
                store.part.addCpu(item);
            }
        auxCpu.clear();


        List<Keyboard> auxKeyboard = CSVReader.read_keyboard();
        if (auxKeyboard.size() > 0)
            for (Keyboard item : auxKeyboard) {
                store.accessory.addKeyboard(item);
            }
        auxKeyboard.clear();

        List<Mouse> auxMouse = CSVReader.read_mouse();
        if (auxMouse.size() > 0)
            for (Mouse item : auxMouse) {
                store.accessory.addMouse(item);
            }
        auxMouse.clear();

        System.out.println("Welcome!\n");
        audit.write("Session Started");

        Scanner in = new Scanner(System.in);
        boolean input = true;

        showMenu();

        do {
            System.out.print("Enter your choice: ");
            String choice = in.nextLine();
            System.out.println();

            switch (choice.trim()){
                case "1":
                    store.part.displayGpus();
                    audit.write("Gpus Displayed");
                    break;
                case "2":
                    store.part.displayGpusByGraphicsRam();
                    audit.write("Gpus By Graphics RAM size:");
                    break;
                case "3":
                    store.part.displayGamingGraphics();
                    audit.write("Gaming Gpus:");
                    break;
                case "4":
                    store.part.displayMotherboards();
                    audit.write("Motherboards Displayed");
                    break;
                case "5":
                    store.part.displayCpus();
                    audit.write("Cpus Displayed");
                    break;
                case "6":
                    store.part.displayCpusbyNofCores();
                    audit.write("Cpus By Number of Cores Displayed");
                    break;
                case "7":
                    store.part.displayCpusByGeneration();
                    audit.write("Cpus By Generation Displayed:");
                    break;
                case "8":
                    store.accessory.displayKeyboards();
                    audit.write("Smart Bands Displayed");
                    break;
                case "9":
                    store.accessory.displayMice();
                    audit.write("Mice Displayed");
                    break;
                case "10":
                    store.accessory.displayMiceByWeight();
                    audit.write("Mice By Weight(g) Displayed");
                    break;
                case "11":
                    store.newPart();
                    showMenu();
                    break;
                case "12":
                    store.newAccessory();
                    showMenu();
                    break;
                case "13":
                    store.removePart();
                    showMenu();
                    break;
                case "14":
                    store.removeAccessory();
                    showMenu();
                    break;
                case "Q":
                    System.out.println("Have a nice day!");
                    audit.write("Session Ended");
                    input = false;

                    CSVWriter CSVWriter = new CSVWriter();
                    CSVWriter.write_gpu(store.part.getGpus());
                    CSVWriter.write_cpu(store.part.getCpus());
                    CSVWriter.write_motherboard(store.part.getMotherboards());
                    CSVWriter.write_keyboard(store.accessory.getKeyboards());
                    CSVWriter.write_mouse(store.accessory.getMice());

                    break;
                case "Menu":
                    showMenu();
                    break;
                default:
                    System.out.println("Error! Invalid input.");
                    break;
            }
        }while (input);
        

    }

    public static void showMenu() {
        System.out.print("Pick an action: ");
        System.out.println();
        System.out.println("1. Display all gpus.");
        System.out.println("2. Display all gpus by graphics RAM size.");
        System.out.println("3. Display gaming gpus.");
        System.out.println("4. Display all motherboards.");
        System.out.println("5. Display all cpus.");
        System.out.println("6. Display all cpus by number of cores.");
        System.out.println("7. Display all cpus by generation.");
        System.out.println("8. Display all keyboards.");
        System.out.println("9. Display all mice.");
        System.out.println("10. Display all mice by weight.");
        System.out.println("11. Add a part.");
        System.out.println("12. Add a accessory.");
        System.out.println("13. Remove a part.");
        System.out.println("14. Remove an accessory.");
        System.out.println();
        System.out.println("To see the menu again type 'Menu'.");
        System.out.println("To exit the menu type 'Q'.");
        System.out.println();
    }
}