package rifqimuhammadaziz.springblogapp.dto;

import lombok.Data;
import rifqimuhammadaziz.springblogapp.model.entity.BaseEntity;

import java.util.Set;

@Data
public class PostResponse extends BaseEntity<String> {
    private String title;
    private CategoryResponse category;
    private Set<TagResponse> tags;
    private String body;
}
