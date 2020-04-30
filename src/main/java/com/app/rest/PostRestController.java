
package com.app.rest;

import com.app.DTO.PostDTO;
import com.app.entity.Post;
import com.app.exceptions.NoSuchPostException;
import com.app.exceptions.NoSuchUserException;
import com.app.service.PostService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class PostRestController {

    @Autowired
    PostService postService;


    @GetMapping("/post")
    public ResponseEntity<List<PostDTO>> list() {
        List<Post> postList = postService.getAll();
        Link link = linkTo(methodOn(PostRestController.class).list()).withSelfRel();
        List<PostDTO> postsDTO = new ArrayList<>();
        for (Post entity : postList) {
            Link selfLink = new Link(link.getHref() + "/" + entity.getPostId()).withSelfRel();
            PostDTO dto = new PostDTO(entity, selfLink);
            postsDTO.add(dto);
        }
        return new ResponseEntity<>(postsDTO, HttpStatus.OK);

    }


    @GetMapping("/post/{id}")
    public ResponseEntity<PostDTO> get(@PathVariable int id) {
        Post post = postService.getPostById(id);
        Link selfLink = linkTo(methodOn(PostRestController.class).get(id)).withSelfRel();
        PostDTO postDTO = new PostDTO(post, selfLink);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT,produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<PostDTO> editPostUserById(@RequestBody Post post,
        @PathVariable int id,@PathVariable int pid) throws NoSuchUserException,NoSuchPostException {
        Post p = postService.updatePost(post, pid);
        Link selfLink = linkTo(methodOn(UserRestController.class).getUserById(id)).withSelfRel();
        Link link = new Link(selfLink.getHref() + "/post/" + post.getPostId()).withSelfRel();
        PostDTO postDTO = new PostDTO(p, link);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);

    }
    
    @DeleteMapping("/post/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        postService.deletePostById(id);;
        return new ResponseEntity(HttpStatus.OK);
    }

}
