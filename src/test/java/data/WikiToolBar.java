package data;

import java.util.ArrayList;
import java.util.List;

public class WikiToolBar {

    private String language;

    private final List<String> menuItems = new ArrayList<>();

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void addMenuItem(String menuItem) {
        menuItems.add(menuItem);
    }

    public List<String> getMenuItems() {
        return menuItems;
    }

    @Override
    public String toString() {
        return "{ language='" + language + '\'' +
                '}';
    }
}
