package api.apiData;

import com.github.javafaker.Faker;
public class FakerProvider {
    private static Faker instance;
    public static Faker getFaker() {
        if (instance == null) {
            instance = new Faker();
        }
        return instance;
    }
}
