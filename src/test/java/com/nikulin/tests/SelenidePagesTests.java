package com.nikulin.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenidePagesTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        //Configuration.browserSize = "500x1000"; // Если есть проблема с отсутствием кнопки Submit, то необходимо подобрать разрешение при котором кнопка будет отображаться
    }

    @Test
    public void searchJunit5CodeOnSoftAssertionsPage() {
        // Открытие страницы selenide в github
        open("/selenide/selenide");

        // Переход в раздел Wiki проекта
        $("#wiki-tab").click();
        // Проверка, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        // Открытие страницы SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        // Проверка, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
