package customer;

import registration.Registration;

import java.util.ArrayList;
import java.util.Comparator;

public class SortCostumer {
    public static void sortCostumerByAll() {
        ArrayList<Costumer> list = Registration.readingCostumerInDatabase();
        Comparator<Costumer> costumerComparator = Comparator.comparing(Costumer::getName)
                .thenComparing(Costumer::getAge).thenComparing(Costumer::getLogin);

        list.stream().sorted(costumerComparator).forEach(System.out::println);
    }
}
