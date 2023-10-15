package br.com.ada.account.dto;

import br.com.ada.account.enumerator.AccountInvolvementTypeValues;
import lombok.Data;

@Data
public class NewAccountInvolvimentDTO {
    private AccountInvolvementTypeValues accountInvolvementTypeValues;
    private Long accountId;
    private Long partyId;
}
