package product;

import servis.AllConstants;

import java.io.*;
import java.util.*;

import static servis.AllConstants.ERROR_TYPING;
import static servis.AllConstants.INDEX_BUSY;

/**
 * Класс база данных товара
 * в классе присутствуют методы
 * - сериализация (чтение / запись файло)
 * - вывод на экран товара
 * - сортировка товара по названию
 * - фильтр товара по веведённым данным
 * - удаление товара из базы данных
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class ProductDatabase {
    public static final String PRODUCT_INDEX = "Товар под индексом ";
    public static final String PRODUCT_IN_STOCK = "\n\tТОВАР В НАЛИЧИИ";
    public static final String DELETE = " удалён";
    public static final String PRICE = " стоимостью ";
    public static final String SUCCESSFULLY_ADDED = " успешно добавлен под индексом ";
    public static final String IN = " в ";
    public static final String CATEGORY = " категорию \n";
    public static ArrayList<Product> productList;
    static Scanner scanner = new Scanner(System.in);

    public static void recordingProductInDatabase() {
        int indexProduct;
        String categoryProduct;
        String nameProduct;
        double costProduct;
        try {
            System.out.print(AllConstants.ADD_PRODUCT);
            int countAddNewProduct = Integer.parseInt(scanner.next());
            for (int i = 0; i < countAddNewProduct; i++) {
                System.out.print(AllConstants.ENTER_INDEX);
                boolean flag;
                do {
                    flag = false;
                    indexProduct = Integer.parseInt(scanner.next());
                    for (Product p : productList) {
                        if (p.getIndexProduct() == indexProduct) {
                            System.out.println(INDEX_BUSY);
                            System.out.print(AllConstants.ENTER_INDEX);
                            flag = true;
                        }
                    }
                } while (flag);
                scanner.nextLine();
                System.out.print(AllConstants.CATEGORY_PRODUCT);
                categoryProduct = scanner.nextLine();
                System.out.print(AllConstants.NAME_NEW_PRODUCT);
                nameProduct = scanner.next();
                System.out.print(AllConstants.COST);
                costProduct = Double.parseDouble(scanner.next());
                System.out.print(nameProduct + PRICE + costProduct + SUCCESSFULLY_ADDED + indexProduct +
                        IN + categoryProduct + CATEGORY);
                productList.add(new Product(indexProduct, categoryProduct, nameProduct, costProduct));
                writingProductInDatabase();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println(ERROR_TYPING + e);
        }
    }

    public static ArrayList<Product> readingProductInDatabase() {
        try {
            FileInputStream fileIS = new FileInputStream(AllConstants.PRODUCT_DATABASE);
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
            FileOutputStream fileOS = new FileOutputStream(AllConstants.PRODUCT_DATABASE);
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
            objectOS.writeObject(productList);
            objectOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getProductOfDatabase() {
        System.out.println(PRODUCT_IN_STOCK);
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
                System.out.println(PRODUCT_INDEX + index + DELETE);
                break;
            }
        }
    }
}
