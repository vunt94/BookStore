package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    private JAXBParser jaxbParser = new JAXBParser();

    @Override
    public boolean login(String phoneNumber, String password) {
        Accounts accounts = jaxbParser.readListAccountFromXML();
        List<Accounts.Account> accountList = accounts.getAccount();
        for (Accounts.Account acc : accountList) {
            if(phoneNumber.equals(acc.getPhoneNumber()) && password.equals(acc.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
