package com.company.certification.reto.stepdefinitions;

import com.company.certification.reto.WebApp;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.company.certification.reto.LoadData.loadDataTestWithTheFollowing;

public class TestStepDefinition {

    @Managed()
    Actor Jesus = Actor.named("Jesus");
    ChromeOptions options = new ChromeOptions();

    WebDriver driver = new ChromeDriver(
            options.addArguments(
            "--disk-cache-dir=null","--disable-popup-blocking","--disable-download-notification",
            "--start-maximized","--test-type","--ignore-certificate-errors","--allow-running-insecure-content",
            "--disable-translate","--always-authorize-plugins","--disable-extensions","--disable-notifications",
            "--disable-infobars","--enable-file-cookies","--enable-application-cache","--disable-web-security","--incognito")
            .setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"))
            .setExperimentalOption("useAutomationExtension", false)
    );

    @Before()
    public void configuracionInicial2() {
        Jesus.remember("driverChrome",driver);
        Jesus.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^I visit the page in app$")
    public void i_visit_the_page_in_app() {
        Jesus.attemptsTo(Open.url("https://www.nike.com/launch?s=in-stock"));
    }

    @When("^I enter the page with this information$")
    public void i_enter_the_page_with_this_information(List<Map<String, Object>> information) {
        Jesus.attemptsTo(loadDataTestWithTheFollowing(information));
    }

    @Then("^I verify the entry to the page$")
    public void i_verify_the_entry_to_the_page() {
        Jesus.attemptsTo(WebApp.inTheAplication());
    }

}
