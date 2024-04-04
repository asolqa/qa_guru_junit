package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class HHRuTest {

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


    @Test
    @DisplayName("Поиск вакансий для автоматизатора")
    void autoQASearchTest() {

        $("[data-qa=signup]").shouldHave(text("Создать резюме"));
        $("[data-qa=login]").shouldHave(text("Войти"));
        $("[data-qa=mainmenu_help]").shouldHave(text("Помощь"));

        $("#a11y-search-input").setValue("QA Automation Engineer").pressEnter();
        $("[data-qa=bloko-modal-close]").click();

            //$("[data-hh-tab-id=searchVacancy]").shouldHave(text("Вакансии"));
            //$("[data-hh-tab-id=resumeSearch]").shouldHave(text("Резюме"));
            //$("[data-hh-tab-id=employersList]").shouldHave(text("Компании"));

           // $("[data-qa=bloko-header-3]").shouldHave(text("QA Automation Engineer"));
        $("[data-qa=vacancy-serp__vacancy_response]").shouldHave(text("Откликнуться"));
        }


    @Test
    @DisplayName("Поиск вакансий для мануального тестировщика")
    void manualQASearchTest() {

        $("[data-qa=signup]").shouldHave(text("Создать резюме"));
        $("[data-qa=login]").shouldHave(text("Войти"));
        $("[data-qa=mainmenu_help]").shouldHave(text("Помощь"));

        $("#a11y-search-input").setValue("QA Manual Engineer").pressEnter();
        $("[data-qa=bloko-modal-close]").click();

        //$("[data-hh-tab-id=searchVacancy]").shouldHave(text("Вакансии"));
        //$("[data-hh-tab-id=resumeSearch]").shouldHave(text("Резюме"));
        //$("[data-hh-tab-id=employersList]").shouldHave(text("Компании"));

        // $("[data-qa=bloko-header-3]").shouldHave(text("QA Automation Engineer"));
        $("[data-qa=vacancy-serp__vacancy_response]").shouldHave(text("Откликнуться"));
    }
}

