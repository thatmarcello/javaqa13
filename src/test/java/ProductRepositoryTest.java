import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(2, "Baudolino", 100_000, "Eco");
    Product smartphone1 = new Smartphone(1, "iphone", 70_000, "Apple");
    Product book2 = new Book(3, "Bubbleheads", 10_032_300, "Oruell");

    @Test
    public void shouldSaveProduct() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProductById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.removeById(2);

        Product[] expected = {smartphone1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProducts() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowExcWhileRemovinNotExistinElement() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }

    @Test
    public void shouldFindById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product expected = book1;
        Product actual = repo.findById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);

        Product expected = null;
        Product actual = repo.findById(50);

        Assertions.assertEquals(expected, actual);
    }
}
