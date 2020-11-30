package specifications;

import com.geekbrains.july.market.julymarket.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> findProductByPartTitle(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> findProductByPartTitle(String productName) {

        if (!productName.startsWith("%") && !productName.endsWith("%")) {
            productName = "%" + productName + "%";
        }

        String finalProductName = productName;

        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), finalProductName);
    }
    public static Specification<Product> categoryIdIsEqualTo(Long id) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), id);
    }
}
