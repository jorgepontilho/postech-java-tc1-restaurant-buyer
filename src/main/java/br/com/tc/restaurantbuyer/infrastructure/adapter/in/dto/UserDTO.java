package br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto;


public record UserDTO(
        Long id,
        String login,
        String role,
        String customer) {
}
