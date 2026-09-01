package hw_19;

import io.cucumber.core.cli.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Hw19CucumberRunnerTest {

    private static final String FEATURES = "src/test/resources/hw_19/login.feature";

    @Test
    void runLoginScenarios() {
        String[] args = new String[]{
                "--glue", "hw_19.steps",
                "--plugin", "pretty",
                "--plugin", "json:build/reports/cucumber/hw_19.json",
                FEATURES
        };
        byte exit = Main.run(args, Thread.currentThread().getContextClassLoader());
        assertEquals(0, exit, "Cucumber scenarios must all pass");
    }
}
