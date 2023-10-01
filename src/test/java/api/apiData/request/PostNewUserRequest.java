package api.apiData.request;

import lombok.Builder;
import lombok.Data;

import static api.apiData.FakerProvider.getFaker;

@Data
@Builder
public class PostNewUserRequest {
    @Builder.Default
    private String name = getFaker().name().fullName();
    @Builder.Default
    private String gender = "male";
    @Builder.Default
    private String email = getFaker().internet().emailAddress();
    @Builder.Default
    private String status = "active";
}
