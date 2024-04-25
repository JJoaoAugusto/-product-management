package product;

import java.util.ArrayList;

import exceptions.NegativeException;
import exceptions.NotFoundException;

public class ProductController {
    protected ArrayList<ProductModel> products = new ArrayList<>();

    public void create(String barCode, String name, int priceInCents, int stock) throws Exception {
        try {
            if(priceInCents <= 0) {
                throw new NegativeException();
            }
            var product = new ProductModel(barCode, name, priceInCents, stock);
            products.add(product);
            System.out.println("Produto " + product.getName() + " foi adicionado com sucesso!");
        } catch (NegativeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void read() throws Exception {
        try {
            if (products.size() > 0) {
                System.out.println(products);
            } else {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void retrieve(String barCode) throws Exception {
        try {
            if (products.size() > 0) {
                var product = products.stream().filter(p -> p.getBarCode().equals(barCode)).findFirst();
                System.out.println(product);
            } else {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
