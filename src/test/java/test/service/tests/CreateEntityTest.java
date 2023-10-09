package test.service.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;

public class CreateEntityTest extends BaseTest {
    Random random = new Random();
    ArrayList<String> idList = new ArrayList<>();
    int countEntities = random.nextInt(4) + 2;

    @Test
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : create a new entities")
    public void postEntity() {
        
        for (int i = 1; i <= countEntities; i++) {
            idList.add(
                requestSpecification
                        .param("title", "entityName" + i)
                        .param("verified", "true")
                    .when()
                        .post(POST_ENDPOINT)
                    .then()
                        .statusCode(200)
                        .extract()
                        .asString()
            );
        }

        for (String list : idList) {
            Assert.assertEquals(Integer.parseInt(list), steps.getEntity(requestSpecification, list).getId(), "Содержимое поля id не соответствует указанному знач-ю при создании сущности");
            Assert.assertTrue(steps.getEntity(requestSpecification, list).getTitle().contains("entityName"), "Содержимое поля title не соответствует указанному знач-ю при создании сущности");
            Assert.assertEquals(true, steps.getEntity(requestSpecification, list).getVerified(), "Содержимое поля verified не соответствует указанному знач-ю при создании сущности");
        }
    }
}
