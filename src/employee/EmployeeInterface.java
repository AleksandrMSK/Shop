package employee;

import customer.Search;
import product.ProductDatabase;
import servis.AllConstants;

import java.io.Serializable;
import java.util.Scanner;

import static servis.AllConstants.ERROR_TYPING;
import static servis.AllConstants.EXIT;

public class EmployeeInterface implements Serializable {
    public static final String INTERFACE_EMPLOYEE = "\nИнтерфейс сотрудника магазина";
    public static final String WATCH_PRODUCT = "1 - посмотреть доступный товар";
    public static final String SORT_BY_PRICE = "2 - выставить товар по цене";
    public static final String DELETE_PRODUCT = "3 - убрать товар с витрины";
    public static final String GET_DATABASE_COSTUMER = "4 - вывести данные о клиенте";
    public static final String ADD_BONUS = "5 - начислить бонусы";
    public static final String DATABASE_PRODUCT = "Склад товара";
    public static final String PRODUCT_SORT_BY_PRICE = "Товар отсортирован по цене";
    public static final String ENTER_INDEX_PRODUCT = "введите индекс товара: ";
    public static final String SEARCH_COSTUMER = "Поиск клиента по логину";
    public static final String ENTER_NUMBER_CART = "Введите номер бонусной карты: ";
    public static final String COUNT_BONUS = "Колличество бонусов: ";
    public static final String MISTAKE = "что то пошло не так :( ";

    static Scanner scanner = new Scanner(System.in);

    public static void getMenuForEmployee() {
        if (SearchEmployers.authorizationCostumerChekLogin()) {
            boolean flagForChekInWhile = true;
            while (flagForChekInWhile) {
                try {
                    System.out.println(INTERFACE_EMPLOYEE);
                    System.out.println(WATCH_PRODUCT);
                    System.out.println(SORT_BY_PRICE);
                    System.out.println(DELETE_PRODUCT);
                    System.out.println(GET_DATABASE_COSTUMER);
                    System.out.println(ADD_BONUS);
                    System.out.println(EXIT);
                    System.out.print(AllConstants.ENTER);
                    switch (Integer.parseInt(scanner.next())) {
                        case 1:
                            System.out.println(DATABASE_PRODUCT);
                            ProductDatabase.getProductOfDatabase();
                            break;
                        case 2:
                            System.out.println(PRODUCT_SORT_BY_PRICE);
                            ProductDatabase.sortProductByName();
                            break;
                        case 3:
                            System.out.print(ENTER_INDEX_PRODUCT);
                            ProductDatabase.deleteProduct(Integer.parseInt(scanner.next()));
                            break;
                        case 4:
                            Scanner input = new Scanner(System.in);
                            System.out.println(SEARCH_COSTUMER);
                            System.out.print(AllConstants.ENTER);
                            System.out.println(Search.searchByLogin(input.nextLine()));
                            System.out.println("");
                            break;
                        case 5:
                            System.out.print(ENTER_NUMBER_CART);
                            int numberBonusCart = Integer.parseInt(scanner.next());
                            System.out.print(COUNT_BONUS);
                            int countBonus = Integer.parseInt(scanner.next());
                            DatabaseEmployers.addBonus(numberBonusCart, countBonus);
                            break;
                        case 0:
                            flagForChekInWhile = false;
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(ERROR_TYPING + e);
                }
            }
        } else {
            System.out.println(MISTAKE);
        }
    }
}
