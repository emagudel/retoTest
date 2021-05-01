package com.company.certification.reto;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static com.company.certification.reto.ConstantManager.CLASE_INTERFAZ_USUARIO;

public class WebPage {
    public static final Target IMAGE_AVATAR = Target.the("Image avatar").located(By.xpath(("//*[@id='root']/div/div/div[1]/div/header/div[1]/section/div/ul/li[1]/div/div/button/div/img")));
    public static final Target BUTTON_LOGIN = Target.the("Button login").located(By.xpath(("//*[@class='join-log-in text-color-grey prl3-sm pt2-sm pb2-sm fs12-sm d-sm-b']")));
    public static final Target TXT_EMAIL = Target.the("Campo email").located(By.name("emailAddress"));
    public static final Target TXT_PASSWORD = Target.the("Campo password").located(By.name("password"));
    public static final Target BUTTON_SIGN_IN = Target.the("Button sing in").located(By.xpath(("//*[@class='nike-unite-submit-button loginSubmit nike-unite-component']")));

    private WebPage(){
        throw new IllegalStateException(CLASE_INTERFAZ_USUARIO);
    }
}