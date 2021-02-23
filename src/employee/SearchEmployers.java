package employee;

import customer.Costumer;
import registration.Registration;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEmployers {
    public static boolean authorizationCostumerChekLogin() {
        int id;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню входа сотрудника");
        System.out.print("Введите ваш id: ");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите ваш пароль: ");
        password = scanner.nextLine();
        for (ShopEmployee s : DatabaseEmployers.shopEmployers) {
            if (s.getId() == id) {
                if (s.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
