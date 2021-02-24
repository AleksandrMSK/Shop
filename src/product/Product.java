package product;

import java.io.Serializable;

/**
 * Класс товар
 * в классе реализованы геттеры ,сеттеры ,конструктор ,так же переопределён toString
 *
 * @author Aleksandr Moskalchuk
 * @version 1.0
 */
public class Product implements Serializable {
    private int indexProduct;
    private String category;
    private String nameProduct;
    private double costProduct;

    public Product(int indexProduct, String category, String nameProduct, double costProduct) {
        this.indexProduct = indexProduct;
        this.category = category;
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
    }

    public int getIndexProduct() {
        return indexProduct;
    }

    public void setIndexProduct(int indexProduct) {
        this.indexProduct = indexProduct;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(double costProduct) {
        this.costProduct = costProduct;
    }

    @Override
    public String toString() {
        return "[индекс: " + indexProduct + "] [категория: " + category + "] [модель "
                + nameProduct + "] [стоимость " + costProduct + "]";

    }
}
