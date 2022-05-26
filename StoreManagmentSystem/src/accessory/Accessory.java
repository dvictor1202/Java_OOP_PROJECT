package accessory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Accessory{
    private List <Keyboard> keyboards;
    private List <Mouse> mice;

    public Accessory() {
        this.keyboards = new ArrayList<Keyboard>();
        this.mice = new ArrayList<Mouse>();
    }

    public List<Keyboard> getKeyboards() {
        return keyboards;
    }

    public List<Mouse> getMice() {
        return mice;
    }

    protected void wearableID() {}

    public void setKeyboards(List<Keyboard> keyboards) {
        this.keyboards = keyboards;
    }

    public void setMice(List<Mouse> mice) {
        this.mice = mice;
    }

    public void addKeyboard(Keyboard keyboard) {
        keyboards.add(keyboard);
    }

    public void addMouse(Mouse mouse) {
        mice.add(mouse);
    }

    public void displayKeyboards(){
        System.out.println("Keyboards: \n");

        for (Keyboard item : keyboards){
            item.wearableID();
        }
    }

    public void displayMice(){
        System.out.println("Mice: \n");

        for (Mouse item : mice){
            item.wearableID();
        }
    }

    public void displayMiceByWeight(){
        System.out.println("Mice by weight: \n");

        mice.sort(new Comparator<Mouse>() {
            @Override
            public int compare(Mouse smartWatch, Mouse t1) {
                return smartWatch.getWeight() - t1.getWeight();
            }
        });

        for (Mouse item : mice){
            item.wearableID();
        }
    }
}