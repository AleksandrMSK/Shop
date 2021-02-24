package customer;

import java.io.Serializable;
/**
 * Класс бонусная карта с геттерами , сетерами и т.д.
 * @author Aleksandr Moskalchuk
 * @version 1.0*/
public class BonusCart implements Serializable {
    private int id;
    private int countBonus;

    @Override
    public String toString() {
        return id + " " + "на карте " + countBonus + " бонусов ";
    }

    public BonusCart(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCountBonus() {
        return countBonus;
    }

    public void setCountBonus(int countBonus) {
        this.countBonus = countBonus;
    }
}
