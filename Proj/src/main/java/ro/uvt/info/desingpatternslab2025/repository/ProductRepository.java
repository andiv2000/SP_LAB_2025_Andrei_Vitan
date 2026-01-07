package ro.uvt.info.desingpatternslab2025.repository;

import ro.uvt.info.desingpatternslab2025.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
