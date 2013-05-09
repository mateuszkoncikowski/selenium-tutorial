package objects;

import enums.Level;

import java.util.Date;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 22:00
 */

public class User {

    private int id = -1;
    private String name;
    private String pass;
    private String email;
    private String creationDate;
    private Level level;

    public User(int id, String name, String pass, String email, String creationDate, Level level) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.creationDate = creationDate;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", level=" + level +
                '}';
    }
}
