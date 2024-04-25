import product.ProductController;

public class Main {
    public static void main(String[] args) throws Exception {
        var product = new ProductController();
        product.create("123456789", "nome-do-produto", 100, 10);
        product.read();
        product.retrieve("123456789");
    }
}