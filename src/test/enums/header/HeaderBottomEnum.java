package test.enums.header;

// Enum для нижних значений хэдера сайта

public enum HeaderBottomEnum {
    МУЖЧИНАМ("Мужчинам"),
    ЖЕНЩИНАМ("Женщинам"),
    ОБУВЬ("Обувь"),
    СУМКИ_И_ЧЕМОДАНЫ("Сумки и чемоданы"),
    АКСЕССУАРЫ("Аксессуары");

    private final String name;

    HeaderBottomEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}