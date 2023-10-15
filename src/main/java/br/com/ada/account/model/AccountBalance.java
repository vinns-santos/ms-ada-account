package br.com.ada.account.model;

import br.com.ada.account.enumerator.AccountBalanceTypeValues;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class AccountBalance {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal accountBalance; //Era pra ser do tipo Amount, mas nao encontrei essa classe no diagrama
    @Enumerated(EnumType.STRING)
    private AccountBalanceTypeValues accountBalanceType;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate accountBalanceDate;
}
