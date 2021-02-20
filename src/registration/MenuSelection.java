package registration;

public enum MenuSelection {
    VIEW_PRODUCT("Просмтреть товар"),
    BUY_PRODUCT("Купить товар"),
    GET_BONUS_CART("Получить бонусную карту"),
    EXIT("Выйти");


    MenuSelection(String s) {
        System.out.println(s);
    }
}
