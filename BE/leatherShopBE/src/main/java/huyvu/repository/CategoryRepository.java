package huyvu.repository;

import huyvu.model.Category;
import huyvu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
    boolean existsByName(String name);
}
