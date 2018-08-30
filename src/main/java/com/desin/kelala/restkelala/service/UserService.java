package com.desin.kelala.restkelala.service;

import com.desin.kelala.restkelala.entity.User;
import com.desin.kelala.restkelala.response.Answer;

public interface UserService {
    Answer saveUser(User user);
}
