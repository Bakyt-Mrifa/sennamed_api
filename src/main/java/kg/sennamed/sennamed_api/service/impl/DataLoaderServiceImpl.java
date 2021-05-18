package kg.sennamed.sennamed_api.service.impl;

import kg.sennamed.sennamed_api.databases.AccountRepository;
import kg.sennamed.sennamed_api.databases.UserRepository;
import kg.sennamed.sennamed_api.mappers.AccountMapper;
import kg.sennamed.sennamed_api.models.dto.AccountDto;
import kg.sennamed.sennamed_api.models.entity.Account;
import kg.sennamed.sennamed_api.models.entity.User;
import kg.sennamed.sennamed_api.models.enums.Role;
import kg.sennamed.sennamed_api.service.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class DataLoaderServiceImpl implements DataLoaderService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void loadAccount(Account account) {
        System.out.println(account);
        if (accountRepository.existsAccountByLogin(account.getLogin())) {
            System.out.println(account + "Пользователь уже существует");
        } else {
            account = accountRepository.getAccountByLogin(account.getLogin());
            accountRepository.save(account);
            User user = new User();
            if (user == null) {
                user.setName("Administrator");
                user.setAccount(account);
                user.setRole(Role.admin);
                System.out.println("Инициализация: " + account + " и " + user + " прошла успешно");
            }
        }
    }

}
