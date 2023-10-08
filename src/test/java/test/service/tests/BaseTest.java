package test.service.tests;

import io.restassured.specification.RequestSpecification;
import test.service.steps.Steps;

import static io.restassured.RestAssured.given;

public class BaseTest {
    Steps steps = new Steps();

    protected final RequestSpecification requestSpecification = given()
            .baseUri("http://localhost:8080");
}
