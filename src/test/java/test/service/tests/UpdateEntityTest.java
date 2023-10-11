package test.service.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.service.model.EntityResponseModel;
import test.service.model.EntityAdditionRequestModel;

import java.util.List;

public class UpdateEntityTest extends BaseTest {
    private String idToUpdateEntity;
    private String entityAsString;
    private EntityAdditionRequestModel entityForUpdate;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeMethod
    public void beforeMethod() throws JsonProcessingException {
        idToUpdateEntity = steps.createEntity(requestSpecification, "title", "false");
        entityForUpdate = steps.getEntityAdditionData("updateTitle", true, "info", 1, List.of(1,2,3));
        entityAsString = objectMapper.writeValueAsString(entityForUpdate);
    }

    @AfterMethod
    public void afterMethod() {
        steps.deleteEntity(requestSpecification, idToUpdateEntity);
    }

    @Test
    @Story("PATCH Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : update entity")
    public void patchEntity() {
        requestSpecification
                .contentType(ContentType.JSON)
                .body(entityAsString)
            .when()
                .patch(PATCH_ENDPOINT + idToUpdateEntity)
            .then()
                .statusCode(204);

        EntityResponseModel updatedEntity = steps.getEntity(requestSpecification, idToUpdateEntity);

        Assert.assertEquals(updatedEntity.getTitle(), entityForUpdate.getTitle(), "Поле title не совпадает. Обновление произошло некорректно");
        Assert.assertEquals(updatedEntity.getVerified(), entityForUpdate.getVerified(), "Поле verified не совпадает. Обновление произошло некорректно");
    }
}
