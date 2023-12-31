package com.walking.lesson49_optional.task3;

import com.walking.lesson49_optional.task3.model.Animal;
import com.walking.lesson49_optional.task3.model.Cat;
import com.walking.lesson49_optional.task3.model.Cow;
import com.walking.lesson49_optional.task3.model.Dog;

import java.util.AbstractMap;
import java.util.Optional;

/**
 * Реализуйте абстрактный класс «Животное», содержащий абстрактный метод sound().
 * Также реализуйте трех наследников: кота, собаку и корову.
 * <p>
 * Реализуйте метод, выводящий в консоль сообщение вида
 * <p>
 * «Это %тип животного%, он (она) говорит %результат метода sound()%»
 * Использование условных конструкций (if-else, switch-case, тернарный оператор)
 * и хранение типа наследника в виде поля недопустимо.
 * <p>
 * Подсказка: используйте or().
 */
public class Main {
    public static void main(String[] args) {
        getAnimalInfo(new Cat());
        getAnimalInfo(new Dog());
        getAnimalInfo(new Cow());
        getAnimalInfo(null);
    }

    private static void getAnimalInfo(Animal animal) {
        Optional.ofNullable(animal)
                .filter(a -> Cat.class.equals(a.getClass()))
                .map(a -> new AbstractMap.SimpleEntry<>("Cat", a))
                .or(() -> Optional.ofNullable(animal)
                        .filter(a -> Dog.class.equals(a.getClass()))
                        .map(a -> new AbstractMap.SimpleEntry<>("Dog", a)))
                .or(() -> Optional.ofNullable(animal)
                        .filter(a -> Cow.class.equals(a.getClass()))
                        .map(a -> new AbstractMap.SimpleEntry<>("Cow", a)))
                .ifPresentOrElse(entry ->
                        System.out.printf("This is %s. It says '%s'\n", entry.getKey(), entry.getValue().sound()),
//                        Больше для демонстрации. Мы не можем использовать throw,
//                        если пишем лямбду в одно строку (без {}). Зато используя {} - можем
                        () -> {
                            throw new RuntimeException("Unknown animal or null");
                        });
    }
}
