package br.com.tc.restaurantbuyer.infrastructure.adapter.in.controller;

import br.com.tc.restaurantbuyer.application.port.in.ProductCustomerUseCase;
import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductCustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products_customer/{customerId}")
public class ProductCustomerController {

    private ProductCustomerUseCase productCustomerUseCase;

    @Autowired
    public ProductCustomerController(ProductCustomerUseCase productCustomerUseCase) {
        Assert.notNull(productCustomerUseCase, "ProductUseCase must not be null!");
        this.productCustomerUseCase = productCustomerUseCase;
    }
    @GetMapping
    public List<ProductCustomerDTO> listAllProducts(@PathVariable("customerId") Long customerId) {
        log.debug("Find all products from restaurant {}", customerId);
        return productCustomerUseCase.listAllProductCustomer(customerId);
    }

}
