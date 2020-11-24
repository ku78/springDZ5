package utils;

import com.geekbrains.july.market.julymarket.entities.Product;
import com.geekbrains.july.market.julymarket.repositories.specifications.ProductSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Getter
public class ProductFilter {
    private Specification<Product> spec;
    private StringBuilder filterDefinition;

    public ProductFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.filterDefinition = new StringBuilder();
        if (map.containsKey("min_price") && !map.get("min_price").isEmpty()) {
            int minPrice = Integer.parseInt(map.get("min_price"));
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
            filterDefinition.append("&min_price=").append(minPrice);
        }
        if (map.containsKey("max_price") && !map.get("max_price").isEmpty()) {
            int maxPrice = Integer.parseInt(map.get("max_price"));
            spec = spec.and(ProductSpecifications.findProductByPartTitle(maxPrice));
            filterDefinition.append("&max_price=").append(maxPrice);
        }
        if (map.containsKey("product_name") && !map.get("product_name").isEmpty()) {
            String productName = map.get("product_name");
            spec = spec.and(ProductSpecifications.findProductByPartTitle(productName));
            filterDefinition.append("&product_name=").append(productName);
        }
        if (map.containsKey("category") && !map.get("category").isEmpty()) {
            Long id = Long.parseLong(map.get("category"));
            spec = spec.and(ProductSpecifications.categoryIdIsEqualTo(id));
            filterDefinition.append("&category=").append(id);
        }
    }
}
