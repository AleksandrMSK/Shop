package servis;

public abstract class AllConstants {
    //регулярки
    public static final String REGEX_NAME = "[A-z||А-я]+";
    public static final String REGEX_LOGIN = "\\w+";
    public static final String REGEX_PASSWORD = "[.||\\S]{8,16}";
    public static final String REGEX_BONUS = "\\d{6}";
    // Названия файлов в сиреолизации
    public static final String PRODUCT_DATABASE = "product.bin";
    public static final String COSTUMER_DATABASE = "databaseCostumer.bin";
    public static final String EMPLOYERS_DATABASE = "employers.bin";

    public static final String ENTER_LOGIN = "Введите логин: ";
    public static final String ENTER_PASSWORD = "Введите пароль: ";
    public static final String MISTAKE_LOGIN = "Не верный логин или мароль :( ";

    public static final String ADD_PRODUCT = "Сколько позиций товара вы хотите добавить:  ";
    public static final String ENTER_INDEX = "Введите индекс нового устройства: ";
    public static final String CATEGORY_PRODUCT = "Введите категорию нового устройства: ";
    public static final String NAME_NEW_PRODUCT = "Введите название нового товара: ";
    public static final String COST = "Введите стоимость товара: ";
    public static final String ENTER = "ввод: ";
    public static final String EXIT = "0 - выйти";
    public static final String COME_BACK = "0 - вернуться";
    public static final String SELECT_ITEM = "Выберите соответствующий пункт меню";
    public static final String SORT_BY_PRICE = "1 - отсортировать по цене";
    public static final String SORT_BY_NAME = "1 - отсортировать по имени";
    public static final String ERROR_TYPING = "Введён недопустимый символ, повторите попытку ";
    public static final String INDEX_BUSY = "Индекс занят";


    public static final String DATABASE_COSTUMERS = "БАЗА ДАННЫХ КЛИЕНТОВ";




}
