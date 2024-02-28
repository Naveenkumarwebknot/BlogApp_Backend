package com.example.Blog.Backend.controller;

import com.example.Blog.Backend.error.BlogNotFoundException;
import com.example.Blog.Backend.model.Blog;
import com.example.Blog.Backend.service.BlogService;
import dto.ApiResponse;
import dto.ApiResponseAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;



    @Cacheable(value = "Blog", key = "#id")
    @GetMapping("/{id}")
    public ApiResponse getBlogPostById(@PathVariable String id) throws BlogNotFoundException {
        Instant start = Instant.now();
        Blog blogPost = blogService.getBlogById(id);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        return new ApiResponse(blogPost, timeElapsed);
    }

    @GetMapping("/all")
    public ApiResponseAll getAllBlogPosts() {
        Instant start = Instant.now();
        List<Blog> blogPosts = blogService.getAllBlogPosts();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        return  new ApiResponseAll(blogPosts,timeElapsed);
    }
    @CachePut(cacheNames = "Blog", key = "#Blog.id")
    @PostMapping("/create")
    public ApiResponse createBlogPost(@RequestBody Blog blogPost) {
        Instant start = Instant.now();
        Blog createdPost = blogService.createBlogPost(blogPost);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        return new ApiResponse(createdPost, timeElapsed);
    }

    @PutMapping("/{id}")
    @Caching(
            evict = {@CacheEvict(value = "Blog", allEntries = true)},
            put = {@CachePut(value = "Blog", key = "#Blog.id")}
    )
    public ApiResponse  updateBlogPost(@PathVariable String id, @RequestBody Blog updatedBlogPost) throws BlogNotFoundException {
        Instant start = Instant.now();
        Blog updatedPost = blogService.updateBlogPost(id,updatedBlogPost);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        return new ApiResponse(updatedPost, timeElapsed);
    }
    @DeleteMapping("/delete/{id}")
    @CacheEvict(cacheNames = "product", allEntries = true)
    public ApiResponse deleteBlogPost(@PathVariable String id) throws BlogNotFoundException {
        Instant start = Instant.now();
        Blog deletedPost = blogService.deleteBlogPost(id);
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        return new ApiResponse(deletedPost, timeElapsed);
    }
}
