package admin;

import product.ProductDatabase;

import java.util.Scanner;

public class AdminInterface {
    public static void menuForAdministrator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Интерфейс администратора магазина");
        System.out.println("1 - добавить новый товар");
        int inChekMenu = scanner.nextInt();
        if (inChekMenu == 1) {
            ProductDatabase.recordingProductInDatabase();
        }
    }
}
