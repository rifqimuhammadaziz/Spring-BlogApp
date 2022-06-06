package rifqimuhammadaziz.springblogapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class TagRequest {

    private Long id;

    @NotEmpty(message = "Tag name is required")
    @Size(min = 3, message = "{validation.tag.name.size.too_short}")
    @Size(max = 20, message = "{validation.tag.name.size.too_long}")
    private String name;
}
