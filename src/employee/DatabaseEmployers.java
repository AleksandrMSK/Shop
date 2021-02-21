package employee;

import customer.BonusCart;
import customer.Costumer;
import customer.CostumerInterface;
import customer.LoginMenu;
import registration.Registration;
import servis.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseEmployers implements Serializable {
    static ArrayList<ShopEmployee> shopEmployers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void addEmployers() {
        int id = shopEmployers.size()+1;
        String password;
        String name = "";
        String position = "";
        int salary = 0;


        try {
            shopEmployers = readingEmployers();
            System.out.print("Enter name: ");
            while (!(chekByConformityNameInRegistration(name = scanner.nextLine()))) {
                System.err.print("Введите корректное имя: ");
            }
            System.out.print("Enter password: ");
            while (!(chekByConformityPasswordInRegistration(password = scanner.nextLine()))) {
                System.err.print("Введите пароль от 8 до 16 символов: ");
            }


            shopEmployers.add(new ShopEmployee(id,password,name,position,salary));
            writingEmployers();
            System.out.println();
            System.out.println();
            EmployeeInterface.getMenuForEmployee();
        } catch (InputMismatchException e) {
            System.out.println("Введён недопустимый символ, повторите регистрацию: " + e);
        }
    }
    public  static void  addBonus(int bonusCart , int count){
        Registration.costumersRegistration = Registration.readingCostumerInDatabase();
        for (Costumer c:Registration.costumersRegistration) {
            if (c.getBonusCart().getId() == bonusCart){
                c.getBonusCart().setCountBonus(count);
            }
        }
        Registration.writingCostumerInDatabase();
    }


    public static void deleteCostumerByLogin(int id){
        shopEmployers = readingEmployers();
        Iterator<ShopEmployee> iterator = shopEmployers.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId()==id){
                iterator.remove();
                writingEmployers();
                System.out.println(id+" уволен!!!!!!");
            }
        }
        System.out.println(id + " не найден");
    }


    public static ArrayList<ShopEmployee> readingEmployers() {
        try {
            FileInputStream fileIS = new FileInputStream("employers.bin");
            ObjectInputStream objectIS = new ObjectInputStream(fileIS);
            ArrayList<ShopEmployee> shopEmployers = (ArrayList<ShopEmployee>) objectIS.readObject();
            objectIS.close();
            return shopEmployers;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writingEmployers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employers.bin"))) {
            oos.writeObject(shopEmployers);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void getDatabaseCostumer() {
        ArrayList<ShopEmployee> list = readingEmployers();
        for (ShopEmployee s : list) {
            System.out.println(s.toString());
            System.out.println("============================================================");
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
