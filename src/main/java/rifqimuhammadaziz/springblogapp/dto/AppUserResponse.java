package rifqimuhammadaziz.springblogapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import rifqimuhammadaziz.springblogapp.model.entity.AppUserRole;

import java.util.Date;

@Data
@NoArgsConstructor
public class AppUserResponse {

    private Long id;
    private String fullName;
    private String email;
    private AppUserRole appUserRole;
    protected Date createdDate;
}
