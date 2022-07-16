package com.example.bookstore.service;


import com.example.bookstore.entity.Accounts;

public interface SignUpService {
    void registerAccount (Accounts.Account account);
    boolean checkExist (String phoneNumber);

    int getLastId ();

 }
