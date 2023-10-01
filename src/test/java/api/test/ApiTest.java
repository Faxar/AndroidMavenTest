package api.test;

import api.apiData.Specifications;
import api.apiData.request.PostNewUserRequest;
import api.apiData.response.GetPostResponse;
import api.apiData.response.GetUserDetailsResponse;
import api.apiData.response.Response401;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Api tests")
public class ApiTest {
    private final static String URL = "https://gorest.co.in/public/v2/";
    SoftAssertions softly = new SoftAssertions();

    /**
     * Checks for unauthorized access.
     *
     * @result Backend should provide unauthorized response.
     */
    @Test
    @Description("Unauthorized 401 negative test")
    void unauthorized401NegativeTest() {
        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpec(401));
        Response401 response = given()
                .body(PostNewUserRequest.builder().build())
                .when()
                .post("users")
                .then().extract().as(Response401.class);
        assertThat(response.message).as("Actual response message").isEqualTo("Authentication failed");
    }

    @Nested
    @DisplayName("Various 200 scenarios")
    class Various200Scenarios {
        /**
         * Test for getting user by id
         *
         * @result Backend should return user object
         * with user info
         */
        @Test
        @Description("Get user positive test")
        void getUserPositiveTest() {
            String id = "628154";
            Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpec(200));
            GetUserDetailsResponse response = given()
                    .when()
                    .get("users/" + id)
                    .then()
                    .extract().as(new TypeRef<GetUserDetailsResponse>() {
                    });
            softly.assertThat(response.getId().toString()).as("Actual user id").isEqualTo(id);
            softly.assertThat(response.getName()).as("Actual user name").isEqualTo("Yogesh Menon");
            softly.assertAll();
        }

        /**
         * Test for getting post by id
         *
         * @result Backend should return user post object
         * with post info
         */
        @Test
        @Description("Get user post positive test")
        void getUserPostPositiveTest() {
            Integer id = 71862;
            Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpec(200));
            GetPostResponse response = given()
                    .when()
                    .get("posts/" + id)
                    .then()
                    .extract().as(new TypeRef<GetPostResponse>() {
                    });
            softly.assertThat(response.getId()).as("Actual post id").isEqualTo(id);
            softly.assertThat(response.getUser_id()).as("Actual user id").isEqualTo(5248614);
            softly.assertAll();
        }

        /**
         * Test for posting new user
         *
         * @result Backend should 200
         * with new user info
         */
        @Test
        @Description("Post new user positive test")
        void postNewUserPositiveTest() {
            PostNewUserRequest request = PostNewUserRequest.builder().build();
            String bearerToken = "5005160f16d71a09fc662e94463d49fc7857a693b18fbaf3552072b31c9af162";
            Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpec(201));
            GetUserDetailsResponse response = given()
                    .headers("Authorization",
                            "Bearer " + bearerToken,
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON)
                    .body(request)
                    .when()
                    .post("users")
                    .then()
                    .extract().as(new TypeRef<GetUserDetailsResponse>() {
                    });
            softly.assertThat(response.getName()).as("Actual user name").isEqualTo(request.getName());
            softly.assertThat(response.getEmail()).as("Actual user email").isEqualTo(request.getEmail());
            softly.assertAll();
        }
    }
}
