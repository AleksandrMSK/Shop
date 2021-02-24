package customer;

import product.Product;
import product.ProductDatabase;
import registration.Registration;

import java.util.ArrayList;
import java.util.Scanner;

import static servis.AllConstants.COME_BACK;
import static servis.AllConstants.SELECT_ITEM;

/**
 * Класс корзина для товара
 * В классе есть такие сущности нак
 * - Константы
 * - Мутод по добавлению товара в корзину
 * - Метод по выводу содержимого корзины
 * - Метод который расчитывает финальную стоимость товара ,и проверяет возможность оплаты клиентом товара.
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class BoxForProduct {
    static int index;
    public static final String BASKET = "КОРЗИНА";
    public static final String ENTER_INDEX = "Введите индекс товара для добавления в корзину: ";
    public static String SUCCESSFULLY_ADDED = "товар под индексом " + index + " успешно добавлен в корзину";
    public static String SUCCESSFULLY_DELETE = "товар под индексом " + index + " не найден";
    public static final String BASKET_EMPTY = "Корзина пуста";
    public static final String PAY = "1 - оплатить";
    public static final String BASKET_CLEAR = "2 - очистить корзину";
    public static final String RECEIPT = "ТОВАРНЫЙ ЧЕК";
    public static final String WRITE_OFF = "списано бонусов - ";
    public static final String PAID_APP = "итого оплачено - ";
    public static final String REMAINDER_BONUS = "остаток бонусов - ";
    public static final String REMAINDER_MONEY = "статок белок - ";
    public static final String ITEM_MENU = "для завершения опперации вам не хватает ";
    public static final String MONEY = " белок";
    public static final String CLEAR = "корзина очищена";

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
                System.out.println(SUCCESSFULLY_DELETE);
            }
        } catch (NumberFormatException e) {
            System.out.println(SELECT_ITEM + e);
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
                System.out.println(PAY);
                System.out.println(BASKET_CLEAR);
                System.out.println(COME_BACK);
                switch (Integer.parseInt(scanner.next())) {
                    case 1:
                        for (Product p : boxForProduct) {
                            finalPrice += p.getCostProduct();
                        }
                        for (Costumer c : Registration.costumersRegistration) {
                            if (c.getLogin().equalsIgnoreCase(LoginMenu.getLogin())) {
                                if (c.getBonusCart().getCountBonus() > 0 && c.getBonusCart()
                                        .getCountBonus() <= finalPrice) {
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
                                    System.out.println(RECEIPT);
                                    System.out.println(WRITE_OFF + countBonus);
                                    System.out.println(PAID_APP + finalPrice);
                                    System.out.println(REMAINDER_BONUS + c.getBonusCart().getCountBonus());
                                    System.out.println(REMAINDER_MONEY + c.getMoney());
                                } else {
                                    System.out.println(ITEM_MENU + (finalPrice - c.getMoney()) + MONEY);
                                }
                            }
                        }
                        break;
                    case 2:
                        boxForProduct.clear();
                        System.out.println(CLEAR);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println(SELECT_ITEM);
                }
            } else {
                System.out.println(BASKET_EMPTY);
            }
        } catch (NumberFormatException e) {
            System.out.println(SELECT_ITEM + e);
        }
    }
}


