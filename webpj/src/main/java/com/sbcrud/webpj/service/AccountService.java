package com.sbcrud.webpj.service;

import com.sbcrud.webpj.User.User;

public interface AccountService {
    User registerUser(String username, String password);
    User login(String username, String password);
    void changePassword(User user, String newPassword);


}
