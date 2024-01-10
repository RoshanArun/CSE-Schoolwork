package GameImplementation;
// Abstract Factory

import Product;

abstract class ProductFactory {
    abstract Product createProduct(String type);
}