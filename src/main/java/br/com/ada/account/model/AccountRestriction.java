package br.com.ada.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AccountRestriction {

    @Id
    @GeneratedValue
    private Long id;

    private String accountRestrictionIdentifier;
    private String restrictionType;
    private String accountRestrictionDescription;

}
