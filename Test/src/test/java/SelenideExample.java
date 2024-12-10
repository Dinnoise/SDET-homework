import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SelenideExample {

    @BeforeClass
    void init() {
        Configuration.baseUrl = "https://www.simbirsoft.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
    }

    @Test
    public void test1() {
        open("https://www.simbirsoft.com/");
        $(By.cssSelector("a[data-gclick='showModalFeedback']"))
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        $x("//*[@class='fmo-parent']//*[@class='fb-modal-default']").shouldBe(visible);
        sleep(5000);
    }

    @Test
    public void test2() {
        open("https://www.simbirsoft.com/");
        $(By.xpath("//*[contains(@class,'gh-nav-item--about')]"))
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .shouldHave(text("Контакты"))
                .click();
        $(By.xpath("//h1")).shouldHave(text("Контакты")).shouldBe(visible);
        webdriver().shouldHave(url("https://www.simbirsoft.com/contacts/"));
        sleep(5000);
    }

    @Test
    public void test3() {
        open("https://www.simbirsoft.com/");
        $(By.xpath("//a[@href=\"/help/\"]"))
                .shouldBe(visible)
                .shouldHave(text("Услуги"))
                .click();
        $(By.xpath("//h1")).shouldHave(text("Услуги")).shouldBe(visible);
        webdriver().shouldHave(url("https://www.simbirsoft.com/help/"));
        sleep(5000);
    }
}
