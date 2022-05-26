package services;

import part.*;
import accessory.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static CSVReader CSVReader_instance = null;

    public static CSVReader getInstance() {
        if (CSVReader_instance == null)
            CSVReader_instance = new CSVReader();

        return CSVReader_instance;
    }

    public List<Gpu> read_gpu() {
        List<Gpu> gpus = new ArrayList<Gpu>();

        try {
            RandomAccessFile gpuStock = new RandomAccessFile("src/files/gpus.csv", "r");
            String gpusInStock;

            while ((gpusInStock = gpuStock.readLine()) != null){
                String[] data = gpusInStock.split(", ");
                Gpu gpu = new Gpu(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                gpus.add(gpu);
            }
            gpuStock.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return gpus;
    }

    public List<Motherboard> read_motherboard() {
        List<Motherboard> motherboards = new ArrayList<Motherboard>();

        try{
            RandomAccessFile motherboardStock = new RandomAccessFile("src/files/motherboards.csv", "r");
            String motherboardsInStock;

            while ((motherboardsInStock = motherboardStock.readLine()) != null){
                String[] data = motherboardsInStock.split(", ");
                Motherboard motherboard = new Motherboard(data[0], data[1], data[2]);
                motherboards.add(motherboard);
            }
            motherboardStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return motherboards;
    }

    public List<Cpu> read_cpu() {
        List<Cpu> cpus = new ArrayList<Cpu>();

        try {
            RandomAccessFile cpuStock = new RandomAccessFile("src/files/cpus.csv", "r");
            String cpusInStock;

            while ((cpusInStock = cpuStock.readLine()) != null) {
                String[] data = cpusInStock.split(", ");
                Cpu cpu = new Cpu(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                cpus.add(cpu);
            }
            cpuStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return cpus;
    }

    public List<Keyboard> read_keyboard() {
        List<Keyboard> keyboards = new ArrayList<Keyboard>();

        try {
            RandomAccessFile keyboardStock = new RandomAccessFile("src/files/keyboards.csv", "r");
            String keyboardsInStock;

            while ((keyboardsInStock = keyboardStock.readLine()) != null){
                String[] data = keyboardsInStock.split(", ");
                Keyboard keyboard = new Keyboard(data[0], data[1], Integer.parseInt(data[2]));
                keyboards.add(keyboard);
            }
            keyboardStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return keyboards;
    }

    public List<Mouse> read_mouse() {
        List<Mouse> mice = new ArrayList<Mouse>();

        try {
            RandomAccessFile mouseStock = new RandomAccessFile("src/files/mice.csv", "r");
            String miceInStock;

            while ((miceInStock = mouseStock.readLine()) != null){
                String[] data = miceInStock.split(", ");
                Mouse mouse = new Mouse(data[0], data[1], Integer.parseInt(data[2]));
                mice.add(mouse);
            }
            mouseStock.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        return mice;
    }
}