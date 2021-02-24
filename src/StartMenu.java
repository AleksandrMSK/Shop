import admin.AdminInterface;
import customer.CostumerInterface;
import employee.EmployeeInterface;
import servis.FileManager;

import java.util.Scanner;

import static servis.AllConstants.ERROR_TYPING;
import static servis.AllConstants.EXIT;

/**
 * Класс начального меню входа
 * запускает программу
 * при вызове case 0 - записывает бинарные файлы и закрывает программу
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class StartMenu {
    public static final String ENTER_ADMIN = "1 - Войти как администратор";
    public static final String ENTER_COSTUMER = "2 - Войти как клиент";
    public static final String ENTER_EMPLOYEE = "3 - Войти как сотрудник";

    public static final String MENU = "1 - Войти как администратор\n2 - Войти как клиент\n" +
            "3 - Войти как сотрудник\n0 - Выход";

    public static void startProgram() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
//                System.out.println(ENTER_ADMIN);
//                System.out.println(ENTER_COSTUMER);
//                System.out.println(ENTER_EMPLOYEE);
//                System.out.println(EXIT);
                System.out.println(MENU);
                switch (Integer.parseInt(scanner.next())) {
                    case 1:
                        AdminInterface.menuForAdministrator();
                        break;
                    case 2:
                        CostumerInterface.interfaceForCostumer();
                        break;
                    case 3:
                        EmployeeInterface.getMenuForEmployee();
                        break;
                    case 0:
                        FileManager.writeToDataBase();
                        System.exit(0);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_TYPING + e);
            }
        }
    }
}
