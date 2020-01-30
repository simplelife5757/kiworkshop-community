package community.tag.service;

import community.tag.api.dto.TagsRequestDto;
import community.tag.domain.Tag;
import community.tag.domain.TagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static community.tag.api.dto.TagRequestDtoTest.getTagsRequestDtoFixture;
import static community.tag.domain.TagTest.getTagsFixture;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceTest {
  private TagService tagService;
  private @Mock TagRepository tagRepository;

  @BeforeEach
  void setUp() {
    tagService = new TagService(tagRepository);
  }

  @Test
  void createTags_ValidInput_ValidOutput() {
    // given
    int tagNums = 2;
    TagsRequestDto tagsRequestDto = getTagsRequestDtoFixture(tagNums);
    List<Tag> tagsToSave = getTagsFixture(tagNums);

    when(tagRepository.save(any(Tag.class))).thenReturn(tagsToSave.get(0), tagsToSave.get(1));
    // when
    List<Long> tagIds = tagService.createTags(tagsRequestDto);
    // then
    then(tagIds).contains(tagsToSave.get(0).getId()).contains(tagsToSave.get(1).getId());
  }
}