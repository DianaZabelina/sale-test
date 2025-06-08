package test.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import test.pages.CartPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

// Page Element для верхней шапки сайта

public class Header {
    Catalog catalog = new Catalog();
    CartPage cartPage = new CartPage();

    private final SelenideElement
            naviSale = $("[title=\"На главную страницу\"]"),
            login = $("[data-selector=\"header-menu-profile-toggler\"]"),
            basket = $("[data-selector=\"basket-desktop\"]"),
            countBasket = $("[data-selector=\"basket-desktop\"] [data-selector=\"bage\"]");

    private final ElementsCollection
            topHeader = $$(".header-top-menu__item"),
            bottomHeader = $$(".header-menu__link");

    public Header clickTopHeader(String value) {
        SelenideElement header = topHeader.findBy(text(value));
        header.click();

        return this;
    }

    public Header clickBottomHeader(String value) {
        SelenideElement header = bottomHeader.findBy(text(value));
        header.click();

        return this;
    }

    public void clickNaviSale() {
        naviSale.click();
    }

    public void clickLogin() {
        login.click();
    }

    public CartPage clickBasket() throws InterruptedException {
        basket.click();
        Thread.sleep(5000); // TODO убрать слип, заменить на ожидание

        return cartPage;
    }

    public Catalog clickCatalog() throws InterruptedException {
        catalog.clickCatalog();
        Thread.sleep(5000); // TODO убрать слип, заменить на ожидание

        return catalog;
    }

    public String getCountBasket() {
        return countBasket.getOwnText();
    }
}