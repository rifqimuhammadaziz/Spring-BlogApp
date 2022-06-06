package rifqimuhammadaziz.springblogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springblogapp.model.entity.Tag;
import rifqimuhammadaziz.springblogapp.model.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag save(Tag tag) {
        // Update
        if (tag.getId() != null) {
            Tag currentTag = tagRepository.findById(tag.getId()).get();
            currentTag.setName(tag.getName());
            tag = currentTag;
        }

        // Create new
        return tagRepository.save(tag);
    }

    public Iterable<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Tag findById(Long tagId) {
        Optional<Tag> tag = tagRepository.findById(tagId);
        if (!tag.isPresent()) {
            return null;
        }
        return tag.get();
    }

    public Tag findByName(String tagName) {
        return tagRepository.findTagByName(tagName);
    }

    public List<Tag> findByNameContains(String tagName) {
        return tagRepository.findTagByNameContains(tagName);
    }

    public void deleteById(Long tagId) {
        tagRepository.deleteById(tagId);
    }
}
