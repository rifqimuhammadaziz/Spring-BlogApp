package rifqimuhammadaziz.springblogapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryRequest {

    private Long id;

    @NotEmpty(message = "Category name is required")
    private String name;
}
