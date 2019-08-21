package com.controller;

import com.entity.User;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="API Rest - Users")
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/usuarios")
    @ApiOperation(value="Return a user List")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/usuarios/{id}")
    @ApiOperation(value="Return a user")
    public User getUser(@PathVariable(value="id") String id){
        return userService.getUser(id);
    }

    @PostMapping("/usuarios")
    @ApiOperation(value="Add a user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/usuarios/{id}")
    @ApiOperation(value="Update a user")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/usuarios/{id}")
    @ApiOperation(value="Delete a user")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
