import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class Test_1 {
    public static final String basePath = "https://www.thecocktaildb.com/api/json/v1/%d/search.php?s=%s";

    @Test
    public void whenLogRequest_thenOK() {
        given().log().all()
                .when().get(String.format(basePath, 1, "margarita"))
                .then().statusCode(200);
    }

    @Test
    public void checkIDResponse() {
        given().
                when().
                get(String.format(basePath, 1, "margarita"))
                .then()
                .body("drinks.idDrink", hasItems("11007", "11118", "17216", "16158", "12322"));
    }

    @Test
    public void invalidParkingSpace() {
        given().when().get(String.format(basePath, 2, "margarita"))
                .then().statusCode(404);
    }

    @Test
    public void i() {
        given().when().get(String.format(basePath, 1, "marga rita"))
                .then().statusCode(200)
                .body("drinks", equalTo(null));
    }
}