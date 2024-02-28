package dto;

import com.example.Blog.Backend.model.Blog;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter

    public class ApiResponse implements Serializable {
        private Blog data;
        private long responseTimeMillis;



    public ApiResponse(Blog data, long responseTimeMillis) {
        this.data = data;
        this.responseTimeMillis = responseTimeMillis;
    }
}

