package builders;

import db.ForumDb;
import enums.Level;
import objects.User;
import utils.Utils;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 22:07
 */

public class UserBuilder {

    private boolean withDbInsert = true;
    private String name = Utils.getRndString("User", 15);
    private String pass = Utils.getRndString("Pass", 15);
    private String email = Utils.getRndString(10) + "@fwc.com";
    private String creationDate = Utils.getTodayDate();
    private Level level = Level.REGULAR_USER;

    public UserBuilder withDbInsert(boolean withDbInsert) {
        this.withDbInsert = withDbInsert;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.pass = password;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setLevel(Level level) {
        this.level = level;
        return this;
    }

    public User build() {
        if (withDbInsert) {
            return new ForumDb().createUserDbRecord(name, pass, email, creationDate, level);
        } else {
            return new User(-1, name, pass, email, creationDate, level);
        }
    }
}
