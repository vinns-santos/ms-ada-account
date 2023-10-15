package br.com.ada.account.repository;

import br.com.ada.account.model.AccountInvolvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInvolvementRepository extends JpaRepository<AccountInvolvement, Long> {
}
