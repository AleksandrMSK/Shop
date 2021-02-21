package customer;

import java.io.Serializable;

public class Costumer implements Serializable {
    private String name;
    private int age;
    private BonusCart bonusCart;
    private String login;
    private String password;

    public Costumer(String name, int age, String login, String password) {
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public Costumer(String name, int age, BonusCart bonusCart, String login, String password) {
        this.name = name;
        this.age = age;
        this.bonusCart = bonusCart;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "[Имя: " + name + "] [Возраст: " + age + "] [Номер бонусной карты: "
                + bonusCart + "] [Логин: " + login+ "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BonusCart getBonusCart() {
        return bonusCart;
    }

    public void setBonusCart(BonusCart bonusCart) {
        this.bonusCart = bonusCart;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
