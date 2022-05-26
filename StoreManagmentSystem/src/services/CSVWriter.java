package services;

import part.*;
import accessory.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private static CSVWriter CSVWriter_instance = null;

    public static CSVWriter getInstance() {
        if (CSVWriter_instance == null)
            CSVWriter_instance = new CSVWriter();

        return CSVWriter_instance;
    }

    public void write_gpu(List<Gpu> gpus) {
        try {
            File inGpu = new File("src/files/gpus.csv");
            inGpu.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/gpus.csv");

            for (Gpu item : gpus)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getGraphicsRam() + ", " + item.getMemoryBus() + "\n");

            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_motherboard (List<Motherboard> motherboards) {
        try {
            File inMotherboard = new File("src/files/motherboards.csv");
            inMotherboard.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/motherboards.csv");

            for (Motherboard item : motherboards)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getSocketCpu() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_cpu(List<Cpu> cpus) {
        try {
            File inCpu = new File("src/files/cpus.csv");
            inCpu.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/cpus.csv");

            for (Cpu item : cpus)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getNofCores() + ", " + item.getGeneration() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_keyboard (List<Keyboard> keyboards) {
        try {
            File inMotherboard = new File("src/files/keyboards.csv");
            inMotherboard.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/keyboards.csv");

            for (Keyboard item : keyboards)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getGaming() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void write_mouse (List<Mouse> mice) {
        try {
            File inMouse = new File("src/files/mice.csv");
            inMouse.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/files/mice.csv");

            for (Mouse item : mice)
                fileWriter.write(item.getManufacturer() + ", " + item.getModel() + ", " + item.getWeight() + "\n");

            fileWriter.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}