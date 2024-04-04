package data;

public class WikiToolBarData {

    public static WikiToolBar englishToolbar() {
        WikiToolBar data = new WikiToolBar();

        data.setLanguage("en");
        data.addMenuItem("Main Page");
        data.addMenuItem("Talk");
        data.addMenuItem("Read");
        data.addMenuItem("View source");
        data.addMenuItem("View history");
        data.addMenuItem("Tools");

        return data;
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static WikiToolBar spanishToolbar() {
        WikiToolBar data = new WikiToolBar();

        data.setLanguage("es");
        data.addMenuItem("Portada");
        data.addMenuItem("Discusión");
        data.addMenuItem("Leer");
        data.addMenuItem("Ver código fuente");
        data.addMenuItem("Ver historial");
        data.addMenuItem("Herramientas");

        return data;
    }

}
