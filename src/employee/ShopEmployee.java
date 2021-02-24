package employee;

import java.io.Serializable;

/**
 * Класс сотрудник магазина
 * в классе присутствуют геттеры ,сеттеры ,конструкторы ,переопределённый toString
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class ShopEmployee implements Serializable {
    private int id;
    private String password;
    private String name;
    private String position;
    private int salary;

    public ShopEmployee(int id, String password, String name, String position, int salary) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[id: " + id + "] [Имя: " + name + "] [Должность: "
                + position + "] [Зарплата: " + salary + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

