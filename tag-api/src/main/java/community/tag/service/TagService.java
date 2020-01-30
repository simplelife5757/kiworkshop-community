package community.tag.service;

import community.tag.api.dto.TagsRequestDto;
import community.tag.domain.Tag;
import community.tag.domain.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
  private final TagRepository tagRepository;

  public List<Long> createTags(TagsRequestDto tagsRequestDto) {
    List<Tag> tags = tagsRequestDto.createTags();
    List<Long> tagIds = new ArrayList<>();
    for (Tag tag: tags) {
      tagIds.add(tagRepository.save(tag).getId());
    }
    return tagIds;
  }
}
