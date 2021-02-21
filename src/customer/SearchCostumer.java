package customer;

import registration.Registration;

import java.util.ArrayList;

public class SearchCostumer {
    public static String searchByLogin(String name){
        ArrayList<Costumer> listSearchName = Registration.readingCostumerInDatabase();
        for (Costumer r : listSearchName ) {
            if (r.getLogin().equalsIgnoreCase(name)) {
                return r.toString();
            }
        }
        return "пользователь не найден";
    }
}
