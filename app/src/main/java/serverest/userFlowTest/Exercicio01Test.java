package serverest.userFlowTest;

import org.junit.Test;

import static io.restassured.RestAssured.when;

public class Exercicio01Test {

    @Test
    public void getUsuarios() {
        when().
                get("http://localhost:3000/usuarios").
                then().
                statusCode(200);
    }
}

