package dto;

import com.example.Blog.Backend.model.Blog;

import java.util.List;

public class ApiResponseAll {
    private List<Blog> data;
    private long responseTimeMillis;

    public ApiResponseAll(List<Blog> data, long responseTimeMillis) {
        this.data = data;
        this.responseTimeMillis = responseTimeMillis;
    }
}
