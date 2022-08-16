import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product smartphone1 = new Smartphone(1, "iphone", 70_000, "Apple");
    Product book1 = new Book(2, "Baudolino", 100_000, "Eco");
    Product book2 = new Book(3, "Bubbleheads", 10_032_300, "Oruell");
    Product book3 = new Book(4, "Baudolino", 42_000, "Eco");


    @Test
    public void shouldAddProduct() {
        manager.add(smartphone1);
        manager.add(book1);

        Product[] expected = {smartphone1, book1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMatches() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book3);

        boolean expected = true;
        boolean actual = manager.matches(book1, "Baudolino");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowNoMatches() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book3);

        boolean expected = false;
        boolean actual = manager.matches(book1, "Apple");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfTwoProducts() {

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Baudolino");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfOneProduct() {

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("iphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfZeroProducts() {

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Нет такого товара");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSetNameOfBook() {
        Book book = new Book(1, "Text2", 12_000, "Oreh");

        book.setName("Text1");

        String expected = "Text1";
        String actual = book.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNameOfBook() {
        Book book = new Book(1, "Text2", 12_000, "Oreh");

        book.getName();

        String expected = "Text2";
        String actual = book.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNameOfSmartphone() {
        Smartphone phone = new Smartphone(1, "samsung", 12_000, "China");

        phone.setName("Text1");

        String expected = "Text1";
        String actual = phone.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNameOfSmartphone() {
        Smartphone phone = new Smartphone(1, "samsung", 12_000, "China");
        phone.getName();

        String expected = "samsung";
        String actual = phone.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetAuthor() {
        Book book = new Book(1, "Text2", 12_000, "Oreh");
        book.setAuthor("Anton");

        String expected = "Anton";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetAuthor() {
        Book book = new Book(1, "Text2", 12_000, "Oreh");

        String expected = "Oreh";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetProducer() {
        Smartphone phone = new Smartphone(1, "samsung", 12_000, "China");
        phone.setProducer("Anton");

        String expected = "Anton";
        String actual = phone.getProducer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetProducer() {
        Smartphone phone = new Smartphone(1, "samsung", 12_000, "China");

        String expected = "China";
        String actual = phone.getProducer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetIdOfProduct() {
        Product product = new Product(5, "Stuff", 19_000);

        product.setId(9);

        int expected = 9;
        int actual = product.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCostOfProduct() {
        Product product = new Product(5, "Stuff", 19_000);

        int expected = 19_000;
        int actual = product.getCost();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetCostOfProduct() {
        Product product = new Product(5, "Stuff", 19_000);

        product.setCost(15_000);

        int expected = 15_000;
        int actual = product.getCost();

        Assertions.assertEquals(expected, actual);
    }

}

