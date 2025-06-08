package test.enums.catalog;

// Enum для значений, находящихся в правой стороне Page Elementa Каталог

public enum CatalogRightMenuEnum {
    БЕЛЬЕ_И_КУПАЛЬНИКИ("Белье и купальники"),
    ВЕРХНЯЯ_ОДЕЖДА("Верхняя одежда"),
    ЖИЛЕТЫ("Жилеты"),
    РЮКЗАКИ("Рюкзаки"),
    ЧАСЫ("Часы"),
    ШОРТЫ("Шорты");
    // TODO Дописать оставшиеся варианты для всех кейсов.

    private final String name;

    CatalogRightMenuEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}