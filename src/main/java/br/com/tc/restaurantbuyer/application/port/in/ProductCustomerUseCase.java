package br.com.tc.restaurantbuyer.application.port.in;

import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductCustomerDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.ProductCustomer;

import java.util.List;

public interface ProductCustomerUseCase {
    List<ProductCustomerDTO> listAllProductCustomer(Long customerId);

    ProductCustomerDTO createProduct(ProductDTO productDTO, Long customerId, Long productId);

    /*----------------------- MAPPERS -----------------------*/
    ProductCustomerDTO toProductCustomerDTO(ProductCustomer productCustomer);

    ProductCustomer toProductCustomer(ProductDTO productDTO, Long customerId, Long productId);


}
