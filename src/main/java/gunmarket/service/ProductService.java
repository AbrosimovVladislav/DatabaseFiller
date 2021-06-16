package gunmarket.service;

import gunmarket.exception.ProductNotFoundException;
import gunmarket.model.Product;
import gunmarket.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product getById(Long id) {
        return productRepo.findByProductId(id).orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> getByIds(List<Long> ids) {
        List<Product> products = getProductsOneByOne(ids);
        if (CollectionUtils.isEmpty(products)) {
            throw new ProductNotFoundException();
        }
        return products;
    }

    @Deprecated
    private List<Product> getProductsOneByOne(List<Long> ids) {
        return ids.stream()
                .map(productRepo::findByProductId)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public void save(Product product) {
        productRepo.saveOrUpdate(product);
    }

}
