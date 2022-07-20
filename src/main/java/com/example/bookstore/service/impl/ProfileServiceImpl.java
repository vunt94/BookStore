package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ProfileServiceImpl implements ProfileService {
    private JAXBParser jaxbParser = new JAXBParser();
    Accounts accounts = jaxbParser.readListAccountFromXML();

    List<Accounts.Account> accountList = accounts.getAccount();

    @Override
    public boolean checkConfirmPassWord(String userName ,String oldPassword) {
        Accounts.Account acc = getAccountById(userName);
        if(acc.getPassword().equals(oldPassword)){
            return true;
        }
        return false;
    }

    @Override
    public void editProfile(Accounts.Account acc) {

    }

    @Override
    public Accounts.Account getAccountById(String userName) {
        for (Accounts.Account acc : accountList) {
            if(userName.equals(acc.getUserName())) {
                return acc;
            }
        }
        return null;
    }
}
