package customer;

import product.ProductDatabase;
import registration.Registration;

import java.util.Scanner;

public class CostumerInterface {
    public static void interfaceForCostumer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - вход");
        System.out.println("2 - регистрация");
        int in = scanner.nextByte();
        if (in == 1) {
            System.out.println("Добро пожвловать");
            System.out.println("1 - Просмотреть список товара");
            System.out.println("2 - Купить товар");
            System.out.println("3 - Получить бонусную карту");
            System.out.println("0 - Выход");
            int numberInMenu = scanner.nextInt();
            if (numberInMenu == 1) ProductDatabase.getProductOfDatabase();
            else if (numberInMenu == 2) System.out.println("покупка товара");
            else if (numberInMenu == 3) System.out.println("получить бонусную карту");
            else if (numberInMenu == 0) System.out.println("выход");
            else System.err.println("Пункта " + numberInMenu + " не сущест");
        } else if (in == 2) {
            System.out.println("Меню регистрации");
            Registration.registrationCostumer();
        }
    }
}
