package employee;

import java.util.Scanner;

import static servis.AllConstants.ERROR_TYPING;

/**
 * Класс авторизация сотрудника
 * проверяет вводимые данные на соответствие с данными в БД сотрудников
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class SearchEmployers {
    public static final String MENU_INPUT = "Меню входа сотрудника";
    public static final String ENTER_ID = "Введите ваш id: ";
    public static final String ENTER_PASSWORD = "Введите ваш пароль: ";

    public static boolean authorizationCostumerChekLogin() {
        int id;
        String password;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(MENU_INPUT);
            System.out.print(ENTER_ID);
            id = Integer.parseInt(scanner.next());
            scanner.nextLine();
            System.out.print(ENTER_PASSWORD);
            password = scanner.nextLine();
            for (ShopEmployee s : DatabaseEmployers.shopEmployers) {
                if (s.getId() == id) {
                    if (s.getPassword().equals(password)) {
                        return true;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(ERROR_TYPING + e);
        }
        return false;
    }
}
