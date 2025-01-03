package huyvu.repository;

import huyvu.model.Product;
import huyvu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String> {
}
