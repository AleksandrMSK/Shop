package product;

import servis.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductDatabase {
    public static void recordingProductInDatabase() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = readingProductInDatabase();
        int indexProduct;
        String categoryProduct;
        String nameProduct;
        double costProduct;
        try {
            System.out.print(Constants.ADD_PRODUCT);
            int countAddNewProduct = scanner.nextInt();
            for (int i = 0; i < countAddNewProduct; i++) {
                System.out.print(Constants.ENTER_INDEX);
                indexProduct = scanner.nextInt();
                scanner.nextLine();
                System.out.print(Constants.CATEGORY_PRODUCT);
                categoryProduct = scanner.nextLine();
                System.out.print(Constants.NAME_NEW_PRODUCT);
                nameProduct = scanner.next();
                System.out.print(Constants.COST);
                costProduct = scanner.nextDouble();
                System.out.print(nameProduct + " стоимостью " + costProduct +
                        " успешно добавлен под индексом " + indexProduct +
                        " в" + categoryProduct + " категорию ");
                productList.add(new Product(indexProduct, categoryProduct, nameProduct, costProduct));
            }
            FileOutputStream fileOS = new FileOutputStream(Constants.PRODUCT_DATABASE);
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
            objectOS.writeObject(productList);
            objectOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Product> readingProductInDatabase() {
        try {
            FileInputStream fileIS = new FileInputStream(Constants.PRODUCT_DATABASE);
            ObjectInputStream objectIS = new ObjectInputStream(fileIS);
            ArrayList<Product> product = (ArrayList<Product>) objectIS.readObject();
            objectIS.close();
            return product;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void getProductOfDatabase() {
        System.out.println("             Перечень товара");
        ArrayList<Product> listProduct = readingProductInDatabase();
        for (Product p : listProduct) {
            System.out.println(p.toString());
        }
    }

    public static void sortProductByPrice(){
        ArrayList<Product> listProduct = readingProductInDatabase();
        Comparator<Product> productComparator = Comparator.comparing(Product::getCostProduct)
                .thenComparing(Product::getNameProduct);
        listProduct.stream().sorted(productComparator).forEach(System.out::println);

    }
}
