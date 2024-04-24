package product;

import java.util.ArrayList;

import exceptions.NegativeException;
import exceptions.NotFoundException;

public class ProductController {
    protected ArrayList<ProductModel> products = new ArrayList<ProductModel>();

    public void create(String name, int priceInCents, int stock) throws Exception {
        try {
            var product = new ProductModel();
            product.setName(name);
            if(priceInCents > 0) {
                product.setPriceInCents(priceInCents);
            } else {
                throw new NegativeException();
            }
            product.setStock(stock);
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
