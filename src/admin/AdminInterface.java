package admin;

import customer.SortCostumer;
import employee.DatabaseEmployers;
import product.ProductDatabase;
import registration.Registration;
import servis.Constants;

import java.util.Scanner;

public class AdminInterface extends ConstantsAdmin {
    public static void menuForAdministrator() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(MENU_ADMIN);
        System.out.print(Constants.ENTER_LOGIN);
        String login = scanner.nextLine();
        System.out.print(Constants.ENTER_PASSWORD);
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
                    System.out.println(Constants.EXIT);
                    System.out.print(Constants.ENTER);

                    switch (Integer.parseInt(scanner.next())) {
                        case 1:
                            boolean flag = true;
                            ProductDatabase.getProductOfDatabase();
                            while (flag) {
                                System.out.println(Constants.SORT_BY_PRICE);
                                System.out.println(Constants.EXIT);
                                int enter = Integer.parseInt(scanner.next());
                                if (enter == 1) {
                                    ProductDatabase.sortProductByName();
                                }
                                if (enter == 0) {
                                    flag = false;
                                } else {
                                    System.out.println(Constants.SELECT_ITEM);
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
                            System.out.println(Constants.DATABASE_COSTUMERS);
                            Registration.getDatabaseCostumer();
                            while (flagInSevenCase) {
                                System.out.println(Constants.SORT_BY_NAME);
                                System.out.println(Constants.EXIT);
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
                            System.out.println(Constants.SELECT_ITEM);
                    }
                }catch (NumberFormatException e){
                    System.out.println(e);
                }
            }
        } else {
            System.out.println(Constants.MISTAKE_LOGIN);
        }
    }

    public static boolean checkInAdmin(String login, String password) {
        if (login.equalsIgnoreCase(LOGIN_ADMIN)) {
            return password.equalsIgnoreCase(PASSWORD_ADMIN);
        }
        return false;
    }
}

