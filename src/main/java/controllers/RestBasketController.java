package controllers;

import com.geekbrains.july.market.julymarket.entities.Product;
import com.geekbrains.july.market.julymarket.entities.dtos.ProductDto;
import com.geekbrains.july.market.julymarket.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.julymarket.services.BasketService;
import com.geekbrains.july.market.julymarket.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class RestBasketController {
    private BasketService basketService;

    @Autowired
    public RestBasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    public List<Product> getAllProductsFromBasket() {
        return basketService.showAllBasketProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProducts(@PathVariable Long id) {
        if (!basketService.existsById(id)) {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
        return new ResponseEntity<>(basketService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public String deleteAllProducts() {
        basketService.removeAll();
        return "OK";
    }

    @DeleteMapping("/{id}")
    public String deleteOneProducts(@PathVariable Long id) {
        basketService.removeProductById(id);
        return "OK";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNewProduct(@RequestBody Product product) {
        return basketService.addProduct(product);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(ProductNotFoundException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }
}
