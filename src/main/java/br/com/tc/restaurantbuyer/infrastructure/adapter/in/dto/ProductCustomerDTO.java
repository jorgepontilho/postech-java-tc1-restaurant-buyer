package br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto;

public record ProductCustomerDTO(
        Long id,
        Long productId,
        Long customerId,
        Integer quantity,
        Integer maxQuantity,
        Integer minQuantity,
        String obs) {
}

