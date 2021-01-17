package kg.sennamed.sennamed_api.models.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Responses {

    private int status;
    private String message;
    private Object object;

    public static Responses userSaveSuccess(){
        return Responses.builder()
                .status(1)
                .message("Успешно!")
                .build();
    }

    public static Responses userExist(){
        return Responses.builder()
                .status(1)
                .message("Пользователь с таким именем существует!")
                .build();
    }
}
