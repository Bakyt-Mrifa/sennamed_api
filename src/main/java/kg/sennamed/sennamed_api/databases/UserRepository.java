package kg.sennamed.sennamed_api.databases;

import kg.sennamed.sennamed_api.models.entity.Account;
import kg.sennamed.sennamed_api.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User getUserByAccount_Id(Long id);
        boolean existsByAccount (Account account);
}
