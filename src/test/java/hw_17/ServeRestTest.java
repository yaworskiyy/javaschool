package hw_17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServeRestTest {

    private static String userId;
    private static String userEmail;
    private static String token;

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Order(1)
    void shouldGetAllUsers() {
        given()
            .when().get("/usuarios")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("quantidade", greaterThan(0))
            .body("usuarios", not(empty()));
    }

    @Test
    @Order(2)
    void shouldFindUserByEmail() {
        String email = given()
            .when().get("/usuarios")
            .then()
            .extract().path("usuarios[0].email");

        given()
            .queryParam("email", email)
            .when().get("/usuarios")
            .then()
            .statusCode(200)
            .body("usuarios", hasSize(1))
            .body("usuarios[0].email", equalTo(email));
    }

    @Test
    @Order(3)
    void shouldCreateNewUser() {
        userEmail = "spy_" + System.currentTimeMillis() + "@qa.com";

        Map<String, String> body = new HashMap<>();
        body.put("nome", "Zé Teste");
        body.put("email", userEmail);
        body.put("password", "teste123");
        body.put("administrador", "true");

        userId = given()
            .contentType(ContentType.JSON)
            .body(body)
            .when().post("/usuarios")
            .then()
            .statusCode(201)
            .body("message", equalTo("Cadastro realizado com sucesso"))
            .extract().path("_id");
    }

    @Test
    @Order(4)
    void shouldUpdateUser() {
        userEmail = "spy_updated_" + System.currentTimeMillis() + "@qa.com";

        Map<String, String> body = new HashMap<>();
        body.put("nome", "Zé da Silva Updated");
        body.put("email", userEmail);
        body.put("password", "teste123");
        body.put("administrador", "true");

        given()
            .contentType(ContentType.JSON)
            .body(body)
            .when().put("/usuarios/" + userId)
            .then()
            .statusCode(200)
            .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @Order(5)
    void shouldLoginAndDeleteUser() {
        // 5.1 — Login to get token
        Map<String, String> loginBody = new HashMap<>();
        loginBody.put("email", userEmail);
        loginBody.put("password", "teste123");

        token = given()
            .contentType(ContentType.JSON)
            .body(loginBody)
            .when().post("/login")
            .then()
            .statusCode(200)
            .body("message", equalTo("Login realizado com sucesso"))
            .extract().path("authorization");

        // 5.2 — Delete user
        given()
            .header("Authorization", token)
            .when().delete("/usuarios/" + userId)
            .then()
            .statusCode(200)
            .body("message", equalTo("Registro excluído com sucesso"));

        // 5.3 — Verify deletion: GET returns 400
        given()
            .when().get("/usuarios/" + userId)
            .then()
            .statusCode(400);

        // 5.4 — Verify deletion: DELETE returns 200 (no record deleted)
        given()
            .header("Authorization", token)
            .when().delete("/usuarios/" + userId)
            .then()
            .statusCode(200);
    }

    @Test
    @Order(6)
    void shouldGetAllProducts() {
        given()
            .when().get("/produtos")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("quantidade", greaterThan(0))
            .body("produtos.preco", everyItem(greaterThan(0)))
            .body("produtos.nome", everyItem(not(emptyString())));
    }

    @Test
    @Order(7)
    void shouldCreateUserFromDto() {
        Usuario usuario = new Usuario(
            "DTO Test",
            "dto_" + System.currentTimeMillis() + "@qa.com",
            "dto123",
            "true"
        );

        given()
            .contentType(ContentType.JSON)
            .body(usuario)
            .when().post("/usuarios")
            .then()
            .statusCode(201)
            .body("message", equalTo("Cadastro realizado com sucesso"))
            .body("_id", notNullValue());
    }
}
