package com.vksdeveloperblog.ws.api.ResourceServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vksdeveloperblog.ws.api.ResourceServer.response.UserRest;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    Environment env;

    @GetMapping("/status/check")
    public String status(){
        return "working.... on port" + env.getProperty("local.server.port");
    }

    @PreAuthorize("hasAuthority('ROLE_user') or #id == #jwt.subject") 
    // @Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted User with id " + id + " and JWT subject " + jwt.getSubject(); 
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path = "/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserRest("John", "Doe", "b0b287ff-ca64-460e-9540-00b28aef29b4");
    }
}
