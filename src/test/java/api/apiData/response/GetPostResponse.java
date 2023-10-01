package api.apiData.response;

import lombok.Data;

@Data
public class GetPostResponse {
    private Integer id;
    private Integer user_id;
    private String title;
    private String body;
}
