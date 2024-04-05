package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiPage {
    private final SelenideElement toolBar = $(".vector-page-toolbar");
    private static final String LANG_BUTTON = "#js-link-box-";

    public WikiPage openPage() {
        open("https://wikipedia.org/");
        return this;
    }

    public WikiPage selectLanguage(String language) {
        $(LANG_BUTTON + language).click();
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public WikiPage checkForMenuItems(List<String> menuItems) {
        menuItems.forEach(
                menuItem -> toolBar.shouldHave(text(menuItem))
        );

        return this;
    }

}
