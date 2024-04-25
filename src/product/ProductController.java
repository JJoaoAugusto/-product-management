package product;

import java.util.ArrayList;

import exceptions.NegativeException;
import exceptions.NotFoundException;

public class ProductController {
    protected ArrayList<ProductModel> products = new ArrayList<>();

    public void create(ProductModel payload) throws Exception {
        try {
            if(payload.getPriceInCents() <= 0) {
                throw new NegativeException();
            }
            var product = new ProductModel(payload.getBarCode(), payload.getName(), payload.getPriceInCents(), payload.getStock());
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
            if (products.size() <= 0) {
                throw new NotFoundException();
            }
            var price = 0;
            for (ProductModel product: products) {
                if(product.getBarCode() == barCode) {
                price = product.getPriceInCents();
                }
            }
            if(price == 0) {
                throw new NotFoundException();
            }
            System.out.println(price);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
