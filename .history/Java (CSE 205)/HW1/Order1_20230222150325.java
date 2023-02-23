package HW1;

/**
 * Homework 01 Polymorphism
 * Student ID # 1221911327
 * 
 * @author Roshan Arun
 *         Lecture Time - 10:30-11:45
 *         Class Description - the abstract class that represents the basic
 *         attributes of an order, root of the hierarchy
 */

public abstract class Order1 {
    // instance variables
    protected String productName = "";
    protected int quantity = 0;
    protected double unitPrice = 0.0;
    protected double totalCost = 0.0;

    // constructor
    public Order1(String name, int num, double price) {
        productName = name;
        quantity = num;
        unitPrice = price;
    }

    /**
     * @return String
     */
    // returns product name
    public String getProductName() {
        return productName;
    }

    // abstract method
    public abstract void computeTotalCost();

    // tostring method
    public String toString() {
        return "Product Name: " + productName + "\nUnit Price: " + unitPrice + "\nTotal Cost: " + totalCost;
    }
}