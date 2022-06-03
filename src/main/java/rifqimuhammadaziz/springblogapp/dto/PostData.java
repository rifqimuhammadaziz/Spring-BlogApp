package rifqimuhammadaziz.springblogapp.dto;

import lombok.Data;
import rifqimuhammadaziz.springblogapp.model.entity.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostData {

    @NotEmpty(message = "Title is required")
    private String title;

    @NotNull(message = "Category is required")
    private Category category;

    @NotEmpty(message = "Post Body is required")
    private String body;
}
