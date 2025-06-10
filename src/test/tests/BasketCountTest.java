package test.tests;

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
    public void checkBasketCountOneTest() {
        String productName = "Женский рюкзак Mellora";

        open("");
        header.clickCatalog().moveOnLeftMenu(CatalogLeftMenuEnum.СУМКИ_И_ЧЕМОДАНЫ.getName())
                .clickRightMenu(CatalogRightMenuEnum.РЮКЗАКИ.getName())
                .findAndClick(productName)
                .addToCart();
        assertEquals("1", header.getCountBasket());
    }

    @Test
    @DisplayName("Проверка отображения количества товаров (3) при добавлении в корзину")
    public void checkBasketCountThreeTest() {
        String productNameOne = "Женский рюкзак Mellora";
        String productNameTwo = "Dickies Wrist Watch Quartz Movement Plastic Strap White Dial Unisex";
        String productNameThree = "Puma Ultraweave 7 Inch Running Shorts Mens Blue Casual Athletic";

        open("");
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.СУМКИ_И_ЧЕМОДАНЫ.getName())
                .clickRightMenu(CatalogRightMenuEnum.РЮКЗАКИ.getName())
                .findAndClick(productNameOne)
                .addToCart();
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.АКСЕССУАРЫ.getName())
                .clickRightMenu(CatalogRightMenuEnum.ЧАСЫ.getName())
                .findAndClick(productNameTwo)
                .addToCart();
        header.clickCatalog()
                .moveOnLeftMenu(CatalogLeftMenuEnum.МУЖЧИНАМ.getName())
                .clickRightMenu(CatalogRightMenuEnum.ШОРТЫ.getName())
                .findAndClick(productNameThree)
                .addToCart();
        assertEquals("3", header.getCountBasket());
    }
}