package employee;

import customer.Costumer;
import registration.Registration;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEmployers {
    public static boolean authorizationCostumerChekLogin() {
        int login;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню входа сотрудника");
        System.out.print("Введите ваш логин: ");
        login = scanner.nextInt();
        System.out.print("Введите ваш пароль: ");
        password = scanner.nextLine();
        System.out.println("");
        ArrayList<ShopEmployee> shopList = DatabaseEmployers.readingEmployers();
        for (ShopEmployee s : shopList) {
            if (s.getId() == login) {
                if (s.getPassword()==password) {
                    return true;
                }
            }
        }
        return false;
    }
}
