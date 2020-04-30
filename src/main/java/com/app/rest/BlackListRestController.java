
package com.app.rest;

import com.app.DTO.BlackListDTO;
import com.app.entity.BlackList;
import com.app.service.BlackListService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class BlackListRestController {
    
   @Autowired  BlackListService blackService;
  
    
    @GetMapping("/blackList")
    public List<BlackList> list() {
        return blackService.getBlackList();
    }
    
    
    
}
