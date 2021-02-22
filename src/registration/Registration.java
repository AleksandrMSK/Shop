package registration;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import customer.BonusCart;
import customer.Costumer;
import customer.CostumerInterface;
import customer.LoginMenu;
import servis.Constants;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static ArrayList<Costumer> costumersRegistration = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void registrationCostumer() {
        String name = "";
        int age;
        int bonusCart;
        String login;
        String password;


        try {
            costumersRegistration = readingCostumerInDatabase();
            System.out.print("Enter name: ");
            while (!(chekByConformityNameInRegistration(name = scanner.nextLine()))) {
                System.err.print("Введите корректное имя: ");
            }
            System.out.print("Enter your age: ");
            while (!(chekByConformityAgeInRegistrationCostumer(age = scanner.nextInt()))) {
                System.err.print("Введите корректный возраст: ");
            }
            System.out.print("Enter your number bonus cart: ");
            while (!LoginMenu.checksByBonusCart(bonusCart = scanner.nextInt())) {
                System.out.print("введите уникальный номер карты: ");
            }
            scanner.nextLine();
            System.out.print("Enter Login: ");
            while (LoginMenu.checksForDuplicateLogin(login = scanner.nextLine())) {
                System.out.print("логин " + login + " занят" + "\n" + "Введите уникальный логин: ");
            }
            while (!chekByConformityLoginInRegistrationCostumer(login)) {
                System.out.print("Введите корректный логин: ");
                login = scanner.nextLine();
            }
            System.out.print("Enter password: ");
            while (!(chekByConformityPasswordInRegistration(password = scanner.nextLine()))) {
                System.err.print("Введите пароль от 8 до 16 символов: ");
            }
            costumersRegistration.add(new Costumer(name, age, new BonusCart(bonusCart), login, password));
            writingCostumerInDatabase();
            System.out.println("Вы успешно зарегистрированы под логином " + login);
            System.out.println();
            CostumerInterface.interfaceForCostumer();
        } catch (InputMismatchException e) {
            System.out.println("Введён недопустимый символ, повторите регистрацию: " + e);
        }
    }
    public static void deleteCostumerByLogin(String login){
        costumersRegistration = readingCostumerInDatabase();
        Iterator<Costumer> iterator = costumersRegistration.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getLogin().equalsIgnoreCase(login)){
                iterator.remove();
                writingCostumerInDatabase();
                System.out.println(login+" успешно удалён");
            }
        }
        System.out.println(login + " не найден");
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
            System.out.println(Constants.LINE);
        }
    }

    //Проверка  на соответствие вводимых данных при регистрации пользователя
    public static boolean chekByConformityNameInRegistration(String name) {
        Pattern pattern = Pattern.compile(Constants.REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean chekByConformityPasswordInRegistration(String password) {
        Pattern pattern = Pattern.compile(Constants.REGEX_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean chekByConformityAgeInRegistrationCostumer(int age) {
        return age > 0 && age < 124;
    }

    public static boolean chekByConformityLoginInRegistrationCostumer(String login) {
        Pattern pattern = Pattern.compile(Constants.REGEX_LOGIN);
        Matcher matcher = pattern.matcher(String.valueOf(login));
        return matcher.matches();
    }
}
