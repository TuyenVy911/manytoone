package InstagramDemo.demo.models;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    @Column(name = "userId")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(int userId, String username, String fullname, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public User(String username, String fullname, String email, String password) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
