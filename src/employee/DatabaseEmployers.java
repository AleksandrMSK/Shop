package employee;

import customer.Costumer;

import registration.Registration;
import servis.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import static servis.Constants.ERROR_TYPING;

public class DatabaseEmployers implements Serializable {
    public static final String ENTER_ID= "Введите id сотрудника: ";
    public static final String ID_BUSY= "Индекс занят";
    public static final String NAME_EMPLOYEE= "Имя сотрудника: ";
    public static final String ENTER_CORRECT_NAME= "Введите корректное имя: ";
    public static final String INSTALL_PASSWORD= "Установить пароль: ";
    public static final String ENTER_PASSWORD= "Введите пароль от 8 до 16 символов: ";
    public static final String ASSIGN_POSITION= "Назначить на должность: ";
    public static final String TRY_AGAIN= "что то пошло не так, попробуй ещё раз: ";
    public static final String ASSIGN_SALARY= "Установить зарплату: ";
    public static final String HIRED= " успешно нанят на должность ";
    public static final String FIRED= " уволен!!!!!!";
    public static final String NOT_FOUND = " не найден";

    static ArrayList<ShopEmployee> shopEmployers;
    static Scanner scanner = new Scanner(System.in);

    public static void addEmployers() {
        int id ;
        String password;
        String name;
        String position;
        int salary;
        try {
            System.out.print(ENTER_ID);
            boolean flag;
            do {
                flag = false;
                id = Integer.parseInt(scanner.next());
                for (ShopEmployee p : shopEmployers) {
                    if (p.getId() == id) {
                        System.out.println(ID_BUSY);
                        System.out.print(ENTER_ID);
                        flag = true;
                    }
                }
            } while (flag);
            scanner.nextLine();
            System.out.print(NAME_EMPLOYEE);
            while (!(Registration.chekByConformityNameInRegistration(name = scanner.nextLine()))) {
                System.err.print(ENTER_CORRECT_NAME);
            }
            System.out.print(INSTALL_PASSWORD);
            while (!(Registration.chekByConformityPasswordInRegistration(password = scanner.nextLine()))) {
                System.err.print(ENTER_PASSWORD);
            }
            System.out.print(ASSIGN_POSITION);
            while (!(Registration.chekByConformityNameInRegistration(position = scanner.nextLine()))) {
                System.err.print(TRY_AGAIN);
            }
            System.out.print(ASSIGN_SALARY);
            salary = Integer.parseInt(scanner.next());
            shopEmployers.add(new ShopEmployee(id, password, name, position, salary));
            writingEmployers();
            System.out.println("\n "+name + HIRED + position+"\n");
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(ERROR_TYPING + e);
        }
    }

    public static void addBonus(int bonusCart, int count) {
        for (Costumer c : Registration.costumersRegistration) {
            if (c.getBonusCart().getId() == bonusCart) {
                c.getBonusCart().setCountBonus(c.getBonusCart().getCountBonus() + count);
            }
        }
        Registration.writingCostumerInDatabase();
    }

    public static void deleteEmployerById(int id) {
        Iterator<ShopEmployee> iterator = shopEmployers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                writingEmployers();
                System.out.println(id + FIRED);
                break;
            }
        }
        System.out.println(id + NOT_FOUND);
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
        for (ShopEmployee s : shopEmployers) {
            System.out.println(s.toString());
        }
    }

    public static ArrayList<ShopEmployee> getShopEmployers() {
        return shopEmployers;
    }

    public static void setShopEmployers(ArrayList<ShopEmployee> shopEmployers) {
        DatabaseEmployers.shopEmployers = shopEmployers;
    }
}
