// Abstract Factory

import GameImplementation.Product;

abstract class ProductFactory {
    abstract Product createProduct(String type);
}