package gunmarket.repo;

import gunmarket.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
    Brand findByShortName(String shortName);
}
