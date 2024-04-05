package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SimpleHHRuTest {

    @BeforeEach
    void setUpEnv() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        open("https://spb.hh.ru/");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

    }

    @AfterEach
    void clearEnv() { Selenide.closeWebDriver(); }

    @ParameterizedTest
    @CsvSource(value = {"QA Automation Engineer, Работа QA Automation Engineer",
            "Java Engineer, Работа Java Engineer"})
    @DisplayName("Поиск вакансий ")
    void vacancySearchTest(String value, String expectedValue) {

        $("#a11y-search-input").setValue(value).pressEnter();
        $("[data-qa=bloko-modal-close]").click();

        $("[data-qa=vacancies-catalog-header]").shouldHave(text(expectedValue));
        $("[data-qa=vacancy-serp__vacancy_response]").shouldHave(text("Откликнуться"));

    }
}

