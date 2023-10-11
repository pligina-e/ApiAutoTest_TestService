package test.service.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteEntityTest extends BaseTest {
    private String idToDeleteEntity;

    @BeforeMethod
    public void beforeMethod() {
        idToDeleteEntity = steps.createEntity(requestSpecification, "title", "true");
    }

    @Test
    @Story("DELETE Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : delete entity by id")
    public void deleteEntity() {
        requestSpecification
                .header("Content-type", "application/json")
            .when()
                .delete(DELETE_ENDPOINT + idToDeleteEntity)
            .then()
                .statusCode(204);

        Assert.assertEquals(0, steps.getEntityForDelete(requestSpecification, idToDeleteEntity).getId(), "Удаление сущности было некорректным");
    }
}
