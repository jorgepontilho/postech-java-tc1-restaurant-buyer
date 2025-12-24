package br.com.tc.restaurantbuyer.application.port.in;

import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.CustomerDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.Customer;

import java.util.List;

public interface CustomerUseCase {
    List<CustomerDTO> listAllCustomers();

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    /*----------------------- MAPPERS -----------------------*/
    CustomerDTO toCustomerDTO(Customer customer);

    Customer toCustomer(CustomerDTO customerDTO);
}
