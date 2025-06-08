package test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

// Page Object для страницы Корзины

public class CartPage {

    private final SelenideElement
            price = $(".cart-item-default__price"),
            name = $(".cart-item-default__title"),
            size = $(byXpath("//li[@class=\"cart-item-default__props-item\"][1]")),
            color = $(byXpath("//li[@class=\"cart-item-default__props-item\"][2]")),
            count = $(".quantity-group__number");

    public String getNameOnCartPage() {
        return name.getOwnText();
    }

    public String getPriceOnCartPage() {
        return price.getOwnText();
    }

    public String getPriceToDecimalPointOnCartPage() {
        String priceToDecimalPoint = getPriceOnCartPage();
        priceToDecimalPoint = priceToDecimalPoint.substring(0, priceToDecimalPoint.indexOf(",")).replaceAll("[^\\d]", "");
        return priceToDecimalPoint;
    }

    public String getSizeOnCartPage() {
        String sizeOnCartPage = size.getOwnText();
        return sizeOnCartPage.substring(sizeOnCartPage.length() - 1);
    }

    public String getColorOnCartPage() {
        String colorOnCartPage = color.getOwnText();
        return colorOnCartPage.substring(7);
    }

    public String getCountOnCartPage() {
        return count.getOwnText();
    }
}