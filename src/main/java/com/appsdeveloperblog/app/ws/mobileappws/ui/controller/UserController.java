package com.appsdeveloperblog.app.ws.mobileappws.ui.controller;

import com.appsdeveloperblog.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

@RestController
@RequestMapping("/users")//http://localhost:8080/users/METHODS
public class UserController {
    @GetMapping()
    public String getUser(@RequestParam (value="page", defaultValue="1") int page,
                            @RequestParam(value="limit", defaultValue="50") int limit,
                            @RequestParam(value="sort", defaultValue= "desc", required= false) String sort) {
        return "get user was called with page = " +page + " and limit= "+ limit + " ans sort = " + sort;
    }

    @GetMapping(path="/{userId}",
            produces= {
            MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String userId) {
        UserRest returnValue= new UserRest();
        returnValue.setEmail("test@test.com");
        returnValue.setFirstName("Sergey");
        //returnValue.setUserId();
        returnValue.setLastName("Kargopolav");

       // return "get user was called= " +userId;
        return returnValue;
    }

    @PostMapping
    public String createUser() {
        return " Create user was called";
    }
    @PutMapping
    public String updateUser() {
        return " update user was called";
    }
    @DeleteMapping
    public String deleteUser() {
        return " delete user was called";
    }
}
