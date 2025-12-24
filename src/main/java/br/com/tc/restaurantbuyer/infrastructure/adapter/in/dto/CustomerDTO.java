package br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto;

import java.math.BigDecimal;

public record CustomerDTO(
        Long id,
        String name,
        String cnpj,
        BigDecimal authorizedBudget
) {
}
