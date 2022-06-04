package rifqimuhammadaziz.springblogapp.dto;

import lombok.Data;
import rifqimuhammadaziz.springblogapp.model.entity.AppUserRole;

@Data
public class AppUserData {

    private String fullName;
    private String email;
    private String password;
    private AppUserRole appUserRole;

}
