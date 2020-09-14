package com.lovinder.editprofile.endpoint;

import com.lovinder.editprofile.domain.User;
import com.lovinder.editprofile.firebase.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.sql.Timestamp;
import java.util.concurrent.ExecutionException;

@RestController
public class UserEndpoint {
    @Autowired
    FireBaseService service;

    @PostMapping(value = "/createUser", produces = "application/json;charset=UTF-8")
    public String createUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return service.saveUserInfor(user);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestHeader String id) {
        return service.getUser(id);
    }


    @PostMapping(value = "/updateUser", produces = "application/json;charset=UTF-8")
    public String updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        return service.updateUser(user);
    }
}
