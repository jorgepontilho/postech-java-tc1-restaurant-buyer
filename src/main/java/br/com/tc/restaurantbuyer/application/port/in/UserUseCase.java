package br.com.tc.restaurantbuyer.application.port.in;

import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.UserDTO;
import br.com.tc.restaurantbuyer.infrastructure.adapter.out.entities.UserClient;

import java.util.List;

public interface UserUseCase {
    List<UserDTO> listAllUser(String role);

    UserDTO createUser(UserDTO userDTO);

    /*----------------------- MAPPERS -----------------------*/
    UserDTO toUserClientDTO(UserClient userClient);

    UserClient toUserClient(UserDTO userDTO);
}
