package customer;

import product.Product;
import product.ProductDatabase;
import servis.Constants;
import java.util.ArrayList;
import java.util.Scanner;

public class BoxForProduct {
    static int index;
    public static final String BASKET = "КОРЗИНА";
    public static final String THANKS_PURCHASE = "Спасибо за покупку:)";
    public static final String PAY = "Спасибо за покупку:)";
    public static final String ENTER_INDEX = "Введите индекс товара для добавления в корзину: ";
    public static final String SUCCESSFULLY_ADDED = "товар под индексом" + index + " успешно добавлен в корзину";
    public static final String BASKET_EMPTY = "Корзина пуста";


    static ArrayList<Product> boxForProduct = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addProductToBox() {
        System.out.print(ENTER_INDEX);
        index = scanner.nextInt();
        scanner.nextLine();
        boolean flag = false;
        for (Product p : ProductDatabase.productList) {
            if (p.getIndexProduct() == index) {
                boxForProduct.add(p);
                System.out.println();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(SUCCESSFULLY_ADDED);
        }
    }

    public static void getProductOfBox() {
        System.out.println(BASKET);
        for (Product p : boxForProduct) {
            System.out.println(p.toString());
        }
    }

    public static void deleteProductOfBox() {
        boolean flag = true;
        if (boxForProduct.size() > 0) {
            getProductOfBox();
            while (flag) {
                System.out.println("1 - оплатить товар");
                System.out.println(Constants.EXIT);
                int enterNum = scanner.nextInt();
                if (enterNum == 1) {
//                boxForProduct.removeAll(boxForProduct);         //Выстрел в голову
                    for (Product b : boxForProduct) {
                        ProductDatabase.deleteProduct(b.getIndexProduct());
                    }
                    boxForProduct.clear();
                    System.out.println(PAY);
                    flag = false;
                }
                if (enterNum == 0) {
                    flag = false;
                } else {
                    System.out.println(Constants.SELECT_ITEM);
                }
            }
        } else {
            System.out.println(BASKET_EMPTY);
        }
    }
}