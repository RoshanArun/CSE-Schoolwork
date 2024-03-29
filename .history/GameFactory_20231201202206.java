// Concrete Factory for Games

import GameImplementation.Game;
import GameImplementation.Product;
import GameImplementation.ProductFactory;

class GameFactory extends ProductFactory {
    @Override
    Product createProduct(String type) {
        return new Game(type);
    }
}