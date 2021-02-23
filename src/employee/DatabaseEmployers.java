package employee;

import customer.Costumer;
import registration.Registration;
import servis.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class DatabaseEmployers implements Serializable {
    static ArrayList<ShopEmployee> shopEmployers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addEmployers() {
        int id = 1;
        String password;
        String name = "";
        String position = "";
        int salary = 0;


        try {

            shopEmployers = readingEmployers();
            System.out.print("Имя сотрудника: ");
            while (!(Registration.chekByConformityNameInRegistration(name = scanner.nextLine()))) {
                System.err.print("Введите корректное имя: ");
            }
            System.out.print("Установить пароль: ");
            while (!(Registration.chekByConformityPasswordInRegistration(password = scanner.nextLine()))) {
                System.err.print("Введите пароль от 8 до 16 символов: ");
            }
            System.out.print("Назначить на должность: ");
            while (!(Registration.chekByConformityNameInRegistration(position = scanner.nextLine()))) {
                System.err.print("что то пошло не так, попробуй ещё раз: ");
            }
            System.out.print("Установить зарплату: ");
            salary = scanner.nextInt();
            shopEmployers.add(new ShopEmployee(id, password, name, position, salary));
            id += shopEmployers.size();
            writingEmployers();
            System.out.println("\n "+name+" успешно нанят на должность " + position+"\n");
        } catch (InputMismatchException e) {
            System.out.println("Введён недопустимый символ, повторите регистрацию: " + e);
        }
    }

    public static void addBonus(int bonusCart, int count) {
        Registration.costumersRegistration = Registration.readingCostumerInDatabase();
        for (Costumer c : Registration.costumersRegistration) {
            if (c.getBonusCart().getId() == bonusCart) {
                c.getBonusCart().setCountBonus(count);
            }
        }
        Registration.writingCostumerInDatabase();
    }


    public static void deleteEmployerById(int id) {
        shopEmployers = readingEmployers();
        Iterator<ShopEmployee> iterator = shopEmployers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                writingEmployers();
                System.out.println(id + " уволен!!!!!!");
            }
        }
        System.out.println(id + " не найден");
    }


    public static ArrayList<ShopEmployee> readingEmployers() {
        try {
            FileInputStream fileIS = new FileInputStream(Constants.EMPLOYERS_DATABASE);
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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.EMPLOYERS_DATABASE))) {
            oos.writeObject(shopEmployers);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void getDatabaseCostumer() {
        ArrayList<ShopEmployee> list = readingEmployers();
        for (ShopEmployee s : list) {
            System.out.println(s.toString());
        }
    }
}
