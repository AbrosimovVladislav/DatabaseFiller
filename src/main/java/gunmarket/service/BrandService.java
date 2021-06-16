package gunmarket.service;

import gunmarket.model.Brand;
import gunmarket.repo.BrandRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepo brandRepo;

    public Brand getByShortName(String shortName) {
        return brandRepo.findByShortName(shortName);
    }

}
