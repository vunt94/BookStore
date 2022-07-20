package com.example.bookstore.service;

import com.example.bookstore.entity.Accounts;

public interface ProfileService {
    boolean checkConfirmPassWord(int userID , String oldPassword);
    void editProfile(Accounts.Account acc);

    Accounts.Account getAccountByUserName (int userName);
}
