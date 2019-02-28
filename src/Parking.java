
import java.util.ArrayList;
import java.util.List;

class Parking {
    private int numberPlaces = 30;
    private List<Car> carList = new ArrayList<>();


    int getNumberPlaces() {
        return numberPlaces;
    }

    void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }

    List<Car> getCarList() {
        return carList;
    }


    void printCar() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }


}
