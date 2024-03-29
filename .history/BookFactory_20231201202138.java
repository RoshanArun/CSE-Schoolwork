import GameImplementation.Book;
import GameImplementation.Product;
import GameImplementation.ProductFactory;

class BookFactory extends ProductFactory {
    @Override
    Product createProduct(String type) {
        return new Book(type);
    }
}