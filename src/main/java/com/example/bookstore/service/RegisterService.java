package com.example.bookstore.service;

import com.example.bookstore.entity.Accounts;

import java.util.List;

public interface RegisterService {
    void registerAccount (String userName, String password, String phoneNumber);
    boolean checkExist (String phoneNumber);

 }
