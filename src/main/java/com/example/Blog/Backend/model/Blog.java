package com.example.Blog.Backend.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
public class Blog implements Serializable {
    @Id
    private String id;
    private String category;
    private String title;
    private String content;
    private String authour;
}
