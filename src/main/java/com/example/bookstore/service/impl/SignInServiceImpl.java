package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.SignInService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignInServiceImpl implements SignInService {
    private JAXBParser jaxbParser = new JAXBParser();
    Accounts accounts = jaxbParser.readListAccountFromXML();
    List<Accounts.Account> accountList = accounts.getAccount();
    @Override
    public boolean login(String phoneNumber, String password) {
        for (Accounts.Account acc : accountList) {
            if(phoneNumber.equals(acc.getPhoneNumber()) && password.equals(acc.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Accounts.Account getAccount(String phoneNumber, String password) {
        for (Accounts.Account acc : accountList) {
            if(phoneNumber.equals(acc.getPhoneNumber()) && password.equals(acc.getPassword())) {
                return acc;
            }
        }
        return null;
    }
}
