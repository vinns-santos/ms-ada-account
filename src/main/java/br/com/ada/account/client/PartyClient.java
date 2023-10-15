package br.com.ada.account.client;

import br.com.ada.party.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "party", url = "${party.url}")
public interface PartyClient {
    @GetMapping(value = "/party/{id}", produces = "application/json")
    Party getPartyById(@PathVariable("id") Long id);
}
