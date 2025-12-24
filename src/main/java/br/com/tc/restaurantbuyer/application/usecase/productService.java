package br.com.tc.restaurantbuyer.application.usecase;

import br.com.tc.restaurantbuyer.application.port.in.ProductUseCase;
import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.Product;
import br.com.tc.restaurantbuyer.application.port.out.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
public class productService implements ProductUseCase {

    private final ProductRepository productRepository;
    private final ProductCustomerService productCustomerService;

    @Autowired
    public productService(ProductRepository productRepository, ProductCustomerService productCustomerService) {
        Assert.notNull(productRepository, "ProductRepository must not be null!");
        Assert.notNull(productCustomerService, "ProductCustomerService must not be null!");
        this.productRepository = productRepository;
        this.productCustomerService = productCustomerService;
    }

    @Override
    public List<ProductDTO> listAllProduct(Long id) {
        List<Product> lstProducts = productRepository.findAllByCustomerId(id);
        return lstProducts.stream().map(this::toProductDTO).toList();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, Long customerId) {
        log.info("Creating Product {} ", productDTO.toString());
        try {
            Product product = productRepository.save(toProduct(productDTO));
            //productDTO = toProductDTO(product);
            productCustomerService.createProduct(productDTO, customerId, product.getId());

        } catch (Exception e) {
            log.error("Error saving new User {}", e.getCause());
            throw e;
        }
        return productDTO;
    }


    /*----------------------- MAPPERS -----------------------*/
    @Override
    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getUnits(),
                null,
                null,
                product.getCategory(),
                null);
    }

    @Override
    public Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.name(),
                productDTO.units(),
                productDTO.category());
    }
}
