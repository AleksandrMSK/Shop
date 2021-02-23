package customer;

import registration.Registration;
import java.util.ArrayList;

public class SearchCostumer {
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
