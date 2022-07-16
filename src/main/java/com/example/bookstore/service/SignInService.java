package com.example.bookstore.service;


import com.example.bookstore.entity.Accounts;

public interface SignInService {
    boolean login (String phoneNumber, String password );

    Accounts.Account getAccount (String phoneNumber, String password);
}
