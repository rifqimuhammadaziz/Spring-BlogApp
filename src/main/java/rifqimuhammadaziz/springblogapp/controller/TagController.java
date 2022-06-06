package rifqimuhammadaziz.springblogapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import rifqimuhammadaziz.springblogapp.dto.ResponseData;
import rifqimuhammadaziz.springblogapp.dto.TagRequest;
import rifqimuhammadaziz.springblogapp.model.entity.Tag;
import rifqimuhammadaziz.springblogapp.service.TagService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Tag>> save(@Valid@RequestBody TagRequest tagRequest, Errors errors) {
        ResponseData<Tag> response = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                response.getMessages().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Tag tag = modelMapper.map(tagRequest, Tag.class);
        response.setStatus(true);
        response.getMessages().add(tag.getName() + " tag successfully saved");
        response.setData(tagService.save(tag));

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public Iterable<Tag> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/{tagId}")
    public Tag findById(@PathVariable("tagId") Long tagId) {
        return tagService.findById(tagId);
    }

    @GetMapping("/name/{tagName}")
    public Tag findByName(@PathVariable("tagName") String tagName) {
        return tagService.findByName(tagName);
    }

    @GetMapping("/contains/{tagName}")
    public List<Tag> findByNameContains(@PathVariable("tagName") String tagName) {
        return tagService.findByNameContains(tagName);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Tag>> update(@Valid @RequestBody TagRequest tagRequest, Errors errors) {
        ResponseData<Tag> response = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                response.getMessages().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Tag tag = modelMapper.map(tagRequest, Tag.class);
        response.setStatus(true);
        response.getMessages().add("Tag with Id: " + tag.getId() + " succesfully updated");
        response.setData(tagService.save(tag));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{tagId}")
    public void deleteById(@PathVariable("tagId") Long tagId) {
        tagService.deleteById(tagId);
    }
}
