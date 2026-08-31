import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.core.cli.Main;

class CucumberRunnerTest {

    private static final String FEATURES = "src/test/resources/booking.feature";

    @Test
    void runAllScenarios() {
        run("json:build/reports/cucumber/all.json", FEATURES);
    }

    @Test
    void runOnlySmokeScenarios() {
        run("json:build/reports/cucumber/smoke.json", "--tags", "@smoke", FEATURES);
    }

    @Test
    void runAllExceptNegativeScenarios() {
        run("json:build/reports/cucumber/not-negative.json", "--tags", "not @negative", FEATURES);
    }

    private void run(String reportPlugin, String... extraArgs) {
        String[] base = new String[]{
                "--glue", "",
                "--plugin", "pretty",
        };
        java.util.List<String> all = new java.util.ArrayList<>();
        java.util.Collections.addAll(all, base);
        all.add("--plugin");
        all.add(reportPlugin);
        java.util.Collections.addAll(all, extraArgs);
        byte exit = Main.run(all.toArray(new String[0]), Thread.currentThread().getContextClassLoader());
        assertEquals(0, exit, "Cucumber scenarios must all pass");
    }
}
