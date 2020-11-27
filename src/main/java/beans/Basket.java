package beans;

import com.geekbrains.july.market.julymarket.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> productList;

    public Basket() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public List<Product> getBasketProducts() {
        return productList;
    }

    public Product getProductFromBasketById(Long id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void removeAll() {
        productList.clear();
    }

    public boolean existsById(Long id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
