package br.com.ada.account.service;

import br.com.ada.account.repository.AccountRepository;
import br.com.ada.account.model.Account;
import br.com.ada.account.repository.AccountBalanceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository, AccountBalanceRepository accountBalanceRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}
