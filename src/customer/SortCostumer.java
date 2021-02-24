package customer;

import registration.Registration;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Класс сортировка
 * сортировка по нескольким параметрам имя/возраст/логин
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class SortCostumer {
    public static void sortCostumerByAll() {
        ArrayList<Costumer> list = Registration.readingCostumerInDatabase();
        Comparator<Costumer> costumerComparator = Comparator.comparing(Costumer::getName)
                .thenComparing(Costumer::getAge).thenComparing(Costumer::getLogin);
        list.stream().sorted(costumerComparator).forEach(System.out::println);
    }
}
