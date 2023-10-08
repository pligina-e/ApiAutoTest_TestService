package test.service.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.service.model.EntityResponseModel;

import java.util.List;

public class GetAllEntitiesTest extends BaseTest {

    @Test
    @Story("GET Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : get all entities")
    public void getAllEntities() {
        List <EntityResponseModel> response = requestSpecification
                .contentType(ContentType.JSON)
            .when()
                .get("/api/getAll")
            .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("entity", EntityResponseModel.class);

        Assert.assertEquals(1, response.get(0).getId(), "Некорректный id у первого элемента списка");
        Assert.assertEquals(2, response.get(1).getId(), "Некорректный id у второго элемента списка");
        Assert.assertEquals(3, response.get(2).getId(), "Некорректный id у третьего элемента списка");
    }
}
