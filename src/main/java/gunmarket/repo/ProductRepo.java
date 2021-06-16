package gunmarket.repo;

import gunmarket.model.Brand;
import gunmarket.model.Product;
import gunmarket.model.Type;
import gunmarket.querybuilder.FilterAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long>, FilterAndSortingRepository<Product> {

    Optional<Product> findByProductId(Long productId);

    default void saveOrUpdate(Product product) {
        if (product.getName().isBlank()) return;
        findByBrandAndNameAndType(product.getBrand(), product.getName(), product.getType())
                .ifPresentOrElse(
                        p -> save(product.setProductId(p.getProductId())),
                        () -> save(product)
                );
    }

    Optional<Product> findByBrandAndNameAndType(Brand brand, String name, Type type);
}
