package org.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(xpath = "//a[@data-gclick='showModalFeedback']")
    private SelenideElement feedbackButton;

    @FindBy(xpath = "//*[contains(@class,'gh-nav-item--about')]")
    private SelenideElement navItemAbout;

    @FindBy(xpath = "//*[contains(@class,'gh-nav-item--career')]")
    private SelenideElement navItemCareer;

    @Step("Проверить, что кнопка Написать нам присутствует и кликабельна")
    public FeedbackModal showFeedbackModal() {
        feedbackButton
                .should(exist)
                .shouldBe(visible)
                .shouldHave(text("Написать нам"))
                .click();
        return page(FeedbackModal.class);
    }

    @Step("Проверить, что при наведении на элемент меню О нас появляется ссылка Контакты")
    public ContactsPage goToContacts() {
        navItemAbout
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .shouldHave(text("Контакты"))
                .click();
        return page(ContactsPage.class);
    }

    @Step("Проверить, что при наведении на элемент в меню Карьера появляется ссылка Пригласи друга")
    public InviteFriendPage goToInviteFriend() {
        navItemCareer
                .shouldHave(text("Карьера"))
                .hover();
        $(By.linkText("Пригласи друга"))
                .shouldHave(text("Пригласи друга"))
                .click();
        return page(InviteFriendPage.class);
    }
}
