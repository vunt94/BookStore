package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Accounts;
import com.example.bookstore.service.SignUpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService {

    private JAXBParser jaxbParser = new JAXBParser();
    List<Accounts.Account> accountList = jaxbParser.readListAccountFromXML();

    @Override
    public void registerAccount(Accounts.Account newAccount) {
        accountList.add(newAccount);
        jaxbParser.writeAccountToXML(newAccount);
    }

    @Override
    public boolean checkExist(String phoneNumber) {
        for (Accounts.Account acc : accountList) {
            if (phoneNumber.equals(acc.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getLastId() {
        return accountList.get(accountList.size() -1).getID();
    }


}
