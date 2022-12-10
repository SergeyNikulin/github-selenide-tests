package com.nikulin.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        //Configuration.browserSize = "500x1000"; // Если есть проблема с отсутствием кнопки Submit, то необходимо подобрать разрешение при котором кнопка будет отображаться
    }

   @Test
    public void replaceElementDragOnDrop() {
        // Открытие страницы drag_and_drop в the-internet.herokuapp.com
        open("/drag_and_drop");

        // Смена прямоугольников местами
        $("#column-a").dragAndDropTo($("#column-b"));
        // Проверка, что прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        // Закрытие браузера
        Selenide.closeWebDriver();
    }

    @Test // Не работает смена
    public void replaceElementActions() {
        // Открытие страницы drag_and_drop в the-internet.herokuapp.com
        open("/drag_and_drop");

        // Смена прямоугольников местами
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(250, 0).release().build().perform();
        //actions().dragAndDropBy($("#column-a"), 250, 0).release().perform();
        //actions().dragAndDrop($("#column-a"), $("#column-b")).release().perform();

        // Проверка, что прямоугольники поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        // Закрытие браузера
        Selenide.closeWebDriver();
    }
}
