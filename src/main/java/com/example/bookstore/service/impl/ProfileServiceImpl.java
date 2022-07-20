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
    public boolean checkConfirmPassWord(String userID ,String oldPassword) {
        Accounts.Account acc = getAccountById(userID);
        if(acc.getPassword().equals(oldPassword)){
            return true;
        }
        return false;
    }

    @Override
    public void editProfile(Accounts.Account acc) {

    }

    @Override
    public Accounts.Account getAccountById(String id) {
        for (Accounts.Account acc : accountList) {
            if(id.equals(acc.getID())) {
                return acc;
            }
        }
        return null;
    }
}
