package dto;

import com.example.Blog.Backend.model.Blog;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
    public class ApiResponse {
        private Blog data;
        private long responseTimeMillis;

        public ApiResponse(Blog data, long responseTimeMillis) {
            this.data = data;
            this.responseTimeMillis = responseTimeMillis;
        }
    }

