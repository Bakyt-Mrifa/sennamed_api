package kg.sennamed.sennamed_api.service.impl;

import kg.sennamed.sennamed_api.databases.AccountRepository;
import kg.sennamed.sennamed_api.databases.UserRepository;
import kg.sennamed.sennamed_api.mappers.AccountMapper;
import kg.sennamed.sennamed_api.models.dto.AccountDto;
import kg.sennamed.sennamed_api.models.entity.Account;
import kg.sennamed.sennamed_api.models.entity.User;
import kg.sennamed.sennamed_api.models.responses.Responses;
import kg.sennamed.sennamed_api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class loginServiceImpl implements LoginService {

    private Responses responses;
    Map<String, String> map = new HashMap<>();
    Map<String, Object> mapObject = new HashMap<>();

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Responses getAccount(AccountDto accountDto) {
        System.out.println(accountDto+" before");

        Account account=accountRepository.getAccountByLogin(accountDto.getLogin());
        System.out.println(account+" after");
        if (account==null){
            responses=Responses.userDoesntExist();
            return responses;

        }
        if (!account.getPassword().equals(accountDto.getPassword())){
            responses=Responses.authFailed();
            return responses;
        }
        if (!account.isActive()){
            responses=Responses.userNotActive();
            return responses;
        }

        User user=userRepository.getUserByAccount_Id(account.getId());
        responses=Responses.Success();
        responses.setObject(user);
        return responses;
    }

    /*@Override
    public ResponseEntity<?> getAccount(AccountDto accountDto) {
        Account account=accountRepository.getAccountByLogin(accountDto.getLogin());
        if (account==null){
            map.put("error","user not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        if (!account.getPassword().equals(accountDto.getPassword())){
            map.put("error", "incorrect authentication data");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        mapObject.put("success", AccountMapper.INSTANCE.toAccountDto(account));
        return new ResponseEntity<>(mapObject, HttpStatus.OK);
    }*/
}
