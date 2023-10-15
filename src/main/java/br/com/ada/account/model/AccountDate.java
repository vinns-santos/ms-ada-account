package br.com.ada.account.model;

import br.com.ada.account.enumerator.AccountDateTypeValues;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class AccountDate {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private AccountDateTypeValues accountDateType;
    private LocalDate accountDate;
}
