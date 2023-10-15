package br.com.ada.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private AccountType accountType;

    private String accountPurpose;

    @OneToMany
    private Set<AccountBalance> accountBalance;

    private String accountDescription;
}
