package employee;

import product.ProductDatabase;
import servis.Constants;
import java.util.Scanner;

public class EmployeeInterface {
    public static void getMenuForEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Интерфейс работника магазина");
        System.out.println("1 - посмотреть доступный товар");
        System.out.println("2 - выставить товар по цене");
        System.out.println("3 - убрать товар с витрины");
        System.out.println("4 - посмотреть имена клиентов");
        System.out.println("5 - выдать бонусную карту");
        System.out.println("0 - выйти");
        System.out.print(Constants.ENTER);
        int inChekMenu = scanner.nextInt();
        if (inChekMenu == 1) ProductDatabase.getProductOfDatabase();
        if (inChekMenu == 2) ProductDatabase.sortProductByPrice();

    }
}
