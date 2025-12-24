package br.com.tc.restaurantbuyer.infrastructure.adapter.in.controller;

import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductDTO;
import br.com.tc.restaurantbuyer.application.port.in.ProductUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products/{customerId}")
public class ProductController {

    private ProductUseCase productUseCase;

    @Autowired
    public ProductController(ProductUseCase productUseCase) {
        Assert.notNull(productUseCase, "ProductUseCase must not be null!");
        this.productUseCase = productUseCase;
    }
    @GetMapping
    public List<ProductDTO> listAllProducts(@PathVariable("customerId") Long customerId) {
        log.debug("Find all products from restaurant {}", customerId);
        return productUseCase.listAllProduct(customerId);
    }

    @PostMapping
    public ProductDTO createProduct(@PathVariable("customerId") Long customerId,
                                    @RequestBody ProductDTO productDTO) {
        return productUseCase.createProduct(productDTO, customerId);
    }
}
