package customer;

import registration.Registration;
import servis.Constants;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean checksForDuplicateLogin(String login) {
        ArrayList<Costumer> listForLogin = Registration.readingCostumerInDatabase();
        for (Costumer c : listForLogin) {
            if (login.equalsIgnoreCase(c.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checksByBonusCart(int bonus) {
        Pattern pattern = Pattern.compile(Constants.REGEX_BONUS);
        Matcher matcher = pattern.matcher(String.valueOf(bonus));
        if (matcher.matches()) {
            ArrayList<Costumer> listForLogin = Registration.readingCostumerInDatabase();
            for (Costumer c : listForLogin) {
                if (bonus == c.getBonusCart().getId()) {
                    System.out.println("номер бонусной карты занят");
                    return false;
                }
            }
        } else {
            System.out.println("не корректный номер бонусной карты");
            return false;
        }
        return true;


    }
}

