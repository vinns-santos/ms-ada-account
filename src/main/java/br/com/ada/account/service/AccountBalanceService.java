package br.com.ada.account.service;

import br.com.ada.account.model.AccountBalance;
import br.com.ada.account.repository.AccountBalanceRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountBalanceService {
    private final AccountBalanceRepository accountBalanceRepository;

    public AccountBalanceService(AccountBalanceRepository accountBalanceRepository) {
        this.accountBalanceRepository = accountBalanceRepository;
    }

    public void saveAccountBalance(AccountBalance accountBalance) {
        accountBalanceRepository.save(accountBalance);
    }
}
