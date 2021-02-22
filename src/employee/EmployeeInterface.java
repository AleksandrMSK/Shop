package employee;

import customer.SearchCostumer;
import product.ProductDatabase;
import servis.Constants;

import java.io.Serializable;
import java.util.Scanner;

public class EmployeeInterface implements Serializable {
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
                System.out.println("Склад товара");
                ProductDatabase.getProductOfDatabase();
            }
            if (inChekMenu == 2) {
                System.out.println("Товар отсортирован по цене");
                ProductDatabase.sortProductByName();
            }
            if (inChekMenu == 3) {
                System.out.println("убрать товар");
            }
            if (inChekMenu == 4) {
                Scanner input = new Scanner(System.in);
                System.out.println("Поиск клиента по логину");
                System.out.print(Constants.ENTER);
                System.err.println(SearchCostumer.searchByLogin(input.nextLine()));
                System.out.println("");
            }
            if (inChekMenu == 5) {
                int numberBonusCart = 0;
                int countBonus = 0;
                System.out.print("Введите номер бонусной карты: " + scanner.nextInt());
                System.out.print("Колличество бонусов: " + scanner.nextInt());
                DatabaseEmployers.addBonus(numberBonusCart, countBonus);
            }
            if (inChekMenu == 0) {
                flagForChekInWhile = false;
            }
        }
    }
}
