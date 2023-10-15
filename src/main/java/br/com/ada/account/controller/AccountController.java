package br.com.ada.account.controller;

import br.com.ada.account.service.OrqAccountService;
import br.com.ada.account.model.Account;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final OrqAccountService orqAccountService;

    public AccountController(OrqAccountService orqAccountService) {
        this.orqAccountService = orqAccountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        return ResponseEntity.ok(orqAccountService.save(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getAccount(@PathVariable Long id) {
        Optional<Account> account = orqAccountService.getAccount(id);
        if (account.isPresent()) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        Optional<Account> account = orqAccountService.getAccount(id);
        if (account.isPresent()) {
            orqAccountService.deleteAccount(id);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @Valid @RequestBody Account account) {
        return ResponseEntity.ok(orqAccountService.updateAccount(id, account));
    }
}
