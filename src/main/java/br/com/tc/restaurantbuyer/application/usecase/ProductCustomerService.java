package br.com.tc.restaurantbuyer.application.usecase;

import br.com.tc.restaurantbuyer.application.port.in.ProductCustomerUseCase;
import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductCustomerDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.ProductCustomer;
import br.com.tc.restaurantbuyer.application.port.out.repository.ProductCustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
public class ProductCustomerService implements ProductCustomerUseCase {

    private final ProductCustomerRepository productCustomerRepository;

    //Construtor para testar sugestao de boas praticas de injecao
    @Autowired
    public ProductCustomerService(ProductCustomerRepository productCustomerRepository) {
        Assert.notNull(productCustomerRepository, "ProductCustomerRepository must not be null!");
        this.productCustomerRepository = productCustomerRepository;
    }

    @Override
    public List<ProductCustomerDTO> listAllProductCustomer(Long customerId) {
        List<ProductCustomer> lstProductCustomer = productCustomerRepository.findAllByCustomerId(customerId);
        return lstProductCustomer.stream().map(this::toProductCustomerDTO).toList();
    }

    @Override
    public ProductCustomerDTO createProduct(ProductDTO productDTO, Long customerId, Long productId) {
        log.info("Creating Product Customer {} {}", customerId, productDTO);
        try {
            return toProductCustomerDTO(productCustomerRepository.save(toProductCustomer(productDTO, customerId, productId)));
        } catch (Exception e) {
            log.error("Error saving new User {}", e.getCause());
            throw e;
        }
    }

    /*----------------------- MAPPERS -----------------------*/
    @Override
    public ProductCustomer toProductCustomer(ProductDTO productDTO, Long customerId, Long productId){
        return new ProductCustomer(
                productId,
                customerId,
                0,
                productDTO.maxQuantity(),
                productDTO.maxQuantity(),
                productDTO.obs()
        );
    };

    @Override
    public ProductCustomerDTO toProductCustomerDTO(ProductCustomer productCustomerDTO) {
        return new ProductCustomerDTO(
                productCustomerDTO.getId(),
                productCustomerDTO.getProductId(),
                productCustomerDTO.getCustomerId(),
                productCustomerDTO.getQuantity(),
                productCustomerDTO.getMaxQuantity(),
                productCustomerDTO.getMinQuantity(),
                productCustomerDTO.getObs());
    }
}
