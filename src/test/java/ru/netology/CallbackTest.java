package ru.netology;


import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CallbackTest {
    @BeforeEach
    void openWebBank() {
        open("http://localhost:7777/");

    }

    @Test
    void test() {
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Петр Петров");
        form.$("[data-test-id=phone] input").setValue("+71231231234");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void test2() {
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Анна-Мария Антуаннета");
        form.$("[data-test-id=phone] input").setValue("+71231231234");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
