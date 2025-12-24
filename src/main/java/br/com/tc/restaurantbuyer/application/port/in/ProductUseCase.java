package br.com.tc.restaurantbuyer.application.port.in;

import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.ProductDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.Product;

import java.util.List;

public interface ProductUseCase {
    List<ProductDTO> listAllProduct(Long id);

    ProductDTO createProduct(ProductDTO productDTO, Long customerId);

    /*----------------------- MAPPERS -----------------------*/
    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
