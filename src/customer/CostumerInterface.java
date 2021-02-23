package customer;

import product.ProductDatabase;
import registration.Registration;
import servis.Constants;
import servis.Greeting;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CostumerInterface {
    public static final String INPUT = "1 - вход";
    public static final String REGISTRATION = "2 - регистрация";

    static Scanner scanner = new Scanner(System.in);

    public static void interfaceForCostumer() {
        boolean flagForMainMenu = true;
        boolean flagOnMenu = true;
        while (flagForMainMenu) {
       try{
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
                            System.out.println("1 - Просмотреть список товара");
                            System.out.println("2 - Отсортировать товар по цене");
                            System.out.println("3 - Добавить товар в корзину");
                            System.out.println("4 - Перейти в корзину");
                            System.out.println("5 - Фильтр товара по цене от - до");
                            System.out.println("6 - Пополнить баланс");
                            System.out.println("7 - Профиль");
                            System.out.println("0 - Выход");
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
                                    System.out.print("от: ");
                                    int from = Integer.parseInt(scanner.next());
                                    System.out.print("до: ");
                                    int before = Integer.parseInt(scanner.next());
                                    ProductDatabase.filterProductByPrice(from, before);
                                    break;
                                case 6:
                                    System.out.print("Сколько белок добавить: ");
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
                                    System.out.println(Constants.SELECT_ITEM);
                            }
                    }

                } else {
                    System.out.println("Вы ввели неверный логин или пароль ,повторите попытку.\n");
                }
            }
            if (in == 2) {
                System.out.println("Меню регистрации");
                Registration.registrationCostumer();
            }
            if (in == 0) {
                flagForMainMenu = false;
            }
        }catch (NumberFormatException e){
            System.out.println(e);
        }

        }
    }
}


