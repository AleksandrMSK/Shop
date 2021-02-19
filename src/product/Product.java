package product;

public class Product {
    private int indexProduct;
    private String category;
    private String nameProduct;
    private double costProduct;

    @Override
    public String toString() {
        return "Product " + indexProduct+" category "+category+" nameProduct "
                +nameProduct +" costProduct " + costProduct;
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

    public Product(int indexProduct, String category, String nameProduct, double costProduct) {
        this.indexProduct = indexProduct;
        this.category = category;
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
    }



}
