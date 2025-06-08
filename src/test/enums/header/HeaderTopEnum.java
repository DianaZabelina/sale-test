package test.enums.header;

// Enum для верхних значений хэдера сайта

public enum HeaderTopEnum {
    ОПЛАТА("Оплата"),
    ДОСТАВКА("Доставка"),
    ПОМОЩЬ("Помощь");

    private final String name;

    HeaderTopEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}