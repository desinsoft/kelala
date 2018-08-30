package com.desin.kelala.restkelala.response;

import com.desin.kelala.restkelala.entity.User;

public class UserResponse {
    Answer answer;
    User user;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
