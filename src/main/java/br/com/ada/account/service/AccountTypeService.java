package br.com.ada.account.service;

import br.com.ada.account.enumerator.AccountTypeValues;
import br.com.ada.account.model.AccountType;
import br.com.ada.account.repository.AccountTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeService(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public void saveAccountType(AccountType accountType) {
        validate(accountType);
        accountTypeRepository.save(accountType);
    }

    private void validate(AccountType accountType) {
        if (!AccountTypeValues.PAYMENT_ACCOUNT.equals(accountType.getAccountTypeValues()))
            throw new IllegalArgumentException(String.format(
                    "No momento o único tipo de conta que trabalhamos é %s", AccountTypeValues.PAYMENT_ACCOUNT));
    }
}
