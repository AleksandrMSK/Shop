package servis;

public abstract class Constants {

    public static final String REGEX_NAME = "[A-z||А-я]+";
    public static final String REGEX_LOGIN = "\\w+";
    public static final String REGEX_PASSWORD = "[.||\\S]{8,16}";
    public static final String REGEX_BONUS = "\\d{6}";
    public static final String PRODUCT_DATABASE = "product.bin";
    public static final String COSTUMER_DATABASE = "databaseCostumer.bin";
    public static final String EMPLOYERS_DATABASE = "employers.bin";

    public static final String ADD_PRODUCT = "Сколько позиций товара вы хотите добавить:  ";
    public static final String ENTER_INDEX = "Введите индекс нового устройства: ";
    public static final String CATEGORY_PRODUCT = "Введите категорию нового устройства: ";
    public static final String NAME_NEW_PRODUCT = "Введите название нового товара: ";
    public static final String COST = "Введите стоимость товара: ";
    public static final String ENTER = "ввод: ";

    public static final String LINE = "========================================================================";

}
