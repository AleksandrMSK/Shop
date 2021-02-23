package customer;

import registration.Registration;


public class Search {
    public static final String USER_NOT_FOUND = "пользователь не найден";
    public static String searchByLogin(String name){
        for (Costumer r : Registration.costumersRegistration ) {
            if (r.getLogin().equalsIgnoreCase(name)) {
                return r.toString();
            }
        }
        return USER_NOT_FOUND;
    }
}
