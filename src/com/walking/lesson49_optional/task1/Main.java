package com.walking.lesson49_optional.task1;

import com.walking.lesson49_optional.task1.model.Car;
import com.walking.lesson49_optional.task1.model.CarIdentifier;
import com.walking.lesson49_optional.task1.service.CarService;

import java.util.Scanner;

/**
 * Реализуйте задачу 2 урока 43:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson43_map/task2">...</a>
 * тип возвращаемого значения в методе поиска должен быть Optional<Car>.
 * Если ничего не найдено – верните Optional.empty().
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());
        CarIdentifier desiredCarIdentifier = createCar();

        carService.findCar(desiredCarIdentifier)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Car not found"));

//        В зависимости от глубины любви к функциональному стилю, можно найти разные варианты решения задачи.
//        От варианта выше до:
//        Optional.of(new CarService(initCars()))
//                .flatMap(service -> Optional.of(createCar())
//                        .flatMap(service::findCar))
//                .ifPresentOrElse(
//                        System.out::println,
//                        () -> System.out.println("Car not found"));
    }

    private static CarIdentifier createCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's number");
        String number = scanner.nextLine();

        System.out.println("Enter a car's year");
        int year = scanner.nextInt();

        scanner.close();

        return new CarIdentifier(number, year);
    }

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
