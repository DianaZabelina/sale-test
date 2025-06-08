package test.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import test.pages.CatalogPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

// Page Element для элемента Каталог

public class Catalog {
    CatalogPage catalogPage = new CatalogPage();

    private final SelenideElement
            catalog = $("[aria-label='Открыть каталог']");

    private final ElementsCollection
            leftMenu = $$(".mega-burger-sidebar-menu__link"),
            rightMenu = $$("[class=\"mega-burger__sub-content mega-burger__sub-content_show\"] .mega-burger-content-menu__title");

    public Catalog clickLeftMenu(String value) {
        SelenideElement menu = leftMenu.findBy(text(value));
        menu.click();

        return this;
    }

    public CatalogPage clickRightMenu(String value) {
        SelenideElement menu = rightMenu.findBy(text(value));
        menu.click();

        return catalogPage;
    }

    public Catalog clickCatalog() {
        catalog.click();

        return this;
    }

    public Catalog moveOnLeftMenu(String value) throws InterruptedException {
        SelenideElement menu = leftMenu.findBy(text(value));
        menu.hover();

        return this;
    }
}