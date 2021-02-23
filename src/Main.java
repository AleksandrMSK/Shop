
import admin.AdminInterface;
import customer.CostumerInterface;
import customer.LoginMenu;
import employee.EmployeeInterface;
import product.Product;
import product.ProductDatabase;
import registration.Registration;
import servis.Constants;
import servis.FileManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        FileManager.initialization();
        while (true) {
            try {
                System.out.println("1 - Войти как владелец");
                System.out.println("2 - Войти как покупатель");
                System.out.println("3 - Войти как сотрудник");
                System.out.println("0 - Выйти");
                int numberForEnter = Integer.parseInt(scanner.next());
                if (numberForEnter == 1) AdminInterface.menuForAdministrator();
                if (numberForEnter == 2) CostumerInterface.interfaceForCostumer();
                if (numberForEnter == 3) EmployeeInterface.getMenuForEmployee();
                if (numberForEnter == 0) {
                    FileManager.writeToDataBase();
                    System.exit(0);
                }

            }catch (NumberFormatException e){
                System.out.println("Неверный символ: "+e);
            }
        }
    }
}

