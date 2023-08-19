package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
