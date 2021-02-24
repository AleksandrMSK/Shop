package servis;

import employee.DatabaseEmployers;
import product.ProductDatabase;
import registration.Registration;

/**
 * Системный класс
 * - Чтение с фалов
 * - Запись в файл
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class FileManager {

    public static void initialization() {
        DatabaseEmployers.setShopEmployers(DatabaseEmployers.readingEmployers());
        ProductDatabase.productList = ProductDatabase.readingProductInDatabase();
        Registration.costumersRegistration = Registration.readingCostumerInDatabase();
    }

    public static void writeToDataBase() {
        DatabaseEmployers.writingEmployers();
        ProductDatabase.writingProductInDatabase();
        Registration.writingCostumerInDatabase();
    }
}
