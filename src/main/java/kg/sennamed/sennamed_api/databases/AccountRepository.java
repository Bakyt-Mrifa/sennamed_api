package kg.sennamed.sennamed_api.databases;

import kg.sennamed.sennamed_api.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
        Account getAccountByLogin (String login);
        boolean existsAccountByLogin (String login);
}
