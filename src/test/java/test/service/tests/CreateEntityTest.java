package test.service.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.service.steps.Steps;

public class CreateEntityTest extends BaseTest {

    @Test
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : create a new entity")
    public void postEntity() {
        String response = requestSpecification
                .param("title", "entityName")
                .param("verified", "true")
            .when()
                .post("/api/create")
            .then()
                .statusCode(200)
                .extract()
                .asString();

        Assert.assertEquals(Integer.parseInt(response), steps.getEntity(requestSpecification, response).getId(), "Содержимое поля id не соответствует указанному знач-ю при создании сущности");
        Assert.assertEquals("entityName", steps.getEntity(requestSpecification, response).getTitle(), "Содержимое поля title не соответствует указанному знач-ю при создании сущности");
        Assert.assertEquals(true, steps.getEntity(requestSpecification, response).getVerified(), "Содержимое поля verified не соответствует указанному знач-ю при создании сущности");
    }
}
