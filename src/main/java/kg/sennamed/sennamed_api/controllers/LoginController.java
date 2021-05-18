package kg.sennamed.sennamed_api.controllers;

import io.swagger.annotations.Api;
import kg.sennamed.sennamed_api.models.dto.AccountDto;
import kg.sennamed.sennamed_api.models.responses.Responses;
import kg.sennamed.sennamed_api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "test")
    //public void testReceive (@RequestParam String login, @RequestParam String password){
    public Responses testReceive (@RequestBody AccountDto accountDto){
        System.out.println("login = "+accountDto.getLogin()+", password = "+accountDto.getPassword());
        System.out.println(accountDto);
        return null;
    }

}
