package com.example.bookstore.service;

public interface SignUpService {
    void registerAccount (String userName, String password, String phoneNumber);
    boolean checkExist (String phoneNumber);

 }
