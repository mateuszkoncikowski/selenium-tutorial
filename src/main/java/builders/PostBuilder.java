package builders;

import db.ForumDb;
import objects.Post;
import objects.Topic;
import objects.User;
import utils.Utils;

import java.util.Date;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 22:07
 */

public class PostBuilder {

    private boolean withDbInsert = true;
    private String content = Utils.getRndString("Random content - ", 20);
    private String creationDate = Utils.getTodayDate();
    private Topic topic;
    private User author;

    public PostBuilder(Topic topic, User author) {
        this.topic = topic;
        this.author = author;
    }

    public PostBuilder withDbInsert(boolean withDbInsert) {
        this.withDbInsert = withDbInsert;
        return this;
    }

    public PostBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public Post build() {
        if (withDbInsert) {
            return new ForumDb().createPostDbRecord(content, creationDate, author, topic);
        } else {
            return new Post(-1, content, creationDate, topic, author);
        }
    }
}
