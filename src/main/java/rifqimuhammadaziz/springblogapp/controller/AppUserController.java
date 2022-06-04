package rifqimuhammadaziz.springblogapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifqimuhammadaziz.springblogapp.dto.AppUserData;
import rifqimuhammadaziz.springblogapp.dto.ResponseData;
import rifqimuhammadaziz.springblogapp.model.entity.AppUser;
import rifqimuhammadaziz.springblogapp.service.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData) {
        ResponseData<AppUser> responseData = new ResponseData<>();
        AppUser user = modelMapper.map(userData, AppUser.class);
        responseData.setStatus(true);
        responseData.getMessages().add("User successfully registered");
        responseData.setData(appUserService.registerUser(user));
        return ResponseEntity.ok(responseData);
    }
}
