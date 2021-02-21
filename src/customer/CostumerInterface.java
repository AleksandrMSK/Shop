package customer;

import product.ProductDatabase;
import registration.MenuSelection;
import registration.Registration;
import servis.Constants;
import servis.Greeting;
import java.util.Scanner;

public class CostumerInterface {
    public static void interfaceForCostumer() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean flagForMainMenu = true;
            boolean flagOnMenu = true;


            while (flagForMainMenu) {
                System.out.println("1 - вход");
                System.out.println("2 - регистрация");
                System.out.print(Constants.ENTER);
                int in = scanner.nextByte();
                if (in == 1) {
                        if (LoginMenu.authorizationCostumerChekLogin()) {
                            flagForMainMenu = false;
                            while (flagOnMenu) {
                                Greeting.getGreeting();
                                System.out.println(LoginMenu.getLogin());
                                System.out.println("1 - Просмотреть список товара");
                                System.out.println("2 - Купить товар");
                                System.out.println("3 - Получить бонусную карту");
                                System.out.println("0 - Выход");
                                System.out.print(Constants.ENTER);

                                //                switch (scanner.nextInt()) {
                                //                    case 1:
                                //                        System.out.println(MenuSelection.VIEW_PRODUCT);
                                //                        ProductDatabase.getProductOfDatabase();
                                //                        break;
                                //                    case 2:
                                //                        System.out.println();
                                //                        break;
                                //                    case 3:
                                //                        System.out.println(MenuSelection.GET_BONUS_CART);
                                //                        break;
                                //                    case 0:
                                //                        System.out.println(MenuSelection.EXIT);
                                //                        break;
                                //                    default: System.out.println("Выберите соответвствующий пункт меню");
                                //
                                int numberInMenu = scanner.nextInt();
                                if (numberInMenu == 1) ProductDatabase.getProductOfDatabase();
                                else if (numberInMenu == 2) System.out.println("покупка товара");
                                else if (numberInMenu == 3) System.out.println("получить бонусную карту");
                                else if (numberInMenu == 0) flagOnMenu = false;
                                else System.err.println("Пункта " + numberInMenu + " не сущест");
                            }
                        } else {
                            System.out.println("Вы ввели неверный логин или пароль ,повторите попытку");

                        }
                }
                if (in == 2) {
                    System.out.println("Меню регистрации");
                    Registration.registrationCostumer();
                }
            }
        }
    }
}
