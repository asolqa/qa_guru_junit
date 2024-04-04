package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class SimpleWikiTest {

    @Tag("Smoke")
    @ParameterizedTest
    @ValueSource(strings = {"Гагарин", "Чайковский"})
    @DisplayName("Страница содержит в меню несколько инструментов на выбор")
    void wikiVariousSearchTest(String searchString) {

        open("https://wikipedia.org/");

        $("#searchInput").setValue(searchString).pressEnter();
        $("#vector-page-tools-dropdown-checkbox").click();
        $$(".vector-menu-content-list").shouldBe(sizeGreaterThan(5));

        Selenide.closeWebDriver();

    }
}
