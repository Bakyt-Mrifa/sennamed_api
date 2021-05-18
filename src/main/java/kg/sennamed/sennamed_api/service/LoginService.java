package kg.sennamed.sennamed_api.service;

import kg.sennamed.sennamed_api.models.dto.AccountDto;
import kg.sennamed.sennamed_api.models.responses.Responses;
import org.springframework.http.ResponseEntity;

public interface LoginService {
   // ResponseEntity<?> getAccount (AccountDto accountDto);
    Responses getAccount (AccountDto accountDto);
}
