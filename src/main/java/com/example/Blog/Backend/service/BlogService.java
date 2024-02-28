package com.example.Blog.Backend.service;

import com.example.Blog.Backend.model.Blog;
import com.example.Blog.Backend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Blog getBlogById(String id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Blog post not found with id: " + id));
    }
    public List<Blog> getAllBlogPosts() {
        return blogRepository.findAll();
    }

    public Blog createBlogPost(Blog blogPost) {
        return blogRepository.save(blogPost);
    }

    public Blog updateBlogPost(String id, Blog updatedBlogPost) {

        Blog existingBlogPost = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog post not found with id: " + id));


        existingBlogPost.setTitle(updatedBlogPost.getTitle());
        existingBlogPost.setContent(updatedBlogPost.getContent());
        existingBlogPost.setAuthour(updatedBlogPost.getAuthour());
        existingBlogPost.setCategory(updatedBlogPost.getCategory());



        return blogRepository.save(existingBlogPost);
    }


    public Blog deleteBlogPost(String id) {
        Blog tobedeleted= blogRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Blog post not found with id: " + id));
        blogRepository.deleteById(id);
        return tobedeleted;
    }
}
