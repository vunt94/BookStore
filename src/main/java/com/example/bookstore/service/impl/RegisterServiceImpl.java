package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.RegisterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private JAXBParser jaxbParser = new JAXBParser();

    @Override
    public void registerAccount(String userName, String password, String phoneNumber) {

    }

    @Override
    public boolean checkExist(String phoneNumber) {
        Accounts accounts = jaxbParser.readListAccountFromXML();
        List<Accounts.Account> accountList = accounts.getAccount();
        for (Accounts.Account acc : accountList) {
            if(phoneNumber.equals(acc.getPhoneNumber())) {
                return true;
            }
        }

        return false;
    }


}
