package test.tests;

import com.codeborne.selenide.WebDriverRunner;
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
    public void checkNamePriceSizeColorTest() throws InterruptedException {
        String productName = "Lifestyle Women Vest Kadın Siyah Yelek Wnv3229-bk";
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
        WebDriverRunner.getWebDriver().manage().window().fullscreen();
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.ЖЕНЩИНАМ.getName())
                .clickRightMenu(CatalogRightMenuEnum.ЖИЛЕТЫ.getName())
                .findAndClick(productName)
                .selectSize(ProductSizeEnum.L.getName())
                .addToCart();

        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
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