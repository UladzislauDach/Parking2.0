import cars.*;
import cars.data.Colour;
import cars.data.GearBox;
import cars.data.Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                "10 - загрузить список авто из файла\n" +
                "Для выхода введите любое другое число");

        Scanner sc2 = new Scanner(System.in);
        while (chose > 0 && chose < 11) {
            chose = sc2.nextInt();
            switch (chose) {
                case 1:
                    for (int i = 0; i < 40; i++) {
                        parking.addCar(generateCar());
                    }
                    break;
                case 2:
                    parking.printCar();
                    break;
                case 3:
                    parking.deleteAuto();
                    break;
                case 4:
                    parking.addCar(generateCar());
                    break;
                case 5:
                    parking.numberOfWhiteCar();
                    break;
                case 6:
                    parking.numberOfAutomatCar();
                    break;
                case 7:
                    parking.sameAuto();
                    break;
                case 8:
                    parking.sortListAuto();
                    System.out.println("Список автомобилей отсортирован. Для вывода на экран введите 2");
                    break;
                case 9:
                    System.out.println("Введите число на которое увеличить количество парковочных мест ");
                    Scanner sc = new Scanner(System.in);
                    int a = sc.nextInt();
                    parking.changeNumberPlaces(a);
                    break;
                case 10:
                    parking.addCar(getCarsWithFile("cars.txt"));

                    break;
                default:
                    System.out.println("До свидания!");
                    break;
            }
        }
    }

    private static Car generateCar() {
        final boolean[] trailers = {true, false, false, false, false};
        final int[] weights = {2300, 2500, 2800, 2900, 3500};
        Random random = new Random();
        return new Car(
                Model.values()[random.nextInt(Model.values().length)],
                GearBox.values()[random.nextInt(GearBox.values().length)],
                Colour.values()[random.nextInt(Colour.values().length)],
                trailers[random.nextInt(trailers.length)],
                weights[random.nextInt(weights.length)]);
    }

    private static ArrayList<Car> getCarsWithFile(String fileName) {
        ArrayList<Car> carList = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String dataOfOneCar = sc.nextLine();
                Pattern pattern = Pattern.compile(";");
                String[] carInfo = pattern.split(dataOfOneCar);
                carList.add(new Car(Model.valueOf(carInfo[0]), GearBox.valueOf(carInfo[1]), Colour.valueOf(carInfo[2]),
                        Boolean.valueOf(carInfo[3]), Integer.valueOf(carInfo[4])));
            }
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println("файл не существует / некорректные данные");
        }
        return carList;
    }
}