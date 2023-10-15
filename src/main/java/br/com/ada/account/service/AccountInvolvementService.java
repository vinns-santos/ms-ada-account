package br.com.ada.account.service;

import br.com.ada.account.client.PartyClient;
import br.com.ada.account.model.AccountInvolvement;
import br.com.ada.account.repository.AccountInvolvementRepository;
import br.com.ada.account.dto.NewAccountInvolvimentDTO;
import br.com.ada.account.model.Account;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class AccountInvolvementService {

    private final PartyClient partyClient;
    private final AccountService accountService;
    private final AccountInvolvementRepository accountInvolvementRepository;

    public AccountInvolvementService(PartyClient partyClient, AccountService accountService
            , AccountInvolvementRepository accountInvolvementRepository) {
        this.partyClient = partyClient;
        this.accountService = accountService;
        this.accountInvolvementRepository = accountInvolvementRepository;
    }

    public AccountInvolvement saveAccountInvolviment(NewAccountInvolvimentDTO accountInvolvimentDTO) {
        return createAccountInvolvement(accountInvolvimentDTO);
    }

    private AccountInvolvement createAccountInvolvement(NewAccountInvolvimentDTO accountInvolvimentDTO) {
        AccountInvolvement accountInvolvement = new AccountInvolvement();
        accountInvolvement.setAccountReference(getAccount(accountInvolvimentDTO.getAccountId()));
        accountInvolvement.setPartyId(validParty(accountInvolvimentDTO.getPartyId()));
        accountInvolvement.setAccountInvolvementTypeValues(accountInvolvimentDTO.getAccountInvolvementTypeValues());
        return accountInvolvementRepository.save(accountInvolvement);
    }

    private Account getAccount(Long accountId) {
        Optional<Account> account = accountService.getAccount(accountId);
        if (account.isEmpty()) {
            throw new EntityNotFoundException(String.format("Conta %s nao encontrada", accountId));
        }

        return account.get();
    }

    private Long validParty(Long partyId) {
        try{
            return partyClient.getPartyById(partyId).getId();
        }
        catch (HttpClientErrorException.NotFound e) {
            throw new EntityNotFoundException(String.format("Party %s nao encontrada", partyId));
        }
    }

    public Optional<AccountInvolvement> getAccountInvolvement(Long id) {
        return accountInvolvementRepository.findById(id);
    }
}
