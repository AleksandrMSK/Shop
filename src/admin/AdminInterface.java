package admin;

import customer.SortCostumer;
import employee.DatabaseEmployers;
import product.ProductDatabase;
import registration.Registration;
import servis.AllConstants;

import java.util.Scanner;
/**
 * Класс интерфейса  для администратора со всеми элементами управления ,
 * авторизация по логину и паролю.
 * @author Aleksandr Moskalchuk
 * @version 1.0*/

public class AdminInterface extends ConstantsAdmin {
    public static void menuForAdministrator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MENU_ADMIN);
        System.out.print(AllConstants.ENTER_LOGIN);
        String login = scanner.nextLine();
        System.out.print(AllConstants.ENTER_PASSWORD);
        String password = scanner.nextLine();
        if (checkInAdmin(login, password)) {
            boolean flagInWhileAdmin = true;
            while (flagInWhileAdmin) {
                try {
                    System.out.println("\n\t" + INTERFACE_ADMIN);
                    System.out.println(CHECK_PRODUCT);
                    System.out.println(ADD_PRODUCT);
                    System.out.println(DELETE_PRODUCT);
                    System.out.println(TO_HIRE_EMPLOY);
                    System.out.println(TO_FIRE_EMPLOY);
                    System.out.println(GET_DATABASE_EMPLOYERS);
                    System.out.println(GET_DATABASE_COSTUMERS);
                    System.out.println(TO_FIRE_COSTUMER);
                    System.out.println(AllConstants.EXIT);
                    System.out.print(AllConstants.ENTER);
                    switch (Integer.parseInt(scanner.next())) {
                        case 1:
                            boolean flag = true;
                            ProductDatabase.getProductOfDatabase();
                            while (flag) {
                                System.out.println(AllConstants.SORT_BY_PRICE);
                                System.out.println(AllConstants.EXIT);
                                int enter = Integer.parseInt(scanner.next());
                                if (enter == 1) {
                                    ProductDatabase.sortProductByName();
                                }
                                if (enter == 0) {
                                    flag = false;
                                } else {
                                    System.out.println(AllConstants.SELECT_ITEM);
                                }
                            }
                            break;
                        case 2:
                            ProductDatabase.recordingProductInDatabase();
                            break;
                        case 3:
                            System.out.print(DELETE_INDEX);
                            ProductDatabase.deleteProduct(Integer.parseInt(scanner.next()));
                            //scanner.nextInt();
                            break;
                        case 4:
                            DatabaseEmployers.addEmployers();
                            break;
                        case 5:
                            System.out.print(ID_COSTUMER);
                            DatabaseEmployers.deleteEmployerById(Integer.parseInt(scanner.next()));
                            break;
                        case 6:
                            DatabaseEmployers.getDatabaseCostumer();
                            break;
                        case 7:
                            boolean flagInSevenCase = true;
                            System.out.println(AllConstants.DATABASE_COSTUMERS);
                            Registration.getDatabaseCostumer();
                            while (flagInSevenCase) {
                                System.out.println(AllConstants.SORT_BY_NAME);
                                System.out.println(AllConstants.EXIT);
                                int enter = Integer.parseInt(scanner.next());
                                if (enter == 1) {
                                    SortCostumer.sortCostumerByAll();
                                }
                                if (enter == 0) {
                                    flagInSevenCase = false;
                                }
                            }
                            break;
                        case 8:
                            System.out.print(LOGIN_COSTUMER);
                            scanner.nextLine();
                            Registration.deleteCostumerByLogin(scanner.nextLine());
                            break;
                        case 0:
                            flagInWhileAdmin = false;
                            break;
                        default:
                            System.out.println(AllConstants.SELECT_ITEM);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(AllConstants.ERROR_TYPING + e);
                }
            }
        } else {
            System.out.println(AllConstants.MISTAKE_LOGIN);
        }
    }

    public static boolean checkInAdmin(String login, String password) {
        if (login.equalsIgnoreCase(LOGIN_ADMIN)) {
            return password.equalsIgnoreCase(PASSWORD_ADMIN);
        }
        return false;
    }
}

