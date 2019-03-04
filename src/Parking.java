import CarData.Colour;
import CarData.GearBox;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Parking {
    private int numberPlaces = 30;
    private List<Car> carList = new ArrayList<>();

    void printCar() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }

    void addCar(Car car) {
        if (filterCar(car)) {
            carList.add(car);
            numberPlaces = numberPlaces - 1;
            System.out.println(car.toString() + " приехал на стоянку" +
                    " Свободных мест : " + numberPlaces);
        } else System.out.println(car.toString() + " не может посетить стоянку (нет мест, с прицепом, большой вес)." +
                " Свободных мест : " + numberPlaces);
    }

    private boolean filterCar(Car car) {
        return !car.isTrailer() && car.getWeight() <= 3000 && numberPlaces > 0;
    }

    void deleteAuto() {
        if (carList.size() <= 0) {
            System.out.println("Нет авто на парковке");
        } else {
            Random random = new Random();
            int i = random.nextInt(carList.size());
            System.out.println(carList.get(i).toString() + " уехал с парковки" +
                    " Свободных мест : " + (numberPlaces + 1));
            carList.remove(i);
            numberPlaces = numberPlaces + 1;
        }
    }

    void numberOfWhiteCar() {
        int caunt = 0;
        for (Car car : carList) {
            if (car.getColour() == Colour.WHITE) {
                caunt++;
            }
        }
        System.out.println("Количество белых авто на парковке: " + caunt);
    }

    void numberOfAutomatCar() {
        int caunt = 0;
        for (Car car : carList) {
            if (car.getGearBox() == GearBox.AUTOMAT) {
                caunt++;
            }
        }
        System.out.println("Количество авто с автоматической КПП на парковке: " + caunt);
    }

    void sameAuto() {
        for (Car car : carList) {
            int caunt = 0;
            for (Car car1 : carList) {
                if (car.getModel() == car1.getModel() && car.getColour() == car1.getColour()) {
                    caunt++;
                }
            }
            if (caunt > 1)
                System.out.println("Авто " + car.toString() + " имеет похожй авто");
        }
    }

    void sortListAuto() {
        carList.sort(Car::compareTo);
    }

    void changeNumberPlaces(int a) {
        numberPlaces = numberPlaces + a;
        System.out.println("Количество парковочных мест увеличено на " + a + " мест \n" +
                "Свободных мест : " + numberPlaces);
    }
}
