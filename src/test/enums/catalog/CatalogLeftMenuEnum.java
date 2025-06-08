package test.enums.catalog;

// Enum для значений, находящихся в левой стороне Page Elementa Каталог

public enum CatalogLeftMenuEnum {
    МУЖЧИНАМ("Мужчинам"),
    ЖЕНЩИНАМ("Женщинам"),
    ОБУВЬ("Обувь"),
    СУМКИ_И_ЧЕМОДАНЫ("Сумки и чемоданы"),
    РЮКЗАКИ("Рюкзаки"),
    АКСЕССУАРЫ("Аксессуары"),
    ZARA("Zara");

    private final String name;

    CatalogLeftMenuEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}