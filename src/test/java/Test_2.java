import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_2 {
    public static final String basePath = "https://www.thecocktaildb.com/api/json/v1/%d/lookup.php?iid=%s";

    @Test
    public void whenLogRequest_thenOK() {
        given().log().all()
                .when().get(String.format(basePath, 1, "552"))
                .then().statusCode(200);
    }

    @Test
    public void ss() {
        given()
                .when().get(String.format(basePath, 1, "254"))
                .then().statusCode(200)
                .body("ingredients[0].strIngredient", equalTo("Guinness stout"));
    }

}
