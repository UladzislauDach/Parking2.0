import cars.Car;
import cars.data.Colour;
import cars.data.GearBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Parking {
    private int numberPlaces = 30;
    private List<Car> carList = new ArrayList<>();

    public void printCar() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }

    public void addCar(Car car) {
        if (validationCar(car)) {
            carList.add(car);
            numberPlaces = numberPlaces - 1;
            System.out.println(car.toString() + " приехал на стоянку" +
                    " Свободных мест : " + numberPlaces);
        } else System.out.println(car.toString() + " не может посетить стоянку (нет мест, с прицепом, большой вес)." +
                " Свободных мест : " + numberPlaces);
    }

    private boolean validationCar(Car car) {
        return !car.isTrailer() && car.getWeight() <= 3000 && numberPlaces > 0;
    }

    public  void deleteAuto() {
        if (carList.size() <= 0) {
            System.out.println("Нет авто на парковке");
        } else {
            Random random = new Random();
            int i = random.nextInt(carList.size());
            Car car = carList.get(i);
            carList.remove(car);
            numberPlaces = numberPlaces + 1;
            System.out.println(car.toString() + " уехал с парковки" +
                    " Свободных мест : " + (numberPlaces));

        }
    }

    public  void numberOfWhiteCar() {
        int count = 0;
        for (Car car : carList) {
            if (car.getColour() == Colour.WHITE) {
                count++;
            }
        }
        System.out.println("Количество белых авто на парковке: " + count);
    }

    public  void numberOfAutomatCar() {
        int count = 0;
        for (Car car : carList) {
            if (car.getGearBox() == GearBox.AUTOMAT) {
                count++;
            }
        }
        System.out.println("Количество авто с автоматической КПП на парковке: " + count);
    }

    public  void sameAuto() {
        for (Car car : carList) {
            int count = 0;
            for (Car car1 : carList) {
                if (car.getModel() == car1.getModel() && car.getColour() == car1.getColour()) {
                    count++;
                }
            }
            if (count > 1)
                System.out.println("Авто " + car.toString() + " имеет похожй авто");
        }
    }

    public  void sortListAuto() {
        carList.sort(Car::compareTo);
    }

    public  void changeNumberPlaces(int a) {
        numberPlaces = numberPlaces + a;
        System.out.println("Количество парковочных мест увеличено на " + a + " мест \n" +
                "Свободных мест : " + numberPlaces);
    }
}
