import CarData.Colour;
import CarData.GearBox;
import CarData.Model;

public class Car implements Comparable<Car> {
    static boolean trailers[] = {true, false, false, false, false};
    static int weights[] = {2300, 2500, 2800, 2900, 3500};

    private Model model;
    private GearBox gearBox;
    private Colour colour;
    private boolean trailer;
    private int weight;

     Car(Model model, GearBox gearBox, Colour colour, boolean trailer, int weight) {
        this.model = model;
        this.gearBox = gearBox;
        this.colour = colour;
        this.trailer = trailer;
        this.weight = weight;
    }


    Model getModel() {
        return model;
    }

    GearBox getGearBox() {
        return gearBox;
    }

    Colour getColour() {
        return colour;
    }

    int getWeight() {
        return weight;
    }

    boolean isTrailer() {
        return trailer;
    }

    @Override
    public String toString() {
        return "Авто " + model +
                ", КПП " + gearBox +
                ", цвет " + colour +
                ", прицеп " + trailer +
                ", вес " + weight;
    }

    @Override
    public int compareTo(Car car) {
        return this.model.toString().compareTo(car.model.toString());
    }
}