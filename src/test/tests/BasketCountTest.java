package test.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.elements.Header;
import test.enums.catalog.CatalogLeftMenuEnum;
import test.enums.catalog.CatalogRightMenuEnum;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Проверка отображения количества товаров при добавлении в корзину

public class BasketCountTest extends BaseTest {
    Header header = new Header();

    @Test
    @DisplayName("Проверка отображения количества товаров (1) при добавлении в корзину")
    public void checkBasketCountOneTest() throws InterruptedException {
        String productName = "Skechers Fabric Backpack";

        open("");
        header.clickCatalog().moveOnLeftMenu(CatalogLeftMenuEnum.СУМКИ_И_ЧЕМОДАНЫ.getName())
                .clickRightMenu(CatalogRightMenuEnum.РЮКЗАКИ.getName())
                .findAndClick(productName)
                .addToCart();
        assertEquals("1", header.getCountBasket());
    }

    @Test
    @DisplayName("Проверка отображения количества товаров (3) при добавлении в корзину")
    public void checkBasketCountThreeTest() throws InterruptedException {
        String productNameOne = "Skechers Fabric Backpack";
        String productNameTwo = "Dickies Wrist Watch Quartz Movement Plastic Strap White Dial Unisex";
        String productNameThree = "Puma Ultraweave 7 Inch Running Shorts Mens Blue Casual Athletic";

        open("");
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.СУМКИ_И_ЧЕМОДАНЫ.getName())
                .clickRightMenu(CatalogRightMenuEnum.РЮКЗАКИ.getName())
                .findAndClick(productNameOne)
                .addToCart();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.АКСЕССУАРЫ.getName())
                .clickRightMenu(CatalogRightMenuEnum.ЧАСЫ.getName())
                .findAndClick(productNameTwo)
                .addToCart();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.МУЖЧИНАМ.getName())
                .clickRightMenu(CatalogRightMenuEnum.ШОРТЫ.getName())
                .findAndClick(productNameThree)
                .addToCart();
        Thread.sleep(3000); // TODO убрать слип, заменить на ожидание
        assertEquals("3", header.getCountBasket());
    }
}