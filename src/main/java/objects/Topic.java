package objects;


/**
 * User: Mateusz Koncikowski
 * Date: 22.04.13
 * Time: 21:27
 */

public class Topic {

    private final int id;
    private final String subject;
    private final String creationDate;
    private final Category category;
    private final User user;
    private String firstPost;

    public Topic(int id, String subject, String creationDate, Category category, User user, String firstPost) {
        this.id = id;
        this.subject = subject;
        this.creationDate = creationDate;
        this.category = category;
        this.user = user;
        this.firstPost = firstPost;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Category getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public String getFirstPost() {
        return firstPost;
    }

    public void setFirstPost(String firstPost) {
        this.firstPost = firstPost;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", category=" + category +
                ", user=" + user +
                ", firstPost='" + firstPost + '\'' +
                '}';
    }
}
