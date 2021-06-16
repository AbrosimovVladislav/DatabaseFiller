package gunmarket.repo;

import gunmarket.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepo extends JpaRepository<Type, Long> {
    Optional<Type> findByShowName(String showName);
}
