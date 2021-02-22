package admin;

import customer.SortCostumer;
import employee.DatabaseEmployers;
import product.ProductDatabase;
import registration.Registration;
import servis.Constants;
import java.util.Scanner;

public class AdminInterface {
    public static void menuForAdministrator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню входа администратора");
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        if (checkInAdmin(login, password)) {
            boolean flagInWhileAdmin = true;
            while (flagInWhileAdmin) {
                System.out.println("");
                System.out.println("Интерфейс администратора магазина");
                System.out.println("1 - посмотреть товар на складе");
                System.out.println("2 - пополнить товар");
                System.out.println("3 - удалить товар");
                System.out.println("4 - нанять сотрудника");
                System.out.println("5 - уволить сотрудника");
                System.out.println("6 - просмотреть базу данных сотрудников");
                System.out.println("7 - просмотреть базу данных клиентов");
                System.out.println("8 - удалить клиента");
                System.out.println("0 - выход");
                System.out.print(Constants.ENTER);
                int inChekMenu = scanner.nextInt();
                if (inChekMenu == 1) {
                    boolean flag = true;
                    ProductDatabase.getProductOfDatabase();
                    while (flag) {
                        System.out.println("1 - Отсортировать по модели");
                        System.out.println("2 - Отсортировать цене");
                        System.out.println("0 - Выйти");
                        int enter = scanner.nextInt();
                        if (enter == 1) {
                            ProductDatabase.sortProductByName();
                        }
                        if (enter == 2) {
                            ProductDatabase.sortProductByName();
                        }
                        if (enter == 0) {
                            flag = false;
                        } else {
                            System.out.println("Выберите соответствующий пункт меню");
                        }
                    }
                } else if (inChekMenu == 2) {
                    ProductDatabase.recordingProductInDatabase();
                } else if (inChekMenu == 3) {
                    System.out.print("Введите индекс удаляемого товара: ");
                    ProductDatabase.deleteProduct(scanner.nextInt());
                    scanner.nextInt();
                } else if (inChekMenu == 4) {
                    DatabaseEmployers.addEmployers();
                } else if (inChekMenu == 5) {
                    System.out.print("Введите id сотрудника: ");
                    DatabaseEmployers.deleteEmployerById(scanner.nextInt());
                } else if (inChekMenu == 6) {
                    DatabaseEmployers.getDatabaseCostumer();
                } else if (inChekMenu == 7) {
                    boolean flag = true;
                    System.out.println("БАЗА ДАННЫХ КЛИЕНТОВ");
                    Registration.getDatabaseCostumer();
                    while (flag) {
                        System.out.println("1 - Отсортировать по имени");
                        System.out.println("0 - Выйти");
                        int enter = scanner.nextInt();
                        if (enter == 1) {
                            SortCostumer.sortCostumerByAll();
                        }
                        if (enter == 0) {
                            flag = false;
                        }
                    }
                } else if (inChekMenu == 8) {
                    System.out.print("Введите логин клиента: ");
                    scanner.nextLine();
                    Registration.deleteCostumerByLogin(scanner.nextLine());
                } else if (inChekMenu == 0) {
                    flagInWhileAdmin = false;
                }
            }
        } else {
            System.out.println("Вход доступен только администратору");
        }
    }
    public static boolean checkInAdmin(String login, String password) {
        if (login.equalsIgnoreCase("admin")) {
            return password.equalsIgnoreCase("admin1234");
        }
        return false;
    }
}

