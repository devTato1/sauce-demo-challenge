package com.nttdata.runners;

import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com.nttdata.glue",
        tags = "@Exitoso"
)
public class CucumberShop {

    @BeforeClass
    public static void setup() {
        // CAMBIO: Usamos firefoxdriver en lugar de chromedriver
        WebDriverManager.firefoxdriver().setup();
    }
}