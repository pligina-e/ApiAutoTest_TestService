package test.service.steps;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import test.service.model.EntityResponseModel;

public class Steps {

    @Step("Get-запрос для излечения данных о сущности с id = {id}")
    public static EntityResponseModel getEntity(RequestSpecification requestSpecification, String id) {
        return requestSpecification
                .contentType("application/json")
            .when()
                .get("/api/get/" + id)
            .then()
                .statusCode(200)
                .extract()
                .as(EntityResponseModel.class);
    }

    @Step("POST-запрос для создания сущности с названием {title}")
    public static String createEntity(RequestSpecification requestSpecification, String title, String verified) {
        return requestSpecification
                .param("title", title)
                .param("verified", verified)
            .when()
                .post("/api/create")
            .then()
                .statusCode(200)
                .extract()
                .asString();
    }

    @Step("DELETE-запрос для удаления сущности с id = {id}")
    public static String deleteEntity(RequestSpecification requestSpecification, String id) {
        return requestSpecification
            .when()
                .delete("/api/delete/" + id)
            .then()
                .extract()
                .asString();
    }

    @Step("GET-запрос для излечения данных об удаленной сущности с id = {id}. Статус-код = 500")
    public static EntityResponseModel getEntityForDelete(RequestSpecification requestSpecification, String id) {
        return requestSpecification
                .contentType("application/json")
            .when()
                .get("/api/get/" + id)
            .then()
                .statusCode(500)
                .extract()
                .as(EntityResponseModel.class);
    }
}
