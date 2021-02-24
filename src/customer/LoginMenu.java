package customer;

import registration.Registration;
import servis.AllConstants;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu {

    public static final String NUMBER_CART_BUSY = "Номер бонусной карты занят";
    public static final String NUMBER_CART_NOT_CORRECT = "Номер бонусной карты введён не корректно";
    private static String login;
    private static String password;

    public static String getLogin() {
        return login;
    }

    public static boolean authorizationCostumerChekLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(AllConstants.ENTER_LOGIN);
        login = scanner.nextLine();
        System.out.print(AllConstants.ENTER_PASSWORD);
        password = scanner.nextLine();
        System.out.println("");
        for (Costumer s : Registration.costumersRegistration) {
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
        for (Costumer c : Registration.costumersRegistration) {
            if (login.equalsIgnoreCase(c.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checksByBonusCart(int bonus) {
        Pattern pattern = Pattern.compile(AllConstants.REGEX_BONUS);
        Matcher matcher = pattern.matcher(String.valueOf(bonus));
        if (matcher.matches()) {
            for (Costumer c : Registration.costumersRegistration) {
                if (bonus == c.getBonusCart().getId()) {
                    System.out.println(NUMBER_CART_BUSY);
                    return false;
                }
            }
        } else {
            System.out.println(NUMBER_CART_NOT_CORRECT);
            return false;
        }
        return true;
    }
}

