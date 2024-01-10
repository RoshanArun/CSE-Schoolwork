import Book;
import Product;
import ProductFactory;

package GameImplementation;
class BookFactory extends ProductFactory {
    @Override
    Product createProduct(String type) {
        return new Book(type);
    }
}