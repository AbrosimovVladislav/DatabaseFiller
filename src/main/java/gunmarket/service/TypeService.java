package gunmarket.service;

import gunmarket.model.Type;
import gunmarket.repo.TypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TypeService {

    private final TypeRepo typeRepo;

    public Optional<Type> findByShowName(String showName) {
        return typeRepo.findByShowName(showName);
    }
}
