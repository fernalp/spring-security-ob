package comfernandoalmanza.jwtspringsecurity.controller;

import comfernandoalmanza.jwtspringsecurity.entities.User;
import comfernandoalmanza.jwtspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/api/users")
    public ResponseEntity<User> create(@RequestBody User user, @RequestHeader HttpHeaders headers){

        if (user.getId() != null){
            System.out.println("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }

        User result = repository.save(user);
        return ResponseEntity.ok(result);

    }
}
