package InstagramDemo.demo.repository;

import InstagramDemo.demo.models.Post;
import InstagramDemo.demo.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    //List<Post> findByUser(User user);
    List<Post> findByUserId(int userId);
    Optional<Post> findByPostIdAndUserId(int postid, int userId);


}
