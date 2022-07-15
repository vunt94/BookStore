package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.RegisterService;

import java.util.List;

public class RegisterServiceImpl implements RegisterService {

    private JAXBParser jaxbParser = new JAXBParser();

    @Override
    public void registerAccount(String userName, String password, String phoneNumber) {

    }

    @Override
    public boolean checkExist(String phoneNumber) {
        Accounts accounts = jaxbParser.readListAccountFromXML();
        System.out.println(accounts);
        return false;
    }


}
