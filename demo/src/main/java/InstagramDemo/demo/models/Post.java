package InstagramDemo.demo.models;



import javax.management.Query;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    @Column(name = "postId")
    private int postId;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "userId")
//    private User user;

//    @Column(name = "username")
//    private String username;
    @ManyToOne
    private User user;


    @Column(name = "createDate")
    private String createDate;

    @Column(name = "content")
    private String content;



    public Post() {
    }

    public Post(int postId, User user, String createDate, String content) {
        this.postId = postId;
        this.user = user;
        this.createDate = createDate;
        this.content = content;
    }

    public Post(User user, String createDate, String content) {
        this.user = user;
        this.createDate = createDate;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
