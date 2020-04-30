
package com.app.DTO;

import com.app.entity.BlackList;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;


@Getter
@Setter
public class BlackListDTO extends ResourceSupport{
    BlackList blackList;

    public BlackListDTO(BlackList blackList,Link selfLink)
    {
        this.blackList = blackList;
        add(selfLink);
    }
    
    
}
