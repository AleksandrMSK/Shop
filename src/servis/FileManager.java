package servis;

import employee.DatabaseEmployers;
import product.ProductDatabase;
import registration.Registration;

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
