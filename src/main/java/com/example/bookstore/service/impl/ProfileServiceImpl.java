package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    private JAXBParser jaxbParser = new JAXBParser();

    @Override
    public boolean checkConfirmPassWord(int userId, String oldPassword) {
        Accounts.Account acc = getAccountByUserName(userId);
        if (acc.getID() == userId) {
            if (acc.getPassword().equals(oldPassword)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void editProfile(Accounts.Account editAccount) {
        List<Accounts.Account> accounts = jaxbParser.readListAccountFromXML();
        for (int i = 0; i < accounts.size(); i++) {
            Accounts.Account acc = accounts.get(i);
            if (acc.getID() == editAccount.getID()) {
                accounts.set(i, editAccount);
                continue;
            }

        }
        jaxbParser.updateAccountXML(new Accounts(accounts));
    }

    @Override
    public Accounts.Account getAccountByUserName(int userId) {
        List<Accounts.Account> accounts = jaxbParser.readListAccountFromXML();
        for (Accounts.Account acc : accounts) {
            if (userId == acc.getID()) {
                return acc;
            }
        }
        return null;
    }
}
