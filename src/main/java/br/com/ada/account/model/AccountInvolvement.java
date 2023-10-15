package br.com.ada.account.model;

import br.com.ada.account.enumerator.AccountInvolvementTypeValues;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class AccountInvolvement {

      @Id
      @GeneratedValue
      private Long id;

      @Enumerated(EnumType.STRING)
      private AccountInvolvementTypeValues accountInvolvementTypeValues;
      @OneToOne
      private Account accountReference;
      private Long partyId;
}
