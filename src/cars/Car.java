package cars;

import cars.data.Colour;
import cars.data.GearBox;
import cars.data.Model;

public class Car implements Comparable<Car> {
    private Model model;
    private GearBox gearBox;
    private Colour colour;
    private boolean trailer;
    private int weight;

    public Car(Model model, GearBox gearBox, Colour colour, boolean trailer, int weight) {
        this.model = model;
        this.gearBox = gearBox;
        this.colour = colour;
        this.trailer = trailer;
        this.weight = weight;
    }


     public Model getModel() {
        return model;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public Colour getColour() {
        return colour;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isTrailer() {
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