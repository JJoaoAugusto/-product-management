import product.ProductController;

public class Main {
    public static void main(String[] args) {
        var product = new ProductController();
        product.create("nome-do-produto", 100, 10);
        product.read();
        product.retrieve("");
    }
}