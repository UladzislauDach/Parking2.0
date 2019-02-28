import CarData.Colour;
import CarData.GearBox;
import CarData.Model;

import java.sql.SQLOutput;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
    addCar();
        }
    }

    public static void addCar() {
        Random random = new Random();
        Car car = new Car(
                Model.values()[random.nextInt(Model.values().length)],
                GearBox.values()[random.nextInt(GearBox.values().length)],
                Colour.values()[random.nextInt(Colour.values().length)],
                Car.trailers[random.nextInt(Car.trailers.length)],
                Car.weights[random.nextInt(Car.weights.length)]);
        if (filterCar(car)) {
            Parking.carList.add(car);
            Parking.numberPlaces--;
            System.out.println(car.toString() + " приехал на стоянку");
        } else System.out.println(car.toString() + " не может посетить стоянку (нет мест, с прицепом, большой вес)");
    }

    public static boolean filterCar(Car car) {
        if (car.isTrailer() || car.getWeight() > 3000 || Parking.numberPlaces <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
