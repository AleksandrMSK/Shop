package product;

import admin.AdminInterface;
import customer.Costumer;
import employee.EmployeeInterface;
import employee.ShopEmployee;
import servis.Constants;
import sun.awt.image.AbstractMultiResolutionImage;

import java.io.*;
import java.util.*;

public class ProductDatabase {
    static ArrayList<Product> productList = readingProductInDatabase();
    static Scanner scanner = new Scanner(System.in);

    public static void recordingProductInDatabase() {
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
        } catch (InputMismatchException e) {
            System.out.println("Введён недопустимый символ, повторите регистрацию: " + e);
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

    public static void writingProductInDatabase() {
        try {
            FileOutputStream fileOS = new FileOutputStream(Constants.PRODUCT_DATABASE);
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
            objectOS.writeObject(productList);
            objectOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getProductOfDatabase() {
        System.out.println("\n+\t+\tТОВАР В НАЛИЧИИ");
        ArrayList<Product> listProduct = readingProductInDatabase();
        for (Product p : listProduct) {
            System.out.println(p.toString());
        }
    }

    public static void sortProductByName() {
        ArrayList<Product> listProduct = readingProductInDatabase();
        Comparator<Product> productComparator = Comparator.comparing(Product::getCostProduct)
                .thenComparing(Product::getNameProduct);
        listProduct.stream().sorted(productComparator).forEach(System.out::println);
    }

    public static void deleteProduct(int index) {
        productList = readingProductInDatabase();
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getIndexProduct() == index) {
                iterator.remove();
                writingProductInDatabase();
                System.out.println("операция прошла успешно");
                AdminInterface.menuForAdministrator();
            }
        }
        System.out.println("упс ,что-то пошло не так");
        AdminInterface.menuForAdministrator();
    }
}
