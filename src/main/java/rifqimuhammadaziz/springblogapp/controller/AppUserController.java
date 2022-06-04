package rifqimuhammadaziz.springblogapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springblogapp.dto.AppUserRequest;
import rifqimuhammadaziz.springblogapp.dto.AppUserResponse;
import rifqimuhammadaziz.springblogapp.dto.ResponseData;
import rifqimuhammadaziz.springblogapp.model.entity.AppUser;
import rifqimuhammadaziz.springblogapp.service.AppUserService;
import rifqimuhammadaziz.springblogapp.utility.ValidationError;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<?>> register(@Valid @RequestBody AppUserRequest userData, Errors errors) {
        ResponseData<AppUserResponse> response = new ResponseData<>();

        // Custom Validation
        if (errors.hasErrors()) {
            response.setMessages(ValidationError.parse(errors));
            response.setStatus(false);
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            AppUser user = modelMapper.map(userData, AppUser.class);
            appUserService.registerUser(user);

            response.setStatus(true);
            response.getMessages().add("User successfully registered");
            response.setData(modelMapper.map(user, AppUserResponse.class)); // response without user password
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            response.getMessages().add(exception.getMessage());
            response.setStatus(false);
            response.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseData<List<AppUserResponse>>> findAll() {
        ResponseData<List<AppUserResponse>> response = new ResponseData<>();
        List<AppUserResponse> listUser = new ArrayList<>();
        appUserService.findAll().forEach(user -> {
            listUser.add(modelMapper.map(user, AppUserResponse.class)); // response without user password
        });
        response.setStatus(true);
        response.setData(listUser);
        return ResponseEntity.ok(response);
    }
}
