package br.com.tc.restaurantbuyer.infrastructure.adapter.in.controller;

import br.com.tc.restaurantbuyer.application.port.in.UserUseCase;
import br.com.tc.restaurantbuyer.infrastructure.adapter.in.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private UserUseCase userUseCase;

    @Autowired
    public UserController(UserUseCase userUseCase) {
        Assert.notNull(userUseCase, "UserUseCase must not be null!");
        this.userUseCase = userUseCase;
    }

    @GetMapping
    public List<UserDTO> listAllUsersWithParams(@RequestParam(required = false) String role) {
        //List<UserDTO> exampleUsers = new ArrayList<>();
        //UserDTO userDTO = new UserDTO("Manoel", "mano_el", "admin");
        //exampleUsers.add(userDTO);
        //return exampleUsers;
        log.debug("Find all users");
        return userUseCase.listAllUser(role);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userUseCase.createUser(user);
    }
}
