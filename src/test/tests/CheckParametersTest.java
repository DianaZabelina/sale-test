package test.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.elements.Header;
import test.enums.catalog.CatalogLeftMenuEnum;
import test.enums.catalog.CatalogRightMenuEnum;
import test.enums.product.ProductSizeEnum;
import test.pages.CartPage;
import test.pages.ProductPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Проверка названия, цены, размера, цвета и количества товара на странице заказа и в корзине

public class CheckParametersTest extends BaseTest {
    Header header = new Header();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Проверка названия, цены, размера, цвета и количества товара на странице заказа и в корзине")
    public void checkNamePriceSizeColorTest() {
        String productName = "Жилет 4F H4Z21-KUMP001 30S";
        String nameOnProductPage,
                priceOnProductPage,
                sizeOnProductPage,
                colorOnProductPage,
                countOnProductPage,
                nameOnCartPage,
                priceOnCartPage,
                sizeOnCartPage,
                colorOnCartPage,
                countOnCartPage;

        open("");
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.ЖЕНЩИНАМ.getName())
                .clickRightMenu(CatalogRightMenuEnum.ЖИЛЕТЫ.getName())
                .findAndClick(productName)
                .selectSize(ProductSizeEnum.M.getName())
                .addToCart();

        nameOnProductPage = productPage.getNameWithoutColorAndSizeOnProductPage();
        priceOnProductPage = productPage.getPriceOnProductPage();
        sizeOnProductPage = productPage.getSizeOnProductPage();
        colorOnProductPage = productPage.getColorOnProductPage();
        countOnProductPage = productPage.getCountOnProductPage();

        header.clickBasket();

        nameOnCartPage = cartPage.getNameOnCartPage();
        priceOnCartPage = cartPage.getPriceToDecimalPointOnCartPage();
        sizeOnCartPage = cartPage.getSizeOnCartPage();
        colorOnCartPage = cartPage.getColorOnCartPage();
        countOnCartPage = cartPage.getCountOnCartPage();

        assertEquals(nameOnProductPage, nameOnCartPage);
        assertEquals(priceOnProductPage, priceOnCartPage);
        assertEquals(sizeOnProductPage, sizeOnCartPage);
        assertEquals(colorOnProductPage, colorOnCartPage);
        assertEquals(countOnProductPage, countOnCartPage);
    }
}