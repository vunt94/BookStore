package com.example.bookstore.service;

import com.example.bookstore.entity.Accounts;

public interface ProfileService {
    boolean checkConfirmPassWord(String userID , String oldPassword);
    void editProfile(Accounts.Account acc);

    Accounts.Account getAccountById (String id);
}
