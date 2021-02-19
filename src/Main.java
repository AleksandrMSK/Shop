
import customer.CostumerInterface;
import product.ProductDatabase;
import registration.Registration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registration.getDatabaseCostumer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вход в магазин");
        System.out.println("1 - Войти как владелец");
        System.out.println("2 - Войти как покупатель");
        System.out.println("3 - Войти как сотрудник");
        int numberForEnter = scanner.nextInt();
        if (numberForEnter==1){
            ProductDatabase.recordingProductInDatabase();
        }
        if (numberForEnter==2){
            CostumerInterface.interfaceForCostumer();
        }
        if (numberForEnter==3){}
    }
}

