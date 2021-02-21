package admin;

import customer.SortCostumer;
import product.ProductDatabase;
import servis.Constants;

import java.util.Scanner;

public class AdminInterface {
    public static void menuForAdministrator() {
        Scanner scanner = new Scanner(System.in);
        boolean flagInWhileAdmin = true;
        while (flagInWhileAdmin) {
            System.out.println("");
            System.out.println("Интерфейс администратора магазина");
            System.out.println("1 - проверить колличество товара на складе");
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
            }
            if (inChekMenu == 2) {
                ProductDatabase.recordingProductInDatabase();
            }
            if (inChekMenu == 3) {
                System.out.println("меню удаления товара");
            }
            if (inChekMenu == 4) {
                System.out.println("нанять сотрудника");
            }
            if (inChekMenu == 5) {
                System.out.println("уволить сотрудника");
            }
            if (inChekMenu == 6) {
                System.out.println("уволить сотрудника");
            }
            if (inChekMenu == 7) {
                SortCostumer.sortCostumerByAll();
            }
            if (inChekMenu == 8) {
                System.out.println("удаление клиента");
            }
            if (inChekMenu == 0) {
                flagInWhileAdmin = false;
            }
        }
    }
}
