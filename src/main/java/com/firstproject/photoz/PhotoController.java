package com.firstproject.photoz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PhotoController {
    private Map<String, Photo> db = new HashMap<>(){{
        put("1",new Photo("1","hello.jpg"));
    }};

    @GetMapping("/")
    public String hello(){
        return "Hello Word";
    }
    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return db.values();
    }
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
}
