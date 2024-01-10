// Concrete Factory for Games
class GameFactory extends ProductFactory {
    @Override
    Product createProduct(String type) {
        return new Game(type);
    }
}