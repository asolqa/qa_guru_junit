package tests;

import com.codeborne.selenide.Selenide;
import data.WikiToolBarData;
import data.WikiToolBar;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.WikiPage;

import java.util.stream.Stream;

public class WikiToolBarTest {

    @AfterEach
    void clearEnv() {

        Selenide.closeWebDriver();
    }

    @Tag("Regression")
    @ParameterizedTest
    @MethodSource("wikiTestData")
    @DisplayName("Панель инструментов отображается на выбранном языке")
    void languageHasCorrectToolbarWikiTest(WikiToolBar data) {

        WikiPage page = new WikiPage();
        page.openPage()
                .selectLanguage(data.getLanguage())
                .checkForMenuItems(data.getMenuItems());

    }

    static Stream<Arguments> wikiTestData() {
        return Stream.of(
                Arguments.of(WikiToolBarData.englishToolbar()),
                Arguments.of(WikiToolBarData.spanishToolbar())
        );
    }
}
