package GameImplementation;
// Concrete Factory for Games

import Game;
import Product;
import ProductFactory;

class GameFactory extends ProductFactory {
    @Override
    Product createProduct(String type) {
        return new Game(type);
    }
}