package customer;

import registration.Registration;

/**
 * Класс Поиск
 * метод ищет клиента по логину
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class Search {
    public static final String USER_NOT_FOUND = "пользователь не найден";

    public static String searchByLogin(String name) {
        for (Costumer r : Registration.costumersRegistration) {
            if (r.getLogin().equalsIgnoreCase(name)) {
                return r.toString();
            }
        }
        return USER_NOT_FOUND;
    }
}
