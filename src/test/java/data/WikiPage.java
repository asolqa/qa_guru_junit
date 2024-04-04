package data;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikiPage {
    private final SelenideElement toolBar = $(".vector-page-toolbar");

    public WikiPage expectedData(String menuItem) {

        toolBar.shouldHave(text(menuItem));

        return this;
    }
}
