
package com.app.DTO;

import com.app.entity.Post;
import com.app.exceptions.NoSuchPostException;
import com.app.rest.PostRestController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@Getter
@Setter
public class PostDTO   extends ResourceSupport {
    Post post;

    public PostDTO(Post post,Link selfLink) throws NoSuchPostException
    {
        this.post = post;
        add(selfLink);
        
    }
    
    
}
