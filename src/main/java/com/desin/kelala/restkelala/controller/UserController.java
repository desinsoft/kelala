package com.desin.kelala.restkelala.controller;

import com.desin.kelala.restkelala.entity.User;
import com.desin.kelala.restkelala.response.Answer;
import com.desin.kelala.restkelala.response.UserResponse;
import com.desin.kelala.restkelala.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    //@PreAuthorize("hasAuthority('WEB_ADMIN')")
    @PostMapping("user/saveUser")
    public @ResponseBody Answer saveUser(@RequestBody User user){
        LOG.info("[userController][saveUser] -> Inicio");
        Answer answer = userService.saveUser(user);
        LOG.info("[userController][saveUser] -> Fin");
        return answer;
    }
}
