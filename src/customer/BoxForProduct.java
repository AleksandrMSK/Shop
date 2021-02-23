package customer;

import product.Product;
import product.ProductDatabase;
import registration.Registration;

import java.util.ArrayList;
import java.util.Scanner;

public class BoxForProduct {
    static int index;
    public static final String BASKET = "КОРЗИНА";
    public static final String THANKS_PURCHASE = "Спасибо за покупку:)";
    public static final String PAY = "Спасибо за покупку:)";
    public static final String ENTER_INDEX = "Введите индекс товара для добавления в корзину: ";
    public static  String SUCCESSFULLY_ADDED = "товар под индексом " + index + " успешно добавлен в корзину";
    public static final String BASKET_EMPTY = "Корзина пуста";


    static ArrayList<Product> boxForProduct = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addProductToBox() {
        try {
            System.out.print(ENTER_INDEX);
            index = Integer.parseInt(scanner.next());
            scanner.nextLine();
            boolean flag = false;
            for (Product p : ProductDatabase.productList) {
                if (p.getIndexProduct() == index) {
                    boxForProduct.add(p);
                    flag = true;
                    System.out.println(SUCCESSFULLY_ADDED);
                }
            }
            if (!flag) {
                System.out.println("товар под индексом " + index + " не найден");
            }
        }catch (NumberFormatException e){
            System.out.println(e);
        }
    }

    public static void getProductOfBox() {
        System.out.println(BASKET);
        for (Product p : boxForProduct) {
            System.out.println(p.toString());
        }
    }

    public static void calculatesFinalPriseProduct() {
        int finalPrice = 0;
        int countBonus = 0;
        try {
            if (boxForProduct.size() > 0) {
                getProductOfBox();
                System.out.println("1 - оплатить");
                System.out.println("2 - очистить корзину");
                System.out.println("0 - вернуться");
                switch (Integer.parseInt(scanner.next())) {
                    case 1:
                        for (Product p : boxForProduct) {
                            finalPrice += p.getCostProduct();
                        }
                        for (Costumer c : Registration.costumersRegistration) {
                            if (c.getLogin().equalsIgnoreCase(LoginMenu.getLogin())) {
                                if (c.getBonusCart().getCountBonus() > 0 && c.getBonusCart().getCountBonus() <= finalPrice) {
                                    finalPrice -= c.getBonusCart().getCountBonus();
                                    if (finalPrice < 0) {
                                        countBonus = c.getBonusCart().getCountBonus() - Math.abs(finalPrice);
                                        c.getBonusCart().setCountBonus(Math.abs(finalPrice));
                                        finalPrice = 0;

                                    } else {
                                        countBonus = c.getBonusCart().getCountBonus();
                                        c.getBonusCart().setCountBonus(0);
                                    }
                                }
                                if (c.getMoney() >= finalPrice) {
                                    c.setMoney(c.getMoney() - finalPrice);
                                    for (Product b : boxForProduct) {
                                        ProductDatabase.deleteProduct(b.getIndexProduct());
                                    }
                                    boxForProduct.clear();
                                    System.out.println("ТОВАРНЫЙ ЧЕК");
                                    System.out.println("списано бонусов - " + countBonus);
                                    System.out.println("итого оплачено - " + finalPrice);
                                    System.out.println("остаток бонусов - " + c.getBonusCart().getCountBonus());
                                    System.out.println("статок белок - " + c.getMoney());

                                } else {
                                    System.out.println("для завершения опперации вам не хватает " + (finalPrice - c.getMoney()) + " белок");
                                }
                            }
                        }
                        break;
                    case 2:
                        boxForProduct.clear();
                        System.out.println("корзина очищена");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Выбери соответствующий пункт меню");
                }
            } else {
                System.out.println("корзина пуста");
            }
        }catch (NumberFormatException e){
            System.out.println(e);
        }
    }
}


