package model;

public class Product {

    private final String id;
    private final double price;

    public Product(String id, double price){
        this.id = id;
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
}
