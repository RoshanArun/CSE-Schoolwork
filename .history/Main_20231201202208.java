// Main class to run the program

import GameImplementation.BookFactory;
import GameImplementation.GameFactory;
import GameImplementation.Product;
import GameImplementation.ProductFactory;

class Main {
    public static void main(String[] args) {
        ProductFactory factory = getProductFactory("book");
        Product book = factory.createProduct("fiction");
        // Use the created product 'book'
    }

    static ProductFactory getProductFactory(String type) {
        if (type.equalsIgnoreCase("book")) {
            return new BookFactory();
        } else if (type.equalsIgnoreCase("game")) {
            return new GameFactory();
        } else {
            throw new IllegalArgumentException("Unknown factory type");
        }
    }
}