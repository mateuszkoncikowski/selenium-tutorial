package db;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import enums.Level;
import objects.Category;
import objects.Post;
import objects.Topic;
import objects.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * User: Mateusz Koncikowski
 * Date: 07.04.13
 * Time: 11:27
 */

public class ForumDb {

    protected final MysqlDataSource dataSource;

    public ForumDb() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
    }

    public Category createCategoryDbRecord(String name, String description) {

        String sql = "INSERT INTO forum.categories(cat_name, cat_description) " +
                "VALUES ('%s', '%s');";
        sql = String.format(sql, name, description);

        int id = executeInsertAndRetrieveRecordId(sql);

        return new Category(id, name, description);
    }

    public User createUserDbRecord(String name, String pass, String email, String creationDate, Level level) {

        String sql = "INSERT INTO forum.users(user_name, user_pass, user_email, user_date, user_level) " +
                "VALUES ('%s', '%s', '%s', '%s', '%s');";
        sql = String.format(sql, name, pass, email, creationDate, level);

        int id = executeInsertAndRetrieveRecordId(sql);

        return new User(id, name, pass, email, creationDate, level);
    }

    public Topic createTopicDbRecord(String subject, String creationDate, Category category, User author, String message) {

        String sql = "INSERT INTO forum.topics(topic_subject, topic_date, topic_cat, topic_by) " +
                "VALUES ('%s', '%s', '%s', '%s');";
        sql = String.format(sql, subject, creationDate, category.getId(), author.getId());

        int id = executeInsertAndRetrieveRecordId(sql);

        Topic topic = new Topic(id, subject, creationDate, category, author, message);
        createPostDbRecord(message, creationDate, author, topic);
        return topic;
    }

    public Post createPostDbRecord(String content, String creationDate, User author, Topic topic) {

        String sql = "INSERT INTO forum.posts(post_content, post_date, post_topic, post_by) " +
                "VALUES ('%s', '%s', '%s', '%s');";
        sql = String.format(sql, content, creationDate, topic.getId(), author.getId());

        int id = executeInsertAndRetrieveRecordId(sql);

        return new Post(id, content, creationDate, topic, author);

    }

    private int executeInsertAndRetrieveRecordId(String insertSql) {
        int id = -1;

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }

            generatedKeys.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
