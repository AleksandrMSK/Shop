package employee;

import customer.SearchCostumer;
import product.ProductDatabase;
import servis.Constants;

import java.util.Scanner;

public class EmployeeInterface {
    static Scanner scanner = new Scanner(System.in);

    public static void getMenuForEmployee() {
        boolean flagForChekInWhile = true;
        while (flagForChekInWhile) {
            System.out.println("");
            System.out.println("Интерфейс работника магазина");
            System.out.println("1 - посмотреть доступный товар");
            System.out.println("2 - выставить товар по цене");
            System.out.println("3 - убрать товар с витрины");
            System.out.println("4 - вывести данные о клиенте");
            System.out.println("5 - начислить бонусы");
            System.out.println("0 - выйти");
            System.out.print(Constants.ENTER);
            int inChekMenu = scanner.nextInt();
            if (inChekMenu == 1) {
                ProductDatabase.getProductOfDatabase();
            }
            if (inChekMenu == 2) {
                ProductDatabase.sortProductByName();
            }
            if (inChekMenu == 3) {
                System.out.println("убрать товар");
            }
            if (inChekMenu == 4) {
                Scanner input = new Scanner(System.in);
                System.out.println("Поиск клиента по логину");
                System.out.print(Constants.ENTER);
                String name = input.nextLine();
                System.err.println(SearchCostumer.searchByLogin(name));
            }
            if (inChekMenu == 5) {
                System.out.println("Выдать бонусную карту");
            }
            if (inChekMenu == 0) {
                flagForChekInWhile = false;
            }
        }
    }
}
