package br.com.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.project.model.User;
import br.com.project.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
      
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> findBayId(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User userCreated = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        	.path("/{id}")
            .buildAndExpand(userCreated.getId())
            .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        User userUpdate = userService.update(user, id);        
        return ResponseEntity.ok().body(userUpdate);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody User user, @PathVariable Long id) {
        userService.delete(user, id);
        return ResponseEntity.noContent().build();
    }
}
