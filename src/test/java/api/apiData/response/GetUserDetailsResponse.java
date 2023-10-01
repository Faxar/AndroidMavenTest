package api.apiData.response;

import lombok.Data;

@Data
public class GetUserDetailsResponse {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
