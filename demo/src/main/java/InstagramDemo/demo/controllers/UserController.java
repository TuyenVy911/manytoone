package InstagramDemo.demo.controllers;

import InstagramDemo.demo.models.User;
import InstagramDemo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//http://localhost:9090/instagram/user/register
@RestController
@RequestMapping("/instagram")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //getAllUsers http://localhost:9090/instagram/user
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

//    //find by username
//    @GetMapping("/user/{username}/{password}")
//    public Optional<User> findByUsername(@PathVariable String username){
//        return userRepository.findByUsername(username);
//    }


    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping("/user/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password){
        return (User) userRepository.findByUsernameAndPassword(username, password);
    }


    //update user
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") int userId,
            @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));

        user.setUsername(userDetails.getUsername());
        user.setFullname(userDetails.getFullname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    //delete user
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(
            @PathVariable(value = "id") int userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
