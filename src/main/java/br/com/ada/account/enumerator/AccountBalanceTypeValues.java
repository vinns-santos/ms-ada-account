package br.com.ada.account.enumerator;

import lombok.Getter;

@Getter
public enum AccountBalanceTypeValues {
    OPENING_BALANCE,
    CLOSING_BALANCE,
    CURRENT_BALANCE,
    AVAILABLE_BALANCE,
    LEDGER_BALANCE,
    RESERVE_BALANCE,
    FREE_BALANCE,
    PRINCIPAL_BALANCE
}
