package services;

import com.geekbrains.july.market.julymarket.beans.Basket;
import com.geekbrains.july.market.julymarket.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    private Basket basket;

    @Autowired
    public void createBasket(Basket basket) {
        this.basket = basket;
    }

    public List<Product> showAllBasketProducts() {
        return basket.getBasketProducts();
    }

    public Product getProductById(Long id) {
        return basket.getProductFromBasketById(id);
    }

    public Product addProduct(Product product) {
        basket.addProduct(product);
        return product;
    }

    public void removeProductById(Long id) {
        for (Product p : basket.getBasketProducts()) {
            if (p.getId() == id) {
                basket.removeProduct(p);
            }
        }
    }

    public void removeAll() {
        basket.removeAll();
    }

    public boolean existsById(Long id) {
        return basket.existsById(id);
    }
}
