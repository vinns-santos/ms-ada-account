package br.com.ada.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class AccountPosition {
//tem ligacao com a classe position - precisa identificar qual MS esta essa classe

    @Id
    @GeneratedValue
    private Long id;
    private String accountPositionDefinition;
    private String positionType;
    private Set<String> position;
}
