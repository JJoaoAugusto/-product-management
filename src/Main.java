import product.ProductController;

public class Main {
    public static void main(String[] args) {
        var product = new ProductController();
        product.create("codigodebarras1", "nome-do-produto", 100, 10);
        product.create("codigodebarras2", "nome-do-produto", 100, 10);
        product.read();
        product.retrieve("codigodebarras2");
    }
}