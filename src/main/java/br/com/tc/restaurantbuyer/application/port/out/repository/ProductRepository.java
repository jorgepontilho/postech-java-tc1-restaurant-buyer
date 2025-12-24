package br.com.tc.restaurantbuyer.application.port.out.repository;

import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllById(Long id);

    @Query("SELECT p FROM Product p INNER JOIN ProductCustomer pc ON p.id = pc.productId WHERE pc.customerId = ?1")
    List<Product> findAllByCustomerId(Long customerId);

}
