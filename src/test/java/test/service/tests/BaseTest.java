package test.service.tests;

import io.restassured.specification.RequestSpecification;
import test.service.steps.Steps;

import static io.restassured.RestAssured.given;

public class BaseTest {
    final String GET_ENDPOINT = "/api/get/";
    final String POST_ENDPOINT = "/api/create";
    final String DELETE_ENDPOINT = "/api/delete/";
    final String PATCH_ENDPOINT = "/api/patch/";
    final String GETALL_ENDPOINT = "/api/getAll";

    Steps steps = new Steps();

    protected final RequestSpecification requestSpecification = given()
            .baseUri("http://localhost:8080");
}
