package test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

// Page Object для страницы Каталога

public class CatalogPage {
    ProductPage productPage = new ProductPage();

    private final ElementsCollection
            name = $$(byXpath("//a[contains(@href, '/product/') and contains(@class, 'product-listing-card__info-title')]"));

    public ProductPage findAndClick(String value) {
        SelenideElement productName = name.findBy(text(value));
        productName.click();

        return productPage;
    }
}