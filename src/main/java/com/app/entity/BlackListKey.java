
package com.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode
@Getter
@Setter
public class BlackListKey implements Serializable {
    int user;
    int lockingUser;

    public BlackListKey() {
    }
    

    
    
    
}
