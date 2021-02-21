package customer;

import java.io.Serializable;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountBonus() {
        return countBonus;
    }

    public void setCountBonus(int countBonus) {
        this.countBonus = this.countBonus + countBonus;
    }
}
