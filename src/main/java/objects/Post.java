package objects;

import java.util.Date;

/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 22:03
 */

public class Post {

    private final int id;
    private final String content;
    private final String creationDate;
    private final Topic topic;
    private final User user;

    public Post(int id, String content, String creationDate, Topic topic, User user ) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.topic = topic;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", topic=" + topic +
                ", user=" + user +
                '}';
    }
}
