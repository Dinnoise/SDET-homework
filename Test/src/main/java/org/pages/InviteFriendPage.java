package org.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class InviteFriendPage {

    @Step("Проверить, что страница Пригласи друга открылась")
    public InviteFriendPage inviteFriendPage(){
        $(By.xpath("//h1"))
                .shouldHave(text("Порекомендуйте друга — получите вознаграждение!"))
                .shouldBe(visible);
        return this;
    }
}
