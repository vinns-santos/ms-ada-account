package br.com.ada.account.service;

import br.com.ada.account.model.Account;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrqAccountService {
    private final AccountService accountService;
    private final AccountBalanceService accountBalanceService;
    private final AccountTypeService accountTypeService;

    public OrqAccountService(AccountService accountService, AccountBalanceService accountBalanceService
            , AccountTypeService accountTypeService) {
        this.accountService = accountService;
        this.accountBalanceService = accountBalanceService;
        this.accountTypeService = accountTypeService;
    }

    public Account save(Account account) {
        accountTypeService.saveAccountType(account.getAccountType());
        account.getAccountBalance().forEach(accountBalanceService::saveAccountBalance);
        return accountService.saveAccount(account);
    }

    public Optional<Account> getAccount(Long id) {
        return accountService.getAccount(id);
    }

    public void deleteAccount(Long id) {
        accountService.deleteAccount(id);
    }

    public Account updateAccount(Long id, Account accountUpdated) {
        Optional<Account> account = getAccount(id);
        if (account.isPresent()) {
            accountTypeService.saveAccountType(accountUpdated.getAccountType());
            account.get().setAccountType(accountUpdated.getAccountType());
            accountUpdated.getAccountBalance().forEach(accountBalanceService::saveAccountBalance);

            account.get().setAccountPurpose(accountUpdated.getAccountPurpose());
            account.get().setAccountBalance(accountUpdated.getAccountBalance());
            account.get().setAccountDescription(accountUpdated.getAccountDescription());
            return accountService.saveAccount(account.get());
        } else {
            throw new EntityNotFoundException();
        }
    }
}
