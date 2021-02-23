package employee;

import customer.Search;
import product.ProductDatabase;
import servis.Constants;

import java.io.Serializable;
import java.util.Scanner;

public class EmployeeInterface implements Serializable {
    static Scanner scanner = new Scanner(System.in);

    public static void getMenuForEmployee() {

        if (SearchEmployers.authorizationCostumerChekLogin()) {
            boolean flagForChekInWhile = true;
            while (flagForChekInWhile) {
                try {
                    System.out.println("");
                    System.out.println("Интерфейс сотрудника магазина");
                    System.out.println("1 - посмотреть доступный товар");
                    System.out.println("2 - выставить товар по цене");
                    System.out.println("3 - убрать товар с витрины");
                    System.out.println("4 - вывести данные о клиенте");
                    System.out.println("5 - начислить бонусы");
                    System.out.println("0 - выйти");
                    System.out.print(Constants.ENTER);
                    int inChekMenu = Integer.parseInt(scanner.next());
                    if (inChekMenu == 1) {
                        System.out.println("Склад товара");
                        ProductDatabase.getProductOfDatabase();
                    }
                    if (inChekMenu == 2) {
                        System.out.println("Товар отсортирован по цене");
                        ProductDatabase.sortProductByName();
                    }
                    if (inChekMenu == 3) {
                        System.out.print("введите индекс товара: ");
                        ProductDatabase.deleteProduct(Integer.parseInt(scanner.next()));

                    }
                    if (inChekMenu == 4) {
                        Scanner input = new Scanner(System.in);
                        System.out.println("Поиск клиента по логину");
                        System.out.print(Constants.ENTER);
                        System.out.println(Search.searchByLogin(input.nextLine()));
                        System.out.println("");
                    }
                    if (inChekMenu == 5) {
                        System.out.print("Введите номер бонусной карты: ");
                        int numberBonusCart = Integer.parseInt(scanner.next());
                        System.out.print("Колличество бонусов: ");
                        int countBonus = Integer.parseInt(scanner.next());
                        DatabaseEmployers.addBonus(numberBonusCart, countBonus);
                    }
                    if (inChekMenu == 0) {
                        flagForChekInWhile = false;
                    }
                }catch (NumberFormatException e){
                    System.out.println(e);
                }
            }
        }
        else {
            System.out.println("что то пошло не так");
        }
    }
}
