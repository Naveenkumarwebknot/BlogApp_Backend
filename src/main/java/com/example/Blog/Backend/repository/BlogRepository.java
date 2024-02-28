package com.example.Blog.Backend.repository;

import com.example.Blog.Backend.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {

}
