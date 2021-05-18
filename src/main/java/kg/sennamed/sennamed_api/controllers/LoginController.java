package kg.sennamed.sennamed_api.controllers;

import kg.sennamed.sennamed_api.models.dto.AccountDto;
import kg.sennamed.sennamed_api.models.responses.Responses;
import kg.sennamed.sennamed_api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "api/v1/login/")
@Api (value = "Управление авторизацией", description = "Методы по управлению авторизацией")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "getAccount")
    //public ResponseEntity<?> getUser(@RequestBody AccountDto accountDto) {
    public Responses getUser(@RequestBody AccountDto accountDto) {
        System.out.println(accountDto);
       return loginService.getAccount(accountDto);

    }

}
