package test.service.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.service.model.EntityResponseModel;
import test.service.steps.Steps;

public class GetEntityTest extends BaseTest {
    private String idToGetEntity;

    @BeforeMethod
    public void beforeMethod() {
        idToGetEntity = steps.createEntity(requestSpecification, "title", "false");
    }

    @AfterMethod
    public void afterMethod() {
        Steps.deleteEntity(requestSpecification, idToGetEntity);
    }

    @Test
    @Story("GET Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : get entity by id")
    public void getEntity() {
        EntityResponseModel response = requestSpecification
                .contentType("application/json")
            .when()
                .get("/api/get/" + idToGetEntity)
            .then()
                .statusCode(200)
                .extract()
                .as(EntityResponseModel.class);

        Assert.assertEquals(Integer.parseInt(idToGetEntity), response.getId(), "Содержимое поля id не соответствует указанному. Get-запрос выполнился некорректно");
    }

}
