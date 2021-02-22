package customer;

import product.Product;
import product.ProductDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BoxForProduct {
    static ArrayList<Product> boxForProduct = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int index;

    public static void addProductToBox() {

        System.out.print("Введите индекс товара для добавления в корзину: ");
        index = scanner.nextInt();
        scanner.nextLine();
        boolean flag = false;
        for (Product p : ProductDatabase.productList) {
            if (p.getIndexProduct() == index) {
                boxForProduct.add(p);
                System.out.println("товар под индексом" + index + " успешно добавлен в корзину" );
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Товара под индексом " + index + " не существует" +
                    "");
        }
    }

    public static void getProductOfBox() {
        System.out.println("КОРЗИНА");
        for (Product p : boxForProduct) {
            System.out.println(p.toString());
        }
    }

    public static void deleteProductOfBox() {
        boolean flag = true;
        if (boxForProduct.size() > 0) {
            getProductOfBox();
            while (flag) {
                System.out.println("КОРЗИНА");
                System.out.println("1 - оплатить");
                System.out.println("0 - выйти");
                int enterNum = scanner.nextInt();
                if (enterNum == 1) {
//                boxForProduct.removeAll(boxForProduct);         //Выстрел в голову
                    for (Product b: boxForProduct) {
                        ProductDatabase.deleteProduct(b.getIndexProduct());
                    }
                    boxForProduct.clear();

                    System.out.println("Спасибо за покупку:)");
                    flag = false;
                    CostumerInterface.interfaceForCostumer();
                }
                if (enterNum == 0) {
                    flag = false;
                    CostumerInterface.interfaceForCostumer();
                } else {
                    System.out.println("Выберите соответствующий пункт меню");
                }
            }
        } else {
            System.out.println("Корзина пуста");
        }
    }
}