package test.service.steps;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import test.service.model.AdditionRequestModel;
import test.service.model.EntityResponseModel;
import test.service.model.EntityAdditionRequestModel;

import java.util.List;

public class Steps {
    static final String GET_ENDPOINT = "/api/get/";
    static final String POST_ENDPOINT = "/api/create";
    static final String DELETE_ENDPOINT = "/api/delete/";

    @Step("Get-запрос для излечения данных о сущности с id = {id}")
    public static EntityResponseModel getEntity(RequestSpecification requestSpecification, String id) {
        return requestSpecification
                .contentType("application/json")
            .when()
                .get(GET_ENDPOINT + id)
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
                .post(POST_ENDPOINT)
            .then()
                .statusCode(200)
                .extract()
                .asString();
    }

    @Step("DELETE-запрос для удаления сущности с id = {id}")
    public static String deleteEntity(RequestSpecification requestSpecification, String id) {
        return requestSpecification
            .when()
                .delete(DELETE_ENDPOINT + id)
            .then()
                .extract()
                .asString();
    }

    @Step("GET-запрос для излечения данных об удаленной сущности с id = {id}. Статус-код = 500")
    public static EntityResponseModel getEntityForDelete(RequestSpecification requestSpecification, String id) {
        return requestSpecification
                .contentType("application/json")
            .when()
                .get(GET_ENDPOINT + id)
            .then()
                .statusCode(500)
                .extract()
                .as(EntityResponseModel.class);
    }
}
