package enums;


/**
 * User: Mateusz Koncikowski
 * Date: 4/30/13
 * Time: 7:53 AM
 */

public enum Level {
    ADMIN_USER("1"),
    REGULAR_USER("0");

    private final String value;

    private Level(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
