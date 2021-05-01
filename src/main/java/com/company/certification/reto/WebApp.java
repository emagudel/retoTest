package com.company.certification.reto;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.company.certification.reto.DataTest.obtain;
import static com.company.certification.reto.VerifyObject.elementVisible;
import static com.company.certification.reto.WebPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WebApp implements Task {

    public static WebApp inTheAplication() {
        return instrumented(WebApp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_LOGIN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BUTTON_LOGIN),
                Enter.theValue(obtain("user").trim()).into(TXT_EMAIL),
                Enter.theValue(obtain("passwordUser").trim()).into(TXT_PASSWORD),
                Click.on(BUTTON_SIGN_IN),
                WaitUntil.the(IMAGE_AVATAR, isVisible()).forNoMoreThan(10).seconds()
        );
        if (!elementVisible(actor, IMAGE_AVATAR)) {
            throw new NullPointerException("Could not authenticate with the credentials");
        }
    }
}
