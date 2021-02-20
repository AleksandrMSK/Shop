package customer;

import registration.Registration;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {
    private static String login;
    private static String password;

    public static String getLogin() {
        return login;
    }

    public static boolean authorizationCostumerChekLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш логин: ");
        login = scanner.nextLine();
        System.out.print("Введите ваш пароль: ");
        password = scanner.nextLine();
        System.out.println("");
        ArrayList<Costumer> ligList = Registration.readingCostumerInDatabase();
        for (Costumer s : ligList) {
            if (s.getLogin().equalsIgnoreCase(login)) {
                if (authorizationCostumerChekPassword(s.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean authorizationCostumerChekPassword(String pass) {
        return password.equals(pass);
    }
}
