package registration;

import customer.Costumer;
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

        while (!(chekLogin(name = scanner.nextLine()))){
            System.out.println("введите коректное имя");
        }







                System.out.print("Enter your age: ");
    age =scanner.nextInt();
        System.out.print("Enter your number bonus cart: ");
    bonusCart =scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Login: ");
    login =scanner.nextLine();
        System.out.print("Enter password: ");
    password =scanner.nextLine();
        costumersRegistration.add(new

    Costumer(name, age, bonusCart, login, password));

    writingCostumerInDatabase();

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

    public static boolean chekLogin(String login) {
        Pattern pattern = Pattern.compile(Constants.REGEX_NAME);
        Matcher matcher = pattern.matcher(login);
        boolean matches = matcher.matches();
        return matches;
    }


}
