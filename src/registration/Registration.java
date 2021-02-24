package registration;

import customer.BonusCart;
import customer.Costumer;
import customer.LoginMenu;
import servis.AllConstants;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static registration.ConstantForRegistration.*;

/**
 * Класс регистрация клиентов
 * в классе присутствуют такие методы как:
 * - регистрация клиентов
 * - удаление клиентов по логину
 * - сериализация (чтение / запись файлов )
 * - вывод юазы данных на экран
 * - проверка через регулярные выражения: имени, логина ,пароля, возраста ,бонусной карты.
 * - зачисление денег на счёт клиента
 * - вывод профиля конкретного клиента
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class Registration {
    public static ArrayList<Costumer> costumersRegistration;
    static Scanner scanner = new Scanner(System.in);

    public static void registrationCostumer() {
        String name;
        int age;
        int bonusCart;
        double money;
        String login;
        String password;
        while (true) {
            try {
                System.out.print(ENTER_NAME);
                while (!(chekByConformityNameInRegistration(name = scanner.nextLine()))) {
                    System.err.print(ConstantForRegistration.ENTER_CORRECT_NAME);
                }
                System.out.print(ENTER_AGE);
                while (!(chekByConformityAgeInRegistrationCostumer(age = Integer.parseInt(scanner.next())))) {
                    System.err.print(ENTER_CORRECT_AGE);
                }
                System.out.print(ENTER_NUMBER_CART);
                while (!LoginMenu.checksByBonusCart(bonusCart = Integer.parseInt(scanner.next()))) {
                    System.out.print(CHECK_BONUS_CART);
                }
                scanner.nextLine();
                System.out.println(HOW_MONEY);
                money = Double.parseDouble(scanner.next());
                scanner.nextLine();
                System.out.print(ENTER_LOGIN);
                while (LoginMenu.checksForDuplicateLogin(login = scanner.nextLine())) {
                    System.out.print(LOGIN + login + BUSY + ENTER_UNIQUE_LOGIN);
                }
                while (!chekByConformityLoginInRegistrationCostumer(login)) {
                    System.out.print(ENTER_CORRECT_LOGIN);
                    login = scanner.nextLine();
                }
                System.out.print(ENTER_PASSWORD);
                while (!(chekByConformityPasswordInRegistration(password = scanner.nextLine()))) {
                    System.err.print(ENTER_CORRECT_PASSWORD);
                }
                costumersRegistration.add(new Costumer(name, age, new BonusCart(bonusCart), money, login, password));
                writingCostumerInDatabase();
                System.out.println(SUCCESSFULLY_REGISTRATION + login);
                System.out.println();
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(AllConstants.ERROR_TYPING + e);
            }
        }
    }

    public static void deleteCostumerByLogin(String login) {
        boolean flag = false;
        Iterator<Costumer> iterator = costumersRegistration.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLogin().equalsIgnoreCase(login)) {
                iterator.remove();
                writingCostumerInDatabase();
                System.out.println(login + SUCCESSFULLY_DELETE);
                flag = true;
            }
        }
        if (!flag) System.out.println(login + NOT_FOUND);
    }

    public static ArrayList<Costumer> readingCostumerInDatabase() {
        try {
            FileInputStream fileIS = new FileInputStream(AllConstants.COSTUMER_DATABASE);
            ObjectInputStream objectIS = new ObjectInputStream(fileIS);
            ArrayList<Costumer> costumersDatabase = (ArrayList<Costumer>) objectIS.readObject();
            objectIS.close();
            return costumersDatabase;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writingCostumerInDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AllConstants.COSTUMER_DATABASE))) {
            oos.writeObject(costumersRegistration);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void getDatabaseCostumer() {
        for (Costumer s : Registration.costumersRegistration) {
            System.out.println(s.toString());
        }
    }

    public static boolean chekByConformityNameInRegistration(String name) {
        Pattern pattern = Pattern.compile(AllConstants.REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean chekByConformityPasswordInRegistration(String password) {
        Pattern pattern = Pattern.compile(AllConstants.REGEX_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean chekByConformityAgeInRegistrationCostumer(int age) {
        return age > 0 && age < 124;
    }

    public static boolean chekByConformityLoginInRegistrationCostumer(String login) {
        Pattern pattern = Pattern.compile(AllConstants.REGEX_LOGIN);
        Matcher matcher = pattern.matcher(String.valueOf(login));
        return matcher.matches();
    }

    public static void addMoneyByBalanceCostumer(double moneyValue) {
        for (Costumer c : costumersRegistration) {
            if (c.getLogin().equalsIgnoreCase(LoginMenu.getLogin())) {
                c.setMoney(c.getMoney() + moneyValue);
                System.out.println(BALANCE_ADDED + moneyValue + MONEY);
            }
        }
        writingCostumerInDatabase();
    }

    public static void getProfileCostumer() {
        for (Costumer c : costumersRegistration) {
            if (c.getLogin().equalsIgnoreCase(LoginMenu.getLogin())) {
                System.out.println(c);
            }
        }
    }
}
