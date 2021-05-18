package kg.sennamed.sennamed_api.models.utils;

import kg.sennamed.sennamed_api.databases.AccountRepository;
import kg.sennamed.sennamed_api.databases.UserRepository;
import kg.sennamed.sennamed_api.models.entity.Account;
import kg.sennamed.sennamed_api.models.entity.User;
import kg.sennamed.sennamed_api.models.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    @Autowired
    public DataLoader(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setLogin("admin");
        account.setPassword("admin");
        account.setActive(true);
        if (accountRepository.existsAccountByLogin(account.getLogin())) {
            System.out.println("Аккаунт уже существует");
            account = accountRepository.getAccountByLogin(account.getLogin());
        } else {
            accountRepository.save(account);

        }
        saveUser(account);
    }

    private void saveUser(Account account) {
        User user = new User();

        //System.out.println("Receive account " + account);
        if (userRepository.existsByAccount(account)) {
            System.out.println("Пользователь существует");
        } else {
            user.setName("Administrator");
            user.setAccount(account);
            user.setAddress("Kyrgyzstan");
            user.setRole(Role.admin);
            userRepository.save(user);
            System.out.println("Инициализация: " + account + " и " + user + " прошла успешно");

        }
    }
}