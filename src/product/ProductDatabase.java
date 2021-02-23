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
    public static ArrayList<Product> productList;
    static Scanner scanner = new Scanner(System.in);

    public static void recordingProductInDatabase() {
        int indexProduct;
        String categoryProduct;
        String nameProduct;
        double costProduct;
        try {
            System.out.print(Constants.ADD_PRODUCT);
            int countAddNewProduct = Integer.parseInt(scanner.next());
            for (int i = 0; i < countAddNewProduct; i++) {
                System.out.print(Constants.ENTER_INDEX);
                boolean flag;
                do {
                    flag = false;
                    indexProduct = Integer.parseInt(scanner.next());
                    for (Product p : productList) {
                        if (p.getIndexProduct() == indexProduct) {
                            System.out.println("индекс занят");
                            System.out.print(Constants.ENTER_INDEX);
                            flag = true;
                        }
                    }
                } while (flag);
                scanner.nextLine();
                System.out.print(Constants.CATEGORY_PRODUCT);
                categoryProduct = scanner.nextLine();
                System.out.print(Constants.NAME_NEW_PRODUCT);
                nameProduct = scanner.next();
                System.out.print(Constants.COST);
                costProduct = Double.parseDouble(scanner.next());
                System.out.print(nameProduct + " стоимостью " + costProduct +
                        " успешно добавлен под индексом " + indexProduct +
                        " в " + categoryProduct + " категорию \n");
                productList.add(new Product(indexProduct, categoryProduct, nameProduct, costProduct));
                writingProductInDatabase();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Введён недопустимый символ: " + e);
        }
    }

    public static ArrayList<Product> readingProductInDatabase() {
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
        System.out.println("\n\t\tТОВАР В НАЛИЧИИ");
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    public static void sortProductByName() {
        Comparator<Product> productComparator = Comparator.comparing(Product::getCostProduct)
                .thenComparing(Product::getNameProduct);
        productList.stream().sorted(productComparator).forEach(System.out::println);
    }

    public static void filterProductByPrice(int start, int end) {
        productList.stream()
                .filter(n -> n.getCostProduct() > start && n.getCostProduct() < end).forEach(System.out::println);
    }

    public static void deleteProduct(int index) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getIndexProduct() == index) {
                iterator.remove();
                writingProductInDatabase();
                System.out.println("Товар под индексом " + index + " удалён");
                break;
            }
        }

    }
}
