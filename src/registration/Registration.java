package registration;

import customer.Costumer;
import customer.CostumerInterface;
import customer.LoginMenu;
import servis.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    static ArrayList<Costumer> costumersRegistration = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void registrationCostumer() {
        String name = "";
        int age;
        int bonusCart;
        String login;
        String password;

        costumersRegistration = readingCostumerInDatabase();
        System.out.print("Enter name: ");
        while (!(chekByConformityDataInRegistration(name = scanner.nextLine()))) {
            System.err.print("Введите корректное имя: ");
        }
        System.out.print("Enter your age: ");
        while (!(chekByConformityAgeInRegistrationCostumer(age = scanner.nextInt()))) {
            System.err.print("Введите корректный возраст: ");
        }
        System.out.print("Enter your number bonus cart: ");
        while (!(chekByConformityBonusCartInRegistrationCostumer(bonusCart = scanner.nextInt()))) {
            System.err.print("Введите корректный номер бонусной карты 6 символов: ");
        }
        System.out.print("Enter Login: ");
        while (LoginMenu.checksForDuplicateLogin(login = scanner.next())) {
            System.out.print("логин "+login + " занят"+"\n"+"Введите уникальный логин: ");
        }
            while (chekByConformityDataInRegistration(login)) {
                System.out.print("Введите корректный логин: ");
            }

        System.out.print("Enter password: ");
        while (!(chekByConformityPasswordInRegistration(password = scanner.nextLine()))) {
            System.err.print("Введите корректный пароль: ");
        }
        costumersRegistration.add(new Costumer(name, age, bonusCart, login, password));
        writingCostumerInDatabase();
        System.out.println("Вы успешно зарегистрированы под логином " + login);
        System.out.println();
        CostumerInterface.interfaceForCostumer();

    }

    public static ArrayList<Costumer> readingCostumerInDatabase() {
        try {
            FileInputStream fileIS = new FileInputStream(Constants.COSTUMER_DATABASE);
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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.COSTUMER_DATABASE))) {
            oos.writeObject(costumersRegistration);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void getDatabaseCostumer() {
        ArrayList<Costumer> list = readingCostumerInDatabase();
        for (Costumer s : list) {
            System.out.println(s.toString());
            System.out.println("============================================================");
        }
    }

    //Проверка  на соответствие вводимых данных при регистрации пользователя
    public static boolean chekByConformityDataInRegistration(String login) {
        Pattern pattern = Pattern.compile(Constants.REGEX_NAME);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }
    public static boolean chekByConformityPasswordInRegistration(String password) {
        Pattern pattern = Pattern.compile(Constants.REGEX_NAME);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean chekByConformityAgeInRegistrationCostumer(int age) {
        return age > 0 && age < 124;
    }

    public static boolean chekByConformityBonusCartInRegistrationCostumer(int bonusCart) {
        Pattern pattern = Pattern.compile(Constants.REGEX_BONUS);
        Matcher matcher = pattern.matcher(String.valueOf(bonusCart));
        return matcher.matches();
    }

}
