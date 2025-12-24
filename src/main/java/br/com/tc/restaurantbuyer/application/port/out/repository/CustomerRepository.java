package br.com.tc.restaurantbuyer.application.port.out.repository;

import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
