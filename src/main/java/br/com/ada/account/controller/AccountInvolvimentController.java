package br.com.ada.account.controller;

import br.com.ada.account.model.AccountInvolvement;
import br.com.ada.account.dto.NewAccountInvolvimentDTO;
import br.com.ada.account.service.AccountInvolvementService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/account-involviment")
public class AccountInvolvimentController {

    private final AccountInvolvementService accountInvolvementService;

    public AccountInvolvimentController(AccountInvolvementService accountInvolvementService) {
        this.accountInvolvementService = accountInvolvementService;
    }

    @PostMapping
    public ResponseEntity<AccountInvolvement> createAccountInvolvement(@Valid @RequestBody NewAccountInvolvimentDTO accountInvolvimentDTO) {
        return ResponseEntity.ok(accountInvolvementService.saveAccountInvolviment(accountInvolvimentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AccountInvolvement>> getAccountInvolvement(@PathVariable Long id) {
        Optional<AccountInvolvement> account = accountInvolvementService.getAccountInvolvement(id);
        if (account.isPresent()) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAccountInvolvement(@PathVariable Long id) {
//        Optional<Account> account = accountInvolvementService.getAccount(id);
//        if (account.isPresent()) {
//            accountInvolvementService.deleteAccount(id);
//        }
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Account> updateAccountInvolvement(@PathVariable Long id, @Valid @RequestBody Account account) {
//        return ResponseEntity.ok(accountInvolvementService.updateAccount(id, account));
//    }
}
