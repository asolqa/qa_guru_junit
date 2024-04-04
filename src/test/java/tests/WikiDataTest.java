package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.WikiPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WikiDataTest {

    @BeforeEach
    void setUpEnv() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        open("https://wikipedia.org/");

    }

    @AfterEach
    void clearEnv() {
        Selenide.closeWebDriver();
    }


    @Tag("Smoke")
    @ParameterizedTest
    @ValueSource(strings = {"Гагарин", "Чайковский"})
    @DisplayName("Результаты поиска содержат меню и не менее 5 инструментов на выбор")
    void wikiVariousSearchTest(String searchString) {

        $("#searchInput").setValue(searchString).pressEnter();
        $("#vector-page-tools-dropdown-checkbox").click();
        $$(".vector-menu-content-list").shouldBe(sizeGreaterThan(5));

    }

    @ParameterizedTest(name = "Для выбранной опции {0} должно быть в меню {1}")
    @CsvSource(value = {
            "#js-link-box-en,Main Page,Talk, Read,View source,View history,Tools",
            "#js-link-box-es,Portada,Discusión,Leer,Ver código fuente,Ver historial,Herramientas"
    })
    @DisplayName("Панель инструментов отобажается на выбранном языке")
    void languageHasCorrectPanelWikiTest(String langString, String expectedMenu ) {


        open("https://wikipedia.org/");
        $(langString).click();

        //wikipage.expectedData("Main Page");
        $(".vector-page-toolbar").shouldHave(text(expectedMenu));
        //$(".vector-page-toolbar").shouldHave(text("Talk"));
        //$(".vector-page-toolbar").shouldHave(text("Read"));
        //$(".vector-page-toolbar").shouldHave(text("View source"));
        //$(".vector-page-toolbar").shouldHave(text("View history"));
        //$(".vector-page-toolbar").shouldHave(text("Tools"));

        /*open("https://wikipedia.org/");
        $("#js-link-box-es").click();

        $(".vector-page-toolbar").shouldHave(text("Portada"));
        $(".vector-page-toolbar").shouldHave(text("Discusión"));
        $(".vector-page-toolbar").shouldHave(text("Leer"));
        $(".vector-page-toolbar").shouldHave(text("Ver código fuente"));
        $(".vector-page-toolbar").shouldHave(text("Ver historial"));
        $(".vector-page-toolbar").shouldHave(text("Herramientas"));*/

    }


    @DisplayName("Панель инструментов отобажается на выбранном языке")
    void languageHasCorrectPanelWikiTest2() {

        open("https://wikipedia.org/");
        $("#js-link-box-en").click();

        $(".vector-page-toolbar").shouldHave(text("Main Page"));
        $(".vector-page-toolbar").shouldHave(text("Talk"));
        $(".vector-page-toolbar").shouldHave(text("Read"));
        $(".vector-page-toolbar").shouldHave(text("View source"));
        $(".vector-page-toolbar").shouldHave(text("View history"));
        $(".vector-page-toolbar").shouldHave(text("Tools"));

        open("https://wikipedia.org/");
        $("#js-link-box-es").click();

        $(".vector-page-toolbar").shouldHave(text("Portada"));
        $(".vector-page-toolbar").shouldHave(text("Discusión"));
        $(".vector-page-toolbar").shouldHave(text("Leer"));
        $(".vector-page-toolbar").shouldHave(text("Ver código fuente"));
        $(".vector-page-toolbar").shouldHave(text("Ver historial"));
        $(".vector-page-toolbar").shouldHave(text("Herramientas"));

    }


}
