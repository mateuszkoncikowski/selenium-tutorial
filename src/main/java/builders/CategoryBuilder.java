package builders;

import db.ForumDb;
import objects.Category;
import utils.Utils;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 22:07
 */

public class CategoryBuilder {

    private boolean withDbInsert = true;
    private String name = Utils.getRndString("Cat name", 19);
    private String description = Utils.getRndString("Cat desc", 19);

    public CategoryBuilder withDbInsert(boolean withDbInsert) {
        this.withDbInsert = withDbInsert;
        return this;
    }

    public CategoryBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category build() {
        if (withDbInsert) {
            return new ForumDb().createCategoryDbRecord(name, description);
        } else {
            return new Category(-1, name, description);
        }
    }

}
