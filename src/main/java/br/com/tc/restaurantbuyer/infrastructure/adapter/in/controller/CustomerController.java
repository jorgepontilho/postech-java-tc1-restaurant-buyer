package br.com.tc.restaurantbuyer.infrastructure.adapter.in.controller;

import br.com.tc.restaurantbuyer.application.port.in.CustomerUseCase;
import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerUseCase customerUseCase;

    @Autowired
    public CustomerController(CustomerUseCase customerUseCase) {
        Assert.notNull(customerUseCase, "CustomerUseCase must not be null!");
        this.customerUseCase = customerUseCase;
    }

    @GetMapping
    public List<CustomerDTO> listAllCustomers() {
        log.debug("Find all customers  ");
        return customerUseCase.listAllCustomers();
    }

    @PostMapping
    public CustomerDTO createProduct(@RequestBody CustomerDTO customerDTO) {
        return customerUseCase.createCustomer(customerDTO);
    }
}
