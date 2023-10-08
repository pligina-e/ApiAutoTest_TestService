package test.service.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateEntityTest extends BaseTest {
    private String idToUpdateEntity;

    @BeforeMethod
    public void beforeMethod() {
        idToUpdateEntity = steps.createEntity(requestSpecification, "title", "false");
    }

    @Test
    @Story("PATCH Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : update entity")
    public void patchEntity() {
        String requestBody = "{\n" +
                "  \"title\": \"updateTitle\",\n" +
                "  \"verified\": false,\n" +
                "  \"addition\": {\n" +
                "  \"additional_info\": \"info\",\n" +
                "  \"additional_number\": 2\n" +
                "},\n" +
                "  \"important_numbers\": [\n" +
                "1,\n" + "2\n" + "]\n" + "}";
        String requestBody2 = "{\n" +
                "  \"addition\": {\n" +
                "  \"additional_info\": \"info\",\n" +
                "  \"additional_number\": 2\n" +
                "},\n" +
                "  \"important_numbers\": [\n" +
                "1,\n" + "2\n" + "],\n" +
                "  \"title\": \"updateTitle\",\n" +
                "  \"verified\": false,\n" + "}";
        String requestBody3 = "{\n" +
                "  \"title\": \"updateTitle\"\n" + "}";

        given().baseUri("http://localhost:8080/api/_/docs/swagger")
        //given().baseUri("http://localhost:8080")
                .body(requestBody3)
            .when()
                .patch("/api/patch/" + idToUpdateEntity)
            .then()
                .log().all()
                .statusCode(204);
    }
}
