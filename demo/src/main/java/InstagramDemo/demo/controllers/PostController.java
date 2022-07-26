package InstagramDemo.demo.controllers;

import InstagramDemo.demo.models.Post;
import InstagramDemo.demo.models.User;
import InstagramDemo.demo.repository.PostRepository;
import InstagramDemo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/instagram")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{user}/posts")
    public List<Post> getAllPostsByUserId(@PathVariable (value = "userId") int userId){
        return postRepository.findByUserId(userId);
    }

//    @PostMapping("/{user}/post/add")
//    public Post addPostOfOneUserId(@RequestBody Post post){
//        return postRepository.save(post);
//    }
//
//    //update post
//    @PutMapping("/{user}/post/{id}")
//    public ResponseEntity<Post> updatePost(
//            @PathVariable(value = "id") int postId,
//            @Valid @RequestBody Post postDetails) throws ResourceNotFoundException {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new ResourceNotFoundException("Post not found on :: "+ postId));
//
//        post.setContent(postDetails.getContent());
//        final Post updatedPost = postRepository.save(post);
//        return ResponseEntity.ok(updatedPost);
//    }
//
//    //delete post
//    @DeleteMapping("/{user}/post/{id}")
//    public Map<String, Boolean> deletePost(
//            @PathVariable(value = "id") int postId) throws Exception {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new ResourceNotFoundException("Post not found on :: "+ postId));
//
//        postRepository.delete(post);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

}
