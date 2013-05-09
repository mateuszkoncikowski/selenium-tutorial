package objects;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:58
 */

public class Category {

    private final int id;
    private final String name;
    private final String description;

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
