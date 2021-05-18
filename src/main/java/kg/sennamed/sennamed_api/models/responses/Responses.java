package kg.sennamed.sennamed_api.models.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Responses {

    private int status;
    private String message;
    private Object object;

    public static Responses Success(){
        return Responses.builder()
                .status(1)
                .message("Успешно!")
                .build();
    }

    public static Responses userAlreadyExist(){
        return Responses.builder()
                .status(2)
                .message("Пользователь с таким именем существует!")
                .build();
    }

    public static Responses userDoesntExist(){
        return Responses.builder()
                .status(3)
                .message("Пользователь не найден")
                .build();
    }

    public static Responses userNotActive(){
        return Responses.builder()
                .status(4)
                .message("Пользователь не активен")
                .build();
    }

    public static Responses authFailed(){
        return Responses.builder()
                .status(5)
                .message("Неверные параметры авторизации")
                .build();
    }
}
