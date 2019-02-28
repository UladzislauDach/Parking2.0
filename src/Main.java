import CarData.Colour;
import CarData.GearBox;
import CarData.Model;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Parking parking = new Parking();
    private static int chose = 1;

    public static void main(String[] args) {
        System.out.println("Создана парковка на 30 стояночных мест.");
        System.out.println("1 - заполнение паркинга 40 рандомными авто \n" +
                "2 - вывести список авто находящихся на парковке \n" +
                "3 - удалить рандомный авто с паркинга \n" +
                "4 - добавить рандомный авто на паркинг\n" +
                "5 - количество белых авто\n" +
                "6 - количество авто с автоматом\n" +
                "7 - автомобили с одинаковой маркой и цветом\n" +
                "8 - отсортировать список авто по марке\n" +
                "9 - изменить количество парковочных мест\n" +
                "Для выхода введите любое другое число");

        Scanner sc2 = new Scanner(System.in);
        while (chose > 0 && chose < 10) {
            chose = sc2.nextInt();
            switch (chose) {
                case 1: for (int i = 0; i < 40; i++) { addCar(); }
                    break;
                case 2: parking.printCar();
                    break;
                case 3: deleteAuto();
                    break;
                case 4: addCar();
                     break;
                case 5: numberOfWhiteCar();
                    break;
                case 6: numberOfAutomatCar();
                    break;
                case 7: sameAuto();
                    break;
                case 8:
                    sortListAuto();
                    System.out.println("Список автомобилей отсортирован. Для вывода на экран введите 2");
                    break;
                case 9:
                    System.out.println("Введите число на которое увеличить количество парковочных мест ");
                    Scanner sc = new Scanner(System.in);
                    int a = sc.nextInt();
                    changeNumberPlaces(a);
                    System.out.println("Число парковочных мест: " + parking.getNumberPlaces());
                    break;
                default:
                    System.out.println("До свидания!");
                    break;
            }
        }
    }

    private static void addCar() {
        Random random = new Random();
        Car car = new Car(
                Model.values()[random.nextInt(Model.values().length)],
                GearBox.values()[random.nextInt(GearBox.values().length)],
                Colour.values()[random.nextInt(Colour.values().length)],
                Car.trailers[random.nextInt(Car.trailers.length)],
                Car.weights[random.nextInt(Car.weights.length)]);
        if (filterCar(car)) {
            parking.getCarList().add(car);
            parking.setNumberPlaces(parking.getNumberPlaces() - 1);
            System.out.println(car.toString() + " приехал на стоянку"+
                    " Свободных мест : " + parking.getNumberPlaces());
        } else System.out.println(car.toString() + " не может посетить стоянку (нет мест, с прицепом, большой вес)." +
                " Свободных мест : " + parking.getNumberPlaces());
    }

    private static boolean filterCar(Car car) {
        if (car.isTrailer() || car.getWeight() > 3000 || parking.getNumberPlaces() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void deleteAuto() {
        if (parking.getCarList().size() <= 0) {
            System.out.println("Нет авто на парковке");
        } else {
            Random random = new Random();
            int i = random.nextInt(parking.getCarList().size());
            System.out.println(parking.getCarList().get(i).toString() + " уехал с парковки" +
                    " Свободных мест : " + (parking.getNumberPlaces() +1));
            parking.getCarList().remove(i);
            parking.setNumberPlaces(parking.getNumberPlaces() + 1);
        }
    }

    private static void numberOfWhiteCar() {
        List<Car> carList = parking.getCarList();
        int caunt = 0;
        for (Car car : carList) {
            if (car.getColour() == Colour.WHITE) {
                caunt++;
            }
        }
        System.out.println("Количество белых авто на парковке: " + caunt);
    }

    private static void numberOfAutomatCar() {
        List<Car> carList = parking.getCarList();
        int caunt = 0;
        for (Car car : carList) {
            if (car.getGearBox() == GearBox.AUTOMAT) {
                caunt++;
            }
        }
        System.out.println("Количество авто с автоматической КПП на парковке: " + caunt);
    }

    private static void sameAuto() {
        List<Car> carList = parking.getCarList();
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

    private static void sortListAuto() {
        parking.getCarList().sort(Car::compareTo);
    }

    private static void changeNumberPlaces(int a) {
        parking.setNumberPlaces(parking.getNumberPlaces() + a);
        System.out.println("Количество парковочных мест измененио на " + a + " мест");
    }
}