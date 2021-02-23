package customer;

import product.ProductDatabase;
import registration.Registration;
import servis.Constants;
import servis.Greeting;


import java.util.Scanner;

import static servis.Constants.SELECT_ITEM;

public class CostumerInterface {
    public static final String INPUT = "1 - вход";
    public static final String REGISTRATION = "2 - регистрация";
    public static final String LIST_PRODUCT = "1 - Просмотреть список товара";
    public static final String SORT = "2 - Отсортировать товар по цене";
    public static final String ADD_IN_BOX = "3 - Добавить товар в корзину";
    public static final String IN_BOX = "4 - Перейти в корзину";
    public static final String FILTER = "5 - Фильтр товара по цене от - до";
    public static final String ADD_BALANCE = "6 - Пополнить баланс";
    public static final String PROFILE = "7 - Профиль";
    public static final String FROM = "от: ";
    public static final String BEFORE = "до: ";
    public static final String HOW_MONEY_ADD = "Сколько белок добавить: ";
    public static final String MISTAKE = "Вы ввели неверный логин или пароль ,повторите попытку.\n";
    public static final String MENU_REGISTRATION = "Меню регистрации";

    static Scanner scanner = new Scanner(System.in);
    public static void interfaceForCostumer() {
        boolean flagForMainMenu = true;
        boolean flagOnMenu = true;
        while (flagForMainMenu) {
            try {
                System.out.println(INPUT);
                System.out.println(REGISTRATION);
                System.out.println(Constants.EXIT);
                System.out.print(Constants.ENTER);
                int in = Integer.parseInt(scanner.next());
                if (in == 1) {
                    if (LoginMenu.authorizationCostumerChekLogin()) {
                        flagForMainMenu = false;
                        while (flagOnMenu) {
                            Greeting.getGreeting();
                            System.out.println(LoginMenu.getLogin());
                            System.out.println(LIST_PRODUCT);
                            System.out.println(SORT);
                            System.out.println(ADD_IN_BOX);
                            System.out.println(IN_BOX);
                            System.out.println(FILTER);
                            System.out.println(ADD_BALANCE);
                            System.out.println(PROFILE);
                            System.out.println(Constants.EXIT);
                            System.out.print(Constants.ENTER);
                            switch (Integer.parseInt(scanner.next())) {
                                case 1:
                                    ProductDatabase.getProductOfDatabase();
                                    break;
                                case 2:
                                    ProductDatabase.sortProductByName();
                                    break;
                                case 3:
                                    BoxForProduct.addProductToBox();
                                    break;
                                case 4:
                                    BoxForProduct.calculatesFinalPriseProduct();
                                    break;
                                case 5:
                                    System.out.print(FROM);
                                    int from = Integer.parseInt(scanner.next());
                                    System.out.print(BEFORE);
                                    int before = Integer.parseInt(scanner.next());
                                    ProductDatabase.filterProductByPrice(from, before);
                                    break;
                                case 6:
                                    System.out.print(HOW_MONEY_ADD);
                                    Registration.addMoneyByBalanceCostumer(Double.parseDouble(scanner.next()));
                                    break;
                                case 7:
                                    Registration.getProfileCostumer();
                                    break;
                                case 0:
                                    System.out.println(Constants.EXIT);
                                    flagOnMenu = false;
                                    break;
                                default:
                                    System.out.println(SELECT_ITEM);
                            }
                        }

                    } else {
                        System.out.println(MISTAKE);
                    }
                }
                if (in == 2) {
                    System.out.println(MENU_REGISTRATION);
                    Registration.registrationCostumer();
                }
                if (in == 0) {
                    flagForMainMenu = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(SELECT_ITEM + e);
            }

        }
    }
}


