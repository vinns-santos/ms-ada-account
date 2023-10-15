package br.com.ada.account.enumerator;

import lombok.Getter;

@Getter
public enum AccountDateTypeValues {

    OPENING_DATE("Data de abertura"),
    CLOSING_DATE ("Data de fechamento"),
    BLOCKING_DATE ("Data de bloqueio");

    private String value;

    AccountDateTypeValues(String value){
        this.value = value;
    }

}
