package builders;

/**
 * User: Mateusz Koncikowski
 * Date: 5/6/13
 * Time: 8:01 AM
 */

public abstract class Builder<T> {

    private boolean withDbInsert;

    public Builder withDbInsert(boolean withDbInsert) {
        this.withDbInsert = withDbInsert;
        return this;
    }

    public abstract T build();
}
