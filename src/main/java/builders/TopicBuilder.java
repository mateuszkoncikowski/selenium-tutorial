package builders;

import db.ForumDb;
import objects.Category;
import objects.Post;
import objects.Topic;
import objects.User;
import utils.Utils;

import java.util.Date;


/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:49
 */

public class TopicBuilder {

    private boolean withDbInsert = true;
    private String firstPost = Utils.getRndString("First post message", 30);
    private String subject = Utils.getRndString("Random subject", 30);
    private String creationDate = Utils.getTodayDate();
    private Category category;
    private User author;

    public TopicBuilder(Category category, User author) {
        this.category = category;
        this.author = author;
    }

    public TopicBuilder withDbInsert(boolean withDbInsert) {
        this.withDbInsert = withDbInsert;
        return this;
    }

    public TopicBuilder setFirstPost(String firstPost) {
        this.firstPost = firstPost;
        return this;
    }

    public TopicBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Topic build() {
        if (withDbInsert) {
            return new ForumDb().createTopicDbRecord(subject, creationDate, category, author, firstPost);
        } else {
            return new Topic(-1, subject, creationDate, category, author, firstPost);
        }
    }

}
