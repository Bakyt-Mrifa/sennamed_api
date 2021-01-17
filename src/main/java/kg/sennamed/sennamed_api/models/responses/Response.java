package kg.sennamed.sennamed_api.models.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private int status;
    private String message;
    private Object object;

    public static Response sucsess(){
        return Response.builder()
                .status(1)
                .message("Успешно!")
                .build();
    }
}
